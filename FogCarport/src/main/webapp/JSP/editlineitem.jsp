<%-- 
    Document   : editLineitem
    Created on : May 2, 2019, 11:07:35 AM
    Author     : Rumle
--%>

<%@page import="FunctionLayer.Material"%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%
    if (session.getAttribute("lineitemToEdit") != null) {
        Material material = (Material) session.getAttribute("lineitemToEdit");
        out.println("<form action=\"FrontController\" method=\"POST\">");
        out.println("<input type=\"hidden\" name=\"command\" value=\"updateLineitem\">");

        out.println("<input style=\"display: none\" type\"text\" name=\"lineitemid\" value=" + material.getLineItemID() + ">");
        out.println("<tr><td> Material id: </tr></td>");
        out.println("<input class=\"form-control\" type=\"text\" name=\"id\" value=" + "\"" + material.getItem_id() + "\"" + "readonly>");
        out.println("<tr><td> Material description: </tr></td>");
        out.println("<input class=\"form-control\" type=\"text\" name=\"description\" value=" + "\"" + material.getItem_description() + "\"" + ">");
        out.println("<tr><td> Material width: </tr></td>");
        out.println("<input class=\"form-control\" type=\"text\" name=\"width\" value=" + "\"" + material.getWidth() + "\"" + ">");
        out.println("<tr><td> Material length: </tr></td>");
        out.println("<input class=\"form-control\" type=\"text\" name=\"length\" value=" + "\"" + material.getLength() + "\"" + ">");
        out.println("<tr><td> Material height: </tr></td>");
        out.println("<input class=\"form-control\" type=\"text\" name=\"height\" value=" + "\"" + material.getHeight() + "\"" + ">");
        out.println("<tr><td> Material entity: </tr></td>");
        out.println("<input class=\"form-control\" type=\"text\" name=\"entity\" value=" + "\"" + material.getEntity() + "\"" + ">");
        out.println("<tr><td> Material type: </tr></td>");
        out.println("<input class=\"form-control\" type=\"text\" name=\"type\" value=" + "\"" + material.getMaterialType() + "\"" + ">");
        out.println("<tr><td> Material price: </tr></td>");
        out.println("<input class=\"form-control\" type=\"text\" name=\"price\" value=" + "\"" + material.getPrice() + "\"" + ">");
        out.println("<tr><td> Material quantity: </tr></td>");
        out.println("<input class=\"form-control\" type=\"text\" name=\"qty\" value=" + "\"" + material.getStockQty() + "\"" + ">");

        out.println("<input class=\"btn btn-info  btn-sm\" type=\"submit\" value=\"Opdatér materiale\" >");
        out.println("</form");

        out.println("<form action=\"FrontController\" method=\"post\">");

    }
%>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
