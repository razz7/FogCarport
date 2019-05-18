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
        
        HttpSession session = request.getSession();
        if(loginStatus(session)) {
            return "index.jsp";
        }
        session.removeAttribute("order");
        
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
   


    


