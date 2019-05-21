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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rumle
 */
public class UpdateLineitemCommand implements Command{
    
    private String target;

    UpdateLineitemCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {
        HttpSession session = request.getSession();
        if(loginStatus(session)) {
            return "index.jsp";
        }
        int order_id = (Integer) request.getSession().getAttribute("specificOrder");
        int lineitem_id = Integer.parseInt(request.getParameter("lineitemid"));
        String description = request.getParameter("description");
        float width = Float.parseFloat(request.getParameter("width"));
        float height = Float.parseFloat(request.getParameter("height"));
        String entity = request.getParameter("entity");
        String type = request.getParameter("type");
        float price = Float.parseFloat(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        
        //DatabaseFacade dbf = new DatabaseFacade();
        manager.editLineItemsFromOrderID(lineitem_id, description, width, height, entity, type, price, qty, order_id);
        
        //Stykliste list = dbf.getOrderFromId(order_id).getStyklist();
        //HttpSession session = request.getSession();
        //session.setAttribute("list", list);
        
        
        Order order = manager.getOrderFromId(order_id);
        session.setAttribute("order", order);
        session.setAttribute("list", order.getStyklist()); 
      
      return target;
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
