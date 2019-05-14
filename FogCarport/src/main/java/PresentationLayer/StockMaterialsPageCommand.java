/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import DBAccess.MaterialDBMapper;
import FunctionLayer.FunctionManager;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.User;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus2
 */
public class StockMaterialsPageCommand implements Command {
    
    private String target;

    StockMaterialsPageCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        //String email = request.getParameter("email");
        //String password = request.getParameter("password");
        //LogicFacade logic = new LogicFacade();
        //User user = logic.login(email, password);
        
        //DatabaseFacade df = new DatabaseFacade();
        ArrayList<Material> materials = manager.getAllMaterials();
        HttpSession session = request.getSession();
        session.setAttribute("stockMaterialList", materials);
        
        return target;
    }
    
}
