<%-- 
    Document   : stockmaterialspage
    Created on : Apr 24, 2019, 1:57:59 PM
    Author     : Rasmus2
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Material"%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>All materials in stock</h1>

<form>
    <table class="table">
        <%
            if (session.getAttribute("stockMaterialList") != null) {
                ArrayList<Material> list = (ArrayList<Material>) session.getAttribute("stockMaterialList");
                for (int i = 0; i < list.size(); i++) {
                    //out.println("<tr><td>" + list.get(i).getItem_id() + ", " + list.get(i).getItem_description() + ", " + list.get(i).getWidth() + ", " + list.get(i).getHeight() + ", " + list.get(i).getEntity() + ", " + list.get(i).getMaterialType() + ", " + list.get(i).getPrice() + "</tr></td>");
                    out.println("<h5>" + list.get(i) + ", StockQty: " + list.get(i).getStockQty() + "</h5>");                    
                    
                    out.println("<form action=\"FrontController\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"command\" value=\"editMaterial\">");
                    out.println("<input type=\"hidden\" name=\"chosenStockMaterial\" value=\"" + list.get(i).getItem_id() + "\">");
                    out.println("<input type=\"submit\" value=\"Edit material\" >");
                    out.println("</form>");
                                        
                    out.println("<form action=\"FrontController\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"command\" value=\"deleteMaterial\">");
                    out.println("<input type=\"hidden\" name=\"chosenStockMaterial\" value=\"" + list.get(i).getItem_id() + "\">");
                    out.println("<input type=\"submit\" value=\"Delete material\" >");
                    out.println("</form>");
                    
                    out.println("<br><br>");
                }
            }
        %>
    </table>
</form>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
