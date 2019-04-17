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
        ArrayList<Item> arrList = new ArrayList<>();
        Stykliste styklist = new Stykliste(arrList, styklist_id);

        //Number of different materials for different positions on the construction
        if (roofTilt == 0) { //Flat roof
            int trykimpBrædt1 = 0; //understernbrædder til for & bag ende
            int trykimpBrædt2 = 0; //understernbrædder til siderne
            int trykimpBrædt3 = 0; //oversternbrædder til forenden
            int trykimpBrædt4 = 0; //oversternbrædder til siderne
            int LægteUbh = 0; //til z på bagside af dør
            int ReglarUb1 = 0; //løsholter til skur gavle
            int ReglarUb2 = 0; //løsholter til skur sider
            int spærtræUbh1 = 0; //Remme i sider, sadles ned i stolper
            int spærtræUbh2 = 0; //Remme i sider, sadles ned i stolper (skur del, deles)
            int spærtræUbh3 = 0; //Spær, monteres på rem
            int trykimpStolpe = 0; //Stolper nedgraves 90 cm. i jord
            int trykimpBrædt5 = 0; //til beklædning af skur 1 på 2
            int trykimpBrædt6 = 0; //vandbrædt på stern i sider
            int trykimpBrædt7 = 0; //vandbrædt på stern i forende
            int PlastmoEcoliteBlåtonet1 = 0; //tagplader monteres på spær
            int PlastmoEcoliteBlåtonet2 = 0; //tagplader monteres på spær
            int plastmoBundskruer200Stk = 0; //Skruer til tagplader
            int hulbånd1x20mm10mtr = 0; //Til vindkryds på spær
            int universal190mmHøjre = 0; //Til montering af spær på rem
            int universal190mmVenstre = 0; //Til montering af spær på rem
            int s45x60mmSkruer200Stk = 0; //Til montering af stern&vandbrædt
            int s40x50mmBeslagskruer250Stk = 0; //Til montering af universalbeslag + hulbånd
            int bræddebolt10x120mm = 0; //Til montering af rem på stolper
            int firkantskiver40x40x11mm = 0; //Til montering af rem på stolper
            int s45x70mmSkruer400stk = 0; //til montering af yderste beklædning
            int s45x50mmSkruer300stk = 0; //til montering af inderste beklædning
            int stalddørsgreb50x75 = 0; //Til lås på dør i skur
            int tHængsel390mm = 0; //Til skurdør
            int vinkelbeslag35 = 0;//Til montering af løsholter i skur

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
