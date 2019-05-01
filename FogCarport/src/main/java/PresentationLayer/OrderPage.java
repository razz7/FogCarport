/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportAlgorithm;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.Stykliste;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ludvig
 */
public class OrderPage extends Command{
    
    private int id = 1;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException, MaterialSampleException {
           HttpSession session = request.getSession();
           
           float height = Float.parseFloat(request.getParameter("height"));
           float width = Float.parseFloat(request.getParameter("width"));
           float length = Float.parseFloat(request.getParameter("length"));
           
           float shedLength = Float.parseFloat(request.getParameter("shedLength"));
           float shedWidth = Float.parseFloat(request.getParameter("shedWidth"));
           float shedTilt = Float.parseFloat(request.getParameter("shedTilt"));
           
           CarportAlgorithm ca = new CarportAlgorithm();

           Stykliste sl = ca.carportAlgorithm(width, length, shedTilt, shedWidth, shedLength, id);          
           id++;
           
           session.setAttribute("stykliste", sl);
           
           return "shop";
    }
    
}
