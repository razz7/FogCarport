<%-- 
    Document   : carportSVGGraphic
    Created on : Apr 24, 2019, 1:26:09 PM
    Author     : Rasmus2
--%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Error!</h1>

<% String message = (String) session.getAttribute("message"); %>

<h5> <%out.println(message);%> </h5>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>