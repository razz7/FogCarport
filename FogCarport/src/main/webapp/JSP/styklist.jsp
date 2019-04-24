<%-- 
    Document   : styklist
    Created on : Apr 24, 2019, 1:26:09 PM
    Author     : Rasmus2
--%>

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
                String in = (String) session.getAttribute("chosenStykliste");
                User u = (User) session.getAttribute("User");
                DataMapper data = new DataMapper();
                if (data.getAllInvoicesForCustomer(u.getUserName(), u.getPassword()) != null) {
                    ArrayList<Invoice> arIn = data.getAllInvoicesForCustomer(u.getUserName(), u.getPassword());
                    for (int i = 0; i < arIn.size(); i++) {
                        if (in.equals(arIn.get(i).getCart().toString())) {
                            for (int j = 0; j < arIn.get(i).getCart().size(); j++) {
                                out.println("<tr><td>" + arIn.get(i).getCart().get(j).toString() + "</tr></td>");
                            }
                        }
                    }
                }
            }
        %>
    </table>
</form>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
