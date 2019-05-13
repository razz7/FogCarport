<%-- 
    Document   : allOrdersPage
    Created on : May 8, 2019, 11:26:42 AM
    Author     : Rumle
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.DatabaseFacade"%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

    <div class="container">
        <h2>See Orders</h2>

        <table class="table table-hover row-clickable">

            <th>Order ID</th>
            <th>Width</th>
            <th>Length</th>
            <th>Rooftilt</th>
            <th>shedwidth</th>
            <th>shedlength</th>
            <th>status</th>
            <th>orderdate</th>
            <th>customername</th>                       

        <% if (request.getAttribute("allOrders") != null) {
                ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("allOrders");

                for (int i = 0; i < orders.size(); i++) {                    

                    //out.println("<form action=\"FrontController\" method=\"POST\">");
                    out.print("<tr><td>" + orders.get(i).getOrder_id() + "</td>");
                    out.print("<td>" + orders.get(i).getWidth() + "</td>");
                    out.print("<td>" + orders.get(i).getLength() + "</td>");
                    out.print("<td>" + orders.get(i).getRoofTilt() + "</td>");
                    out.print("<td>" + orders.get(i).getShedWidth() + "</td>");
                    out.print("<td>" + orders.get(i).getShedLength() + "</td>");
                    if(orders.get(i).isOrderStatus() == true) {
                    out.println("<td>sendt</td>");
                } else {
                        out.println("<td>ikke sendt</td>");
                    }
                                                      
                    out.print("<td>" + orders.get(i).getOrderdate() + "</td>");
                    out.print("<td>"  + orders.get(i).getUser().getEmail() + "</td>");
                    out.print("<td>");
                    out.println("<form action=\"FrontController\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"command\" value=\"styklistpage\">");
                    out.println("<input type=\"hidden\" name=\"specificOrder\" value=\"" + orders.get(i).getOrder_id() + "\">");
                    out.println("<input class=\"btn btn-info  btn-sm\" type=\"submit\" value=\"Se stykliste\" >");
                    out.println("</form>");                    
                    
                    out.println("<form action=\"FrontController\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"command\" value=\"graphic\">");
                    out.println("<input type=\"hidden\" name=\"thisOrder\" value=\"" + orders.get(i).getOrder_id() + "\">");
                    out.println("<input class=\"btn btn-info  btn-sm\" type=\"submit\" value=\"Se tegning\" >");
                    out.println("</form>");
                    
                    out.println("<form action=\"FrontController\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"command\" value=\"finalPrice\">");
                    out.println("<input type=\"hidden\" name=\"thisOrder\" value=\"" + orders.get(i).getOrder_id() + "\">");
                    out.println("<input class=\"btn btn-info  btn-sm\" type=\"submit\" value=\"Prissæt ordre\" >");
                    out.println("</form>");
                    out.print("</td>");
                    
                    out.print("</tr>");
                }
            }
        %>

    </table>
</div>


