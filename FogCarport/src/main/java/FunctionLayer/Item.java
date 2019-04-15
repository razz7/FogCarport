/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author rasmu
 */
public class Item {
    private int item_id;
    private float length;
    private int qty;
    private String components;
    private String description;
    private String materialtype;

    public Item(int item_id, float length, int qty, String components, String description, String materialtype) {
        this.item_id = item_id;
        this.length = length;
        this.qty = qty;
        this.components = components;
        this.description = description;
        this.materialtype = materialtype;
    }

    public int getItem_id() {
        return item_id;
    }

    public float getLength() {
        return length;
    }

    public int getQty() {
        return qty;
    }

    public String getComponents() {
        return components;
    }

    public String getDescription() {
        return description;
    }

    public String getMaterialtype() {
        return materialtype;
    }

    @Override
    public String toString() {
        return "Item{" + "item_id=" + item_id + ", length=" + length + ", qty=" + qty + ", components=" + components + ", description=" + description + ", materialtype=" + materialtype + '}';
    }
    
    
}
