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
 * @author Rumle
 */
public interface DatabaseFacadeInterface {

    public ArrayList<Material> getAllMaterials() throws MaterialSampleException;

    public void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException;

    public void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity) throws MaterialSampleException, ClassNotFoundException;

    public void deleteMaterial(int item_id) throws MaterialSampleException;

    public Material getMaterialbyID(int item_id) throws MaterialSampleException;

    public ArrayList<Material> getAllMaterialbyType(String type) throws MaterialSampleException;

    public ArrayList<Order> getAllOrders() throws OrderSampleException;

    public Order getOrderFromId(int order_id) throws OrderSampleException;

    public void saveOrder(Order order) throws OrderSampleException, StyklistException;

    public void editLineItemsFromOrderID(int item_id, String item_description, float width, float height,
            String entity, String materialtype, float price, int orderquantity, int order_id);

    public void saveLineItemsInDB(Stykliste styklist, int order_id) throws StyklistException;

    public Material getMaterialFromLineItems(int lineItemID) throws StyklistException;

}
