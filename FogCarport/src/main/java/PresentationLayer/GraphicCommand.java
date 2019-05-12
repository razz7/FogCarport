/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.CarportAlgorithm;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.Stykliste;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ludvig
 */
public class GraphicCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException, MaterialSampleException {

        

        if (request.getParameter("thisOrder") != null) {
            HttpSession session = request.getSession();
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));

            OrderMapper om = new OrderMapper();
            Order order = om.getOrderFromId(orderId);

            //CarportAlgorithm car = new CarportAlgorithm();
            //Stykliste styklist = car.carportAlgorithm(order.getWidth(), order.getLength(), order.getRoofTilt(), order.getShedWidth(), order.getShedLength(), 1);
            //System.out.println(order.toString());
            //order.setStyklist(styklist);
            System.out.println(order.toString());

            session.setAttribute("order", order);
        }

        return "carportSVGGraphic";
    }
}
