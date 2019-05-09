package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public interface Command {


    String execute( HttpServletRequest request, FunctionManager manager ) 
            throws LoginSampleException, OrderSampleException, MaterialSampleException;

}
