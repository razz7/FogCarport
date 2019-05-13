package PresentationLayerDONTREMOVE;

import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class TargetCommand implements Command {
  private final String target;

  TargetCommand(String target) {
    this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, OrderSampleException, MaterialSampleException, StyklistException {
        
        
        return target;
    }
  
  }
