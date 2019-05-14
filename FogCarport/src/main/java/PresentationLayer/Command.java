package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import javax.servlet.http.HttpServletRequest;

public interface Command {

<<<<<<< HEAD
    abstract String execute( HttpServletRequest request, FunctionManager manager ) 
=======

    String execute( HttpServletRequest request, FunctionManager manager ) 
>>>>>>> b220211488bca6e491fc22002b4601c1560e931f
            throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException;

}
