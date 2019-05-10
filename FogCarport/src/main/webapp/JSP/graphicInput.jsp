<%-- 
    Document   : graphicInput

    Author     : Ludvig
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Stykliste"%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<div class="container">
    <form action="FrontController" method="POST">


        <h4>Lav en tegning af din carport</h4>

        <div class="form-row">
            <input type="hidden" name="command" value="graphic">

            <div class="col-md-3 mb-3">

                <label for="">Bredde</label>
                <input type="text" name="width" value="" class="form-control" placeholder="Carport Bredde">
            </div>
            <div class="col-md-3 mb-3">

                <label for="">Længde</label>
                <input type="text" name="length" value="" class="form-control" placeholder="Carport LÃ¦ngde">
            </div>
        </div>
        <br>
        <h4>Skur mål</h4>
        <div class="form-row">
            <div class="col-md-3 mb-3">

                <label for="">Længde</label>
                <input type="text" name="shedLength" value="" class="form-control" placeholder="Skur LÃ¦ngde">
            </div>
            <div class="col-md-3 mb-3">


                <label for="">Skur bredde</label>
                <input type="text" name="shedWidth" value="" class="form-control" placeholder="Skur Bredde">
            </div>
        </div>

        <span>
            <fieldset id="roof">
                <h5>Højt tag</h5>
                <input type="radio" value="1" name="roof">

                <h5>Lavt tag</h5>
                <input type="radio" value="0" name="roof">
            </fieldset>
        </span>

        <br>

        <input class="btn btn-primary" type="submit" value="Vis tegning">
        </div>
    </form>
    

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>



