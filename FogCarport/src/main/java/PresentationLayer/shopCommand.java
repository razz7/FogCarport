/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rh
 */
public class shopCommand implements Command {
    
    
    
    private String target;

    shopCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) 
            throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {
<<<<<<< HEAD
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        
        
        if(manager.verifyUser(email, password)) {
           session.removeAttribute("order");
=======
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
           HttpSession session = request.getSession();
           session.setAttribute("order", null);
>>>>>>> e9311238ab34bfa74c181eb5f6ec24a7efdace4d
          
        
        
        return target;                
    }   else
        return "error";
    }
}


