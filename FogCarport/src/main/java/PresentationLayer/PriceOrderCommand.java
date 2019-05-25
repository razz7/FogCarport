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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ludvig
 */
public class PriceOrderCommand implements Command {

    private String target;

    /**
     * Constructor sets target field
     *
     * @param target
     */
    PriceOrderCommand(String target) {
        this.target = target;
    }

    /**
     * Gets attributes percent and orderId and gives the order a new price based
     * of the percent parameter and sets the order and new price as session
     * attributes
     *
     * @param request
     * @param manager
     * @return
     * @throws LoginSampleException
     * @throws OrderSampleException
     * @throws MaterialSampleException
     * @throws StyklistException
     */
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {
        HttpSession session = request.getSession();
        if (loginStatus(session)) {
            return "index.jsp";
        }

        if (request.getParameter("thisOrder") != null) {
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));
            float percent = Float.parseFloat(request.getParameter("percentage"));

            Order order = manager.getOrderFromId(orderId);
            float price = manager.getPriceFromId(orderId);

            float orderPrice = (price * (1 + (percent / 100)));
            manager.setPriceOrder(orderId, orderPrice);

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
