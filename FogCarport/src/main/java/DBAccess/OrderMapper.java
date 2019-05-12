package DBAccess;

import FunctionLayer.CarportAlgorithm;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
                Order order = new Order(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), 0, rs.getFloat(4), rs.getInt(5), rs.getInt(6));
                orders.add(order);
                order.setOrderdate(rs.getDate(9));
                User user = new User(rs.getString(10), "", "");
                order.setUser(user);
                
                
            }
                    return orders;
                    
               }catch(SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }

    public Order getOrderFromId(int order_id) throws OrderSampleException{
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM orders WHERE order_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            Order order = null;
            User user = null;

            while(rs.next()) {
                order = new Order(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), 2300, rs.getFloat(4), rs.getFloat(5), rs.getFloat(6));
                boolean bool = (rs.getInt(7) == 1);
                order.setOrderStatus(bool);
                order.setOrderdate(rs.getDate(9));
                user = new User(rs.getString(10), "", "");
                
                //order.setUser(rs.getInt(8));
              
            }
            order.setUser(user);
            OrderMapper map = new OrderMapper();
            order.setStyklist(map.getStyklistForOrder(order_id));
            return order;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
        
    }
    
    private Stykliste getStyklistForOrder(int order_id) throws OrderSampleException {
        try{
            String sql = "select * from lineitems where order_id = ?";
            Connection conn = dbc.connection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            ArrayList<Material> lineitems = new ArrayList<>();
            while(rs.next()) {
                Material material = new Material(rs.getInt(2), rs.getString(4), rs.getFloat(5), rs.getFloat(7), rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getInt(12));
                material.setStyklistQty(rs.getInt(11));
                material.setLineItemID(rs.getInt(1));
                material.setLength(rs.getFloat(6));
                
                lineitems.add(material);
                
            }
            Stykliste styklist = new Stykliste(lineitems, order_id);
            return styklist;
        } catch(SQLException | ClassNotFoundException ex) {
            
            throw new OrderSampleException(ex.getMessage());
        }
    }
        
    
        public void saveOrder(Order order) throws OrderSampleException, StyklistException{
        try {
            String sql = "INSERT INTO orders (width, length, rooftilt, shedwidth, shedlength, status, customer_id, orderdate, customername)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            
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
            ps.setString(9, order.getUser().getEmail());
            ps.executeUpdate();
            
            StyklisteMapper mapper = new StyklisteMapper();
            ResultSet rs = ps.getGeneratedKeys();
            int key = 0;
            if(rs != null && rs.next()) key = rs.getInt(1);
            System.out.println(key);
            mapper.saveLineItemsInDB(order.getStyklist(),key);
            
           
            
        } catch(SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
        
    }
        
    public void finalizeOrder(int order_id) throws OrderSampleException {
        try {
            String sql = "UPDATE fog.orders SET status=true WHERE order_id=?";

            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.executeUpdate();
           
        } catch(SQLException | ClassNotFoundException ex) {
            throw new OrderSampleException(ex.getMessage());
        }
    }
        
    public static void main(String[] args) throws OrderSampleException, MaterialSampleException, LoginSampleException, ClassNotFoundException, StyklistException{
        Order order = new Order(6000, 7800, 0, 5300, 2100, 1, 1);
        OrderMapper map = new OrderMapper();
        
        map.finalizeOrder(22);
        
        StyklisteMapper mapper = new StyklisteMapper();
        
        
//        User user = new User("derqe", "qwe", "qwe");
//        user.setId(10);
//        order.setUser(user);
//        CarportAlgorithm algo = new CarportAlgorithm();
//        FunctionLayer.Stykliste list = algo.carportAlgorithm(order.getWidth(), order.getLength(), order.getRoofTilt(), order.getShedWidth(), order.getShedLength(), 1);
//        order.setStyklist(list);
//        
//        map.saveOrder(order);
//        System.out.println(list);
//System.out.println(map.getAllOrders());
//Order order = map.getOrderFromId(9);
//System.out.println(order.toString());
//        System.out.println(order.getSl().getStyklist());
//map.getOrderFromId(10).getUser().getEmail();
//ArrayList<Order> list = map.getAllOrders();
//for(int i = 0; i < list.size(); i++) {
//    System.out.println(list.get(i).getUser().getEmail());
//}      
    }
}
    

