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
public class DeleteStockMaterialCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("chosenStockMaterial"));

        //DatabaseFacade df = new DatabaseFacade();
        manager.deleteMaterial(id);

        ArrayList<Material> materials = manager.getAllMaterials();
        session.setAttribute("stockMaterialList", materials);

        return "stockmaterialspage";
    }
}
