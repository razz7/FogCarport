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
        MaterialDBMapper mapper = new MaterialDBMapper();
        return mapper.getAllMaterials();
    }

    @Override
    public void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException {
        MaterialDBMapper mapper = new MaterialDBMapper();
        mapper.addNewMaterial(item_description, width, height, entity, materialtype, price, quantity);
    }

    @Override
    public void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException, ClassNotFoundException {
        MaterialDBMapper mapper = new MaterialDBMapper();
        mapper.updateMaterialData(item_id, item_description, width, height, entity, materialtype, price, quantity);
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

    @Override
    public Stykliste getLineitemsByOrderId(int order_id) throws MaterialSampleException {
        MaterialDBMapper map = new MaterialDBMapper();
        return map.getLineitemsByOrderId(order_id);
    }

    @Override
    public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException {
        MaterialDBMapper map = new MaterialDBMapper();
        return map.getAllMaterialbyType(type);
    }
    
    @Override
    public ArrayList<Order> getAllOrders() throws OrderSampleException {
        OrderDBMapper map = new OrderDBMapper();
        return map.getAllOrders();
    }

    @Override
    public Order getOrderFromId(int order_id) throws OrderSampleException {
        OrderMapper map = new OrderDBMapper();
        return map.getOrderFromId(order_id);

    }

    @Override
    public void saveOrder(Order order) throws OrderSampleException {
        OrderDBMapper map = new OrderDBMapper();
        map.saveOrder(order);
    }

    @Override
    public void editLineItemsFromOrderID(int lineitem_id, String item_description, float width, float height, String entity, String materialtype, float price, int orderquantity, int order_id) {
        StyklisteDBMapper map = new StyklisteDBMapper();
        map.editLineItemsFromOrderID(lineitem_id, item_description, width, height, entity, materialtype, price, orderquantity, order_id);

    }

    @Override
    public void saveLineItemsInDB(Stykliste styklist, int order_id) throws StyklistException {
        StyklisteDBMapper map = new StyklisteDBMapper();
        map.saveLineItemsInDB(styklist, order_id);
    }

    @Override
    public Material getMaterialFromLineItems(int lineItemID) throws StyklistException {
        StyklisteDBMapper map = new StyklisteDBMapper();
        return map.getMaterialFromLineItems(lineItemID);
    }

    @Override
    public void finalizeOrder(int order_id) throws OrderSampleException {
        OrderDBMapper map = new OrderDBMapper();
        map.finalizeOrder(order_id);
    }

    @Override
    public Stykliste getStyklistForOrder(int order_id) throws OrderSampleException {
        OrderDBMapper map = new OrderDBMapper();
        return map.getStyklistForOrder(order_id);
    }

    @Override
    public void createUser(String email, String password, String role) throws LoginSampleException {
        UserDBMapper map = new UserDBMapper();
        map.createUser(email, password, role);
    }

    @Override
    public boolean verifyUser(String email, String password) throws LoginSampleException {
        UserDBMapper map = new UserDBMapper();
        return map.verifyUser(email, password);
    }

    @Override
    public User getUserByEmail(String email) throws LoginSampleException {
        UserDBMapper map = new UserDBMapper();
        return map.getUserByEmail(email);
    }

    @Override
    public void deleteOrder(int order_id) throws OrderSampleException {
        OrderDBMapper map = new OrderDBMapper();
        map.deleteOrder(order_id);
    }

    @Override
    public void removeUser(User user) throws LoginSampleException {
        UserDBMapper map = new UserDBMapper();
        map.removeUser(user);
    }

    @Override
    public User login(String email, String password) throws LoginSampleException {
        UserDBMapper map = new UserDBMapper();
        return map.login(email, password);
    }

    @Override
    public User getUserByID(int id) throws LoginSampleException {
        UserDBMapper map = new UserDBMapper();
        return map.getUserByID(id);
    }

}
