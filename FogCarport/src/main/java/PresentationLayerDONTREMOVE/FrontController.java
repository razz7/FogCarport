package PresentationLayerDONTREMOVE;

import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PetServlet", urlPatterns = {"/PetServlet"})
public class FrontController extends HttpServlet {
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String commandKey = request.getParameter("command");
    Command command = CommandFactory.commandFrom(commandKey);
    try {
      String target = command.execute(request, response);
      RequestDispatcher dispatcher = request.getRequestDispatcher(target);
      dispatcher.forward(request, response);
      }
    catch (CommandException ce) {
      request.setAttribute("message", ce.getMessage());
      RequestDispatcher dispatcher = request.getRequestDispatcher(ce.getTarget());
      dispatcher.forward(request, response);
      }
    catch (OrderSampleException oe) {
      request.setAttribute("message", oe.getMessage());
      RequestDispatcher dispatcher = request.getRequestDispatcher(oe.getTarget());
      dispatcher.forward(request, response);
      }
    catch (MaterialSampleException me) {
      request.setAttribute("message", me.getMessage());
      RequestDispatcher dispatcher = request.getRequestDispatcher(me.getTarget());
      dispatcher.forward(request, response);
      }
    catch (StyklistException se) {
      request.setAttribute("message", se.getMessage());
      RequestDispatcher dispatcher = request.getRequestDispatcher(se.getTarget());
      dispatcher.forward(request, response);
      }
    catch (Exception e) {
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("  <head><title>PANIC Page</title></head>");
      out.println("  <body>");      
      out.println("    <h3>"+e.getMessage()+"</h3><hr/>");
      out.println("    <pre>");
      e.printStackTrace(out); // Don't do this in production code!
      out.print("</pre>");
      out.println("  </body>");
      out.println("</html>");
      }
    }

  @Override
  public String getServletInfo() {
    return "Short description";
    }

  }
