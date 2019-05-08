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

    private int styklistQty = 0;
    private int stockQty = 0;
    private float length = 0;
    private String constructionDescription = "";
    private int item_id;
    private String item_description;
    private float width;
    private float height;
    private String entity;
    private String materialtype;
    private float price;
    private int versionnr;

    public Material(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int versionnr) {
        this.item_id = item_id;
        this.item_description = item_description;
        this.width = width;
        this.height = height;
        this.entity = entity;
        this.materialtype = materialtype;
        this.price = price;
        this.versionnr = versionnr;
    }

    public int getStockQty() {
        return stockQty;
    }

    public int getStryklistQty() {
        return styklistQty;
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

    public void setStyklistQty(int qty) {
        this.styklistQty = qty;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getTotalItemPrice() {
        return price * styklistQty;
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

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public int getVersionnr() {
        return versionnr;
    }

    public void setVersionnr(int versionnr) {
        this.versionnr = versionnr;
    }


    public void setConstructionDescription(String constructionDescription) {
        this.constructionDescription = constructionDescription;
    }


    @Override
    public String toString() {
        return "Material{" + "styklistQty=" + styklistQty + ", stockQty=" + stockQty + ", length=" + length + ", constructionDescription=" + constructionDescription + ", item_id=" + item_id + ", item_description=" + item_description + ", width=" + width + ", height=" + height + ", entity=" + entity + ", materialtype=" + materialtype + ", price=" + price + ", versionnr=" + versionnr + '}';
    }

    
    
    
    public String toString1() {
        return "Materiale information: " + " materiale id: " + item_id +  ", materiale beskrivelse: " + item_description + ", højde: " + height  + ", bredde: " + width + ", entity: " + entity + ", materialetype: " + materialtype + ", pris: " + price + ", versionnr: " + versionnr;
    }

    

}
