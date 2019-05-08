<%-- 
    Document   : EditMaterial
    Created on : 24-04-2019, 15:08:21
    Author     : Ludvig
--%>
<%@page import="FunctionLayer.Material"%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>


<br>
<div class="container">
<h2>Edit material!</h2>
</div>
<%
    out.println("<div class=\"container\">");
    if (session.getAttribute("stockMaterial") != null) {
        Material material = (Material) session.getAttribute("stockMaterial");
        out.println("<form action=\"FrontController\" method=\"POST\">");
        out.println("<div class=\"form-row\">");
        out.println("<input type=\"hidden\" name=\"command\" value=\"updateMaterial\">");
        out.println("<div class=\"col-md-3 mb-3\">");
        out.println("<tr><td> Material id: </tr></td>");
        out.println("<input type=\"text\" name=\"id\" value=" + material.getItem_id() + ">");
        out.println("</div>");
        out.println("<div class=\"col-md-3 mb-3\">");
        out.println("<tr><td> Material description: </tr></td>");
        out.println("<input type=\"text\" name=\"description\" value=" + material.getItem_description() + ">");
        out.println("</div>");
        out.println("<div class=\"col-md-3 mb-3\">");
        out.println("<tr><td> Material width: </tr></td>");
        out.println("<input type=\"text\" name=\"width\" value=" + material.getWidth() + ">");
        out.println("</div>");
        out.println("<div class=\"col-md-3 mb-3\">");
        out.println("<tr><td> Material height: </tr></td>");
        out.println("<input type=\"text\" name=\"height\" value=" + material.getHeight() + ">");
        out.println("</div>");
        out.println("<div class=\"col-md-3 mb-3\">");
        out.println("<tr><td> Material entity: </tr></td>");
        out.println("<input type=\"text\" name=\"entity\" value=" + material.getEntity() + ">");
        out.println("</div>");
        out.println("<div class=\"col-md-3 mb-3\">");
        out.println("<tr><td> Material type: </tr></td>");

        out.println("<input type=\"text\" name=\"type\" value=" +  "\"" + material.getMaterialType() + "\"" + ">");

        out.println("<input type=\"text\" name=\"type\" value=" + material.getMaterialType() + ">");
                out.println("<h5>" + material.getMaterialType() + "</h5>");

        out.println("</div>");
        out.println("<div class=\"col-md-3 mb-3\">");
        out.println("<tr><td> Material price: </tr></td>");
        out.println("<input type=\"text\" name=\"price\" value=" + material.getPrice() + ">");
        out.println("</div>");
        out.println("<div class=\"col-md-3 mb-3\">");
        out.println("<tr><td> Material quantity: </tr></td>");
        out.println("<input type=\"text\" name=\"qty\" value=" + material.getStockQty() + ">");
        out.println("</div>");
        out.println("<input class=\"btn btn-primary\" type=\"submit\" value=\"Submit changes\">");
        out.println("</div>");
        out.println("</form");
    } else {

        out.println("<form action=\"FrontController\" method=\"POST\">");
        out.println("<div class=\"form-row\">");
        out.println("<input type=\"hidden\" name=\"command\" value=\"createMaterial\">");
        
        out.println("<tr><td> Material description: </tr></td>");
        out.println("<input type=\"text\" name=\"description\" value=\"\">");
        out.println("<tr><td> Material width: </tr></td>");
        out.println("<input type=\"text\" name=\"width\" value=\"\">");
        out.println("<tr><td> Material width: </tr></td>");
        out.println("<input type=\"text\" name=\"height\" value=\"\">");
        out.println("<tr><td> Material entity: </tr></td>");
        out.println("<input type=\"text\" name=\"entity\" value=\"\">");
        out.println("<tr><td> Material type: </tr></td>");
        out.println("<input type=\"text\" name=\"type\" value=\"\">");
        out.println("<tr><td> Material price: </tr></td>");
        out.println("<input type=\"text\" name=\"price\" value=\"\">");
        out.println("<tr><td> Material quantity: </tr></td>");
        out.println("<input type=\"text\" name=\"qty\" value=\"\">");

        out.println("<input type=\"submit\" value=\"Submit material\">");
        out.println("</div>");
        out.println("</form");
        out.println("</div>");
    }
%>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
