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
import FunctionLayer.StyklistException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rh
 */
public class StockListTagpakkeCommand implements Command {
    
    private String target;

    StockListTagpakkeCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {
        //DatabaseFacade df = new DatabaseFacade();
        ArrayList<Material> materials = manager.getAllMaterialbyType("Træ & Tagplader");
        System.out.println(materials);
        HttpSession session = request.getSession();
        session.setAttribute("stockListWood", materials);
        
        return target;
    }
}
   