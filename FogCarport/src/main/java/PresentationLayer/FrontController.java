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
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rasmus2
 *
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    private final FunctionManager manager = new FunctionManager();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, StyklistException {

        String commandKey = request.getParameter("command");
        Command command = CommandFactory.commandFrom(commandKey);
        try {
            String target = command.execute(request, manager);
            RequestDispatcher dispatcher = request.getRequestDispatcher(target);
            dispatcher.forward(request, response);
        } catch (CommandException ce) {
            request.setAttribute("message", ce.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    ce.getTarget());
            dispatcher.forward(request, response);
        } catch (OrderSampleException oe) {
            request.setAttribute("message", oe.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    oe.getTarget());
            dispatcher.forward(request, response);
        } catch (MaterialSampleException me) {
            request.setAttribute("message", me.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    me.getTarget());
            dispatcher.forward(request, response);
        } catch (StyklistException se) {
            request.setAttribute("message", se.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    se.getTarget());
            dispatcher.forward(request, response);
        } catch (LoginSampleException le) {
            request.setAttribute("message", le.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    le.getTarget());
            dispatcher.forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head><title>PANIC Page</title></head>");
            out.println("  <body>");
            out.println("    <h3>" + e.getMessage() + "</h3><hr/>");
            out.println("    <pre>");
            e.printStackTrace(out); // Don't do this in production code!
            out.print("</pre>");
            out.println("  </body>");
            out.println("</html>");
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
