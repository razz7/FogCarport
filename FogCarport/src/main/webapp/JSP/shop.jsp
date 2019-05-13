<%-- 
    Document   : ordering
    Created on : 16-04-2019, 23:11:39
    Author     : Ludvig
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Stykliste"%>
<%@page import="FunctionLayer.CarportAlgorithm"%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>


    <div class="alert alert-primary"
         <br>
        <div class="container">
            <h2>Velkommen til Fogs online bestillingsservice!</h2>
        </div>
        <br>
        <form action="FrontController" method="POST">
            <div class="container">
            <%
                if (session.getAttribute("order") == null) {
            %>
            <h4>Carport mål </h4>
            <div class="form-row">
                <input type="hidden" name="command" value="order">

                <div class="col-md-3 mb-3">

                    <label for="">Bredde</label>
                    <input type="text" name="width" value="6000" class="form-control" 
                           placeholder="0.0"  >
                </div>
                <div class="col-md-3 mb-3">

                    <label for="">Længde</label>
                    <input type="text" name="length" value="7800" class="form-control" 
                           placeholder="0.0">
                </div>
                <div class="col-md-3 mb-3">
                    <label for="">Carport rejsning(optional)</label>
                    <input type="text" name="roof" value="0" class="form-control" 
                           placeholder="0.0">
                </div>
            </div>
            <br>
            <h4>Skur mål</h4>
            <div class="form-row">
                <div class="col-md-3 mb-3">

                    <label for="">Skur Længde</label>
                    <input type="text" name="shedLength" value="2100" class="form-control" 
                           placeholder="0.0">
                </div>
                <div class="col-md-3 mb-3">
                    <label for="">Skur bredde</label>
                    <input type="text" name="shedWidth" value="5300" class="form-control" 
                           placeholder="0.0">
                </div>
            </div>
            <br>
            <h4>Personlig data</h4>
            <div class="form-row">
                <div class="col-md-3 mb-3">
                    <label for="">Fulde navn</label>
                    <input type="text" name="name" value="j" class="form-control" 
                           placeholder="">
                </div>
                <div class="col-md-3 mb-3">
                    <label for="">Adresse</label>
                    <input type="text" name="adress" value="f" class="form-control" 
                           placeholder="">
                </div>
                <div class="col-md-3 mb-3">
                    <label for="">Email</label>
                    <input type="text" name="email" value="k" class="form-control" 
                           placeholder="">
                </div>
            </div>


            <%--
            <h5>Indtast 0 for fladt tag og 1 for højt tag</h5>
            <input type="text" name="shedTilt" value="">
            --%>


            <br>

            <input class="btn btn-primary" type="submit" value="Make order">
            <%
            } else {
            %>
            <input type="hidden" name="command" value="graphic">
            <input class="btn btn-primary" type="submit" value="See visual order">
            <%
                }
            %>

        </div>
    </form>

    <%
        if (session.getAttribute("list") != null) {
            Stykliste sl = (Stykliste) session.getAttribute("stykliste");
            out.println("<h4> Styklisten: </h4>");
            //out.println("<h4> Id:" + sl.getStyklist_id() + "</h4>");
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


    <%--     return "Materiale information: " + " materiale id: " + item_id + 
         ", materiale beskrivelse: " + item_description + ", højde: " +
         height  + ", bredde: " + width + ", entity: " + entity + ", materialetype: " + 
         materialtype + ", pris: " + price + ", versionnr: " + versionnr; --%>



</div>
</div>
<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
