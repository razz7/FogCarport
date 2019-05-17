/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderDBMapper;
import DBAccess.OrderMapper;
import FunctionLayer.CarportAlgorithm;
import FunctionLayer.FunctionManager;
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
public class GraphicCommand implements Command {
    
    private String target;

    GraphicCommand(String target) {
        this.target = target;
    }
    
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        HttpSession session = request.getSession();
        if(loginStatus(session)) {
            return "index.jsp";
        }
        session.setAttribute("order", null);

        if (request.getParameter("thisOrder") != null) {
            int orderId = Integer.parseInt(request.getParameter("thisOrder"));
            //OrderDBMapper om = new OrderDBMapper();
            Order order = manager.getOrderFromId(orderId);
            session.setAttribute("order", order);

            //CarportAlgorithm car = new CarportAlgorithm();
            //Stykliste styklist = car.carportAlgorithm(order.getWidth(), order.getLength(), order.getRoofTilt(), order.getShedWidth(), order.getShedLength(), 1);
            //System.out.println(order.toString());
            //order.setStyklist(styklist);
            //System.out.println(order.toString());
            return target;

        } else {
            float width = Float.parseFloat(request.getParameter("width"));
            float length = Float.parseFloat(request.getParameter("length"));
            float shedLength = Float.parseFloat(request.getParameter("shedLength"));
            float shedWidth = Float.parseFloat(request.getParameter("shedWidth"));
            float roofTilt = Integer.parseInt(request.getParameter("roof"));
            float height = 2300;

            if (width > 7500 || width < 2400 || length > 7800 || length < 2400 || shedLength > 6900 || shedLength < 1500 || shedWidth > 7200 || shedWidth < 2100 || roofTilt > 45 || roofTilt < 0) {
                //throw new MaterialSampleException("Fejl i mål");
                return target;
            } else {
                //CarportAlgorithm ca = new CarportAlgorithm();
                Order order = new Order(0, width, length, height, roofTilt, shedWidth, shedLength);
                Stykliste sl = manager.carportAlgorithm(width, length, roofTilt, shedWidth, shedLength, 0);
                order.setStyklist(sl);

                session.setAttribute("order", order);
                session.setAttribute("stykliste", sl);
            }
            return target;
        }
    }  

    @Override
    public boolean loginStatus(HttpSession session) {
       if(session.getAttribute("user") != null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean accesToPage(HttpSession session, String accesForRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
