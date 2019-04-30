<%-- 
    Document   : styklist
    Created on : Apr 24, 2019, 1:26:09 PM
    Author     : Rasmus2
--%>

<%@page import="FunctionLayer.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.User"%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Styklist data</h1>

<form>
    <table class="table">
        <%
            if (session.getAttribute("chosenStykliste") != null) {
                ArrayList<Material> list = (ArrayList<Material>) session.getAttribute("chosenStykliste");

                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        out.println("<h4> Item id: " + list.get(i).getItem_id() + "</h4>");
                        out.println("<h4> Item description: " + list.get(i).getItem_description() + "</h4>");
                        out.println("<h4> Item id: " + list.get(i).getMaterialType() + "</h4>");
                        out.println("<h4> Item id: " + list.get(i).getWidth() + "</h4>");
                        out.println("<h4> Item id: " + list.get(i).getHeight() + "</h4>");
                        System.out.println("hello world");
                    }
                }
            }
        %>
    </table>
</form>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
