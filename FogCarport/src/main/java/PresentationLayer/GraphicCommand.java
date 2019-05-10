/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

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
    
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
            HttpSession session = request.getSession();
           
            //float height = Float.parseFloat(request.getParameter("height"));
            float width = Float.parseFloat(request.getParameter("width"));
            float length = Float.parseFloat(request.getParameter("length"));
           
            float shedLength = Float.parseFloat(request.getParameter("shedLength"));
            float shedWidth = Float.parseFloat(request.getParameter("shedWidth"));
            //float shedTilt = Float.parseFloat(request.getParameter("shedTilt"));
           
            //int roof = Integer.parseInt(request.getParameter("roof"));   
           
            Order order = new Order(1, width, length, 2300, 0, shedWidth, shedLength);
           
            Stykliste styklist = manager.carportAlgorithm(order.getWidth(), order.getLength(), order.getRoofTilt(), order.getShedWidth(), order.getShedLength(), 1);
            order.setStyklist(styklist);
           
           session.setAttribute("order", order);
           
           return "carportSVGGraphic";
    }
    
}
