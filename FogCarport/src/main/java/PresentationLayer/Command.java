package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import javax.servlet.http.HttpServletRequest;

public interface Command {

    String execute( HttpServletRequest request, FunctionManager manager ) 
            throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException, CommandException, ClassNotFoundException, NumberFormatException;

}
