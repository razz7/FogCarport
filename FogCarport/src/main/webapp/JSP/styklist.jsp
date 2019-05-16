<%-- 
    Document   : styklist
    Created on : Apr 24, 2019, 1:26:09 PM
    Author     : Rasmus2
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.CarportAlgorithm"%>
<%@page import="FunctionLayer.Stykliste"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.User"%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>
    <br>
    <div class ="container">
        <h2>Stykliste</h2>
        <table class="table">

        <%
            //if (session.getAttribute("list") != null) {
            if (session.getAttribute("order") != null) {
                //Stykliste list = (Stykliste) session.getAttribute("list");
                Order order = (Order) session.getAttribute("order");
                Stykliste list = order.getStyklist();
                
                out.print("<th>");
                out.println("<form action=\"FrontController\" method=\"post\">");
                out.println("<input type=\"hidden\" name=\"command\" value=\"AllOrders\">");
                out.println("<input class=\"btn btn-info  btn-sm\" type=\"submit\" value=\"Se all ordrer\" >");
                out.println("</form>");
                out.println("<form action=\"FrontController\" method=\"post\">");
                out.println("<input type=\"hidden\" name=\"command\" value=\"graphic\">");
                out.println("<input type=\"hidden\" name=\"thisOrder\" value=\"" + order.getOrder_id() + "\">");
                out.println("<input class=\"btn btn-info  btn-sm\" type=\"submit\" value=\"Se tegning\" >");
                out.println("</form>");
                out.print("</th>");

                out.println("<tr><th>ID</th>");
                out.println("<th>Description</th>");
                out.println("<th>Width</th>");
                out.println("<th>Length</th>");
                out.println("<th>Height</th>");
                out.println("<th>Type</th>");
                out.println("<th>Styk</th>");
                out.println("<th>Pris</th></tr>");

                for (int i = 0; i < list.getStyklist().size(); i++) {
                    out.println("<form action=\"FrontController\" method=\"POST\">");

                    out.println("<tr>" + "<td>" + list.getStyklist().get(i).getItem_id() + "</td>");
                    out.println("<td>" + list.getStyklist().get(i).getItem_description() + "</td>");

                    out.println("<td>" + list.getStyklist().get(i).getWidth() + "</td>");
                    out.println("<td>" + list.getStyklist().get(i).getLength() + "</td>");
                    out.println("<td>" + list.getStyklist().get(i).getHeight() + "</td>");
                    out.println("<td>" + list.getStyklist().get(i).getEntity() + "</td>");
                    out.println("<td>" + list.getStyklist().get(i).getMaterialType() + "</td>");
                    out.println("<td>" + list.getStyklist().get(i).getStryklistQty() + "</td>");
                    out.println("<td>" + list.getStyklist().get(i).getPrice() + "</td>");
                    out.println("<input type=\"hidden\" name=\"lineitemID\" value=" + list.getStyklist().get(i).getLineItemID() + ">");

                    out.print("<td>");
                    out.println("<form action=\"FrontController\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"command\" value=\"editlineitem\">");
                    out.println("<input type=\"hidden\" name=\"lineitemToEdit\" value=\"" + list.getStyklist().get(i).getItem_id() + "\">");
                    out.println("<input class=\"btn btn-info  btn-sm\" type=\"submit\" value=\"Edit material\" >");
                    out.println("</form>");
                    out.print("</td>");
                    out.println("</tr>");
                    //out.println("</div");
                }
            }
        %>
    </table>
</div>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
