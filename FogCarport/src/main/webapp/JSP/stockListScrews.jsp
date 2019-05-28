<%-- 
    Document   : træ
    Created on : May 7, 2019, 9:37:17 AM
    Author     : rh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Material"%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

    <div class ="offset-sm-2">
        <br>
        <h3>Alt træ på lager</h3>

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
                if (session.getAttribute("stockListScrews") != null) {
                    ArrayList<Material> list = (ArrayList<Material>) session.getAttribute("stockListScrews");
                    for (int i = 0; i < list.size(); i++) {
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
                } else {
                    out.println("<h1>Hej</h1>");
                }
            %>
        </table>
    </form>
</div>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
