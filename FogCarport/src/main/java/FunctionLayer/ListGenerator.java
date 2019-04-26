/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rh
 */
public class ListGenerator {

    private boolean skurCheck;
    private int sideLength;
    private int frontLength;

    //For fladt tag carport mål 6.0 * 7.8 mtr
    //Træ&Tagplader
    private int f25x200mmtrykimpBrædt1 = 360;
    private int f25x200mmtrykimpBrædt2 = 540;
    private int f25x125mmtrykimpBrædt1 = 360;
    private int f25x125mmtrykimpBrædt2 = 540;
    private int f38x73mmLægtubh = 420;
    private int f45x95mmReglarub1 = 270;
    private int f45x95mmReglarub2 = 240;
    private int f45x195mmspærtræubh1Top = 6 ;
    private int f45x195mmspærtræubh2 = 480;
    private int f45x195mmspærtræubh = 6;
    private int f97x97mmtrykimpStolpe = 300;
    private int f19x100mmtrykimpBrædt1 = 210;
    private int f19x100mmtrykimpBrædt2 = 540;
    private int f19x100mmtrykimpBrædt = 360;
    private int PlastmoEcoliteblåtonet1 = 600;
    private int PlastmoEcoliteblåtonet2 = 360;

    //Beslag&Skruer
    private int plastmobundskruer200stk = 0;
    private int hulbånd1x20mm10mtr = 0;
    private int universal190mmhøjre = 0;
    private int universal190mmvenstre = 0;
    private int f45x60mmskruer200stk = 0;
    private int f40x50mmbeslagskruer250stk = 0;
    private int bræddebolt10x120mm = 0;
    private int firkantskiver40x40x11mm = 0;
    private int f45x70mmSkruer400stk = 0;
    private int f45x50mmSkruer300stk = 0;
    private int stalddørsgreb50x75 = 0;
    private int thængsel390mm = 0;
    private int vinkelbeslag35 = 0;

    private static boolean FlatTag;
    private ArrayList sides = new ArrayList();

    //virker ikke 
    private int sideCalWithShed(ArrayList<Double> sides, double shedLength) {
        double sideMats = 0.0;
        ArrayList<Double> sideLength = new ArrayList();
        double carPortLength = (sides.get(1) - shedLength);
        double carPortMatsLength = (carPortLength / f45x195mmspærtræubh1Top);
        int totalLengthOfSideBoards =(int)Math.ceil(carPortMatsLength);
        return totalLengthOfSideBoards;
        
        
    }

    public static void main(String[] args) {
        ListGenerator l = new ListGenerator();
        
    }

}
