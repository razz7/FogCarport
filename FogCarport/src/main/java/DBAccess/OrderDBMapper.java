package DBAccess;

import FunctionLayer.CarportAlgorithm;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ludvig
 */
public class OrderDBMapper extends OrderMapper {

    private Connector dbc = new Connector();

    private static OrderDBMapper instance = null;

    public synchronized static OrderDBMapper getInstance() {
        if (instance == null) {
            instance = new OrderDBMapper();
        }
        return instance;
    }

    @Override
    public ArrayList<Order> getAllOrders() throws OrderSampleException {
        try {
            String sql = "Select * from orders;";
            Connection conn = dbc.connection();
            ArrayList<Order> orders = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7));
                orders.add(order);
            }
            return orders;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }

    @Override
    public Order getOrderFromId(int order_id) throws OrderSampleException {
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM orders WHERE order_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            Order order = null;

            while (rs.next()) {
                order = new Order(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7));
                //order.setUser(rs.getInt(8));

            }
            OrderDBMapper map = new OrderDBMapper();
            order.setStyklist(map.getStyklistForOrder(order_id));
            return order;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }

    }

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
                Material material = new Material(rs.getInt(2), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getInt(11));
                material.setStyklistQty(rs.getInt(10));

                lineitems.add(material);

            }
            Stykliste styklist = new Stykliste(lineitems, order_id);
            return styklist;
        } catch (SQLException | ClassNotFoundException ex) {

            throw new OrderSampleException(ex.getMessage());
        }
    }

    @Override
    public void saveOrder(Order order) throws OrderSampleException {
        try {
            String sql = "INSERT INTO orders (width, length, rooftilt, shedwidth, shedlength, status, customer_id)"
                    + "VALUES(?,?,?,?,?,?,?)";

            Connection conn = dbc.connection();
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setFloat(1, order.getWidth());
            ps.setFloat(2, order.getLength());
            ps.setFloat(3, order.getRoofTilt());
            ps.setFloat(4, order.getShedWidth());
            ps.setFloat(5, order.getLength());
            ps.setFloat(6, 0);
            ps.setInt(7, order.getUser().getId());
            ps.executeUpdate();

            StyklisteDBMapper mapper = new StyklisteDBMapper();
            ResultSet rs = ps.getGeneratedKeys();
            int key = 0;
            if (rs != null && rs.next()) {
                key = rs.getInt(1);
            }
            System.out.println(key);
            mapper.saveLineItemsInDB(order.getStyklist(), key);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }

    }

    @Override
    public void finalizeOrder(int order_id) throws OrderSampleException {
        try {
            String sql = "UPDATE fog.orders SET status=true WHERE order_id=?";

            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }
    
    @Override
    public void deleteOrder(int order_id) throws OrderSampleException {
        try {
            String sql = "DELETE FROM fog.orders WHERE order_id=?";

            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }

}
