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

    private static boolean skurCheck;
    private int sideLength;
    private int FrontLength;
    private static boolean FlatTag;
   private ArrayList sides = new ArrayList();
    
    
    private ArrayList sideCal(ArrayList sides, int length) 
    {
        ArrayList sideLength = new ArrayList();
        
        for(int i = 0; i <sides.size(); ++i)
        {
            if (sides.indexOf(i) < 3.0)
            {
                return sideLength;
            }
            else {
                double x = sides.indexOf(i) % length;
                sideLength.add(x);
            }
        }
        
        
        System.out.print(sideLength);
        return sideLength;
    }
    
    
    
    public static void main(String[] args) {
        ListGenerator Ls = new ListGenerator();
        ArrayList a = new ArrayList();
        
        a.add(5.5);
        a.add(6.6);
        a.add(643.3);
        Ls.sideCal(a, 10);
        System.out.println(Ls.sideCal(a, 10));
    }
    
    
    



}
