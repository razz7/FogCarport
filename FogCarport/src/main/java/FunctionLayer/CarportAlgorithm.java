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

    public Stykliste carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id) throws MaterialSampleException {
        MaterialMapper materialMap = new MaterialMapper();
        ArrayList<Material> mat = materialMap.getAllMaterials();
        HashMap<Integer, Material> materials = new HashMap<>();
        for (Material m : mat) {
            materials.put(m.getItem_id(), m);
        }
        ArrayList<Material> arrList = new ArrayList<>();
        Stykliste styklist = new Stykliste(arrList, styklist_id);
        Material material;

        if (roofTilt == 0) { //Flat roof

            //CAROPRT MED SKUR
            // Tilføj 10 stolper til hvert hjørne af 97x97mm.trykimp.Stolpe
            material = materials.get(6);
            Material m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(3000); //Carporten har en standarthøjde som IKKE ændres i udregning
            m.setStyklistQty(10 + 1); //evt. + 1 Hvis døren ikke er placeret imod hjørnestolpen
            arrList.add(m);

            //Tilføj 2 remme i siderne der sadles ned i stolperne af 45x195mm.spærtræubh
            material = materials.get(5);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(length - shedLength + 10); //så lange som carporten -minus skuret og lidt til tilskæring
            m.setStyklistQty(2);
            arrList.add(m);

            //Tilføj 2 remme der sadles ned i stolperne for skuret af 45x195mm.spærtræubh
            material = materials.get(5);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(shedLength + 10); //så lange som skurets sider og lidt til tilskæring
            m.setStyklistQty(2);
            arrList.add(m);

            //Tilføj bræddebolte 2 pr stolpe under rem og 4 for stolperne uder samligen mellem caports og skurret remme af bræddebolt10x120mm
            material = (materials.get(16));
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //ingen længde
            m.setStyklistQty(6 * 2 + 2 * 4); //2 bræddebolte for hver stople under rem, bemærk at remmen samles af 2 stykker, over den stole der er mellem skur og carport,
            arrList.add(m);                   //Samlingen centreres over stolpen og der anvendes i alt 4 bolte til denne samling.

            //Tilføj firkantskiver for hver bræddebolt af firkantskiver40x40x11mm
            material = materials.get(17);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //ingen længde
            m.setStyklistQty(6 * 2 + 2 * 4); //samme mængde som der er bræddebolte
            arrList.add(m);

            //Montering af spær med max 60 cm mellemrum af 45x195mm.spærtræubh
            material = materials.get(5);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(length); //så lange som selve carportens brede
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 600)) + 1); //Et spær pr. højest 0.60 meter af hele carport længden + 1 til enden
            arrList.add(m);

            //Montering af universal højre beslag 1 pr spær af universal190mmhøjre
            material = materials.get(12);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //ingen længde
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 600)) + 1); //Et beslag pr spær i højre side
            arrList.add(m);

            //Montering af universal venstre beslag 1 pr spær af universal190mmvenstre
            material = materials.get(13);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //ingen længde
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 600)) + 1); //Et beslag pr spær i venstre side
            arrList.add(m);

            //Montering af venstr og højre niversalbeslag med 3 beslagskruger pr. flade af 4,0x50mm.beslagskruer250stk.
            material = materials.get(15);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty(1); //En pakke indholder 250 beslagskruger
            arrList.add(m);

            //Tilføj 2 Hulbånd i et kryds på tværs af selve carport sektionen af hulbånd1x20mm.10mtr.
            material = materials.get(10);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(10000); //rulle længe
            if ((Math.sqrt(Math.pow(length - shedLength - 55, 2) + Math.pow(width - 30, 2))) < 500) { //Der kan ikke bruges mere end 2 ruller
                m.setStyklistQty(1);
            } else {
                m.setStyklistQty(2);
            }
            arrList.add(m);

            //Montering af hulbånd med 2 beslagskruger pr. ende af 4,0x50mm.beslagskruer250stk.
            material = materials.get(15);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty(1); //En pakke indholder 250 beslagskruger
            arrList.add(m);

            //Montering af understern til begge carportens sider af 25x200mm.trykimp.Brædt
            material = materials.get(1);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength((length + 200) / (int) Math.ceil((length + 100) / 6000)); //Længde af understærn dømt ud fra carports længde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
            m.setStyklistQty(((int) Math.ceil((length + 100) / 6000)) * 2); //Mængde bedømt ud fra at brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
            arrList.add(m);

            //Montering af understern til carportens front og bag af 25x200mm.trykimp.Brædt
            material = materials.get(1);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength((width + 200) / (int) Math.ceil((width + 100) / 6000)); //Bredde af understærn dømt ud fra carports bredde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
            m.setStyklistQty(((int) Math.ceil((width + 100) / 6000)) * 2); //Mængde bedømt ud fra at brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
            arrList.add(m);

            //Montering af overstern til begge carportens sider af 25x125mm.trykimp.Brædt
            material = materials.get(2);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength((length + 200) / (int) Math.ceil((length + 100) / 6000)); //Længde af overstern dømt ud fra carports længde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
            m.setStyklistQty(((int) Math.ceil((length + 100) / 6000)) * 2); //Mængde bedømt ud fra at brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
            arrList.add(m);

            //Montering af overstern til carportens frontende af 25x125mm.trykimp.Brædt
            material = materials.get(2);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength((width + 200) / (int) Math.ceil((width + 100) / 6000)); //Længde af overstern dømt ud fra carports længde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
            m.setStyklistQty(((int) Math.ceil((width + 100) / 6000))); //Der skal kun monteres til forenden her, Mængde bedømt ud fra at brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
            arrList.add(m);

            //Montering af 1090mm bredde Trapez plader af PlastmoEcoliteblåtonet
            material = materials.get(8);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            if (length + 50 * 2 < 6) {
                m.setLength(length + 50 * 2); //Længde af carporten + 5 cm til hver ende, hvis carporten er under 6 meter og derfor kun bruger en plade på langs
                m.setStyklistQty(((int) Math.ceil((width + 50 * 2) / (1090 - 20 * 2)))); //Der skal monteres nok plader til at dække hele carportens bredde med 2cm overlap og 5 cm ekstra på hver side
            } else { //Da pladerne i dette tilfølde er længere ind de max 6m må der istedet være 2 set af plader istedet.
                m.setLength((length / 2) + 50 * 2 + 20 * 2); //Længde af carporten + 5cm til hver side + 2 cm til overlap
                m.setStyklistQty(((int) Math.ceil((width + 50 * 2) / (1090 - 20 * 2))) * 2); //Der skal monteres nok plader til at dække hele carportens bredde med 2cm overlap og 5 cm ekstra på hver side
            }
            arrList.add(m);

            //Montering af trapezplader med bundskruger af plastmobundskruer200stk.
            material = materials.get(9);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty(3); //En pakke indholder 200 bundskruger, da der bruges flere bundskruger pr. plade pr.trapezrille bruges 3 pakker.
            arrList.add(m);

            //Montering af vandbrædt til begge carportens sider af 19x100mm.trykimp.Brædt
            material = materials.get(7);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength((length + 200) / (int) Math.ceil((length + 100) / 6000)); //Længde af understærn dømt ud fra carports længde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
            m.setStyklistQty(((int) Math.ceil((length + 100) / 6000)) * 2); //Mængde bedømt ud fra at brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
            arrList.add(m);

            //Montering af vandbrædt til carportens frontende af 19x100mm.trykimp.Brædt
            material = materials.get(7);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength((width + 200) / (int) Math.ceil((width + 100) / 6000)); //Længde af overstern dømt ud fra carports længde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
            m.setStyklistQty(((int) Math.ceil((width + 100) / 6000))); //Der skal kun monteres til forenden her, Mængde bedømt ud fra at brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
            arrList.add(m);

            //Skruger til montering af stern og vandbrædt af 4,5x60mm.skruer200stk.
            material = materials.get(14);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty(1); //En pakke indholder 200 skruger
            arrList.add(m);

            //Montering af brædder til bedækningaf skur af 19x100mm.trykimp.Brædt
            material = materials.get(7);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(2100); //Skurets højde ændres ikke
            m.setStyklistQty((int) (((shedLength / (100 - 19 * 2)) * 2) + ((shedwidth / (100 - 19 * 2)) * 2))); //Udregning af antal brædder på baggund af deres overlap på omtrænt 19mm på hver side, med skurets mål.
            arrList.add(m);
            
            
            
            
            
            

        } else { //Roof tilt
            System.out.println("Hello World!");
        }
        return styklist;
    }

    public static void main(String[] args) throws MaterialSampleException { //Main til at teste algoritme
        MaterialMapper materialMap = new MaterialMapper();
        ArrayList<Material> materials = materialMap.getAllMaterials();
        for (Material mat : materials) {
            System.out.println(mat);
        }

        System.out.println("");

        CarportAlgorithm car = new CarportAlgorithm();
        Stykliste styk = car.carportAlgorithm(6000, 7800, 0, 5300, 2100, 1);
        for (int i = 0; i < styk.getStyklist().size(); i++) {
            System.out.println(styk.getStyklist().get(i));
        }
    }
}
