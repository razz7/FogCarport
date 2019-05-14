/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import FunctionLayer.CarportAlgorithm;
import FunctionLayer.FunctionManager;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus2
 */
public class StyklistPageCommand implements Command {

    private String target;

    StyklistPageCommand(String target) {
        this.target = target;
    }
    
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        //Stykliste styk = manager.carportAlgorithm(6000, 7800, 0, 5300, 2100, 1);
        HttpSession session = request.getSession();
        //session.setAttribute("list", styk);

        if (request.getParameter("specificOrder") != null) {
            int order_id = Integer.parseInt(request.getParameter("specificOrder"));
            Order order = manager.getOrderFromId(order_id);
            session.setAttribute("order", order);
            session.setAttribute("list", order.getStyklist());
        } else if (session.getAttribute("order") != null) {
            Order order = (Order) session.getAttribute("specificOrder");
            session.setAttribute("list", order.getStyklist());
        }
        return target;
    }

}
