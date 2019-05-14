/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rasmus2
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {
    
    private final FunctionManager manager = new FunctionManager();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, StyklistException {
            String command = request.getParameter("command");
            Command action = CommandFactory.commandFrom(command);
        try {
<<<<<<< HEAD
            String commandKey = request.getParameter("command");
            Command action = CommandFactory.commandFrom(commandKey);
            String view = action.execute(request, response);
            request.getRequestDispatcher(view).forward(request, response);
        } catch (LoginSampleException | OrderSampleException | MaterialSampleException | StyklistException ex) {
=======
            String view = action.execute(request, manager);
            request.getRequestDispatcher("/JSP/" + view + ".jsp").forward(request, response);
        } catch (LoginSampleException | OrderSampleException | MaterialSampleException ex) {
>>>>>>> b220211488bca6e491fc22002b4601c1560e931f
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch(StyklistException e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (StyklistException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (StyklistException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
