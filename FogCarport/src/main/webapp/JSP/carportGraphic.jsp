<%-- 
    Document   : carportGraphic
    Created on : 06-05-2019, 18:52:35
    Author     : Ludvig
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Stykliste"%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<h2>Din tegning!</h2>



<%
    if (session.getAttribute("width") != null && session.getAttribute("shedWidth") != null && session.getAttribute("length") != null && session.getAttribute("shedLength") != null) {
        float width = (float) session.getAttribute("width");
        float shedWidth = (float) session.getAttribute("shedWidth");
        float length = (float) session.getAttribute("length");
        float shedLength = (float) session.getAttribute("shedLength");

        out.println("<svg width=\"30cm\" height=\"13cm\">");
        
        out.println("<rect x=\"50\" y=\"0\" width=" + width + " height=\"30\" style=\"stroke: #000000; fill: #0033cc;/>");
        
        out.println("<rect x=" + width + " y=\"30\" width=\"30\" height=\"500\" style=\"stroke: #000000; fill: #0033cc;\"/>");
        out.println("<rect x=\"50\" y=\"30\" width=\"30\" height=\"500\" style=\"stroke: #000000; fill: #FF0000;\"/>");   
                      
        out.println("<rect x=\"50\" y=\"30\" width=" + shedWidth + " height=\"470\" style=\"stroke: #000000; fill: #01DF01;\"/>");
        
        out.println("</svg>");
  
    }
%>



<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>



