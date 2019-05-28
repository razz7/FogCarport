<%-- 
    Document   : ordering
    Created on : 16-04-2019, 23:11:39
    Author     : Ludvig
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Stykliste"%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>


    <div class="alert alert-primary">
        <br>
        <div class="container">
            <h2>Velkommen til Fogs online bestillingsservice!</h2>
        </div>

        <form action="FrontController" method="POST">
            <div class="container">
            <%
                if (session.getAttribute("order") == null) {
            %>
            <h6>Der er et sæt minimums- og maximumskrav til størrelse</h6>
            <h6>Hvis målene ikke følger disse krav går ordren ikke igennem</h6>

            <br>

            <h4>Carport mål </h4>
            <div class="form-row">
                <input type="hidden" name="command" value="order">

                <div class="col-md-3 mb-3">

                    <label for="">Bredde</label>
                    <p><small>Min: 2400 Max: 7500</small></p>
                    <input type="text" name="width" value="" class="form-control" 
                           placeholder="0.0"  >
                </div>
                <div class="col-md-3 mb-3">

                    <label for="">Længde</label>
                    <p><small>Min: 2400 Max: 7800</small></p>
                    <input type="text" name="length" value="" class="form-control" 
                           placeholder="0.0">
                </div>
                <div class="col-md-3 mb-3">
                    <label for="">Carport rejsning (optional)</label>
                    <p><small>Min: 0 Max: 45</small></p>
                    <input type="text" name="roof" value="0" class="form-control" 
                           placeholder="0.0">
                </div>
            </div>
            <br>
            <h4>Skur mål</h4>
            <div class="form-row">
                <div class="col-md-3 mb-3">

                    <label for="">Skur Længde</label>
                    <p><small>Min: 1500 Max: 6900</small></p>
                    <input type="text" name="shedLength" value="" class="form-control" 
                           placeholder="0.0">
                </div>
                <div class="col-md-3 mb-3">
                    <label for="">Skur bredde</label>
                    <p><small>Min: 2100 Max: 7200</small></p>
                    <input type="text" name="shedWidth" value="" class="form-control" 
                           placeholder="0.0">
                </div>
            </div>
            <br>

        </div>

        <br>

        <input class="btn btn-primary" type="submit" value="Make order">
        <%
        } else {
            Order order = (Order) session.getAttribute("order");
        %>


        <input type="hidden" name="command" value="graphicShop">
        <input class="btn btn-primary" type="submit" value="See visual order">
        <%

        %>
    </form>    
</div>


<%     
        Stykliste sl = order.getStyklist();
        out.println("<br>");
        out.println("<h4> Styklisten: </h4>");
        out.println("<div class=\"container\">");
        ArrayList<Material> am = sl.getStyklist();
        out.println("<table class=\"table table-striped\"> "
                + "<thead><tr class=\"bg-primary\">"
                + "<th>Matriale id</th>"
                + "<th>Styklist Qty</th>"
                + "<th>Stock Qty</th>"
                + "<th>Mat type</th>"
                + "<th> Mat beskrivelse</th>"
                + "<th> Con beskrivelse</th>"
                + "<th>Bredde</th>"
                + "<th>Højde</th>"
                + "<th>Længde</th>"
                + "<th>Entity</th>"
                + "<th>Pris</th>"
                + "<th>Version</th>"
                + "</th></thead>");
        for (int i = 0; i < am.size(); i++) {
            out.println("<tr>");
            out.println("<td> " + am.get(i).getItem_id() + "</td>");
            out.println("<td> " + am.get(i).getStryklistQty() + "</td>");
            out.println("<td> " + am.get(i).getStockQty() + "</td>");
            out.println("<td> " + am.get(i).getMaterialType() + "</td>");
            out.println(
                    "<td> " + am.get(i).getItem_description() + "</td>");
            out.println(
                    "<td> " + am.get(i).GettConstructionDescription() + "</td>");
            out.println("<td> " + am.get(i).getWidth() + "</td>");
            out.println("<td> " + am.get(i).getHeight() + "</td>");
            out.println("<td> " + am.get(i).getLength() + "</td>");
            out.println("<td> " + am.get(i).getEntity() + "</td>");
            out.println("<td> " + am.get(i).getPrice() + "</td>");
            out.println("<td> " + am.get(i).getVersionnr() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");
        if (session != null) {
            session.removeAttribute("stykliste");
        }
    }
%>
<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
