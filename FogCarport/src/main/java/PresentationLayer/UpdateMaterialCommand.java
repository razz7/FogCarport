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
 * @author Ludvig
 */
public class UpdateMaterialCommand implements Command {

    private String target;

    /**
     * Constructor sets target field
     *
     * @param target
     */
    UpdateMaterialCommand(String target) {
        this.target = target;
    }

    /**
     * Receives parameters from request and updates the material specified by
     * the id parameter
     *
     * @param request
     * @param manager
     * @return
     * @throws LoginSampleException
     * @throws OrderSampleException
     * @throws MaterialSampleException
     * @throws ClassNotFoundException
     * @throws NumberFormatException
     */
    @Override
    public String execute(HttpServletRequest request, FunctionManager manager) throws LoginSampleException, OrderSampleException, MaterialSampleException, ClassNotFoundException, NumberFormatException {
        HttpSession session = request.getSession();
        if (loginStatus(session)) {
            return "index.jsp";
        }
        ArrayList<Material> materials = manager.getAllMaterials();

        String regexNumber = ".*\\d.*";

        if (request.getParameter("id") != null && request.getParameter("description") != null && request.getParameter("width") != null && request.getParameter("height") != null && request.getParameter("entity") != null && request.getParameter("type") != null && request.getParameter("price") != null && request.getParameter("qty") != null) {
            if (request.getParameter("id").length() != 0 && request.getParameter("description").length() != 0 && request.getParameter("width").length() != 0 && request.getParameter("height").length() != 0 && request.getParameter("entity").length() != 0 && request.getParameter("type").length() != 0 && request.getParameter("price").length() != 0 && request.getParameter("qty").length() != 0) {
                if (!(request.getParameter("entity")).matches(regexNumber) && !(request.getParameter("type")).matches(regexNumber)) {

                    int id = Integer.parseInt(request.getParameter("id"));
                    String description = request.getParameter("description");
                    float width = Float.parseFloat(request.getParameter("width"));
                    float height = Float.parseFloat(request.getParameter("height"));
                    String entity = request.getParameter("entity");
                    String type = request.getParameter("type");
                    float price = Float.parseFloat(request.getParameter("price"));
                    int qty = Integer.parseInt(request.getParameter("qty"));

                    manager.updateMaterialData(id, description, width, height, entity, type, price, qty);

                    ArrayList<Material> materials2 = manager.getAllMaterials();
                    session.setAttribute("stockMaterialList", materials2);
                    return target;
                }
            }
        }
        //}
        session.setAttribute("stockMaterialList", materials);

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
