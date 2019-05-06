<%-- 
    Document   : newjsp
    Created on : Apr 29, 2019, 10:53:18 AM
    Author     : Rasmus2
--%>

<%@page import="FunctionLayer.Stykliste"%>
<%@page import="FunctionLayer.CarportAlgorithm"%>
<%@page import="FunctionLayer.Order"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>

         <link rel = "stylesheet"
   type = "text/css"
   href = "css.css" />

    </head>
    <body>
        <h1>SVG!</h1>


        <%
            Order order = new Order(1, 6000, 7800, 2300, 0, 5300, 2100);
            //Order(int order_id, float width, float length, float height, float roofTilt, float shedWidth, float shedLength)
            //carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id)
            CarportAlgorithm car = new CarportAlgorithm();
            Stykliste stykl = car.carportAlgorithm(order.getWidth(), order.getLength(), order.getRoofTilt(), order.getShedWidth(), order.getShedLength(), 1);

        %>

        <div id="box">
            <svg width="54px" height="54px" viewBox="0 0 54 54" version="1.1">

            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% order.getLength(); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="2300" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% order.getLength(); %>" cy="2300" r="4" stroke="black" stroke-width="3" fill="red" />

            <%
//180 - (Math.pow(Math.sin((230-220)/order.getLength()), -1) + 90)
            %> 




            <rect x='0' y='80' width='150' height='80'/>

            <rect x='0' y='80' width='150' height='80' 
                  transform='rotate(90 150 160) rotate(90 150 80)'/>

            </svg>
        </div>
    </body>
</html>
