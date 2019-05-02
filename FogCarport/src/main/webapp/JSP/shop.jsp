<%-- 
    Document   : ordering
    Created on : 16-04-2019, 23:11:39
    Author     : Ludvig
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Stykliste"%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Velkommen til Fogs online bestillingsservice!</h1>
<br><br>

<form  class="container-fluid"   action="FrontController" method="POST">
    <input type="hidden" name="command" value="order">
    <h4>Carport mål: </h4>
    <h5>Højde</h5>
    <input type="text" name="height" value="">
    <h5>Bredde</h5>
    <input type="text" name="width" value="">
    <h5>Længde</h5>
    <input type="text" name="length" value="">
    
    <h4>Skur mål</h4>
    <h5>Skur længde</h5>
    <input type="text" name="shedLength" value="">
    <h5>Skur bredde</h5>
    <input type="text" name="shedWidth" value="">
    
    <h5>Indtast 0 for fladt tag og 1 for højt tag</h5>
    <input type="text" name="shedTilt" value="">
    
    <br><br>

    <%
        if (session.getAttribute("stykliste") != null){
            Stykliste sl = (Stykliste) session.getAttribute("stykliste");
            out.println("<h4> Styklisten: </h4>");
            out.println("<h4> Id:" + sl.getStyklist_id() + "</h4>");
            
            ArrayList<Material> am = sl.getStyklist();
            
            for(int i = 0; i < am.size(); i++){
                out.println("<h5>" + am.get(i) + "</h5>");
            }
            
            if (session != null) {
            session.removeAttribute("stykliste");
            }
        }
    %>

    <input class="btn btn-primary" type="submit" value="Make order">
</form>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
