/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.MaterialMapper;
import java.util.ArrayList;

/**
 *
 * @author rasmu
 */
public class CarportAlgorithm {

    private Stykliste carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id) throws MaterialSampleException {
        ArrayList<Material> materials = MaterialMapper.getAllMaterials();
        ArrayList<Material> arrList = new ArrayList<>();
        Stykliste styklist = new Stykliste(arrList, styklist_id);

        if (roofTilt == 0) { //Flat roof


        } else { //Roof tilt

        }
        return styklist;
    }

    public static void main(String[] args) throws MaterialSampleException { //Main til at teste algoritme
        ArrayList<Material> materials = MaterialMapper.getAllMaterials();
        for (Material mat : materials) {
            System.out.println(mat);
        }

    }
}
