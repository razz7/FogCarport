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
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ludvig
 */
public class PriceCommand implements Command{
    
    private String target;

    PriceCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
                 
        if(request.getParameter("thisOrder") != null){
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));
            
            Order order = manager.getOrderFromId(orderId);
            Stykliste sl = manager.getStyklistForOrder(orderId);
            
            ArrayList<Material> materials = sl.getStyklist();           
            float price = 0;
            for(int i = 0; i < materials.size(); i++){
                price = price + materials.get(i).getPrice();
            }
            
            request.setAttribute("price", price);
            request.setAttribute("order", order);
        }
        
        return target;
    }
    
}
