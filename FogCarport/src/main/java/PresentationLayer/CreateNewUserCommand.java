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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rumle
 */
public class CreateNewUserCommand implements Command {

    private String target;

    /**
     * Constructor sets target field
     *
     * @param target
     */
    CreateNewUserCommand(String target) {
        this.target = target;
    }

    /**
     * Creates new user based of email and password parameters
     * 
     * @param request
     * @param manager
     * @return
     * @throws LoginSampleException
     * @throws OrderSampleException
     * @throws MaterialSampleException
     * @throws StyklistException
     * @throws CommandException
     * @throws ClassNotFoundException
     * @throws NumberFormatException 
     */
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException, CommandException, ClassNotFoundException, NumberFormatException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (password1.equals(password2)) {
            manager.createUser(email, password1, "customer");

        }

        return target;
    }

    @Override
    public boolean loginStatus(HttpSession session) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean accesToPage(HttpSession session, String accesForRole) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
