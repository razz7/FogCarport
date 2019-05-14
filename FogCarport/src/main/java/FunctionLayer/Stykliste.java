/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author rasmu
 */
public class Stykliste {
    private final ArrayList<Material> styklist;
    private final int styklist_id;

    public Stykliste(ArrayList<Material> styklist, int styklist_id) {
        this.styklist = styklist;
        this.styklist_id = styklist_id;
    }

    public ArrayList<Material> getStyklist() {
        return styklist;
    }

    public int getStyklist_id() {
        return styklist_id;
    }

    public void deleteItem(Material item) {
        styklist.remove(item);
    }

    public void addItem(Material item) {
        styklist.add(item);
    }

    @Override
    public String toString() {
        return "Stykliste{ " + "styklist= " + styklist + ", styklist_id= " + styklist_id + '}';
    }

}
