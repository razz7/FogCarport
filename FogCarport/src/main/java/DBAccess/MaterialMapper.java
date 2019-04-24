/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rasmus2
 */
public class MaterialMapper {

    private Connector dbc = new Connector();

    public ArrayList<Material> getAllMaterials() throws MaterialSampleException {
        ArrayList<Material> list = new ArrayList();
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM fog.stock";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Material material = new Material(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getFloat(7));
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
    public void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, int quantity) throws MaterialSampleException {
        try {
            String sql = "INSERT into fog.stock (item_description, width, height, entity, materialtype)"
                    + " VALUES(?,?,?,?,?)";
            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, item_description);
            ps.setFloat(2, width);
            ps.setFloat(3, height);
            ps.setString(4, entity);
            ps.setString(5, materialtype);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int item_id = rs.next() ? rs.getInt(1) : 0;
            addStockQuantityToNewMaterial(item_id, quantity);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }

    /**
     * This method adds quantity to the stock with the given item_id. If the
     * value given the quantity
     *
     * @param item_id
     * @param quantity
     * @throws MaterialSampleException
     */
    private void addStockQuantityToNewMaterial(int item_id, int quantity) throws MaterialSampleException {
        try {
            String sql = "INSERT into fog.stockStatus(item_id, quantity) VALUES(?,?)";
            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, item_id);
            ps.setInt(2, quantity);
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
     * @param quantity
     * @throws MaterialSampleException
     * @throws ClassNotFoundException
     */
    public void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, int quantity) throws MaterialSampleException, ClassNotFoundException {
        try {
            String sql = "UPDATE fog.stock SET item_description=?, width=?, height=?, entity=?, materialtype=? where item_id=?";
            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item_description);
            ps.setFloat(2, width);
            ps.setFloat(3, height);
            ps.setString(4, entity);
            ps.setString(5, materialtype);
            ps.setInt(6, item_id);
            ps.executeUpdate();
            if (quantity != 0 && item_id != 0) {
                updateQuantityToExistingMaterial(item_id, quantity);
            }

        } catch (SQLException | ClassCastException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }

    /**
     * This Method updates the quantity of an item with the item_id given. The
     * value set to quantity It is used in "updateMaterialData" and is only
     * executed if the quantity is more or less than 0.
     *
     * @param item_idm
     * @param quantity
     * @throws MaterialSampleException
     */
    public void updateQuantityToExistingMaterial(int item_id, int quantity) throws MaterialSampleException {
        try {
            String sql = "UPDATE fog.stockStatus SET quantity=quantity+? where item_id=?";
            Connection con = dbc.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, item_id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }

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
                material = new Material(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getFloat(7));
            }

            return material;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new MaterialSampleException(ex.getMessage());
        }
    }

    public static void main(String[] args) throws MaterialSampleException, ClassNotFoundException {
        //addNewMaterial("TESTTEST", 100, 50, "TEST", "TEST", 0);
        //updateMaterialData(38, "TEST", 10.0f, 10.0f, "TEST", "TEST", 9);
        //MaterialMapper map = new MaterialMapper();
        //System.out.println(map.getAllMaterials());
        //addStockQuantityToNewMaterial(1, 10);
        //updateQuantityToExistingMaterial(39, 100);
        //deleteMaterial(41);
        MaterialMapper map = new MaterialMapper();

        map.getMaterialbyID(1);
    }

}
