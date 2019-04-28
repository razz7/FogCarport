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

            //CAROPRT MED SKUR
            // Tilføj 10 stolper til hvert hjørne af 97x97mm.trykimp.Stolpe
            material = materials.get(6);
            material.setLength(300); //Carporten har en standarthøjde som IKKE ændres i udregning
            material.setStyklistQty(10);
            arrList.add(material);

            //Tilføj 2 remme i siderne der sadles ned i stolperne af 45x195mm.spærtræubh
            material = materials.get(5);
            material.setLength(length - shedLength + 10); //så lange som carporten -minus skuret og lidt til tilskæring
            material.setStyklistQty(2);
            arrList.add(material);
            
            //Tilføj 1 rem der skæres over til siderne der sadles ned i stolperne for skuret af 45x195mm.spærtræubh
            material = materials.get(5);
            material.setLength(shedLength * 2 + 10); //så lange som begge af skurets sider lagt sammen og lidt til tilskæring
            material.setStyklistQty(1);
            arrList.add(material);
            
            //Tilføj bræddebolte 2 pr stolpe under rem og 4 for stolperne uder samligen mellem caports og skurret remme af bræddebolt10x120mm
            material = materials.get(16);
            material.setLength(0); //ingen længde
            material.setStyklistQty(6 * 2 + 2 * 4); //2 bræddebolte for hver stople under rem, bemærk at remmen samles af 2 stykker, over den stole der er mellem skur og carport,
            arrList.add(material);                   //Samlingen centreres over stolpen og der anvendes i alt 4 bolte til denne samling.
            
            //Tilføj firkantskiver for hver bræddebolt af firkantskiver40x40x11mm
            material = materials.get(17);
            material.setLength(0); //ingen længde
            material.setStyklistQty(6 * 2 + 2 * 4); //samme mængde som der er bræddebolte
            arrList.add(material);   
            
            //Montering af spær med 55 cm mellemrum af 45x195mm.spærtræubh
            material = materials.get(5);
            material.setLength(length); //så lange som selve carportens brede
            material.setStyklistQty((int)((length) / 0.55) + 1); //Et spær pr 0.55 meter af hele carport længden + 1 til enden
            arrList.add(material);
            
            //Montering af universal højre beslag 1 pr spær af universal190mmhøjre
            material = materials.get(12);
            material.setLength(length); //ingen længde
            material.setStyklistQty((int)((length) / 0.55) + 1); //Et beslag pr spær i højre side
            arrList.add(material);
            
            //Montering af universal venstre beslag 1 pr spær af universal190mmvenstre
            material = materials.get(13);
            material.setLength(length); //ingen længde
            material.setStyklistQty((int)((length) / 0.55) + 1); //Et beslag pr spær i venstre side
            arrList.add(material);
            
            //Montering af venstr og højre niversalbeslag med 3 beslagskruger pr. flade af 4,0x50mm.beslagskruer250stk.
            material = materials.get(15);
            material.setLength(0); //Ingen længde
            material.setStyklistQty(1); //En pakke indholder 250 beslagskruger
            arrList.add(material);
            
            //Tilføj 2 Hulbånd i et kryds på tværs af selve carport sektionen af hulbånd1x20mm.10mtr.
            material = materials.get(10);
            material.setLength(10); //rulle længe
            material.setStyklistQty((int)Math.ceil((Math.sqrt(Math.pow(length - shedLength - 0.55, 2) + Math.pow(width - 0.30, 2))) / 10) * 2); //Længden af den ukende side på tværs af selve carporten fra første spær til pæl ved Math.sqrt((Math.pow(length - 0.55, 2) + Math.pow(width - 0.30, 2)) over eller understiger aldrig brugen af 10 meter hulånd pr rulle og er derfor bare 2 ruller.
            arrList.add(material);
            
            //Montering af hulbånd med 2 beslagskruger pr. ende af 4,0x50mm.beslagskruer250stk.
            material = materials.get(15);
            material.setLength(0); //Ingen længde
            material.setStyklistQty(1); //En pakke indholder 250 beslagskruger
            arrList.add(material);
            
            //Montering af understern til begge carportens sider af 25x200mm.trykimp.Brædt
            material = materials.get(1);
            material.setLength((length + 0.20f) / (int)Math.ceil((length + 0.10) / 6)); //Længde af understærn dømt ud fra carports længde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
            material.setStyklistQty(((int)Math.ceil((length + 0.10) / 6))* 2); //Mængde bedømt ud fra af brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
            arrList.add(material);
            
            //Montering af understern til carportens front og bag af 25x200mm.trykimp.Brædt
            material = materials.get(12);
            material.setLength((width + 0.20f) / (int)Math.ceil((width + 0.10) / 6)); //Bredde af understærn dømt ud fra carports bredde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
            material.setStyklistQty(((int)Math.ceil((width + 0.10) / 6))* 2); //Mængde bedømt ud fra af brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
            arrList.add(material);
            
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
        
        System.out.println((int)Math.ceil(1.3));
        System.out.println((int)Math.ceil((Math.sqrt(Math.pow(7.8 - 0.55, 2) + Math.pow(6 - 0.30, 2))) / 10) * 2);
        
        CarportAlgorithm car = new CarportAlgorithm();
        Stykliste styk = car.carportAlgorithm(6, 7.8f, 0, 6, 2.10f, 1);
        for (int i = 0; i < styk.getStyklist().size(); i ++) {
            System.out.println(styk.getStyklist().get(i));
        }
    }
}
