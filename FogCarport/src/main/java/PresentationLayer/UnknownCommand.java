package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus2
 */
public class UnknownCommand implements Command {

    private String target;

    /**
     * Constructor sets target field
     *
     * @param target
     */
    UnknownCommand(String target) {
        this.target = target;
    }

    /**
     * Throws LoginSampleException
     *
     * @param request
     * @param manager
     * @return
     * @throws LoginSampleException
     */
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException {
        String msg = "Unknown command. Contact IT";
        throw new LoginSampleException(msg);
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
