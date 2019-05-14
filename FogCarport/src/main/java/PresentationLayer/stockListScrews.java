/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import FunctionLayer.FunctionManager;
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
public class stockListScrews implements Command {
    
    private String target;

    stockListScrews(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        
        DatabaseFacade df = new DatabaseFacade();
        ArrayList<Material> materials = df.getAllMaterialbyType("Beslag & Skruer");
        System.out.println(materials);
        HttpSession session = request.getSession();
        session.setAttribute("stockListScrews", materials);
        
        return target;
    }
    
}
    