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
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ludvig
 */
class OrderPageCommand implements Command {

    private int id = 1;

    private String target;

    /**
     * Constructor sets target field
     *
     * @param target
     */
    OrderPageCommand(String target) {
        this.target = target;
    }

    /**
     * Creates an order and styklist based of user input, sets stykliste as belonging 
     * to the order and sets order and styklist as session attributes 
     *
     * @param request
     * @param manager
     * @return
     * @throws LoginSampleException
     * @throws OrderSampleException
     * @throws MaterialSampleException
     */
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {

        HttpSession session = request.getSession();
        if (loginStatus(session)) {
            return "index.jsp";
        }
        float width = Float.parseFloat(request.getParameter("width"));
        float length = Float.parseFloat(request.getParameter("length"));
        float shedLength = Float.parseFloat(request.getParameter("shedLength"));
        float shedWidth = Float.parseFloat(request.getParameter("shedWidth"));
        float roofTilt = Integer.parseInt(request.getParameter("roof"));
        float height = 2300;

        if (width > 7500 || width < 2400 || length > 7800 || length < 2400 || shedLength > 6900 || shedLength < 1500 || shedWidth > 7200 || shedWidth < 2100 || roofTilt > 45 || roofTilt < 0) {
            return target;
        } else {
            User user = (User) session.getAttribute("user");
            Order order = new Order(id, width, length, height, roofTilt, shedWidth, shedLength);
            order.setUser(user);
            Stykliste sl = manager.carportAlgorithm(width, length, roofTilt, shedWidth, shedLength, id);
            order.setStyklist(sl);

            manager.saveOrder(order);

            session.setAttribute("order", order);
            session.setAttribute("stykliste", sl);
            session.setAttribute("shopOrder", order);

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
