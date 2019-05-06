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

        <title>Web Project Basic</title>

        <base href="${pageContext.request.contextPath}/" >

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <body>
        <h1>SVG!</h1>

        <%
            Order order = new Order(1, 6000, 7800, 2300, 0, 5300, 2100);
            //Order(int order_id, float width, float length, float height, float roofTilt, float shedWidth, float shedLength)
            //carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id)
            CarportAlgorithm car = new CarportAlgorithm();
            Stykliste styklist = car.carportAlgorithm(order.getWidth(), order.getLength(), order.getRoofTilt(), order.getShedWidth(), order.getShedLength(), 1);
            order.setStyklist(styklist);

        %>

        <div>
            <svg width="<% order.getLength(); %>" height="2300">

            <rect x="50" y="100" width="50" height="50"
                  style="stroke: #000000; fill: none;"/>

            <rect x="100" y="100" width="50mm" height="50mm"
                  style="stroke: #000000; fill: none;" />

            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% order.getLength(); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="2300" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% order.getLength();%>" cy="2300" r="4" stroke="black" stroke-width="3" fill="red" />

            <rect x='0' y='0' width=' <% out.println(order.getStyklist().getStyklist().get(15).getLength() * ((order.getStyklist().getStyklist().get(15).getStryklistQty() / (int) (order.getWidth() / 1090)) - 100)); %>' height='80' 
                  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> 0 0)'/>

            </svg>
        </div>
    </body>
</html>
