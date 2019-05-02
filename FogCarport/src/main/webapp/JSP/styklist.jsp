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




<br>
<div class ="container">
    <h2>Stykliste</h2>
    <table class="table">
        
        <% 
           
           if(session.getAttribute("list") != null) {
                Stykliste list = (Stykliste) session.getAttribute("list");
            
                        
                    out.println("<tr><th>ID</th>");
                    out.println("<th>Beskrivelse</th>");
                    out.println("<th>Højde</th>");
                    out.println("<th>Bredde</th>");
                    out.println("<th>Entity</th>");
                    out.println("<th>Type</th>");
                    out.println("<th>Pris</th></tr>");
                    for (int i = 0; i < list.getStyklist().size(); i++) {
                        
                     out.println("<tr>" + "<td>" + list.getStyklist().get(i).getItem_id()+"</td>");
                     out.println("<td>" + list.getStyklist().get(i).getItem_description()+"</td>" );
                     out.println("<td>" + list.getStyklist().get(i).getHeight()+"</td>" );
                     out.println("<td>" + list.getStyklist().get(i).getWidth()+"</td>" );
                     out.println("<td>" + list.getStyklist().get(i).getEntity()+"</td>" );
                     out.println("<td>" + list.getStyklist().get(i).getMaterialType()+"</td>" );
                     out.println("<td>" + list.getStyklist().get(i).getPrice()+"</td>" + "</tr>");
                     
                    
        }
           }
                    
            
            
        %>
   
       
       
    </table>
    
</div>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
