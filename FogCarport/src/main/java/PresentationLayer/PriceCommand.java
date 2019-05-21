/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ludvig
 */
public class PriceCommand implements Command {

    private String target;

    public PriceCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        HttpSession session = request.getSession();
        if (loginStatus(session)) {
            return "index.jsp";
        }

        if (request.getParameter("thisOrder") != null) {
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));

            Order order = manager.getOrderFromId(orderId);
            Stykliste sl = manager.getStyklistForOrder(orderId);

            float orderPrice = manager.getPriceFromId(orderId);

            if (orderPrice == 0) {
                ArrayList<Material> materials = sl.getStyklist();
                float price = 0;
                for (int i = 0; i < materials.size(); i++) {
                    price = price + materials.get(i).getTotalItemPrice();
                }

                //order.setPrice(price);
                manager.setPriceOrder(orderId, price);
                request.setAttribute("price", price);
                request.setAttribute("order", order);
                return target;
            }
            request.setAttribute("price", orderPrice);
            request.setAttribute("order", order);
        }

        return target;
    }

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
