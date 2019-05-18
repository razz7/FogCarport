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
public class StockListScrewsCommand implements Command {
    
    private String target;

    StockListScrewsCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        HttpSession session = request.getSession();
        if(loginStatus(session)) {
            return "index.jsp";
        }
        //DatabaseFacade df = new DatabaseFacade();
        ArrayList<Material> materials = manager.getAllMaterialbyType("Beslag & Skruer");
        System.out.println(materials);
        
        session.setAttribute("stockListScrews", materials);
        
        return target;
    }

    @Override
    public boolean loginStatus(HttpSession session) {
         if(session.getAttribute("user") != null) {
            return false;
        }
        return true;
    
    }

    @Override
    public boolean accesToPage(HttpSession session, String accesForRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    