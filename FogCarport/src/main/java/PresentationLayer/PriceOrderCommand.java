/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import DBAccess.OrderMapper;
import FunctionLayer.FunctionManager;
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
public class PriceOrderCommand implements Command{
    
    private String target;

    PriceOrderCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {               
        if(request.getParameter("thisOrder") != null){
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));
            float percent = Float.parseFloat(request.getParameter("percentage"));
            float price = Float.parseFloat(request.getParameter("price"));
                        
//            manager.finalizeOrder(orderId);    
            
            float orderPrice = price*(1+(percent/100));
            
            Order order = manager.getOrderFromId(orderId);    
            order.setPrice(orderPrice);
//            order.setOrderStatus(true);
            
//            ArrayList<Order> allOrders = manager.getAllOrders();
//            request.setAttribute("allOrders", allOrders);
            request.setAttribute("price", orderPrice);
            request.setAttribute("order", order);
        }
        
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));
            Order order = manager.getOrderFromId(orderId); 
            
            float price = Float.parseFloat(request.getParameter("price"));                      
            
            request.setAttribute("price", price);
            request.setAttribute("order", order);
            
        
        return target;
    }   

    @Override
    public boolean loginStatus(HttpSession session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean accesToPage(HttpSession session, String accesForRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
