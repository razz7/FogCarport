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
import FunctionLayer.StyklistException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rh
 */
public class StockListTagpakkeCommand implements Command {

    private String target;

    /**
     * Constructor sets target field
     *
     * @param target
     */
    StockListTagpakkeCommand(String target) {
        this.target = target;
    }

    /**
     * Gets an arraylist of all materials of type "Tagpakken" and sets it as a
     * session attribute
     *
     * @param request
     * @param manager
     * @return
     * @throws LoginSampleException
     * @throws OrderSampleException
     * @throws MaterialSampleException
     * @throws StyklistException
     */
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException {
        HttpSession session = request.getSession();
        if (loginStatus(session)) {
            return "index.jsp";
        }
        ArrayList<Material> materials = manager.getAllMaterialbyType("Tagpakken");
        System.out.println(materials);

        session.setAttribute("stockListTagpakke", materials);

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
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
