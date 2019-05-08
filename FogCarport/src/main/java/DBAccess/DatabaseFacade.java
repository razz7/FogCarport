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
        MaterialMapper mapper = new MaterialMapper();
        return mapper.getAllMaterials();
    }

    public void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException {
        MaterialMapper mapper = new MaterialMapper();
        mapper.addNewMaterial(item_description, width, height, entity, materialtype, price, quantity);

    }

    public void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException, ClassNotFoundException {
        MaterialMapper mapper = new MaterialMapper();
        mapper.updateMaterialData(item_id, item_description, width, height, entity, materialtype, price, quantity);
    }

    
    public void deleteMaterial(int item_id) throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        map.deleteMaterial(item_id);
    }

    public Material getMaterialbyID(int item_id) throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        return map.getMaterialbyID(item_id);
    }

    public Stykliste getLineitemsByOrderId(int order_id) throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        return map.getLineitemsByOrderId(order_id);
    }
    

    public void saveOrder(Order order) throws OrderSampleException{
        OrderMapper map = new OrderMapper();
        map.saveOrder(order);

    public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        return map.getAllMaterialbyType(type);

    }
}
