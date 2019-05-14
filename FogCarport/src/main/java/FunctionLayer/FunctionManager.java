/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.MaterialMapper;
import DBAccess.OrderMapper;
import DBAccess.StyklisteMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

/**
 *
 * @author Ludvig
 */
public class FunctionManager {

    private final StyklisteMapper StykMapper = StyklisteMapper.instance();
    private final OrderMapper OrdMapper = OrderMapper.instance();
    private final MaterialMapper MatMapper = MaterialMapper.instance();
    private final UserMapper UseMapper = UserMapper.instance();
    private CarportAlgorithm ca = new CarportAlgorithm();
    private Encryption ec = new Encryption();

    

    public void editLineItemsFromOrderID(int item_id, String item_description, float width, float height,
            String entity, String materialtype, float price, int orderquantity, int order_id) {
        StykMapper.editLineItemsFromOrderID(item_id, item_description, width, height,
                entity, materialtype, price, orderquantity, order_id);
    }

    public void saveLineItemsInDB(Stykliste styklist, int order_id) {
        StykMapper.saveLineItemsInDB(styklist, order_id);
    }

    public Material getMaterialFromLineItems(int lineItemID) throws StyklistException {
        return StykMapper.getMaterialFromLineItems(lineItemID);
    }

    public ArrayList<Order> getAllOrders() throws OrderSampleException {
        return OrdMapper.getAllOrders();
    }

    public Order getOrderFromId(int order_id) throws OrderSampleException {
        return OrdMapper.getOrderFromId(order_id);
    }

    public Stykliste getStyklistForOrder(int order_id) throws OrderSampleException {
        return OrdMapper.getStyklistForOrder(order_id);
    }

    public void saveOrder(Order order) throws OrderSampleException {
        OrdMapper.saveOrder(order);
    }
    
    public void finalizeOrder(int order_id) throws OrderSampleException {
        OrdMapper.finalizeOrder(order_id);
    }
    
    public void deleteOrder(int order_id) throws OrderSampleException{
        OrdMapper.deleteOrder(order_id);
    }

    public ArrayList<Material> getAllMaterials() throws MaterialSampleException {
        return MatMapper.getAllMaterials();
    }

    public void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException {
        MatMapper.addNewMaterial(item_description, width, height, entity, materialtype, price, quantity);
    }

    public void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException, ClassNotFoundException {
        MatMapper.updateMaterialData(item_id, item_description, width, height, entity, materialtype, price, quantity);
    }

    public void deleteMaterial(int item_id) throws MaterialSampleException {
        MatMapper.deleteMaterial(item_id);
    }

    public Material getMaterialbyID(int item_id) throws MaterialSampleException {
        return MatMapper.getMaterialbyID(item_id);
    }

    public Stykliste getLineitemsByOrderId(int order_id) throws MaterialSampleException {
        return MatMapper.getLineitemsByOrderId(order_id);
    }

    public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException {
        return MatMapper.getAllMaterialbyType(type);
    }
    
    public void createUser(User user) throws LoginSampleException{
        UseMapper.createUser(user);
    }
    
    public User login(String email, String password) throws LoginSampleException{
        return UseMapper.login(email, password);
    }
    
    public boolean verifyUser(String email, String password) throws LoginSampleException{
        return UseMapper.verifyUser(email, password);
    }
    
    public void removeUser(User user) throws LoginSampleException{
        UseMapper.removeUser(user);
    }
    
    public User getUserByEmail(String email) throws LoginSampleException {
        return UseMapper.getUserByEmail(email);
    }

    public Stykliste carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id) throws MaterialSampleException {
        return ca.carportAlgorithm(width, length, roofTilt, shedwidth, shedLength, styklist_id);
    }

    public static void main(String[] args) throws MaterialSampleException, OrderSampleException {
        FunctionManager fm = new FunctionManager();

        fm.deleteOrder(19);
    }
}