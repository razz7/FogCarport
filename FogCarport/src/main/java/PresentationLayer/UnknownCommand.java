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

    @Override
    public String execute( HttpServletRequest request, FunctionManager manager ) throws LoginSampleException {
        String msg = "Unknown command. Contact IT";
        throw new LoginSampleException( msg );
    }

}
