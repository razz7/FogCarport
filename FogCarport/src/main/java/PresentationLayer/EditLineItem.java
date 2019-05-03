/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rumle
 */
public class EditLineItem extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException, MaterialSampleException {
            DatabaseFacade dbf = new DatabaseFacade();
            Material material = null;
            int id = Integer.parseInt(request.getParameter("lineitemToEdit"));
            material = dbf.getMaterialbyID(id);
            
            HttpSession session = request.getSession();
            session.setAttribute("lineitemToEdit", material);
            
            return "editlineitem";
       
        
    }
    
}
