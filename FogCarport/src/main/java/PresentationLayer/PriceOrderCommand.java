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
        HttpSession session = request.getSession();
        if(loginStatus(session)) {
            return "index.jsp";
        }
        
        if(request.getParameter("thisOrder") != null){
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));
            float percent = Float.parseFloat(request.getParameter("percentage"));
            float price = Float.parseFloat(request.getParameter("price")); 
            
            Order order = manager.getOrderFromId(orderId);  
            
            //Order order = (Order) request.getAttribute("order");
            //float price = order.getPrice();
            float orderPrice = (price*(1+(percent/100)));             
            order.setPrice(orderPrice);

            request.setAttribute("orderPrice", orderPrice);
            request.setAttribute("price", orderPrice);
            request.setAttribute("order", order);
            
            return target;            
        } else {
            
            ArrayList<Order> orders = manager.getAllOrders();
            request.setAttribute("allOrders", orders);
            
            return "JSP/allOrdersPage.jsp";
        }            
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
