/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rh
 */
public class StockListWoodCommand implements Command {

    private String target;

    /**
     * Constructor sets target field
     *
     * @param target
     */
    StockListWoodCommand(String target) {
        this.target = target;
    }

    /**
     * Gets an arraylist of all materials of the type "Træ & Tagplader" and sets
     * it as a session attribute
     *
     * @param request
     * @param manager
     * @return
     * @throws LoginSampleException
     * @throws OrderSampleException
     * @throws MaterialSampleException
     */
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException {
        HttpSession session = request.getSession();
        if (loginStatus(session)) {
            return "index.jsp";
        }
        //DatabaseFacade df = new DatabaseFacade();
        ArrayList<Material> materials = manager.getAllMaterialbyType("Træ & Tagplader");
        System.out.println(materials);

        session.setAttribute("stockListWood", materials);

        return target;
    }

    /**
     * Checks the user's login status
     *
     * @param session
     * @return boolean
     */
    @Override
    public boolean loginStatus(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean accesToPage(HttpSession session, String accesForRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
