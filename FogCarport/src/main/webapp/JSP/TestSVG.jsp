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
            <svg width="50" height="30">


            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="<% out.println(2300 / 10); %>" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy=" <% out.println(2300 / 10); %> " r="4" stroke="black" stroke-width="3" fill="red" />


            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (order.getStyklist().getStyklist().get(0).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
                double sum = 30;
                for (int i = 0; i < (int) (order.getShedLength() / 60); i++) {
            %>
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - 300) + sum) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum += 60;
                }
            %>
            <rect x='0' y='0' width='<% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(13).getHeight()) / 10);%>'  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> )'/>
            <rect x='<% out.println(25 / 10); %>' y='<% out.println(order.getStyklist().getStyklist().get(13).getHeight() / 10); %>' width='<% out.println(((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) / 10) - 50 / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(11).getHeight()) / 10);%>'  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> )'/>

            </svg>
        </div>
    </body>
</html>
