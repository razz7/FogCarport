package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import com.google.protobuf.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    
    private String target;

    LogoutCommand(String target) {
        this.target = target;
    }
    
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException, CommandException, ClassNotFoundException {
        HttpSession session = request.getSession();
        session.invalidate();
        session.removeAttribute("email");
        session.removeAttribute("password");
        return target;     
    }
}
