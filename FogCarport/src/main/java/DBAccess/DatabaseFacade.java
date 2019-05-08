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
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import java.util.ArrayList;

/**
 *
 * @author rasmu
 */
public class DatabaseFacade implements DBInterface{

    @Override
    public ArrayList<Material> getAllMaterials() throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        return map.getAllMaterials();
    }

    @Override
    public void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException, ClassNotFoundException {
        MaterialMapper map = new MaterialMapper();
        map.updateMaterialData(item_id, item_description, width, height, entity, materialtype, price, quantity);
    }

    @Override
    public void deleteMaterial(int item_id) throws MaterialSampleException {
       MaterialMapper map = new MaterialMapper();
       map.deleteMaterial(item_id);
    }

    @Override
    public Material getMaterialbyID(int item_id) throws MaterialSampleException {
      MaterialMapper map = new MaterialMapper();
      return map.getMaterialbyID(item_id);
    }

    @Override
    public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        return map.getAllMaterialbyType(type);
    }

    @Override
    public void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        map.addNewMaterial(item_description, width, height, entity, materialtype, price, quantity);
    }

    @Override
    public ArrayList<Order> getAllOrders() throws OrderSampleException {
        OrderMapper map = new OrderMapper();
        return map.getAllOrders();
    }

    @Override
    public Order getOrderFromId(int order_id) throws OrderSampleException {
       OrderMapper map = new OrderMapper();
       return map.getOrderFromId(order_id);
    }

    @Override
    public void saveOrder(Order order) throws OrderSampleException, StyklistException {
        OrderMapper map = new OrderMapper();
        map.saveOrder(order);
    }

    @Override
    public void editLineItemsFromOrderID(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int orderquantity, int order_id) {
        StyklisteMapper map = new StyklisteMapper();
        map.editLineItemsFromOrderID(item_id, item_description, width, height, entity, materialtype, price, orderquantity, order_id);
        
    }

    @Override
    public void saveLineItemsInDB(Stykliste styklist, int order_id) throws StyklistException  {
         StyklisteMapper map = new StyklisteMapper();
         map.saveLineItemsInDB(styklist, order_id);
    }

    @Override
    public Material getMaterialFromLineItems(int lineItemID) throws StyklistException {
        StyklisteMapper map = new StyklisteMapper();
        return map.getMaterialFromLineItems(lineItemID);
    }

   
    
}
