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
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rumle
 */
public class AllOrdersCommand implements Command {

    private String target;

    /**
     * Constructor sets target field
     *
     * @param target
     */
    AllOrdersCommand(String target) {
        this.target = target;
    }

    /**
     * Gets all orders from database as an arraylist and sets it as a session attribute
     * 
     * @param request
     * @param manager
     * @return
     * @throws LoginSampleException
     * @throws OrderSampleException
     * @throws MaterialSampleException 
     */
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {

        HttpSession session = request.getSession();
        if (loginStatus(session)) {
            return "index.jsp";
        }
        ArrayList<Order> allOrders = manager.getAllOrders();
        request.setAttribute("allOrders", allOrders);

        return target;
    }

    /**
     * Checks the user's login status
     * 
     * @param session
     * @return boolean
     */
    @Override
    public boolean loginStatus(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean accesToPage(HttpSession session, String accesForRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
