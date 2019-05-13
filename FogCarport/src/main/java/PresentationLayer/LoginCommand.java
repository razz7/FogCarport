/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rumle
 */
public class LoginCommand implements Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
            throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        DatabaseFacade dbf = new DatabaseFacade();
        
        if(dbf.verifyUser(email, password)) {
            User user = dbf.getUserByEmail(email);
            request.getSession().setAttribute("user", user);
            return "mainpage";
        }
        return "index";
        
        
    }
    
}
