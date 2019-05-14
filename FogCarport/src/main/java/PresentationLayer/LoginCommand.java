/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import FunctionLayer.FunctionManager;
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
    
    private String target;

    LoginCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) 
            throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(manager.verifyUser(email, password)) {
            User user = manager.getUserByEmail(email);
            request.getSession().setAttribute("user", user);
            return "mainpage";
        }
        return target;                
    }   
}
