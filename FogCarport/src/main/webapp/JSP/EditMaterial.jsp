<%-- 
    Document   : EditMaterial
    Created on : 24-04-2019, 15:08:21
    Author     : Ludvig
--%>

<%@page import="FunctionLayer.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit material!</h1>
        <%
            if (session.getAttribute("Material") != null) {
                Material material = (Material) session.getAttribute("material");
                
                out.println("<form action=\"FrontController\" method=\"POST\">");
                    out.println("<input type=\"hidden\" name=\"command\" value=\"change\">");
                    
                    out.println("<tr><td> Material id: " + material.getItem_id() + "</tr></td>");
                    out.println("<input type=\"text\" name=\"id\" value=\"\">");
                    out.println("<tr><td> Material description: " + material.getItem_description() + "</tr></td>");
                    out.println("<input type=\"text\" name=\"description\" value=\"\">");
                    out.println("<tr><td> Material width: " + material.getWidth() + "</tr></td>");
                    out.println("<input type=\"text\" name=\"width\" value=\"\">");
                    out.println("<tr><td> Material width: " + material.getHeight() + "</tr></td>");
                    out.println("<input type=\"text\" name=\"height\" value=\"\">");
                    out.println("<tr><td> Material width: " + material.getEntity() + "</tr></td>");
                    out.println("<input type=\"text\" name=\"entity\" value=\"\">");
                    out.println("<tr><td> Material width: " + material.getMaterialType() + "</tr></td>");
                    out.println("<input type=\"text\" name=\"type\" value=\"\">");
                    out.println("<tr><td> Material width: " + material.getPrice() + "</tr></td>");                    
                    out.println("<input type=\"text\" name=\"price\" value=\"\">");
                    
                    out.println("<input type=\"submit\" value=\"Submit changes\">");
                out.println("</form");
            }
        %>
    </body>
</html>
