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

        <% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) / 10); %>

        <div>
            <svg width="50" height="30">

            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="<% out.println(2300 / 10); %>" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy=" <% out.println(2300 / 10); %> " r="4" stroke="black" stroke-width="3" fill="red" />

            <rect x='0' y='0' width='<% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(13).getHeight()) / 10);%>'  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> )'/>
            <rect x='<% out.println(25 / 10); %>' y='<% out.println(order.getStyklist().getStyklist().get(13).getHeight() / 10); %>' width='<% out.println(((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) / 10) - 50 / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(11).getHeight()) / 10);%>'  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> )'/>


            <%
                double space = 0;
                double sum = 0;
                for (int i = 0; i < order.getStyklist().getStyklist().get(0).getStryklistQty() / 2; i++) {
            %>
            <% out.print("<rect x=\"" + sum + "\" height=\"" + order.getStyklist().getStyklist().get(0).getLength() / 10 + "\" width=\"" + order.getStyklist().getStyklist().get(0).getWidth() / 10 + "\""); %>
            style="stroke:#006600; fill: #ff0000"/>
            <%
                    sum = sum + space + order.getStyklist().getStyklist().get(0).getWidth() / 10;
                }
            %>


            </svg>
        </div>
    </body>
</html>
