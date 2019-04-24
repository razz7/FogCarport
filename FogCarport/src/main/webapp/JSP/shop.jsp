<%-- 
    Document   : ordering
    Created on : 16-04-2019, 23:11:39
    Author     : Ludvig
--%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Velkommen til Fogs online bestillingsservice!</h1>

<form action="FrontController" method="POST">
    <input type="hidden" name="command" value="order">
    <h5>Height</h5>
    <input type="text" name="height" value="">
    <h5>Width</h5>
    <input type="text" name="width" value="">
    <h5>Length</h5>
    <input type="text" name="length" value="">

    <span>
        <fieldset id="roof">
            <h5>Højt tag</h5>
            <input type="radio" value="high" name="roof">

            <h5>Lavt tag</h5>
            <input type="radio" value="low" name="roof">
        </fieldset>
    </span>

    <input type="submit" value="Make order">
</form>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
