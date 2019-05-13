/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rumle
 */
public class UpdateLineitem implements Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {
        int order_id = (Integer) request.getSession().getAttribute("specificOrder");
        int lineitem_id = Integer.parseInt(request.getParameter("lineitemid"));
        String description = request.getParameter("description");
        float width = Float.parseFloat(request.getParameter("width"));
        float height = Float.parseFloat(request.getParameter("height"));
        String entity = request.getParameter("entity");
        String type = request.getParameter("type");
        float price = Float.parseFloat(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        DatabaseFacade dbf = new DatabaseFacade();
        dbf.editLineItemsFromOrderID(lineitem_id, description, width, height, entity, type, price, qty, order_id);
        
        
        
        
        //Stykliste list = dbf.getOrderFromId(order_id).getStyklist();
        //HttpSession session = request.getSession();
        //session.setAttribute("list", list);
        
        HttpSession session = request.getSession();
        Order order = dbf.getOrderFromId(order_id);
        session.setAttribute("order", order);
        session.setAttribute("list", order.getStyklist()); 
      
      return "styklist";
    }
    
}
