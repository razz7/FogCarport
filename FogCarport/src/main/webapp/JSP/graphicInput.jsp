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


    <form action="FrontController" method="POST">
        <div class="container">
            <form action="FrontController" method="POST">


                <h4>Lav en tegning af din carport</h4>

                <div class="form-row">
                    <input type="hidden" name="command" value="graphic">

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

                <br>

                <input class="btn btn-primary" type="submit" value="Vis tegning">
                </div>
            </form>


        <jsp:include page='/JSP/sitefooter.jsp'></jsp:include>



