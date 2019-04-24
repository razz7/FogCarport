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
public class Material {
    private int qty = 0;
    private float length = 0;
    private int item_id;
    private String item_description;
    private float width;
    private float height;
    private String entity;
    private String materialtype;
    private float price;

    public Material(int item_id, String item_description, float width, float height, String entity, String materialtype, float price) {
        this.item_id = item_id;
        this.item_description = item_description;
        this.width = width;
        this.height = height;
        this.entity = entity;
        this.materialtype = materialtype;
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public float getLength() {
        return length;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItem_description() {
        return item_description;
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

    public String getMaterialType() {
        return materialtype;
    }

    public float getPrice() {
        return price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setLength(float length) {
        this.length = length;
    }
    
    public float getTotalItemPrice(){
        return price * qty;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public void setMaterialtype(String materialtype) {
        this.materialtype = materialtype;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" + "qty=" + qty + ", length=" + length + ", item_id=" + item_id + ", item_description=" + item_description + ", width=" + width + ", height=" + height + ", entity=" + entity + ", materialtype=" + materialtype + ", price=" + price + '}';
    }
    

}
