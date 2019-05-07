<%-- 
    Document   : ordering
    Created on : 16-04-2019, 23:11:39
    Author     : Ludvig
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Stykliste"%>
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
        <h4>Carport mål </h4>
        <div class="form-row">
            <input type="hidden" name="command" value="order">
           
            <div class="col-md-3 mb-3">

                <label for="">Bredde</label>
                <input type="text" name="width" value="" class="form-control" placeholder="Carport Bredde">
            </div>
            <div class="col-md-3 mb-3">

                <label for="">Længde</label>
                <input type="text" name="length" value="" class="form-control" placeholder="Carport Længde">
            </div>
        </div>
        <br>
        <h4>Skur mål</h4>
        <div class="form-row">
            <div class="col-md-3 mb-3">

                <label for="">Længde</label>
                <input type="text" name="shedLength" value="" class="form-control" placeholder="Skur Længde">
            </div>
            <div class="col-md-3 mb-3">


                <label for="">Skur bredde</label>
                <input type="text" name="shedWidth" value="" class="form-control" placeholder="Skur Bredde">
            </div>
        </div>


        <%--
        <h5>Indtast 0 for fladt tag og 1 for højt tag</h5>
        <input type="text" name="shedTilt" value="">
        --%>

        <span>
            <fieldset id="roof">
                <h5>Højt tag</h5>
                <input type="radio" value="1" name="roof">

                <h5>Lavt tag</h5>
                <input type="radio" value="0" name="roof">
            </fieldset>
        </span>

        <br>

        <%
            if (session.getAttribute("stykliste") != null) {
                Stykliste sl = (Stykliste) session.getAttribute("stykliste");
                out.println("<h4> Styklisten: </h4>");
                out.println("<h4> Id:" + sl.getStyklist_id() + "</h4>");

                ArrayList<Material> am = sl.getStyklist();

                for (int i = 0; i < am.size(); i++) {
                    out.println("<h5>" + am.get(i) + "</h5>");
                }

                if (session != null) {
                    session.removeAttribute("stykliste");
                }
            }
        %>

        <input class="btn btn-primary" type="submit" value="Make order">
        </div>
    </form>
</div>
</div>
<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
