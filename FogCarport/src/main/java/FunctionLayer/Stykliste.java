/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author Rasmus2
 */
public class Stykliste {
    private final ArrayList<Material> styklist;
    private final int styklist_id;

    /**
     * Constructor for Stykliste objects
     * 
     * @param styklist
     * @param styklist_id 
     */
    public Stykliste(ArrayList<Material> styklist, int styklist_id) {
        this.styklist = styklist;
        this.styklist_id = styklist_id;
    }

    /**
     * Returns stykliste parameter
     * 
     * @return styklist
     */
    public ArrayList<Material> getStyklist() {
        return styklist;
    }

    
    /**
     * Returns stykliste_id parameter
     * 
     * @return styklist_id
     */
    public int getStyklist_id() {
        return styklist_id;
    }

    /**
     * Deletes Material object from styklist parameter
     * 
     * @param item 
     */
    public void deleteItem(Material item) {
        styklist.remove(item);
    }

    /**
     * Adds Material object to styklist parameter
     * 
     * @param item 
     */
    public void addItem(Material item) {
        styklist.add(item);
    }

    @Override
    public String toString() {
        return "Stykliste{ " + "styklist= " + styklist + ", styklist_id= " + styklist_id + '}';
    }

}
