/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.MaterialMapper;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author rasmu
 */
public class CarportAlgorithm {

    private Stykliste carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id) throws MaterialSampleException {
        MaterialMapper materialMap = new MaterialMapper();
        ArrayList<Material> mat = materialMap.getAllMaterials();
        HashMap<Integer, Material> materials = new HashMap<>();
        for (Material m : mat) {
            
            materials.put(m.getItem_id(), m);
        }

        ArrayList<Material> arrList = new ArrayList<>();
        Stykliste styklist = new Stykliste(arrList, styklist_id);
        Material material = null;

        if (roofTilt == 0) { //Flat roof

            //skur
            // Tilføj 4 stolper til hvert hjørne af 97x97mm.trykimp.Stolpe
            material = materials.get(2);
            material.setStyklistQty(4);
            arrList.add(material);

            //
        } else { //Roof tilt

        }
        return styklist;
    }

    public static void main(String[] args) throws MaterialSampleException { //Main til at teste algoritme
        MaterialMapper materialMap = new MaterialMapper();
        ArrayList<Material> materials = materialMap.getAllMaterials();
        for (Material mat : materials) {
            System.out.println(mat);
        }

    }
}
