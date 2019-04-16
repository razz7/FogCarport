/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Rasmus2
 */
public class Material {
    private int item_id;
    private String item_description;
    private float width;
    private float height;
    private String entity;
    private String materialtype;

    public Material(int item_id, String item_description, float width, float height, String entity, String materialtype) {
        this.item_id = item_id;
        this.item_description = item_description;
        this.width = width;
        this.height = height;
        this.entity = entity;
        this.materialtype = materialtype;
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

    public String getMaterialtype() {
        return materialtype;
    }

    @Override
    public String toString() {
        return "Material{" + "item_id=" + item_id + ", item_description=" + item_description + ", width=" + width + ", height=" + height + ", entity=" + entity + ", materialtype=" + materialtype + '}';
    }
    
    
}
