<%-- 
    Document   : stockmaterialspage
    Created on : Apr 24, 2019, 1:57:59 PM
    Author     : Rasmus2
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Material"%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

    <div class ="offset-sm-2">
        <br>
        <h3>All materials in stock</h3>

        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="editMaterial">
            <input type="hidden" name="chosenStockMaterial" value="">
            <input type="submit" value="Create a new stock material">
        </form>
    </div>
    <br>
    <div class="col-sm-8 offset-sm-2 text-left">
        <form>
            <table class="table">
            <%
                if (session.getAttribute("stockMaterialList") != null) {
                    ArrayList<Material> list = (ArrayList<Material>) session.getAttribute("stockMaterialList");
                    for (int i = 0; i < list.size(); i++) {
                        //out.println("<tr><td>" + list.get(i).getItem_id() + ", " + list.get(i).getItem_description() + ", " + list.get(i).getWidth() + ", " + list.get(i).getHeight() + ", " + list.get(i).getEntity() + ", " + list.get(i).getMaterialType() + ", " + list.get(i).getPrice() + "</tr></td>");
                        out.println("<div class=\"alert alert-primary\" role=\"alert\">");
                        out.println("<h5>" + " " + list.get(i).toString1() + ", StockQty: " + list.get(i).getStockQty() + "</h5>");

                        out.println("<form action=\"FrontController\" method=\"post\">");
                        out.println("<input type=\"hidden\" name=\"command\" value=\"editMaterial\">");
                        out.println("<input type=\"hidden\" name=\"chosenStockMaterial\" value=\"" + list.get(i).getItem_id() + "\">");
                        out.println("<input class=\"btn btn-info  btn-sm\" type=\"submit\" value=\"Edit material\" >");
                        out.println("</form>");
                        out.println("<form action=\"FrontController\" method=\"post\">");
                        out.println("<input type=\"hidden\" name=\"command\" value=\"deleteMaterial\">");
                        out.println("<input type=\"hidden\" name=\"chosenStockMaterial\" value=\"" + list.get(i).getItem_id() + "\">");
                        out.println("<input class=\"btn btn-danger  btn-sm\" type=\"submit\" value=\"Delete material\" >");
                        out.println("</form>");

                        out.println("<br><br>");
                        out.println("</div>");
                    }
                }
            %>
        </table>
    </form>
</div>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
