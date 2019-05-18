/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ludvig
 */
public class OrderFinalizeCommand implements Command {

    private String target;

    OrderFinalizeCommand(String target) {
        this.target = target;
    }

    @Override
<<<<<<< HEAD:FogCarport/src/main/java/PresentationLayer/OrderFinalizeCommand.java
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException, CommandException, ClassNotFoundException, NumberFormatException {
=======
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {       
        HttpSession session = request.getSession();
        if(loginStatus(session)) {
            return "index.jsp";
        }
>>>>>>> 3f2a71cd0da22bae5c2149e00a1d21d3c6c6957f:FogCarport/src/main/java/PresentationLayer/FinalizeOrderCommand.java
        if(request.getParameter("thisOrder") != null){
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));
            
            manager.finalizeOrder(orderId); 
            Order order = manager.getOrderFromId(orderId);  
            order.setOrderStatus(true);
            
            ArrayList<Order> allOrders = manager.getAllOrders();
            request.setAttribute("allOrders", allOrders);
        }
        return target;
<<<<<<< HEAD:FogCarport/src/main/java/PresentationLayer/OrderFinalizeCommand.java
    }

=======
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
>>>>>>> 3f2a71cd0da22bae5c2149e00a1d21d3c6c6957f:FogCarport/src/main/java/PresentationLayer/FinalizeOrderCommand.java
}
