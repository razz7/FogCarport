/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Material;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;

/**
 *
 * @author Ludvig
 */
public abstract class StyklisteMapper {

    public static StyklisteMapper instance() {
        return StyklisteDBMapper.getInstance();
    }

    public abstract void editLineItemsFromOrderID(int item_id, String item_description, float width, float height,
            String entity, String materialtype, float price, int orderquantity, int order_id);

    public abstract void saveLineItemsInDB(Stykliste styklist, int order_id);

    public abstract Material getMaterialFromLineItems(int lineItemID) throws StyklistException;

}
