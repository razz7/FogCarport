/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.DatabaseFacade;
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
public class EditStockMaterialPage extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        //String email = request.getParameter("email");
        //String password = request.getParameter("password");
        //LogicFacade logic = new LogicFacade();
        //User user = logic.login(email, password);

        int id = Integer.parseInt(request.getParameter("id"));
        DatabaseFacade dbf = new DatabaseFacade();
        Material mat = dbf.getMaterialbyID(id);
        
        HttpSession session = request.getSession();
        session.setAttribute("stockMaterial", mat);

        String description = request.getParameter("description");
        float width = Float.parseFloat(request.getParameter("width"));
        float height = Float.parseFloat(request.getParameter("height"));
        String entity = request.getParameter("entity");

        return "editMaterial";

    }
}
