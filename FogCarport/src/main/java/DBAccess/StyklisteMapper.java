/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;


import FunctionLayer.Stykliste;

import FunctionLayer.CarportAlgorithm;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Ludvig
 */


public abstract class StyklisteMapper {
    
    public static StyklisteMapper instance() {
        return StyklisteDBMapper.getInstance();
    }
    
    public abstract void editLineItemsFromOrderID(int item_id, String item_description, float width, float height,
            String entity, String materialtype, float price, int orderquantity, int order_id);
    
    public abstract void saveLineItemsInDB(Stykliste styklist, int order_id);

    
    public Material getMaterialFromLineItems(int lineItemID) throws StyklistException {
        try{
            String sql = "Select * from lineitems where lineitems_id=?";
            Connection conn = dbc.connection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, lineItemID);
            ResultSet rs = ps.executeQuery();
            Material material = null;
            while(rs.next()) {
                material = new Material(rs.getInt(2), rs.getString(4), rs.getFloat(5), rs.getFloat(7), rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getInt(11));
                material.setStyklistQty(rs.getInt(10));
                material.setLineItemID(rs.getInt(1));
                material.setLength(rs.getFloat(6));
            }
            return material;
            
        } catch(SQLException | ClassNotFoundException ex) {
            throw new StyklistException(ex.getMessage());
                    
        }
        
    }
    
    public static void main(String[] args) throws MaterialSampleException, Exception {
        long start = System.currentTimeMillis();
        StyklisteMapper mapper = new StyklisteDBMapper();
//        CarportAlgorithm car = new CarportAlgorithm();
//        Stykliste styklist = car.carportAlgorithm(6000, 7800, 0, 5300, 2100, 1);
//        System.out.println(styklist.toString());
//        
//        mapper.saveOrder(styklist.getStyklist());
//        
//        long elapsedTimeMillis = System.currentTimeMillis()-start;
//        System.out.println(elapsedTimeMillis/1000F);
//mapper.editLineItemsFromOrderID(3, "træ", 10f, 10f, "træ", "træ", 10f, 100, 1);
        System.out.println(mapper.getMaterialFromLineItems(531));

    }
    