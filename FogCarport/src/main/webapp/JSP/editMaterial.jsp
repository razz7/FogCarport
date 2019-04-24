<%-- 
    Document   : EditMaterial
    Created on : 24-04-2019, 15:08:21
    Author     : Ludvig
--%>
<%@page import="FunctionLayer.Material"%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Edit material!</h1>
<%
    if (session.getAttribute("stockMaterial") != null) {
        Material material = (Material) session.getAttribute("stockMaterial");

        out.println("<form action=\"FrontController\" method=\"POST\">");
        out.println("<input type=\"hidden\" name=\"command\" value=\"allmaterials\">");

        out.println("<tr><td> Material id: </tr></td>");
        out.println("<input type=\"text\" name=\"id\" value=" + material.getItem_id() + ">");
        out.println("<tr><td> Material description: </tr></td>");
        out.println("<input type=\"text\" name=\"description\" value=" + material.getItem_description() + ">");
        out.println("<tr><td> Material width: </tr></td>");
        out.println("<input type=\"text\" name=\"width\" value=" + material.getWidth() + ">");
        out.println("<tr><td> Material width: </tr></td>");
        out.println("<input type=\"text\" name=\"height\" value=" + material.getHeight() + ">");
        out.println("<tr><td> Material entity: </tr></td>");
        out.println("<input type=\"text\" name=\"entity\" value=" + material.getEntity() + ">");
        out.println("<tr><td> Material type: </tr></td>");
        out.println("<input type=\"text\" name=\"type\" value=" + material.getMaterialType() + ">");
        out.println("<tr><td> Material price: </tr></td>");
        out.println("<input type=\"text\" name=\"price\" value=" + material.getPrice() + ">");

        out.println("<input type=\"submit\" value=\"Submit changes\">");
        out.println("</form");
    }
%>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
