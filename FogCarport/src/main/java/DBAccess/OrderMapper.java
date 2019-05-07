package DBAccess;

import FunctionLayer.CarportAlgorithm;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
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
public class OrderMapper {

    private Connector dbc = new Connector();
    
    public ArrayList<Order> getAllOrders() throws OrderSampleException{
        try{
            String sql = "Select * from orders;";
            Connection conn = dbc.connection();
            ArrayList<Order> orders = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Order order = new Order(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7));
                orders.add(order);
            }
                    return orders;
                    
               }catch(SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }

    public Order getOrderFromId(int order_id) throws LoginSampleException, ClassNotFoundException {
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM 'order' WHERE id = " + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);

            int ID = 0;
            float length = 0;
            float width = 0;
            float height = 0;
            float roofTilt = 0;
            float shedWidth = 0;
            float shedLength = 0;

            Order order = null;

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Order order = new Order(rs.getInt(2), width, length, height, roofTilt, shedWidth, shedLength);

                order = new Order(ID, height, width, length, roofTilt, shedWidth, shedLength);

            } else {
                throw new LoginSampleException("Could not validate user");
            }

            return order;

        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
        public void saveOrder(Order order) throws OrderSampleException{
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
            
            
           
            
        } catch(SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
        
    }
    public static void main(String[] args) throws OrderSampleException, MaterialSampleException{
        Order order = new Order(6000, 7800, 0, 5300, 2100, 1, 1);
        OrderMapper map = new OrderMapper();
        StyklisteMapper mapper = new StyklisteMapper();
//        User user = new User("derqe", "qwe", "qwe");
//        user.setId(10);
//        order.setUser(user);
//        CarportAlgorithm algo = new CarportAlgorithm();
//        FunctionLayer.Stykliste list = algo.carportAlgorithm(order.getWidth(), order.getLength(), order.getRoofTilt(), order.getShedWidth(), order.getShedLength(), 1);
//        order.setSl(list);
//        
//        map.saveOrder(order);
//        mapper.saveLineItemsInDB(list.getStyklist());
System.out.println(map.getAllOrders());
        
    }
    
}
