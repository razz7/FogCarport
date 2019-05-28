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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ludvig
 */
public class GraphicCommand implements Command {

    private String target;

    /**
     * Constructor sets target field
     *
     * @param target
     */
    GraphicCommand(String target) {
        this.target = target;
    }

    /**
     * Gets order from database based of id and sets it as a session attribute
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
        session.setAttribute("order", null);
        if (request.getParameter("thisOrder") != null) {
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));
            Order order = manager.getOrderFromId(orderId);
            session.setAttribute("order", order);
        }
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
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
