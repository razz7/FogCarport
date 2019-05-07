<%-- 
    Document   : editLineitem
    Created on : May 2, 2019, 11:07:35 AM
    Author     : Rumle
--%>

<%@page import="FunctionLayer.Material"%>

<!DOCTYPE html>
<%
    if(session.getAttribute("lineitemToEdit")!=null) {
        Material material = (Material)session.getAttribute("lineitemToEdit");
out.println("<form action=\"FrontController\" method=\"POST\">");
        out.println("<input type=\"hidden\" name=\"command\" value=\"???\">");

        out.println("<tr><td> Material id: </tr></td>");
        out.println("<input type=\"text\" name=\"id\" value=" + material.getItem_id() + ">");
        out.println("<tr><td> Material description: </tr></td>");
        out.println("<input type=\"text\" name=\"description\" value=" + material.getItem_description() + ">");
        out.println("<tr><td> Material width: </tr></td>");
        out.println("<input type=\"text\" name=\"width\" value=" + material.getWidth() + ">");
        out.println("<tr><td> Material height: </tr></td>");
        out.println("<input type=\"text\" name=\"height\" value=" + material.getHeight() + ">");
        out.println("<tr><td> Material entity: </tr></td>");
        out.println("<input type=\"text\" name=\"entity\" value=" + material.getEntity() + ">");
        out.println("<tr><td> Material type: </tr></td>");
        out.println("<input type=\"text\" name=\"type\" value=" + material.getMaterialType() + ">");
        out.println("<tr><td> Material price: </tr></td>");
        out.println("<input type=\"text\" name=\"price\" value=" + material.getPrice() + ">");
        out.println("<tr><td> Material quantity: </tr></td>");
        out.println("<input type=\"text\" name=\"qty\" value=" + material.getStockQty() + ">");

        out.println("<input type=\"submit\" value=\"Submit changes\">");
        out.println("</form");
    }
        %>
