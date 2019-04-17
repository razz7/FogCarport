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
    private float length;
    private Material material;

    public Item(float length, Material material) {
        this.length = length;
        this.material = material;
    }

    public int getQty() {
        return qty;
    }

    public float getLength() {
        return length;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Item{" + "qty=" + qty + ", length=" + length + ", material=" + material + '}';
    }

}
