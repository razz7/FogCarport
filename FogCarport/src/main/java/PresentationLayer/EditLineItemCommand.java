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
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
/**
 *
 * @author Rumle
 */
public class EditLineItemCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
            //DatabaseFacade dbf = new DatabaseFacade();
            Material material = null;
            int id = Integer.parseInt(request.getParameter("lineitemToEdit"));
            material = manager.getMaterialbyID(id);
=======
public class EditLineItemCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {
            DatabaseFacade dbf = new DatabaseFacade();
>>>>>>> newCommand
            
            int id = Integer.parseInt(request.getParameter("lineitemID"));
            
            Material material = dbf.getMaterialFromLineItems(id);
            HttpSession session = request.getSession();
            session.setAttribute("lineitemToEdit", material);
            
            
            return "editlineitem";
       
        
    }
    
}
