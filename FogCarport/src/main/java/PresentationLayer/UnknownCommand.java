package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rasmus2
 */
public class UnknownCommand implements Command {
    
    private String target;

    UnknownCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute( HttpServletRequest request, FunctionManager manager ) throws LoginSampleException {
        String msg = "Unknown command. Contact IT";
        throw new LoginSampleException( msg );
    }

}
