/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.Stykliste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rasmu
 */
public class DatabaseFacade {

    public ArrayList<Material> getAllMaterials() throws MaterialSampleException {
        MaterialDBMapper mapper = new MaterialDBMapper();
        return mapper.getAllMaterials();
    }

    public void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException {
        MaterialDBMapper mapper = new MaterialDBMapper();
        mapper.addNewMaterial(item_description, width, height, entity, materialtype, price, quantity);

    }

    public void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException, ClassNotFoundException {
        MaterialDBMapper mapper = new MaterialDBMapper();
        mapper.updateMaterialData(item_id, item_description, width, height, entity, materialtype, price, quantity);
    }

    
    public void deleteMaterial(int item_id) throws MaterialSampleException {
        MaterialDBMapper map = new MaterialDBMapper();
        map.deleteMaterial(item_id);
    }

    public Material getMaterialbyID(int item_id) throws MaterialSampleException {
        MaterialDBMapper map = new MaterialDBMapper();
        return map.getMaterialbyID(item_id);
    }

    public Stykliste getLineitemsByOrderId(int order_id) throws MaterialSampleException {
        MaterialDBMapper map = new MaterialDBMapper();
        return map.getLineitemsByOrderId(order_id);
    }
    

    public void saveOrder(Order order) throws OrderSampleException{
        OrderDBMapper map = new OrderDBMapper();
        map.saveOrder(order);
    }

    public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException {
        MaterialDBMapper map = new MaterialDBMapper();
        return map.getAllMaterialbyType(type);

    }
}
