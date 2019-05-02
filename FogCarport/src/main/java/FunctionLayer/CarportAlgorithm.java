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
        Material m;

        if (roofTilt == 0) { //Flat roof

            //CAROPRT MED SKUR
            // Tilføj 10 stolper til hvert hjørne af 97x97mm.trykimp.Stolpe
            material = materials.get(6);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
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

            //Montering af venstre og højre universalbeslag med 3 beslagskruger pr. flade af 4,0x50mm.beslagskruer250stk.
            material = materials.get(15);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty(1); //En pakke indholder 250 beslagskruger
            arrList.add(m);

            //Tilføj 2 Hulbånd i et kryds på tværs af selve carport sektionen af hulbånd1x20mm.10mtr.
            material = materials.get(10);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(10000); //rulle længe
            if ((Math.sqrt(Math.pow(length - shedLength - 600, 2) + Math.pow(width - 30, 2))) < 500) { //Hulbånd placeres et spær inde, der kan ikke bruges mere end 2 ruller
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

            //Montering af brædder til yderste bedækning af skur af 19x100mm.trykimp.Brædt
            material = materials.get(7);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(2100); //Skurets højde ændres ikke
            m.setStyklistQty((int) (((shedLength / 60) * 2) + ((shedwidth / 60) * 2))); //Udregning af antal brædder på baggund af at beklædningsbrædder monteres med 6.cm mellemrum, med skurets mål.
            arrList.add(m);

            //Montering af yderste bedækning med 6 skruger pr. planke af 4,5x70mm.Skruer400stk.
            material = materials.get(18);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty((int) Math.ceil((((shedLength / 60) * 2) + ((shedwidth / 60) * 2)) * 6 / 400)); //Mængden af brædder divideret med 400 og rundet op til et helt tal, hvilket angiver hvor mange pakker af 400 vi så skal bruge hvis hvert brædt bruger 4 skruger.
            arrList.add(m);

            //Montering af inderste bedækning med 3 skruger pr. planke af 4,5x50mm.Skruer300stk.
            material = materials.get(19);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty((int) Math.ceil((((shedLength / 60) * 2) + ((shedwidth / 60) * 2)) * 3 / 300)); //Mængden af brædder divideret med 300 og rundet op til et helt tal, hvilket angiver hvor mange pakker af 300 vi så skal bruge hvis hvert brædt bruger 4 skruger.
            arrList.add(m);

            //Montering af 12 løsholter til skur gavler af 45x95mm.Reglarub.
            material = materials.get(4);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(shedwidth / 2); //Længden af løsholtere med spllittelse i bjælkerne og lidt ekstra til tilskærelse og tilpadsning ud fra skurets bredde.
            m.setStyklistQty(12); //Der skal uanset hvad bruges 12 løsholtere til gavlen for indersiden af skurets konstruktion.
            arrList.add(m);

            //Montering af 4 løsholter til skur sider af 45x95mm.Reglarub.
            material = materials.get(4);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(shedLength); //Længden af løsholtere og lidt ekstra til tilskærelse og tilpadsning ud fra skurets længde.
            m.setStyklistQty(4); //Der skal uanset hvad bruges 4 løsholtere til indersiden af skurets konstruktion.
            arrList.add(m);

            //Montering af vinkelbeslag til montering af løsholter i skur med 2 beslag pr. lysholter af vinkelbeslag35
            material = materials.get(22);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde.
            m.setStyklistQty((12 + 4) * 2); //Der skal uanset hvad bruges 2 vinkelbeslag pr. lysholter i skuret.
            arrList.add(m);

            //Montering af lægte til z på bagside af dør af 38x73mm.Lægteubh.
            material = materials.get(3);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(4200); //Fast længde på alle modeller.
            m.setStyklistQty(1); //Fast mængde på alle modeller.
            arrList.add(m);

            //Montering af 2 t-hængseler til skur dør af thængsel390mm.
            material = materials.get(21);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde.
            m.setStyklistQty(2); //Fast mængde på alle modeller, da en dør skal bruge mindst 2 t-hængsler.
            arrList.add(m);

            //Montering af et sæt ståldørsgreb til lås på dør i skur af stalddørsgreb50x75
            material = materials.get(20);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde.
            m.setStyklistQty(1); //Fast mængde på alle modeller, da en dør kun skal et sæt ståldørsgreb.
            arrList.add(m);

        } else { //Roof tilt ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //CAROPRT MED OG UDEN SKUR
            if (shedLength != 0 || shedwidth != 0) {
                // Tilføj 8 stolper til hvert hjørne af 97x97mm.trykimp.Stolpe
                material = materials.get(6);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength(3000); //Carporten har en standarthøjde som IKKE ændres i udregning
                m.setStyklistQty(8 + 1); //evt. + 1 Hvis døren ikke er placeret imod hjørnestolpen
                arrList.add(m);
            } else {
                //Hvis der ikke er skur, tilføj 6 stolper til hvert hjørne af 97x97mm.trykimp.Stolpe
                material = materials.get(6);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength(3000); //Carporten har en standarthøjde som IKKE ændres i udregning
                m.setStyklistQty(6); //6 stopler hvis uden skur
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Tilføj 2 remme i siderne der sadles ned i stolperne af 45x195mm.spærtræubh
                material = materials.get(5);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength(length - shedLength + 10); //så lange som carporten -minus skuret og lidt til tilskæring
                m.setStyklistQty(2);
                arrList.add(m);
            } else {
                //Hvis der ikke er skur, tilføj 4 remme i siderne der sadles ned i stolperne af 45x195mm.spærtræubh
                material = materials.get(5);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength((length / 2) + 10); //så lange som carporten delt i to og lidt til tilskæring, da der er 6 stolper hvis uden skur.
                m.setStyklistQty(4);
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Tilføj 2 remme der sadles ned i stolperne for skuret af 45x195mm.spærtræubh
                material = materials.get(5);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength(shedLength + 10); //så lange som skurets sider og lidt til tilskæring
                m.setStyklistQty(2);
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Tilføj bræddebolte 2 pr stolpe under rem og 4 for stolperne uder samligen mellem caports og skurret remme af bræddebolt10x120mm
                material = (materials.get(16));
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength(0); //ingen længde
                m.setStyklistQty(6 * 2 + 2 * 4); //2 bræddebolte for hver stople under rem, bemærk at remmen samles af 2 stykker, over den stole der er mellem skur og carport,
                arrList.add(m);                   //Samlingen centreres over stolpen og der anvendes i alt 4 bolte til denne samling.
            } else {
                //Hvis der ikke er skur, tilføj bræddebolte 2 pr stolpe og 4 pr samling under rem af bræddebolt10x120mm
                material = (materials.get(16));
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength(0); //ingen længde
                m.setStyklistQty(4 * 2 + 2 * 4); //Da der er 6 stolper og 4 remme laves en af samlinger under de midterste stolper, 2 bræddebolte for hver stople under rem, bemærk at remmen samles af 2 stykker, over den stole der er mellem skur og carport,
                arrList.add(m);                   //Samlingen centreres over stolpen og der anvendes i alt 4 bolte til denne samling.
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Tilføj firkantskiver for hver bræddebolt af firkantskiver40x40x11mm
                material = materials.get(17);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength(0); //ingen længde
                m.setStyklistQty(6 * 2 + 2 * 4); //samme mængde som der er bræddebolte
                arrList.add(m);
            } else {
                //Hvis ikke skur tilføj firkantskiver for hver bræddebolt af firkantskiver40x40x11mm
                material = materials.get(17);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength(0); //ingen længde
                m.setStyklistQty(4 * 2 + 2 * 4); //samme mængde som der er bræddebolte
                arrList.add(m);
            }

            //Montering af fædigskåret byg-selvspær max 110 cm mellemrum af fædigskåret(byg-selv spær)
            material = materials.get(24);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(length); //så lange som selve carportens brede
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 1100)) + 1); //Et spær pr. højest 1.10 meter af hele carport længden + 1 til enden
            arrList.add(m);

            //Montering af universal højre beslag 1 pr spær af universal190mmhøjre
            material = materials.get(12);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //ingen længde
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 1100)) + 1); //Et beslag pr spær i højre side
            arrList.add(m);

            //Montering af universal venstre beslag 1 pr spær af universal190mmvenstre
            material = materials.get(13);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //ingen længde
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 1100)) + 1); //Et beslag pr spær i venstre side
            arrList.add(m);

            //Montering af venstre og højre universalbeslag med 3 beslagskruger pr. samt toplægte flade af 5,0x40mm.beslagskruer250stk.
            material = materials.get(32);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty(1); //En pakke indholder 250 beslagskruger
            arrList.add(m);

            if (shedLength != 0 || shedwidth != 0) {
                //Tilføj 2 Hulbånd i et kryds på tværs af selve carport sektionen af hulbånd1x20mm.10mtr.
                material = materials.get(10);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength(10000); //rulle længe
                if ((Math.sqrt(Math.pow(length - shedLength - 1100, 2) + Math.pow(width - 30, 2))) < 500) { //Hulbånd placeres et spær inde, der kan ikke bruges mere end 2 ruller
                    m.setStyklistQty(1);
                } else {
                    m.setStyklistQty(2);
                }
                arrList.add(m);
            } else {
                //Hvis der ikke er skur, tilføj 2 Hulbånd i et kryds på tværs af selve carport sektionen af hulbånd1x20mm.10mtr.
                material = materials.get(10);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength(10000); //rulle længe
                if ((Math.sqrt(Math.pow(length - (1100 * 2), 2) + Math.pow(width - 30, 2))) < 500) { //Da der ikke er et skur placeres hulbåndet et spær inde fra begge sider, der kan ikke bruges mere end 2 ruller
                    m.setStyklistQty(1);
                } else {
                    m.setStyklistQty(2);
                }
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Montering af sternbrædder til begge carportens sider af 25x150mm.trykimp.Bræt
                material = materials.get(23);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength((length + 200) / (int) Math.ceil((length - shedLength + 100) / 6000)); //Længde af understærn dømt ud fra carports længde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
                m.setStyklistQty(((int) Math.ceil((length - shedLength + 100) / 6000)) * 2); //Mængde bedømt ud fra at brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
                arrList.add(m);
            } else {
                //Hvis der ikke er skur, montering af sternbrædder til begge carportens sider af 25x150mm.trykimp.Bræt
                material = materials.get(23);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength((length + 200) / (int) Math.ceil((length + 100) / 6000)); //Længde af understærn dømt ud fra carports længde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
                m.setStyklistQty(((int) Math.ceil((length + 100) / 6000)) * 2); //Mængde bedømt ud fra at brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Montering af sternbrædder til begge skurets carportens sider af 25x150mm.trykimp.Bræt
                material = materials.get(23);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
                m.setLength((width + 200) / (int) Math.ceil((shedLength + 100) / 6000)); //Bredde af understærn dømt ud fra carports bredde + 20 cm til tilskæring, bræderne må ikke overstige 6 meter i længde
                m.setStyklistQty(((int) Math.ceil((shedLength + 100) / 6000)) * 2); //Mængde bedømt ud fra at brædderne ikke må overstige 6 meter, ellers rundes der op til at tilpadse flere bræder
                arrList.add(m);
            }

            //Montering af Vindskeder på rejsning af 25x150mm.trykimp.Bræt
            material = materials.get(23);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength((int) ((width / 2) / Math.sin(70))); //Den ukende side for vores rejsningspærs hypotenuse.
            m.setStyklistQty(2); //En til hver side af carportens front.
            arrList.add(m);

            //Montering af vandbrædt til vindskeder af 19x100mm.trykimp.Bræt
            material = materials.get(7);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength((int) ((width / 2) / Math.sin(70))); //Den ukende side for vores rejsningspærs hypotenuse, samme størrelse som vindskeden.
            m.setStyklistQty(2); //En til hver side af carportens front, samme som vindskeden.
            arrList.add(m);

            //Skruger til montering af stern, vindskeder, vindkryds/hulbånd & vandbræt af 4,5x60mm.skruer200stk.
            material = materials.get(14);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty(1); //En pakke indholder 200 skruger
            arrList.add(m);

            ///////////////////////////////////////////
            //Montering af læter på spær, med 307mm mellemrum for lægter på hver skiftevis 1 hel & 1 halv lægte af 38x73mm.taglægteT1
            material = materials.get(26);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength((length / 3 * 2) + 300); //Skiftevis en en og en halv lægte til carportens bredde + 300mm i hver ende til overhæng samt tilskæring.
            m.setStyklistQty(((int) Math.ceil(((int) Math.ceil(((((width / 2) / Math.sin(70)) - (350 + 30)) / (38 + 307))) + 1) * 1.5)) * 2); //Den ukende længde af carportens sidespær - længden for den første lægte der skal have en afstand på 350mm og den efterladte længde på toppen 30mm, udregninet med en uprundet gennemsnitsmængde med udgangspunkt i en mindsteafstand af 307mm + 38mm for lægdens tykkelse. Der er også taget udgangspunkt i at hvær længte af carporten bruger 1 og 1 halv lægte, pr. side
            arrList.add(m);

            //Montering af lægter med 2 pakker skruger af 5,0x100mm.skruer100stk.
            material = materials.get(33);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty(2); //To pakker med 100 da intet andet er indikeret
            arrList.add(m);

            //Montering af toplægte til senere montering af rygsten lægges i toplægteholder af 38x73mm.taglægteT1
            material = materials.get(26);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            if (length + 300 * 2 > 6000) {
                m.setLength((length + 300 * 2) / 2); //Hvis length + 300mm * 2 er størrer end 6m som er max ængde for træ, skal længden være carportens længde / 2 + 300mm i hver side til tilskæring og overhæng.
            } else {
                m.setLength(length + 300); //Hvis length + 300mm * 2 er under 6m er længden bare length + 300mm * 2
            }
            m.setStyklistQty((int) Math.ceil((length + 300 * 2) / 6000)); //Mængde baseret på om træet overstiger 6m
            arrList.add(m);

            //Montering af toplægteholdere for hvert spær under toplægten af B&CToplægteholder
            material = materials.get(29);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 1100)) + 1); //En toplægteholder pr spær.
            arrList.add(m);

            //Montering af brædt oven på tagfodslægte med 300mm udhæng af 25x50mm.trykimp.Bræt.
            material = materials.get(25);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            if (length + 300 * 2 > 6000) {
                m.setLength((length + 300 * 2) / 2); //Hvis length + 300mm * 2 er størrer end 6m som er max ængde for træ, skal længden være carportens længde / 2 + 300mm i hver side til tilskæring og overhæng.
            } else {
                m.setLength(length + 300); //Hvis length + 300mm * 2 er under 6m er længden bare length + 300mm * 2
            }
            m.setStyklistQty((int) Math.ceil((length + 300 * 2) / 6000)); //Mængde baseret på om træet overstiger 6m
            arrList.add(m);

            //Montering for hvær række lægter af tagsten 300mm bredde af B&CDobbelt-ssort
            material = materials.get(27);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty(((int) Math.ceil(((((width / 2) / Math.sin(70)) - (350 + 30)) / (38 + 307))) + 1) * ((int) Math.ceil(length / 300)) * 2); //Mængden af spær gange mængden af 300mm bredde tagsten på carportens længde, for begge sider.
            arrList.add(m);

            //Montering af tagstensbindere og nakkekroge til montering af tagsten hvor hveranden ydersten fastgøres af B&Ctagstensbindere&nakkekroge
            material = materials.get(31);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty(2); //En pakke med tagstensbindere pr side af taget
            arrList.add(m);

            //Montering af rygsten 350mm bredde på taglægten af B&CRygstensort
            material = materials.get(28);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty((int) Math.ceil(length / 350)); //Oprundet mængde af rygsten med 350mm bredde.
            arrList.add(m);

            //Montering af rygstensbeslag for hver rygsten på taglægten af B&Crygstensbeslag
            material = materials.get(30);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice());
            m.setLength(0); //Ingen længde
            m.setStyklistQty((int) Math.ceil(length / 350)); //Et beslag for hver rygsten.
            arrList.add(m);

        }
        return styklist;
    }

    public static void main(String[] args) throws MaterialSampleException { //Main til at teste algoritme
        MaterialMapper materialMap = new MaterialMapper();
        ArrayList<Material> materials = materialMap.getAllMaterials();
        for (Material mat : materials) {
            System.out.println(mat);
        }

        System.out.println("Med skur og uden rejsning --->");

        CarportAlgorithm car = new CarportAlgorithm();
        Stykliste styk = car.carportAlgorithm(6000, 7800, 0, 5300, 2100, 1);
        for (int i = 0; i < styk.getStyklist().size(); i++) {
            System.out.println(styk.getStyklist().get(i));
        }

        System.out.println("Uden skur og med rejsning --->");

        Stykliste stykk = car.carportAlgorithm(3600, 7300, 35, 0, 0, 1);
        for (int i = 0; i < stykk.getStyklist().size(); i++) {
            System.out.println(stykk.getStyklist().get(i));
        }

        System.out.println("Med skur og med rejsning --->");

        Stykliste styk1 = car.carportAlgorithm(3600, 7300, 35, 3200, 2100, 1);
        for (int i = 0; i < styk1.getStyklist().size(); i++) {
            System.out.println(styk1.getStyklist().get(i));
        }

    }
}
