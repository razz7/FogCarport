/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportAlgorithm;
import FunctionLayer.FunctionManager;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus2
 */
public class StyklistPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        
        //CarportAlgorithm car = new CarportAlgorithm();
        Stykliste styk = manager.carportAlgorithm(6000, 7800, 0, 5300, 2100, 1);
        HttpSession session = request.getSession();
        session.setAttribute("list", styk);
        
        return "styklist";
    }
    
}
