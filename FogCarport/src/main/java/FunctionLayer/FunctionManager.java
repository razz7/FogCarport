/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.DatabaseFacadeInterface;
import DBAccess.MaterialMapper;
import DBAccess.OrderMapper;
import DBAccess.StyklisteMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

/**
 *
 * @author Ludvig
 */
public class FunctionManager implements DatabaseFacadeInterface, LogicFacadeInterface {

    private final StyklisteMapper StykMapper = StyklisteMapper.instance();
    private final OrderMapper OrdMapper = OrderMapper.instance();
    private final MaterialMapper MatMapper = MaterialMapper.instance();
    private final UserMapper UseMapper = UserMapper.instance();
    private CarportAlgorithm ca = new CarportAlgorithm();
    private Encryption ec = new Encryption();
    

    @Override
    public void editLineItemsFromOrderID(int item_id, String item_description, float width, float height,
            String entity, String materialtype, float price, int orderquantity, int order_id) {
        StykMapper.editLineItemsFromOrderID(item_id, item_description, width, height,
                entity, materialtype, price, orderquantity, order_id);
    }

    @Override
    public void saveLineItemsInDB(Stykliste styklist, int order_id) {
        StykMapper.saveLineItemsInDB(styklist, order_id);
    }

    @Override
    public Material getMaterialFromLineItems(int lineItemID) throws StyklistException {
        return StykMapper.getMaterialFromLineItems(lineItemID);
    }

    @Override
    public ArrayList<Order> getAllOrders() throws OrderSampleException {
        return OrdMapper.getAllOrders();
    }

    @Override
    public Order getOrderFromId(int order_id) throws OrderSampleException {
        return OrdMapper.getOrderFromId(order_id);
    }

    @Override
    public Stykliste getStyklistForOrder(int order_id) throws OrderSampleException {
        return OrdMapper.getStyklistForOrder(order_id);
    }

    @Override
    public void saveOrder(Order order) throws OrderSampleException {
        OrdMapper.saveOrder(order);
    }

    @Override
    public void finalizeOrder(int order_id) throws OrderSampleException {
        OrdMapper.finalizeOrder(order_id);
    }
    
    //@Override
    public void setPriceOrder(int order_id, float price) throws OrderSampleException {
        OrdMapper.setPriceOrder(order_id, price);
    }
    
    public float getPriceFromId(int order_id) throws OrderSampleException{
        return OrdMapper.getPriceFromId(order_id);
    }

    @Override
    public void deleteOrder(int order_id) throws OrderSampleException {
        OrdMapper.deleteOrder(order_id);
    }
    
    @Override
    public ArrayList<Material> getAllMaterials() throws MaterialSampleException {
        return MatMapper.getAllMaterials();
    }

    @Override
    public void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException {
        MatMapper.addNewMaterial(item_description, width, height, entity, materialtype, price, quantity);
    }

    @Override
    public void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException, ClassNotFoundException {
        MatMapper.updateMaterialData(item_id, item_description, width, height, entity, materialtype, price, quantity);
    }

    @Override
    public void deleteMaterial(int item_id) throws MaterialSampleException {
        MatMapper.deleteMaterial(item_id);
    }

    @Override
    public Material getMaterialbyID(int item_id) throws MaterialSampleException {
        return MatMapper.getMaterialbyID(item_id);
    }

    @Override
    public Stykliste getLineitemsByOrderId(int order_id) throws MaterialSampleException {
        return MatMapper.getLineitemsByOrderId(order_id);
    }

    @Override
    public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException {
        return MatMapper.getAllMaterialbyType(type);
    }

    @Override
    public User login(String email, String password) throws LoginSampleException {
        return UseMapper.login(email, password);
    }

    @Override
    public boolean verifyUser(String email, String password) throws LoginSampleException {
        return UseMapper.verifyUser(email, password);
    }

    @Override
    public void removeUser(User user) throws LoginSampleException {
        UseMapper.removeUser(user);
    }

    @Override
    public User getUserByEmail(String email) throws LoginSampleException {
        return UseMapper.getUserByEmail(email);
    }

    @Override
    public Stykliste carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id) throws MaterialSampleException {
        return ca.carportAlgorithm(width, length, roofTilt, shedwidth, shedLength, styklist_id);
    }

    public static void main(String[] args) throws MaterialSampleException, OrderSampleException {
        FunctionManager fm = new FunctionManager();
        
        //fm.setPriceOrder(71, 2400);
        System.out.println(fm.getPriceFromId(71));
        
//        Stykliste sl = fm.getStyklistForOrder(77);
//        ArrayList<Material> ml = sl.getStyklist();
//        System.out.println(ml.get(1).getPrice());

        //fm.deleteOrder(22);
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

    @Override
    public void createUser(String email, String password, String role) throws LoginSampleException {
       UseMapper.createUser(email, password, role);
    }
}
