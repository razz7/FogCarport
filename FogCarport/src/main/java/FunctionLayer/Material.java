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
    private int lineItemID;

    /**
     * Constructor for Material object
     * 
     * @param item_id
     * @param item_description
     * @param width
     * @param height
     * @param entity
     * @param materialtype
     * @param price
     * @param versionnr 
     */
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

    /**
     * Returns stockQty parameter
     * 
     * @return stockQty
     */
    public int getStockQty() {
        return stockQty;
    }

    /**
     * Returns styklistQty parameter
     * 
     * @return styklistQty
     */
    public int getStryklistQty() {
        return styklistQty;
    }

    /**
     * Returns length parameter
     * 
     * @return length
     */
    public float getLength() {
        return length;
    }

    /**
     * Returns item_id parameter
     * 
     * @return item_id
     */
    public int getItem_id() {
        return item_id;
    }

    /**
     * Returns item_description parameter
     * 
     * @return item_description
     */
    public String getItem_description() {
        return item_description;
    }

    /**
     * Returns width parameter
     * 
     * @return width
     */
    public float getWidth() {
        return width;
    }

    /**
     * Returns height parameter
     * 
     * @return height
     */
    public float getHeight() {
        return height;
    }

    /**
     * Returns entity parameter
     * 
     * @return entity
     */
    public String getEntity() {
        return entity;
    }

    /**
     * Returns materialtype parameter
     * 
     * @return materialtype
     */
    public String getMaterialType() {
        return materialtype;
    }

    /**
     * Returns price parameter
     * 
     * @return price
     */
    public float getPrice() {
        return price;
    }

     /**
     * Sets parameter qty
     * 
     * @param qty
     */
    public void setStyklistQty(int qty) {
        this.styklistQty = qty;
    }

    /**
     * Sets parameter length
     * 
     * @param length
     */
    public void setLength(float length) {
        this.length = length;
    }

    /**
     * Returns price times styklistQty
     * 
     * @return price * styklistQty
     */
    public float getTotalItemPrice() {
        return price * styklistQty;
    }

    /**
     * Sets parameter item_id
     * 
     * @param item_id
     */
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    /**
     * Sets parameter item_description
     * 
     * @param item_description
     */
    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    /**
     * Sets parameter width
     * 
     * @param width
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * Sets parameter height
     * 
     * @param height
     */
    public void setHeight(float height) {
        this.height = height;
    }
    
    /**
     * Sets parameter entity
     * 
     * @param entity
     */
    public void setEntity(String entity) {
        this.entity = entity;
    }

    /**
     * Sets parameter materialtype
     * 
     * @param materialtype
     */
    public void setMaterialtype(String materialtype) {
        this.materialtype = materialtype;
    }
    
    /**
     * Sets parameter price
     * 
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    /**
     * Sets parameter stockQty 
     * 
     * @param stockQty
     */
    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    /**
     * Returns versionnr parameter
     * 
     * @return vesionnr
     */
    public int getVersionnr() {
        return versionnr;
    }

    /**
     * Sets parameter versionnr
     * 
     * @param versionnr 
     */
    public void setVersionnr(int versionnr) {
        this.versionnr = versionnr;
    }

    /**
     * Sets parameter constructionDescription
     * 
     * @param constructionDescription 
     */
    public void setConstructionDescription(String constructionDescription) {
        this.constructionDescription = constructionDescription;
    }
    
    /**
     * Returns constructionDescription parameter
     * 
     * @return constructionDescription
     */
    public String GettConstructionDescription() {
        return constructionDescription;
    }

    /**
     * Returns lineItemID parameter
     * 
     * @return lineItemID
     */
    public int getLineItemID() {
        return lineItemID;
    }

    /**
     * Sets parameter lineItemID
     * 
     * @param lineItemID
     */
    public void setLineItemID(int lineItemID) {
        this.lineItemID = lineItemID;
    }
    

    @Override
   public String toString() {
        return "Materiale information: " + " materiale id: " + item_id + 
                ", materiale beskrivelse: " + item_description + ", højde: " +
                height  + ", bredde: " + width + ", entity: " + entity + ", materialetype: " + 
                materialtype + ", pris: " + price + ", versionnr: " + versionnr;
    }
    
    
    
    public String toString1() {
        return "Materiale information: " + " materiale id: " + item_id +  ", materiale beskrivelse: " + item_description + ", højde: " + height  + ", bredde: " + width + ", entity: " + entity + ", materialetype: " + materialtype + ", pris: " + price + ", versionnr: " + versionnr;
    }

    public String toString2() {
        return "Materiale information: " + " materiale id: " + item_id + 
                ", materiale beskrivelse: " + item_description + ", højde: " +
                height  + ", bredde: " + width + ", entity: " + entity + ", materialetype: " + 
                materialtype + ", pris: " + price + ", versionnr: " + versionnr + ", constructionDescription: " + constructionDescription;
    }
    

}
