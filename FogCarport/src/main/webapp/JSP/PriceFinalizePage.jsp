<%-- 
    Document   : PriceFinalizePage
    Created on : 13-05-2019, 09:54:18
    Author     : Ludvig
--%>

<%@page import="FunctionLayer.Order"%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<div class="container">
        <h2>Ordren</h2>
            
            

        <% if (request.getAttribute("price") != null && request.getAttribute("order") != null) {
                Order order = (Order) request.getAttribute("order");
                float price = (Float) request.getAttribute("price");
                
                out.println("<h3>" + price + "</h3>");
                out.println("<h3> Indtast procent </h3>");

                out.println("<form action=\"FrontController\" method=\"post\">");
                out.println("<input type=\"text\" name=\"percent\" value=\"\">");
                out.println("<input type=\"hidden\" name=\"price\" value=\"" + price + ">");
                out.println("<input type=\"hidden\" name=\"command\" value=\"percentPrice\">");
                out.println("<input type=\"hidden\" name=\"thisOrder\" value=\"" + order.getOrder_id() + "\">");
                out.println("<input type=\"submit\" value=\"Godkend ordre\" >");
                out.println("</form>");
            }
        %>

    </table>
</div>
