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
    private int qty = 0;
    private int item_id;
    private String item_description;
    private String help_description;
    private float length;
    private float width;
    private float height;
    private String entity;
    private String materialtype;

    public Item(int item_id, String item_description, String help_description, float length, float width, float height, String entity, String materialtype) {
        this.item_id = item_id;
        this.item_description = item_description;
        this.help_description = help_description;
        this.length = length;
        this.width = width;
        this.height = height;
        this.entity = entity;
        this.materialtype = materialtype;
    }

    public int getQty() {
        return qty;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItem_description() {
        return item_description;
    }

    public String getHelp_description() {
        return help_description;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public String getEntity() {
        return entity;
    }

    public String getMaterialtype() {
        return materialtype;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" + "qty=" + qty + ", item_id=" + item_id + ", item_description=" + item_description + ", help_description=" + help_description + ", length=" + length + ", width=" + width + ", height=" + height + ", entity=" + entity + ", materialtype=" + materialtype + '}';
    }

    
    
}
