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
<div class="container">
    <form action="FrontController" method="POST">
        <h4>Carport m�l </h4>
        <div class="form-row">
            <input type="hidden" name="command" value="order">
           
            <div class="col-md-3 mb-3">

                <label for="">Bredde</label>
                <input type="text" name="width" value="" class="form-control" 
                       placeholder="Carport Bredde"  >
            </div>
            <div class="col-md-3 mb-3">

                <label for="">L�ngde</label>
                <input type="text" name="length" value="" class="form-control" 
                       placeholder="Carport L�ngde">
            </div>
        </div>
        <br>
        <h4>Skur m�l</h4>
        <div class="form-row">
            <div class="col-md-3 mb-3">

                <label for="">L�ngde</label>
                <input type="text" name="shedLength" value="" class="form-control" 
                       placeholder="Skur L�ngde">
            </div>
            <div class="col-md-3 mb-3">


                <label for="">Skur bredde</label>
                <input type="text" name="shedWidth" value="" class="form-control" 
                       placeholder="Skur Bredde">
            </div>
        </div>


        <%--
        <h5>Indtast 0 for fladt tag og 1 for h�jt tag</h5>
        <input type="text" name="shedTilt" value="">
        --%>

        <span>
            <fieldset id="roof">
                <h5>H�jt tag</h5>
                <input type="radio" value="1" name="roof">

                <h5>Lavt tag</h5>
                <input type="radio" value="0" name="roof">
            </fieldset>
        </span>

        <br>
        
                <input class="btn btn-primary" type="submit" value="Make order">
        </div>
    </form>

        <%
            if (session.getAttribute("stykliste") != null) {
                Stykliste sl = (Stykliste) session.getAttribute("stykliste");
                out.println("<h4> Styklisten: </h4>");
                out.println("<h4> Id:" + sl.getStyklist_id() + "</h4>");
                out.println("<div class=\"container\">");
                ArrayList<Material> am = sl.getStyklist();
                    out.println("<table class=\"table table-striped\"> "
                            + "<thead><tr class=\"bg-warning\">"
                            + "<th>Matriale id</th>"
                            + "<th>Styklist Qty</th>"
                            + "<th>Stock Qty</th>"
                            + "<th>Mat type</th>"
                            
                            + "<th> Mat beskrivelse</th>"
                            + "<th> Con beskrivelse</th>"
                            +"<th>Bredde</th>"
                            +"<th>H�jde</th>"
                            +"<th>L�ngde</th>"
                            +"<th>Entity</th>"
                            +"<th>Pris</th>"
                            +"<th>Version</th>"
                            + "</th></thead>");
                for (int i = 0; i < am.size(); i++) {
                    out.println("<tr>");
                    out.println("<td> " + am.get(i).getItem_id() + "</td>");
                    out.println("<td> " + am.get(i).getStryklistQty()+ "</td>");
                    out.println("<td> " + am.get(i).getStockQty()+ "</td>");
                    out.println("<td> " + am.get(i).getMaterialType()+ "</td>");
                    
                    out.println("<td> " + am.get(i).getItem_description()+ "</td>");
                    out.println("<td> " + am.get(i).GettConstructionDescription() + "</td>");
                    out.println("<td> " + am.get(i).getWidth()+ "</td>");
                    out.println("<td> " + am.get(i).getHeight()+ "</td>");
                    out.println("<td> " + am.get(i).getLength()+ "</td>");
                    out.println("<td> " + am.get(i).getEntity()+ "</td>");
                    out.println("<td> " + am.get(i).getPrice()+ "</td>");
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
                ", materiale beskrivelse: " + item_description + ", h�jde: " +
                height  + ", bredde: " + width + ", entity: " + entity + ", materialetype: " + 
                materialtype + ", pris: " + price + ", versionnr: " + versionnr; --%>
        
        
        
</div>
</div>
<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
