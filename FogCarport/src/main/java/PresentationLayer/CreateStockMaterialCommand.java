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
<<<<<<< HEAD
public class CreateStockMaterialCommand extends Command {
    
    private String target;

    CreateStockMaterialCommand(String target) {
        this.target = target;
    }
=======
public class CreateStockMaterialCommand implements Command {
>>>>>>> b220211488bca6e491fc22002b4601c1560e931f

    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        HttpSession session = request.getSession();
        
        String description = request.getParameter("description");
        float width = Float.parseFloat(request.getParameter("width"));
        float height = Float.parseFloat(request.getParameter("height"));
        String entity = request.getParameter("entity");
        String type = request.getParameter("type");
        float price = Float.parseFloat(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        
        //DatabaseFacade df = new DatabaseFacade();
        
        manager.addNewMaterial(description, width, height, entity, type, price, qty);
        
        ArrayList<Material> materials = manager.getAllMaterials();
        session.setAttribute("stockMaterialList", materials);
        
        return target;
    }

}
