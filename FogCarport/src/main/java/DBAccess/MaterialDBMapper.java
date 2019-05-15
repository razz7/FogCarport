/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Stykliste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Rasmus2
 */
public class MaterialDBMapper extends MaterialMapper{

    private Connector dbc = new Connector();
    
    private static MaterialDBMapper instance = null;
    
    public synchronized static MaterialDBMapper getInstance() {
        if (instance == null) instance = new MaterialDBMapper();
        return instance;
    }

    @Override
    public ArrayList<Material> getAllMaterials() throws MaterialSampleException {
        ArrayList<Material> list = new ArrayList();
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM fog.stock";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Material material = new Material(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getInt(9));
                material.setStockQty(rs.getInt(8));
                
                list.add(material);
            }
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }

    /**
     * This method adds a new material to the db.
     *
     * @param item_description
     * @param width
     * @param height
     * @param entity
     * @param materialtype
     * @param quantity
     * @throws MaterialSampleException
     */
    @Override
    public void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException {
        try {
            String sql = "INSERT into fog.stock (item_description, width, height, entity, materialtype, price, stockquantity)"
                    + " VALUES(?,?,?,?,?,?,?)";
            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item_description);
            ps.setFloat(2, width);
            ps.setFloat(3, height);
            ps.setString(4, entity);
            ps.setString(5, materialtype);
            ps.setFloat(6, price);
            ps.setInt(7, quantity);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }

    /**
     * This method updates an item with the given item_id. All values given the
     * method as parameter replaces the data in the db, even values that are
     * empty, except the quantity, it will only be updated if it is higher or
     * lower than 0.
     *
     * @param item_id
     * @param item_description
     * @param width
     * @param height
     * @param entity
     * @param materialtype
     * @param price
     * @param quantity
     * @throws MaterialSampleException
     * @throws ClassNotFoundException
     */
    @Override
    public void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException, ClassNotFoundException {
        try {
            String sql = "UPDATE fog.stock SET item_description=?, width=?, height=?, entity=?, materialtype=?, price=?, stockquantity=?, versionnr = versionnr + 1 where item_id=?";

            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item_description);
            ps.setFloat(2, width);
            ps.setFloat(3, height);
            ps.setString(4, entity);
            ps.setString(5, materialtype);
            ps.setFloat(6, price);
            ps.setInt(7, quantity);
            ps.setInt(8, item_id);
            ps.executeUpdate();
           

        } catch (SQLException | ClassCastException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }

    /**
     * Delete the material in the databases along with the quantity in stock.
     *
     * @param item_id
     * @throws MaterialSampleException
     */
    @Override
    public void deleteMaterial(int item_id) throws MaterialSampleException {
        try {
            String sql = "DELETE FROM fog.stock WHERE item_id = ?";
            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, item_id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }

    @Override
    public Material getMaterialbyID(int item_id) throws MaterialSampleException {
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM fog.stock WHERE item_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, item_id);
            ResultSet rs = ps.executeQuery();
            Material material = null;
            while (rs.next()) {

                material = new Material(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getInt(9));
                material.setStockQty(rs.getInt(8));

                
            }

            return material;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }

    /**
     * This methods return all the lineitems and information about the item.
     *
     * @param order_id
     * @return
     * @throws MaterialSampleException
     */
    @Override
    public Stykliste getLineitemsByOrderId(int order_id) throws MaterialSampleException {
        try {
            String sql = "SELECT quantity, length, stock.item_id, item_description, width, height, entity, materialtype, price "
                    + "FROM stock "
                    + "INNER JOIN lineitems ON lineitems.item_id = stock.item_id where order_id = " + order_id + ";";
            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            MaterialDBMapper mapper = new MaterialDBMapper();
            ArrayList<Material> materials = new ArrayList<>();
            while (rs.next()) {
                Material material = new Material(0, "", 0, 0, "", "", 0, 0);
                material.setStockQty(rs.getInt("quantity"));
                material.setLength(rs.getFloat("length"));
                material.setItem_id(rs.getInt("item_id"));
                material.setItem_description(rs.getString("item_description"));
                material.setWidth(rs.getFloat("width"));
                material.setHeight(rs.getFloat("height"));
                material.setEntity(rs.getString("entity"));
                material.setMaterialtype(rs.getString("materialtype"));
                material.setPrice(rs.getFloat("price"));
                materials.add(material);
            }
            Stykliste styklist = new Stykliste(materials, order_id);
            return styklist;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }
    
    
    @Override
        public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException {
        try {
            ArrayList<Material> ML = new ArrayList();
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM fog.stock WHERE materialtype = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               Material material = new Material(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getInt(9));
                material.setStockQty(rs.getInt(8));
                ML.add(material);
            }

            return ML;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }

    public static void main(String[] args) throws MaterialSampleException, ClassNotFoundException {
        MaterialDBMapper map = new MaterialDBMapper();
        
        String regex = "[0-9]+";
        String regexLetter = "^(?=.*\\pL)[\\pL\\pN]+(?:[ -]+[\\pL\\pN]+)*$";
        
        String text1 = "hej24";
        String text2 = "hejsa";
        String text3 = "35";
        
        System.out.println(!text1.matches(".*\\d.*"));
        System.out.println(!text2.matches(".*\\d.*"));
        System.out.println(!text3.matches(".*\\d.*"));
        
        System.out.println(" ");
        
        System.out.println(!text1.matches(regexLetter));
        System.out.println(!text2.matches(regexLetter));
        System.out.println(!text3.matches(regexLetter));
        
        //updateMaterialData(38, "TEST", 10.0f, 10.0f, "TEST", "TEST", 9);
        //System.out.println(map.getAllMaterials());
        //addStockQuantityToNewMaterial(1, 10);
        //updateQuantityToExistingMaterial(39, 100);
        //deleteMaterial(41);
        //System.out.println(map.getLineitemsByOrder_id(1));
        //map.updateMaterialData(42, "qwe", 1, 1, "stk", "qwe", 1000, 0);


        //map.updateMaterialData(42, "hey", 3.6f, 25.7f, "stk", "pakke", 45.6f, 500);
        //map.addNewMaterial("hey1", 3.6f, 25.7f, "stk", "pakke", 45.6f, 500);

        //map.updateMaterialData(49, "qwe", 1f, 1f, "qwe", "qwe", 1, 1);
//        ArrayList<Material> list =  map.getAllMaterials();
//        for(int i = 0; i < list.size(); i++) {
//        
//        System.out.println(map.getAllMaterials().get(i).getVersionnr());
//        }
//
//        map.updateMaterialData(49, "qwe", 1f, 1f, "qwe", "qwe", 1, 1);

        //System.out.println(map.getAllMaterialbyType("Træ"));
        //map.updateMaterialData(42, "hey", 3.6f, 25.7f, "stk", "pakke", 45.6f, 500);
        //map.addNewMaterial("hey1", 3.6f, 25.7f, "stk", "pakke", 45.6f, 500);
        //System.out.println(map.getAllMaterials());
    }
}
