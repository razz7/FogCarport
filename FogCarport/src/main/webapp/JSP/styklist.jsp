<%-- 
    Document   : styklist
    Created on : Apr 24, 2019, 1:26:09 PM
    Author     : Rasmus2
--%>

<%@page import="FunctionLayer.CarportAlgorithm"%>
<%@page import="FunctionLayer.Stykliste"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.User"%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Stykliste</h1>



<form>
    
    <table class="table">
        
        <%
           if(session.getAttribute("list") != null) {
                Stykliste list = (Stykliste) session.getAttribute("list");
            
            
            
                    for (int i = 0; i < list.getStyklist().size(); i++) {
                        
                     out.println("<p>" + list.getStyklist().get(i).toString1() + "</p>");
                     
                     
                    
        }
           }
                    
            
            
        %>
   
       
       
    </table>
    
</form>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
