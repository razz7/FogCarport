/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rumle
 */
<<<<<<< HEAD
public class AllOrdersCommand extends Command{
    
    private String target;

    AllOrdersCommand(String target) {
        this.target = target;
    }
=======
public class AllOrdersCommand implements Command{
>>>>>>> b220211488bca6e491fc22002b4601c1560e931f

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        ArrayList<Order> allOrders = manager.getAllOrders();
        //HttpSession session = request.getSession();
        request.setAttribute("allOrders", allOrders);
        
        return target;
    }
    
}
