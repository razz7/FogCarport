/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.DatabaseFacade;
import DBAccess.DatabaseFacadeInterface;
import java.util.ArrayList;

/**
 *
 * @author Ludvig
 */
public class FunctionManager implements DatabaseFacadeInterface, LogicFacadeInterface {


    @Override
    public ArrayList<FunctionLayer.Material> getAllMaterials() throws MaterialSampleException {
        DatabaseFacade DBF = new DatabaseFacade();
        return DBF.getAllMaterials();
    }

    @Override
    public void addNewMaterial(String item_description, float width,
            float height, String entity, String materialtype, float price,
            int quantity) throws MaterialSampleException {
        
        DatabaseFacade mapper = new DatabaseFacade();
        mapper.addNewMaterial(item_description, width, height, entity,
                materialtype, price, quantity);
    }

    @Override
    public void updateMaterialData(int item_id, String item_description,
            float width, float height, String entity, String materialtype,
            float price, int quantity) throws MaterialSampleException, ClassNotFoundException {
        DatabaseFacade mapper = new DatabaseFacade();
        mapper.updateMaterialData(item_id, item_description, width, height,
                entity, materialtype, price, quantity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMaterial(int item_id) throws MaterialSampleException {
        DatabaseFacade map = new DatabaseFacade();
        map.deleteMaterial(item_id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FunctionLayer.Material getMaterialbyID(int item_id) throws MaterialSampleException {
        DatabaseFacade map = new DatabaseFacade();
        return map.getMaterialbyID(item_id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stykliste getLineitemsByOrderId(int order_id) throws MaterialSampleException {
        DatabaseFacade map = new DatabaseFacade();
        return map.getLineitemsByOrderId(order_id);
    }

    @Override
    public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException {
        DatabaseFacade map = new DatabaseFacade();
        return map.getAllMaterialbyType(type);
    }

    @Override
    public ArrayList<Order> getAllOrders() throws OrderSampleException {
        DatabaseFacade map = new DatabaseFacade();
        return map.getAllOrders();
    }

     @Override
    public Order getOrderFromId(int order_id) throws OrderSampleException {
        DatabaseFacade map = new DatabaseFacade();
        return map.getOrderFromId(order_id);

    }


    @Override
    public void saveOrder(Order order) throws OrderSampleException{
        DatabaseFacade map = new DatabaseFacade();
        map.saveOrder(order);
    }


    @Override
    public void editLineItemsFromOrderID(int lineitem_id, String item_description, float width, float height, String entity, String materialtype, float price, int orderquantity, int order_id) {
        DatabaseFacade map = new DatabaseFacade();
        map.editLineItemsFromOrderID(lineitem_id, item_description, width, height, entity, materialtype, price, orderquantity, order_id);

    }

    @Override
    public void saveLineItemsInDB(Stykliste styklist, int order_id) throws StyklistException {
        DatabaseFacade map = new DatabaseFacade();
        map.saveLineItemsInDB(styklist, order_id);
    }

    @Override
    public Material getMaterialFromLineItems(int lineItemID) throws StyklistException {
        DatabaseFacade map = new DatabaseFacade();
        return map.getMaterialFromLineItems(lineItemID);
    }
    
    @Override
    public void finalizeOrder(int order_id) throws OrderSampleException{
        DatabaseFacade map = new DatabaseFacade();
        map.finalizeOrder(order_id);
    }
    
    @Override
    public Stykliste getStyklistForOrder(int order_id) throws OrderSampleException{
        DatabaseFacade map = new DatabaseFacade();
        return map.getStyklistForOrder(order_id);
    }

        @Override
    public void createUser(User user) throws LoginSampleException {
        DatabaseFacade map = new DatabaseFacade();
        map.createUser(user);
    }

    @Override
    public boolean verifyUser(String email, String password) throws LoginSampleException {
        DatabaseFacade map = new DatabaseFacade();
        return map.verifyUser(email, password);
    }

    @Override
    public User getUserByEmail(String email) throws LoginSampleException {
        DatabaseFacade map = new DatabaseFacade();
        return map.getUserByEmail(email);
    }

    @Override
    public void deleteOrder(int order_id) throws OrderSampleException {
        DatabaseFacade map = new DatabaseFacade();
        map.deleteOrder(order_id);
    }


    @Override
    public FunctionLayer.Stykliste carportAlgorithm(float width, float length,
            float roofTilt, float shedwidth, float shedLength, int styklist_id) throws MaterialSampleException {
            LogicFacade log = new LogicFacade();
            return log.carportAlgorithm(width, length, roofTilt, shedwidth,
                    shedLength, styklist_id);
    }

    @Override
    public FunctionLayer.Material Material(int item_id, String item_description,
            float width, float height, String entity, String materialtype,
            float price, int versionnr) {
       
       Material mat = new Material(item_id, item_description, width, height, entity,
               materialtype, price, versionnr);
       return mat;
    }

    @Override
    public FunctionLayer.Order Order(int order_id, float width, float length,
            float height, float roofTilt, float shedWidth, float shedLength) {
        Order order = new Order(order_id, width, length, height, roofTilt, shedWidth, shedLength);
        return order;
    }

    @Override
    public FunctionLayer.Stykliste Stykliste(
            ArrayList<FunctionLayer.Material> styklist, int styklist_id) {
            LogicFacade log = new LogicFacade();
            Stykliste stk = log.Stykliste(styklist, styklist_id);
            return stk;
    }

    @Override
    public FunctionLayer.User User(String email, int id, String role) {
       LogicFacade log = new LogicFacade();
       User user = log.User(email, id, role);
       return user;
    }

    @Override
    public String getSalt(int length) {
       LogicFacade log = new LogicFacade();
       return log.getSalt(length);
    }

    @Override
    public String generateSecurePassword(String password, String salt) {
        LogicFacade log = new LogicFacade();
        return log.generateSecurePassword(password, salt);
    }

    @Override
    public boolean verifyUserPassword(String providedPassword,
            String securepassword, String salt) {
        LogicFacade log = new LogicFacade();
        return log.verifyUserPassword(providedPassword, securepassword, salt);
    }

}
