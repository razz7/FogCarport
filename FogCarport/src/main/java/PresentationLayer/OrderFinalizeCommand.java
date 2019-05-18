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
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException, CommandException, ClassNotFoundException, NumberFormatException {
        if(request.getParameter("thisOrder") != null){
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));
            
            manager.finalizeOrder(orderId); 
            Order order = manager.getOrderFromId(orderId);  
            order.setOrderStatus(true);
            
            ArrayList<Order> allOrders = manager.getAllOrders();
            request.setAttribute("allOrders", allOrders);
        }
        return target;
    }

}
