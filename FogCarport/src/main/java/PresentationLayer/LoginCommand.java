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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rumle
 */
public class LoginCommand implements Command {

    private String target;

    /**
     * Constructor sets target field
     *
     * @param target
     */
    public LoginCommand(String target) {
        this.target = target;
    }

    /**
     * Gets email and password attributes, verifies if the user is legit and if
     * so logs the user in, otherwise user is returned to index.jsp
     *
     * @param request
     * @param manager
     * @return
     * @throws LoginSampleException
     * @throws OrderSampleException
     * @throws MaterialSampleException
     * @throws StyklistException
     */
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager)
            throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        FunctionManager fm = new FunctionManager();
        if (fm.verifyUser(email, password)) {
            User user = fm.getUserByEmail(email);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return target;
        }

        return "index.jsp";
    }

    @Override
    public boolean loginStatus(HttpSession session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean accesToPage(HttpSession session, String accesForRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
