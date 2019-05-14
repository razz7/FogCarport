/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus2
 */
public class EditStockMaterialPageCommand implements Command {
    
    private String target;

    EditStockMaterialPageCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        //String email = request.getParameter("email");
        //String password = request.getParameter("password");
        //LogicFacade logic = new LogicFacade();
        //User user = logic.login(email, password);

        DatabaseFacade dbf = new DatabaseFacade();
        Material mat = null;
        if (!"".equals(request.getParameter("chosenStockMaterial"))) {
            int id = Integer.parseInt(request.getParameter("chosenStockMaterial"));
            mat = dbf.getMaterialbyID(id);
        }
        HttpSession session = request.getSession();
        session.setAttribute("stockMaterial", mat);

        return target;

    }
}
