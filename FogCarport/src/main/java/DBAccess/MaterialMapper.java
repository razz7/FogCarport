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
}
