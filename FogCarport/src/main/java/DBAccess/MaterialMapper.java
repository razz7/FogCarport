/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Stykliste;
import java.util.ArrayList;

/**
 *
 * @author Ludvig
 */
public abstract class MaterialMapper {

    public static MaterialMapper instance() {
        return MaterialDBMapper.getInstance();
    }

<<<<<<< HEAD
    public abstract ArrayList<Material> getAllMaterials() throws MaterialSampleException;
=======
    /**
     * Delete the material in the databases along with the quantity in stock.
     *
     * @param item_id
     * @throws MaterialSampleException
     */
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

    
        public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException {
        try {
            ArrayList<Material> ML = new ArrayList();
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM fog.stock WHERE materialtype = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
>>>>>>> newCommand
            
    public abstract void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity)throws MaterialSampleException;
            
    public abstract void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity)throws MaterialSampleException, ClassNotFoundException ;
            
    public abstract void deleteMaterial(int item_id)throws MaterialSampleException;
            
    public abstract Material getMaterialbyID(int item_id) throws MaterialSampleException;
            
    public abstract Stykliste getLineitemsByOrderId(int order_id)throws MaterialSampleException;
            
    public abstract ArrayList<Material> getAllMaterialbyType(String type)throws MaterialSampleException;
}
