/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
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
public class AllOrdersCommand extends Command{
    
    private String target;

    AllOrdersCommand(String target) {
        this.target = target;
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        DatabaseFacade dbf = new DatabaseFacade();
        ArrayList<Order> allOrders = dbf.getAllOrders();
        //HttpSession session = request.getSession();
        request.setAttribute("allOrders", allOrders);
        
        return target;
    }
    
}
