/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportAlgorithm;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Stykliste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ludvig
 */
public class StyklisteMapper {
    
    private Connector dbc = new Connector();
    
//    public ArrayList<Stykliste> getAllStykliste() throws ClassNotFoundException, SQLException{
//        ArrayList<Stykliste> list = new ArrayList();
//        
//        try{
//            Connection con = dbc.connection();
//            String SQL = "SELECT * FROM fog.stock";
//        }
//    }
    
    public void editLineItemsFromOrderID(int item_id, String item_description, float width, float height,
            String entity, String materialtype, float price, int orderquantity, int order_id) {
        try {
        Connection con = dbc.connection();
        String sql = "UPDATE lineitems SET item_id=?, item_description=?, width=?, "
                + "height=?, entity=?, materialtype=?, price=?, orderquantity=? where order_id=? and item_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, item_id);
            ps.setString(2, item_description);
            ps.setFloat(3, width);
            ps.setFloat(4, height);
            ps.setString(5, entity);
            ps.setString(6, materialtype);
            ps.setFloat(7, price);
            ps.setInt(8, orderquantity);
            ps.setInt(9, order_id);
            ps.setInt(10, item_id);
            ps.executeUpdate();
        
        }catch(SQLException | ClassNotFoundException ex) {
            
        }
    }
    public void saveLineItemsInDB(ArrayList<Material> lineitems) {
        try {
            
        Connection con = dbc.connection();
        
        String sql = "INSERT INTO lineitems(item_id, item_description, width, height, entity, materialtype, price, orderquantity, versionnr)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = dbc.connection().prepareStatement(sql);
            for(int i = 0; i < lineitems.size();i++) {
            ps.setInt(1, lineitems.get(i).getItem_id());
            ps.setString(2, lineitems.get(i).getItem_description());
            ps.setFloat(3, lineitems.get(i).getWidth());
            ps.setFloat(4, lineitems.get(i).getHeight());
            ps.setString(5, lineitems.get(i).getEntity());
            ps.setString(6, lineitems.get(i).getMaterialType());
            ps.setFloat(7, lineitems.get(i).getPrice());
            ps.setInt(8, lineitems.get(i).getStryklistQty());
            ps.setInt(9, 1);
            
            ps.executeUpdate();
        }
        }catch(SQLException | ClassNotFoundException ex) {
            
        }
        
    }
    public static void main(String[] args) throws MaterialSampleException {
        long start = System.currentTimeMillis();
        StyklisteMapper mapper = new StyklisteMapper();
//        CarportAlgorithm car = new CarportAlgorithm();
//        Stykliste styklist = car.carportAlgorithm(6000, 7800, 0, 5300, 2100, 1);
//        System.out.println(styklist.toString());
//        
//        mapper.saveOrder(styklist.getStyklist());
//        
//        long elapsedTimeMillis = System.currentTimeMillis()-start;
//        System.out.println(elapsedTimeMillis/1000F);
mapper.editLineItemsFromOrderID(3, "træ", 10f, 10f, "træ", "træ", 10f, 100, 1);
    }
    
}
