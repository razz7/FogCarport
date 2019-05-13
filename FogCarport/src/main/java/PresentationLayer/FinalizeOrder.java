/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ludvig
 */
public class FinalizeOrder implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {       
        
        if(request.getParameter("thisOrder") != null){
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));
            float percent = Float.parseFloat(request.getParameter("percent"));
            float price = Float.parseFloat(request.getParameter("price"));
            
            DatabaseFacade dbf = new DatabaseFacade();
            dbf.finalizeOrder(orderId);
            
            Order order = dbf.getOrderFromId(orderId);
            order.setPrice(price * ((percent/100)+1));
            
            ArrayList<Order> allOrders = dbf.getAllOrders();
            request.setAttribute("allOrders", allOrders);
        }
        
        return "allOrdersPage";
    }
    
}
