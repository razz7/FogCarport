/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import java.util.ArrayList;

/**
 *
 * @author rasmu
 */
public class DatabaseFacade implements DatabaseFacadeInterface {

    @Override
    public ArrayList<Material> getAllMaterials() throws MaterialSampleException {
<<<<<<< HEAD
        MaterialDBMapper mapper = new MaterialDBMapper();
        return mapper.getAllMaterials();
    }

    public void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException {
        MaterialDBMapper mapper = new MaterialDBMapper();
        mapper.addNewMaterial(item_description, width, height, entity, materialtype, price, quantity);

=======
        MaterialMapper map = new MaterialMapper();
        return map.getAllMaterials();
>>>>>>> newCommand
    }

    @Override
    public void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException, ClassNotFoundException {
<<<<<<< HEAD
        MaterialDBMapper mapper = new MaterialDBMapper();
        mapper.updateMaterialData(item_id, item_description, width, height, entity, materialtype, price, quantity);
=======
        MaterialMapper map = new MaterialMapper();
        map.updateMaterialData(item_id, item_description, width, height, entity, materialtype, price, quantity);
>>>>>>> newCommand
    }

    @Override
    public void deleteMaterial(int item_id) throws MaterialSampleException {
        MaterialDBMapper map = new MaterialDBMapper();
        map.deleteMaterial(item_id);
    }

    @Override
    public Material getMaterialbyID(int item_id) throws MaterialSampleException {
        MaterialDBMapper map = new MaterialDBMapper();
        return map.getMaterialbyID(item_id);
    }

<<<<<<< HEAD
    public Stykliste getLineitemsByOrderId(int order_id) throws MaterialSampleException {
        MaterialDBMapper map = new MaterialDBMapper();
        return map.getLineitemsByOrderId(order_id);
=======
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
>>>>>>> newCommand
    }

<<<<<<< HEAD
    public void saveOrder(Order order) throws OrderSampleException{
        OrderDBMapper map = new OrderDBMapper();
        map.saveOrder(order);
    }

    public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException {
        MaterialDBMapper map = new MaterialDBMapper();
        return map.getAllMaterialbyType(type);
=======
    @Override
    public void saveOrder(Order order) throws OrderSampleException, StyklistException {
        OrderMapper map = new OrderMapper();
        map.saveOrder(order);
    }

    @Override
    public void editLineItemsFromOrderID(int lineitem_id, String item_description, float width, float height, String entity, String materialtype, float price, int orderquantity, int order_id) {
        StyklisteMapper map = new StyklisteMapper();
        map.editLineItemsFromOrderID(lineitem_id, item_description, width, height, entity, materialtype, price, orderquantity, order_id);

    }

    @Override
    public void saveLineItemsInDB(Stykliste styklist, int order_id) throws StyklistException {
        StyklisteMapper map = new StyklisteMapper();
        map.saveLineItemsInDB(styklist, order_id);
    }

    @Override
    public Material getMaterialFromLineItems(int lineItemID) throws StyklistException {
        StyklisteMapper map = new StyklisteMapper();
        return map.getMaterialFromLineItems(lineItemID);
    }
    
    @Override
    public void finalizeOrder(int order_id) throws OrderSampleException{
        OrderMapper map = new OrderMapper();
        map.finalizeOrder(order_id);
    }
    
    @Override
    public Stykliste getStyklistForOrder(int order_id) throws OrderSampleException{
        OrderMapper map = new OrderMapper();
        return map.getStyklistForOrder(order_id);
    }
>>>>>>> newCommand

    @Override
    public void createUser(User user) throws LoginSampleException {
        UserMapper map = new UserMapper();
        map.createUser(user);
    }

    @Override
    public boolean verifyUser(String email, String password) throws LoginSampleException {
        UserMapper map = new UserMapper();
        return map.verifyUser(email, password);
    }

    @Override
    public User getUserByEmail(String email) throws LoginSampleException {
        UserMapper map = new UserMapper();
        return map.getUserByEmail(email);
    }

}
