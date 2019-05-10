/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rh
 */
public class stockListTagpakke extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException, MaterialSampleException {

        
        DatabaseFacade df = new DatabaseFacade();
        ArrayList<Material> materials = df.getAllMaterialbyType("Tagpakken");
        System.out.println(materials);
        HttpSession session = request.getSession();
        session.setAttribute("stockListTagpakke", materials);
        
        return "stockListTagpakke";
    }
    
}
   