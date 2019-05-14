package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    abstract String execute( HttpServletRequest request, FunctionManager manager ) 
            throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException;

}
