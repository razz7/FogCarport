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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
public class EditLineItemCommand extends Command {

    private String target;

    EditLineItemCommand(String target) {
        this.target = target;
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {
        DatabaseFacade dbf = new DatabaseFacade();

        int id = Integer.parseInt(request.getParameter("lineitemID"));

        Material material = dbf.getMaterialFromLineItems(id);
        HttpSession session = request.getSession();
        session.setAttribute("lineitemToEdit", material);

        return target;
    }
=======

/**
 *
 * @author Rumle
 */

public class EditLineItemCommand implements Command{

    @Override
     public String execute(HttpServletRequest request, FunctionManager manager) 
            throws LoginSampleException, OrderSampleException, MaterialSampleException {
         
            int id = Integer.parseInt(request.getParameter("lineitemID"));
            
            Material material;
        try {
            material = manager.getMaterialFromLineItems(id);
            
            HttpSession session = request.getSession();
            session.setAttribute("lineitemToEdit", material);
        } catch (StyklistException ex) {
            Logger.getLogger(EditLineItemCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            return "editlineitem";             
    }    
>>>>>>> b220211488bca6e491fc22002b4601c1560e931f
}
