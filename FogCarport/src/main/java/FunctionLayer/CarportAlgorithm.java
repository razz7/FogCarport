/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.DatabaseFacade;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rasmus2
 */
public class CarportAlgorithm {

    /**
     * Calculates and returns the Stykliste for an order based on specified size
     *
     * @param width
     * @param length
     * @param roofTilt
     * @param shedwidth
     * @param shedLength
     * @param styklist_id
     * @return
     * @throws MaterialSampleException
     */
    public Stykliste carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id) throws MaterialSampleException {
        DatabaseFacade materialMap = new DatabaseFacade();
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

            //CAROPRT WITH SHED
            if (shedLength != 0 || shedwidth != 0) {
                //Add 10 pole one for each corner of 97x97mm.trykimp.Stolpe
                material = materials.get(6);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(3000); //The carport has a standard height which is NOT changed in calculation
                m.setStyklistQty(10 + 1); //Possibly. +1 If the door is not positioned against the corner pole
                m.setConstructionDescription("Stolper nedgraves 90 cm. i jord");
                arrList.add(m);
            } else {
                //If there is no shed, add 6 poles, one to each corner of 97x97mm.trykimp.Stolpe
                material = materials.get(6);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(3000); //The carport has a standard height which is NOT changed in calculation
                m.setStyklistQty(6); //6 poles if without shed
                m.setConstructionDescription("Stolper nedgraves 90 cm. i jord");
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Add 2 straps to the sides that are lowered into the posts of 45x195mm
                material = materials.get(5);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(length - shedLength + 10); //As long as the carport-minus shed and a bit for cutting
                m.setStyklistQty(2);
                m.setConstructionDescription("Remme i sider, sadles ned i stolper");
                arrList.add(m);
            } else {
                //If there is no shed, add 4 straps to the sides that are lowered into the posts of 45x195mm.spærtræubh
                material = materials.get(5);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength((length / 2) + 10); //As long as the carport divided into two and slightly to cut, as there are 6 posts if without shed.
                m.setStyklistQty(4);
                m.setConstructionDescription("Remme i sider, sadles ned i stolper");
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Add 2 straps that are lowered into the posts for the shed of 45x195mm.spærtræubh
                material = materials.get(5);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(shedLength + 10); //As long as the sides of the shed and a little for cutting
                m.setStyklistQty(2);
                m.setConstructionDescription("Remme i sider, sadles ned i stolper (skur del)");
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Add board bolts 2 per post under strap and 4 for poles outside together between caports and scratched straps of bræddebolt10x120mm
                material = (materials.get(16));
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty(6 * 2 + 2 * 4); //2 board bolts for each stop under belt, note that the belt is assembled by 2 pieces, over the chairs that are between shed and carport, the assembly is centered over the post and a total of 4 bolts are used for this assembly.
                m.setConstructionDescription("Til montering af rem på stolper");
                arrList.add(m);
            } else {
                //If there is no shed, add board bolts 2 per post and 4 per assembly under strap of bræddebolt10x120mm
                material = (materials.get(16));
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty(4 * 2 + 2 * 4); //Since there are 6 posts and 4 straps, one of the joints under the middle posts, 2 board bolts for each strap under strap, note that the strap is assembled by 2 pieces, over the chairs that are between shed and carport, the assembly is centered over the post and used a total of 4 bolts for this collection.
                m.setConstructionDescription("Til montering af rem på stolper");
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Add square discs for each board bolt of firkantskiver40x40x11mm
                material = materials.get(17);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty(6 * 2 + 2 * 4); //The same amount as there are board bolts
                m.setConstructionDescription("Til montering af rem på stolper");
                arrList.add(m);
            } else {
                //If no shed, add square discs for each board bolt of firkantskiver40x40x11mm
                material = materials.get(17);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty(4 * 2 + 2 * 4); //The same amount as there are board bolts
                m.setConstructionDescription("Til montering af rem på stolper");
                arrList.add(m);
            }

            //Mounting of rafters with a maximum of 60 cm intervals of 45x195mm.spærtræubh
            material = materials.get(5);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(width); //As long as the carport itself is wide
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 600)) + 1); //A raft per. maximum 0.60 meters of the entire carport length + 1 to the end
            m.setConstructionDescription("Spær, monteres på rem");
            arrList.add(m);

            //Mounting of universal right bracket 1 per raft of universal190mmhøjre
            material = materials.get(12);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 600)) + 1); //A bracket per raft on the right
            m.setConstructionDescription("Til montering af spær på rem");
            arrList.add(m);

            //Mounting of universal left bracket 1 per raft of universal190mmvenstre
            material = materials.get(13);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 600)) + 1); //A bracket per raft on the left
            m.setConstructionDescription("Til montering af spær på rem");
            arrList.add(m);

            //Mounting of left and right universal brackets with 3 bracket screws per unit. flat of 4,0x50mm.beslagskruer250stk.
            material = materials.get(15);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty(1); //A package contains 250 fittings
            m.setConstructionDescription("Til montering af universalbeslag + hulbånd");
            arrList.add(m);

            if (shedLength != 0 || shedwidth != 0) {
                //Add 2 hole bands at a cross over the carport section itself of hulbånd1x20mm.10mtr.
                material = materials.get(10);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(10000); //Roll length
                if ((Math.sqrt(Math.pow(length - shedLength - 600, 2) + Math.pow(width - 30, 2))) < 500) { //Hole strips are placed one rafts space inside, there cannot be used more than 2 rolls
                    m.setStyklistQty(1);
                } else {
                    m.setStyklistQty(2);
                }
                m.setConstructionDescription("Til vindkryds på spær");
                arrList.add(m);
            } else {
                //If there is no shed, add 2 Hole strips at a cross over the actual carport section of hulbånd1x20mm.10mtr.
                material = materials.get(10);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(10000); //Roll length
                if ((Math.sqrt(Math.pow(length - (600 * 2), 2) + Math.pow(width - 30, 2))) < 500) { //Since there is no shed, the hollow belt is placed one raft in from both sides, and cannot be used more than 2 rolls
                    m.setStyklistQty(1);
                } else {
                    m.setStyklistQty(2);
                }
                m.setConstructionDescription("Til vindkryds på spær");
                arrList.add(m);
            }

            //Mounting of hollow belt with 2 bracket screws per. unit end of 4,0x50mm.beslagskruer250stk.
            material = materials.get(15);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty(1); //A package contains 250 fittings
            m.setConstructionDescription("Til montering af universalbeslag + hulbånd");
            arrList.add(m);

            //Mounting the lower base to both sides of the carport of 25x200mm.trykimp.Brædt
            material = materials.get(1);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength((length + 200) / (int) Math.ceil((length + 100) / 6000)); //Length of lower beam judged from carport length + 20 cm for cutting, the boards must not exceed 6 meters in length
            m.setStyklistQty(((int) Math.ceil((length + 100) / 6000)) * 2); //Quantity judged on the boards not to exceed 6 meters, otherwise round up to accommodate more boards
            m.setConstructionDescription("Understernbrædder til siderne");
            arrList.add(m);

            //Mounting the lower base to the front and rear of the carport of 25x200mm.trykimp.Brædt
            material = materials.get(1);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength((width + 200) / (int) Math.ceil((width + 100) / 6000)); //Width of lower beam judged from carport width + 20 cm for cutting, the boards must not exceed 6 meters in length
            m.setStyklistQty(((int) Math.ceil((width + 100) / 6000)) * 2); //Quantity judged on the boards not to exceed 6 meters, otherwise round up to accommodate more boards
            m.setConstructionDescription("Understernbrædder til for & bag ende");
            arrList.add(m);

            //Mounting the upper part to both sides of the carport 25x125mm.trykimp.Brædt
            material = materials.get(2);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength((length + 200) / (int) Math.ceil((length + 100) / 6000)); //Length of the upper part condemned from carport length + 20 cm for cutting, the boards must not exceed 6 meters in length
            m.setStyklistQty(((int) Math.ceil((length + 100) / 6000)) * 2); //Quantity judged on the boards not to exceed 6 meters, otherwise round up to accommodate more boards
            m.setConstructionDescription("Oversternbrædder til siderne");
            arrList.add(m);

            //Mounting the upper part of the front of the carport of 25x125mm.trykimp.Brædt
            material = materials.get(2);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength((width + 200) / (int) Math.ceil((width + 100) / 6000)); //Length of the upper part condemned from carport length + 20 cm for cutting, the boards must not exceed 6 meters in length
            m.setStyklistQty(((int) Math.ceil((width + 100) / 6000))); //Only install for the front end here, Quantity judged on the boards not to exceed 6 meters, otherwise round up to load more boards
            m.setConstructionDescription("Oversternbrædder til forenden");
            arrList.add(m);

            //Mounting of 1090mm width Trapez plates PlastmoEcoliteblåtonet
            material = materials.get(8);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            if (length + 50 * 2 < 6) {
                m.setLength(length + 50 * 2); //Length of carport + 5 cm to each end, if the carport is less than 6 meters and therefore only use one plate lengthwise
                m.setStyklistQty(((int) Math.ceil((width + 50 * 2) / (1090 - 20 * 2)))); //Sufficient plates must be fitted to cover the entire carport width with 2cm overlap and 5 cm extra on each side
            } else { //Since the plates in this case are longer in the max 6m, instead there must be 2 sets of plates instead.
                m.setLength((length / 2) + 50 * 2 + 20 * 2); //Length of carport + 5cm for each side + 2 cm for overlap
                m.setStyklistQty(((int) Math.ceil((width + 50 * 2) / (1090 - 20 * 2))) * 2); //Sufficient plates must be fitted to cover the entire carport width with 2cm overlap and 5 cm extra on each side
            }
            m.setConstructionDescription("Tagplader monteres på spær");
            arrList.add(m);

            //Mounting of trapezoidal plates with bottom screws of plastmobundskruer200stk.
            material = materials.get(9);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty(3); //A package contains 200 bottom screws, as several bottom screws are used per unit. plate pr.trapezrille, we use 3 packs.
            m.setConstructionDescription("Skruer til tagplader");
            arrList.add(m);

            //Mounting of water board to both sides of the carport of 19x100mm.trykimp.Brædt
            material = materials.get(7);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength((length + 200) / (int) Math.ceil((length + 100) / 6000)); //Length of lower beam judged from carport length + 20 cm for cutting, the boards must not exceed 6 meters in length
            m.setStyklistQty(((int) Math.ceil((length + 100) / 6000)) * 2); //Quantity judged on the boards not to exceed 6 meters, otherwise round up to accommodate more boards
            m.setConstructionDescription("Vandbrædt på stern i sider");
            arrList.add(m);

            //Mounting of water board to the front of the carport of 19x100mm.trykimp.Brædt
            material = materials.get(7);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength((width + 200) / (int) Math.ceil((width + 100) / 6000)); //Length of the upper part condemned from carport length + 20 cm for cutting, the boards must not exceed 6 meters in length
            m.setStyklistQty(((int) Math.ceil((width + 100) / 6000))); //Only install for the front end here, Quantity judged on the boards not to exceed 6 meters, otherwise round up to load more boards
            m.setConstructionDescription("Vandbrædt på stern i forende");
            arrList.add(m);

            //Screws for mounting the stern and water board of 4,5x60mm.skruer200stk.
            material = materials.get(14);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty(1); //One package contains 200 screws
            m.setConstructionDescription("Til montering af stern&vandbrædt");
            arrList.add(m);

            if (shedLength != 0 || shedwidth != 0) {
                //Installation of boards for the outer covering of shed of 19x100mm.trykimp.Brædt
                material = materials.get(7);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(2100); //The height of the shed does not change
                m.setStyklistQty((int) (((shedLength / 60) * 2) + ((shedwidth / 60) * 2))); //Calculation of the number of boards on the back of that cladding boards are mounted at 6.cm intervals, with the shed's dimensions.
                m.setConstructionDescription("Til beklædning af skur 1 på 2");
                arrList.add(m);

                //Mounting of outer cover with 6 screws per unit. plank of 4,5x70mm.Screws400pcs.
                material = materials.get(18);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty((int) Math.ceil((((shedLength / 60) * 2) + ((shedwidth / 60) * 2)) * 6 / 400)); //The amount of boards divided by 400 and rounded up to an integer, which indicates how many packets of 400 we will need if each board uses 4 screws.
                m.setConstructionDescription("Til montering af yderste beklædning");
                arrList.add(m);

                //Mounting of inner cover with 3 screws per. plank of 4,5x50mm.Skruer300stk.
                material = materials.get(19);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty((int) Math.ceil((((shedLength / 60) * 2) + ((shedwidth / 60) * 2)) * 3 / 300)); //The amount of boards divided by 300 and rounded up to an integer, which indicates how many packs of 300 we will need if each board uses 4 screws.
                m.setConstructionDescription("Til montering af inderste beklædning");
                arrList.add(m);

                //Mounting of 12 holder beams for shed ends of 45x95mm.Reglarub.
                material = materials.get(4);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(shedwidth / 2); //The length of the holder beams with splits in the beams and a little extra for cutting and adapting from the width of the shed.
                m.setStyklistQty(12); //No matter what, 12 holder beams for the gable for the inside of the shed's construction must be used.
                m.setConstructionDescription("Løsholter til skur gavle");
                arrList.add(m);

                //Mounting of 4 holder beams for shed sides of 45x95mm.Reglarub.
                material = materials.get(4);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(shedLength); //The length of the soles and a little extra for cutting and adjusting from the length of the shed.
                m.setStyklistQty(4); //No matter what, 4 idlers must be used for the inside of the shed's construction.
                m.setConstructionDescription("Løsholter til skur sider");
                arrList.add(m);

                //Mounting of angle brackets for mounting of brackets in shed with 2 brackets per unit. light cavities of vinkelbeslag35
                material = materials.get(22);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length.
                m.setStyklistQty((12 + 4) * 2); //No matter what, 2 angle brackets are needed per. light cavities in the shed.
                m.setConstructionDescription("Til montering af løsholter i skur");
                arrList.add(m);

                //Mounting of board for z on rear of door of 38x73mm.Lægteubh.
                material = materials.get(3);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(4200); //Fixed length on all models.
                m.setStyklistQty(1); //Fixed quantities on all models.
                m.setConstructionDescription("Til z på bagside af dør");
                arrList.add(m);

                //Mounting 2 t-hinges for shed dies of thængsel390mm.
                material = materials.get(21);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length.
                m.setStyklistQty(2); //Fixed quantites on all models, as a door must use at least 2 t-hinges.
                m.setConstructionDescription("Til skurdør");
                arrList.add(m);

                //Mounting a set of steel door handle for lock on door in shed of stalddørsgreb50x75
                material = materials.get(20);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length.
                m.setStyklistQty(1); //Fixed quantites on all models, as a door only needs a set of steel door handles.
                m.setConstructionDescription("Til lås på dør i skur");
                arrList.add(m);
            }

        } else { //Roof tilt ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //CAROPRT WITHOUT SHED
            if (shedLength != 0 || shedwidth != 0) {
                //Add 8 poles to each corner of 97x97mm.trykimp.Stolpe
                material = materials.get(6);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(3000); //The carport has a standard height which is NOT changed in the calculation
                m.setStyklistQty(8 + 1); //Possibly. + 1 If the door is not positioned against the corner post
                m.setConstructionDescription("Stolper nedgraves 90 cm. i jord");
                arrList.add(m);
            } else {
                //If there is no shed, add 6 poles to each corner of 97x97mm.trykimp.Stolpe
                material = materials.get(6);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(3000); //The carport has a standard height which is NOT changed in the calculation
                m.setStyklistQty(6); //6 poles without shed
                m.setConstructionDescription("Stolper nedgraves 90 cm. i jord");
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Add 2 straps to the sides that are lowered into the posts of 45x195mm.spærtræubh
                material = materials.get(5);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(length - shedLength + 10); //As long as the carport-minus the shed and a bit for cutting
                m.setStyklistQty(2);
                m.setConstructionDescription("Remme i sider, sadles ned i stolper Carport del");
                arrList.add(m);
            } else {
                //If there is no shed, add 4 straps to the sides that are lowered into the posts of 45x195mm.spærtræubh
                material = materials.get(5);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength((length / 2) + 10); //As long as the carport divided into two and slightly to cut, as there are 6 posts if without shed.
                m.setStyklistQty(4);
                m.setConstructionDescription("Remme i sider, sadles ned i stolper Carport del");
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Add 2 straps that are lowered into the posts for the shed of 45x195mm.spærtræubh
                material = materials.get(5);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(shedLength + 10); //As long as the sides of the shed and a little for cutting
                m.setStyklistQty(2);
                m.setConstructionDescription("Remme i sider, sadles ned i stolper Skur del");
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Add board bolts 2 per post under strap and 4 for poles outside together between caports and scratched straps of bræddebolt10x120mm
                material = (materials.get(16));
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty(6 * 2 + 2 * 4); //2 board bolts for each stop under belt, note that the belt is assembled by 2 pieces, over the chairs that are between shed and carport, the assembly is centered over the post and a total of 4 bolts are used for this assembly.
                m.setConstructionDescription("Til montering af rem på stolper");
                arrList.add(m);
            } else {
                //If there is no shed, add board bolts 2 per post and 4 per assembly under strap of bræddebolt10x120mm
                material = (materials.get(16));
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty(4 * 2 + 2 * 4); //Since there are 6 posts and 4 straps, one of the joints under the middle posts, 2 board bolts for each strap under strap, note that the strap is assembled by 2 pieces, over the chairs that are between shed and carport, the assembly is centered over the post and used a total of 4 bolts for this collection.
                m.setConstructionDescription("Til montering af rem på stolper");
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Add square discs for each board bolt of firkantskiver40x40x11mm
                material = materials.get(17);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty(6 * 2 + 2 * 4); //The same amount as there are board bolts
                m.setConstructionDescription("Til montering af rem på stolper");
                arrList.add(m);
            } else {
                //If no shed, add square discs for each board bolt of firkantskiver40x40x11mm
                material = materials.get(17);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty(4 * 2 + 2 * 4); //The same amount as there are board bolts
                m.setConstructionDescription("Til montering af rem på stolper");
                arrList.add(m);
            }

            //Mounting of the pre-cut self-build trusses/rafts spacing max 110 cm apart of fædigskåret(byg-selv spær)
            material = materials.get(24);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(width); //As long as the carport itself is wide
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 1100)) + 1); //A raft per. maximum 1.10 meters of the entire carport length + 1 for the end
            m.setConstructionDescription("Byg-selv spær (skal samles) 1 stk.");
            arrList.add(m);

            //Mounting of universal right bracket 1 per raft of universal190mmhøjre
            material = materials.get(12);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 1100)) + 1); //A bracket per raft on the right
            m.setConstructionDescription("Til montering af spær på rem");
            arrList.add(m);

            //Mounting of universal left bracket 1 per raft of universal190mmvenstre
            material = materials.get(13);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 1100)) + 1); //A bracket per raft on the left
            m.setConstructionDescription("Til montering af spær på rem");
            arrList.add(m);

            //Mounting of left and right universal brackets with 3 bracket screws per unit and topcoat surface of 5,0x40mm.beslagskruer250stk.
            material = materials.get(32);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty(1); //A package contains 250 fittings
            m.setConstructionDescription("Til montering af universalbeslag + toplægte");
            arrList.add(m);

            if (shedLength != 0 || shedwidth != 0) {
                //Add 2 hole bands at a cross over the carport section itself of hulbånd1x20mm.10mtr.
                material = materials.get(10);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(10000); //Roll length
                if ((Math.sqrt(Math.pow(length - shedLength - 1100, 2) + Math.pow(width - 30, 2))) < 500) { //Hole bands are placed one raft inside, there cannot be used more than 2 rolls
                    m.setStyklistQty(1);
                } else {
                    m.setStyklistQty(2);
                }
                m.setConstructionDescription("Til vindkryds på spær");
                arrList.add(m);
            } else {
                //If there is no shed, add 2 Hole strips at a cross over the actual carport section of hulbånd1x20mm.10mtr.
                material = materials.get(10);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(10000); //Roll length
                if ((Math.sqrt(Math.pow(length - (1100 * 2), 2) + Math.pow(width - 30, 2))) < 500) { //Since there is no shed, the hollow belt is placed one raft in from both sides that cannot be used more than 2 rolls
                    m.setStyklistQty(1);
                } else {
                    m.setStyklistQty(2);
                }
                m.setConstructionDescription("Til vindkryds på spær");
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Mounting of stern boards to both sides of the carport of 25x150mm.trykimp.Bræt
                material = materials.get(23);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength((length + 200) / (int) Math.ceil((length - shedLength + 100) / 6000)); //Length of lower beam judged from carport length + 20 cm for cutting, the boards must not exceed 6 meters in length
                m.setStyklistQty(((int) Math.ceil((length - shedLength + 100) / 6000)) * 2); //Quantity judged on the boards not to exceed 6 meters, otherwise round up to accommodate more boards
                m.setConstructionDescription("Sternbrædder til siderne Carport del");
                arrList.add(m);
            } else {
                //If there is no shed, installing stern boards on both sides of the carport of 25x150mm.trykimp.Bræt
                material = materials.get(23);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength((length + 200) / (int) Math.ceil((length + 100) / 6000)); //Length of lower beam judged from carport length + 20 cm for cutting, the boards must not exceed 6 meters in length
                m.setStyklistQty(((int) Math.ceil((length + 100) / 6000)) * 2); //Quantity judged on the boards not to exceed 6 meters, otherwise round up to accommodate more boards
                m.setConstructionDescription("Sternbrædder til siderne Carport del");
                arrList.add(m);
            }

            if (shedLength != 0 || shedwidth != 0) {
                //Mounting of stern boards to both sides of the shed of 25x150mm.trykimp.Bræt
                material = materials.get(23);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength((width + 200) / (int) Math.ceil((shedLength + 100) / 6000)); //Width of lower beam judged from carport width + 20 cm for cutting, the boards must not exceed 6 meters in length
                m.setStyklistQty(((int) Math.ceil((shedLength + 100) / 6000)) * 2); //Quantity judged on the boards not to exceed 6 meters, otherwise round up to accommodate more boards
                m.setConstructionDescription("Sternbrædder til siderne Skur del");
                arrList.add(m);
            }

            //Mounting of windshields on travel of 25x150mm.trykimp.Bræt
            material = materials.get(23);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength((float) ((width / 2) / Math.sin((180 - 90 - roofTilt) * Math.PI / 180))); //The unknown side for our angled rafts hypotenuse.
            m.setStyklistQty(2); //One to each side of the front of the carport.
            m.setConstructionDescription("Vindskeder på rejsning");
            arrList.add(m);

            //Mounting of water board on windshields of 19x100mm.trykimp.Bræt
            material = materials.get(7);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength((float) ((width / 2) / Math.sin((180 - 90 - roofTilt) * Math.PI / 180))); //The unknown side for our erection bar, the same size as the windshield.
            m.setStyklistQty(2); //One to each side of the front of the carport, the same amount as the windshield.
            m.setConstructionDescription("Vandbræt på vindskeder");
            arrList.add(m);

            //Screws for mounting the stern, windshields, wind crossing/straps & water board of 4,5x60mm.skruer200stk.
            material = materials.get(14);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty(1); //One package contains 200 screws
            m.setConstructionDescription("Til montering af Stern, vindskeder, vindkryds & vandbræt");
            arrList.add(m);

            //Mounting of battens on rafters, with 307mm spacers for battens on each alternate 1 full & 1 half batten of 38x73mm.taglægteT1
            material = materials.get(26);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength((length / 3 * 2) + 300); //Alternately a one and a half lath to the width of the carport + 300mm at each end for overhang and cutting.
            m.setStyklistQty(((int) Math.ceil(((float) Math.ceil(((((width / 2) / Math.sin((180 - 90 - roofTilt) * Math.PI / 180)) - (350 + 30)) / (38 + 307))) + 1) * 1.5)) * 2); //The unknown length of the carport's side rail - the length of the first batten to have a distance of 350mm and the left length of the top 30mm, the rain tine with an unround average amount based on a minimum distance of 307mm + 38mm for the latches thickness. It is also assumed that where the length of the carport is used is 1 and 1 half loaded, per. page
            m.setConstructionDescription("Til montering på spær, på hver skiftevis 1 hel & 1 halv lægte");
            arrList.add(m);

            //Mounting of the laths with 2 packages of screws of 5,0x100mm.skruer100stk.
            material = materials.get(33);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty(2); //Two packs of 100 since nothing else is indicated
            m.setConstructionDescription("Til taglægter");
            arrList.add(m);

            //Mounting of topsheets for later mounting of the backrest is to be placed in a top-level holder of 38x73mm.taglægteT1
            material = materials.get(26);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            if (length + 300 * 2 > 6000) {
                m.setLength((length + 300 * 2) / 2); //If length + 300mm * 2 is larger than 6m which is max length for wood, the length must be the length of the carport / 2 + 300mm on each side for cutting and overhang.
            } else {
                m.setLength(length + 300); //If length + 300mm * 2 is below 6m, the length is just length + 300mm * 2
            }
            m.setStyklistQty((int) Math.ceil((length + 300 * 2) / 6000)); //Quantity based on whether the wood exceeds 6m
            m.setConstructionDescription("Toplægte til montering af rygsten lægges i toplægteholder");
            arrList.add(m);

            //Mounting of top brackets for each raft under the topcoat of B&CToplægteholder
            material = materials.get(29);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty((int) Math.ceil((length - 45) / (45 + 1100)) + 1); //One top holder per bar.
            m.setConstructionDescription("Monteres på toppen af spæret (til toplægte)");
            arrList.add(m);

            //Mounting of boards on top of roof truss with 300 mm overhang of 25x50mm.trykimp.Bræt.
            material = materials.get(25);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            if (length + 300 * 2 > 6000) {
                m.setLength((length + 300 * 2) / 2); //If length + 300mm * 2 is larger than 6m which is max length for wood, the length must be the length of the carport / 2 + 300mm on each side for cutting and overhang.
            } else {
                m.setLength(length + 300); //If length + 300mm * 2 is below 6m, the length is just length + 300mm * 2
            }
            m.setStyklistQty((int) Math.ceil((length + 300 * 2) / 6000)); //Quantity based on whether the tree exceeds 6m
            m.setConstructionDescription("Til montering oven på tagfodslægte");
            arrList.add(m);

            //Mounting for each row of tile roof tiles 300mm width of B&CDobbelt-ssort
            material = materials.get(27);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty(((int) Math.ceil(((((width / 2) / Math.sin((180 - 90 - roofTilt) * Math.PI / 180)) - (350 + 30)) / (38 + 307))) + 1) * ((int) Math.ceil(length / 300)) * 2); //The amount of rafters multiplied by the amount of 300mm broad roof tiles at the length of the carport, for both sides.
            m.setConstructionDescription("Monteres på taglægter 6 rækker af 24 sten på hver side af taget");
            arrList.add(m);

            //Mounting of tile binders and neck hooks for mounting the tiles where every other is attached, of B&Ctagstensbindere&nakkekroge
            material = materials.get(31);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty(2); //A package of tile binders per side of the roof
            m.setConstructionDescription("Til montering af tagsten, alle ydersten + hver anden fastgøres");
            arrList.add(m);

            //Mounting the backstones 350mm wide on the roof top of B&CRygstensort
            material = materials.get(28);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty((int) Math.ceil(length / 350)); //Rounted quantity of backstones 350mm wide.
            m.setConstructionDescription("Monteres på toplægte med medfølgende beslag se tagstens vejledning");
            arrList.add(m);

            //Mounting the backstone bracket for each backrest on the roof top B&Crygstensbeslag
            material = materials.get(30);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(0); //No length
            m.setStyklistQty((int) Math.ceil(length / 350)); //A bracket for each backstone.
            m.setConstructionDescription("Til montering af rygsten");
            arrList.add(m);

            //Mounting of boards to the outer covering of gables of 19x100mm.trykimp.Brædt
            material = materials.get(7);
            m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
            m.setLength(2100); //The height of the shed does not change
            m.setStyklistQty((int) ((width / 60) * 2)); //Calculation of the number of boards on the background of the fact that cladding boards are mounted at 6.cm intervals, with the shed's dimensions.
            m.setConstructionDescription("Til beklædning af gavle 1 på 2");
            arrList.add(m);

            if (shedLength != 0 || shedwidth != 0) {
                //Installation of boards for the outer covering of shed of 19x100mm.trykimp.Brædt
                material = materials.get(7);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(2100); //The height of the shed does not change
                m.setStyklistQty((int) (((shedLength / 60) * 2) + ((shedwidth / 60) * 2))); //Calculation of the number of boards on the background of the fact that cladding boards are mounted at 6.cm intervals, with the shed's dimensions.
                m.setConstructionDescription("Beklædning af skur 1 på 2");
                arrList.add(m);

                //Mounting of outer cover with 6 screws per unit. plank of 4,5x70mm.Skruer200stk.
                material = materials.get(34);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty((int) Math.ceil((((shedLength / 60) * 2) + ((shedwidth / 60) * 2)) * 6 / 200)); //The amount of boards divided by 200 and rounded up to an integer, which indicates how many packages of 400 we will need if each board uses 4 screws.
                m.setConstructionDescription("Til montering af yderste bræt ved beklædning");
                arrList.add(m);

                //Mounting of inner cover with 3 screws per. plank of 4,5x50mm.Skruer350stk.
                material = materials.get(35);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length
                m.setStyklistQty((int) Math.ceil((((shedLength / 60) * 2) + ((shedwidth / 60) * 2)) * 3 / 350)); //The amount of boards divided by 300 and rounded up to an integer, indicating how many packages of 350 we will need if each board uses 4 screws.
                m.setConstructionDescription("Til montering af inderste bræt ved beklædning");
                arrList.add(m);

                //Mounting of 6 holder beams for shed gable ends of 45x95mm.Reglarub.
                material = materials.get(4);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(shedwidth); //The width of the carport and a little extra for cutting and adjusting.
                m.setStyklistQty(6); //Regardless of what is used, there must be 6 loose sockets for the gable for the inside of the shed's construction.
                m.setConstructionDescription("Løsholter i gavle af skur");
                arrList.add(m);

                //Mounting of 4 holder beams for shed sides of 45x95mm.Reglarub.
                material = materials.get(4);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(shedLength); //The length of the holder beams and a little extra for cutting and adapting to the length of the shed.
                m.setStyklistQty(4); //No matter what, 4 holder beams must be used for the inside of the shed's construction.
                m.setConstructionDescription("Løsholter i siderne af skur");
                arrList.add(m);

                //Mounting of angle brackets for mounting of holder beams in shed with 2 brackets per unit. lysholter of vinkelbeslag35
                material = materials.get(22);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length.
                m.setStyklistQty((6 + 4) * 2); //No matter what, 2 angle brackets are needed per. holder beam in the shed.
                m.setConstructionDescription("Til montering af løsholter");
                arrList.add(m);

                //Mounting of board for z on rear of door of 38x73mm.taglægteT1
                material = materials.get(26);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(5400); //Fixed length on all models.
                m.setStyklistQty(1); //Fixed quantity on all models.
                m.setConstructionDescription("Til z på bagside af dør");
                arrList.add(m);

                //Mounting 2 t-hinges for shed door of thængsel390mm.
                material = materials.get(21);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length.
                m.setStyklistQty(2); //Fixed quantity on all models, as a door must use at least 2 t-hinges.
                m.setConstructionDescription("Til dør i skur");
                arrList.add(m);

                //Mounting a set of steel door handles for lock on door in shed of stalddørsgreb50x75
                material = materials.get(20);
                m = new Material(material.getItem_id(), material.getItem_description(), material.getWidth(), material.getHeight(), material.getEntity(), material.getMaterialType(), material.getPrice(), material.getVersionnr());
                m.setLength(0); //No length.
                m.setStyklistQty(1); //Fixed quantity on all models, as a door only needs one set of steel door handles.
                m.setConstructionDescription("Til dør i skur");
                arrList.add(m);
            }

        }

        return styklist;
    }

}
