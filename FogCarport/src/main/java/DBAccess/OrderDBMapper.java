package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDBMapper extends OrderMapper {

    private Connector dbc = new Connector();
    private boolean testConnection = false;

    private static OrderDBMapper instance = null;

    /**
     * Returns instance of OrderDBMapper
     *
     * @return OrderDBMapper
     */
    public synchronized static OrderDBMapper getInstance() {
        if (instance == null) {
            instance = new OrderDBMapper();
        }
        return instance;
    }

    /**
     * Sets connection
     *
     * @param connection
     */
    public void setMapperConnection(Connection connection) {
        dbc.setConnection(connection);
        testConnection = true;
    }

    /**
     * Gets all orders in the database and return them as an ArrayList of Order
     * objects
     *
     * @return ArrayList<Order>
     * @throws OrderSampleException
     */
    @Override
    public ArrayList<Order> getAllOrders() throws OrderSampleException {
        try {
            String sql = "Select * from orders;";
            Connection conn = dbc.connection();
            ArrayList<Order> orders = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), 2300, rs.getFloat(4), rs.getFloat(5), rs.getFloat(6));
                orders.add(order);
                order.setOrderdate(rs.getDate(9));
                int user_id = rs.getInt(8);
                UserDBMapper mapper = new UserDBMapper();
                User user = mapper.getUserByID(user_id);
                order.setOrderStatus(rs.getBoolean(7));
                order.setUser(user);
            }
            return orders;

        } catch (SQLException | ClassNotFoundException | LoginSampleException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }

    /**
     * Gets specific order based on order id
     *
     * @param order_id
     * @return Order
     * @throws OrderSampleException
     */
    @Override
    public Order getOrderFromId(int order_id) throws OrderSampleException {
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM orders WHERE order_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            Order order = null;
            User user = null;

            while (rs.next()) {
                order = new Order(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), 2300, rs.getFloat(4), rs.getFloat(5), rs.getFloat(6));
                boolean bool = (rs.getInt(7) == 1);
                order.setOrderStatus(bool);
                order.setOrderdate(rs.getDate(9));
                user = new User(rs.getString(10), 0, "");
                order.setUser(user);
                //order.setUser(rs.getInt(8));
            }

            if (testConnection == false) {
                OrderDBMapper map = new OrderDBMapper();
                order.setStyklist(map.getStyklistForOrder(order_id));
            }
            return order;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }

    }

    /**
     * Gets stykliste based off the order_id of the order it is assigned to
     *
     * @param order_id
     * @return Stykliste
     * @throws OrderSampleException
     */
    @Override
    public Stykliste getStyklistForOrder(int order_id) throws OrderSampleException {
        try {
            String sql = "select * from lineitems where order_id = ?";
            Connection conn = dbc.connection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            ArrayList<Material> lineitems = new ArrayList<>();
            while (rs.next()) {
                Material material = new Material(rs.getInt(2), rs.getString(4), rs.getFloat(5), rs.getFloat(7), rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getInt(12));
                material.setStyklistQty(rs.getInt(11));
                material.setLineItemID(rs.getInt(1));
                material.setLength(rs.getFloat(6));

                lineitems.add(material);

            }
            Stykliste styklist = new Stykliste(lineitems, order_id);
            return styklist;
        } catch (SQLException | ClassNotFoundException ex) {

            throw new OrderSampleException(ex.getMessage());
        }
    }

    /**
     * Saves data of an order object in the database
     *
     * @param order
     * @throws OrderSampleException
     */
    @Override
    public void saveOrder(Order order) throws OrderSampleException {
        try {
            String sql = "INSERT INTO orders (width, length, rooftilt, shedwidth, shedlength, status, customer_id, orderdate)"
                    + "VALUES(?,?,?,?,?,?,?,?)";

            Connection conn = dbc.connection();
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setFloat(1, order.getWidth());
            ps.setFloat(2, order.getLength());
            ps.setFloat(3, order.getRoofTilt());
            ps.setFloat(4, order.getShedWidth());
            ps.setFloat(5, order.getShedLength());
            ps.setFloat(6, 0);
            ps.setInt(7, order.getUser().getId());
            ps.setDate(8, Date.valueOf(LocalDate.now()));

            ps.executeUpdate();

            if (order.getStyklist() != null) {
                StyklisteDBMapper mapper = new StyklisteDBMapper();
                ResultSet rs = ps.getGeneratedKeys();
                int key = 0;
                if (rs != null && rs.next()) {
                    key = rs.getInt(1);
                }
                System.out.println(key);
                mapper.saveLineItemsInDB(order.getStyklist(), key);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }

    }

    /**
     * Updates the status of the order to true
     *
     * @param order_id
     * @throws OrderSampleException
     */
    @Override
    public void finalizeOrder(int order_id) throws OrderSampleException {
        try {
            String sql = "UPDATE orders SET status=true WHERE order_id=?";

            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }

    /**
     * Updates the status of the order to false
     *
     * @param order_id
     * @throws OrderSampleException
     */
    @Override
    public void unFinalizeOrder(int order_id) throws OrderSampleException {
        try {
            String sql = "UPDATE orders SET status=false WHERE order_id=?";

            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(0, order_id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }

    /**
     * Receives parameters order_id and price and updates the price in the order
     * with the matching order_id
     *
     * @param order_id
     * @param price
     * @throws OrderSampleException
     */
    @Override
    public void setPriceOrder(int order_id, float price) throws OrderSampleException {
        try {
            String sql = "UPDATE orders SET price=? WHERE order_id=?";

            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setInt(2, order_id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }

    /**
     * Gets price of order with the same order_id
     *
     * @param order_id
     * @return
     * @throws OrderSampleException
     */
    @Override
    public float getPriceFromId(int order_id) throws OrderSampleException {
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT price FROM orders WHERE order_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            float price = 0;

            while (rs.next()) {
                price = rs.getFloat(1);
            }

            return price;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }

    }

    /**
     * Deletes order specified by order_id
     *
     * @param order_id
     * @throws OrderSampleException
     */
    @Override
    public void deleteOrder(int order_id) throws OrderSampleException {
        try {
            String sql = "DELETE FROM orders WHERE order_id=?";

            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }

}
