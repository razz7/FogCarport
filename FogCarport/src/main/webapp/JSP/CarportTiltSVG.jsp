<%-- 
    Document   : newjsp
    Created on : Apr 29, 2019, 10:53:18 AM
    Author     : Rasmus2
--%>

<%@page import="java.util.HashMap"%>
<%@page import="FunctionLayer.Material"%>
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
        <h1>SVG TILT!</h1>

        <%
            Order order = new Order(1, 3600, 7300, 2100, 30, 5300, 2100);
            //Order order = new Order(1, 3600, 7300, 2100, 30, 0, 0);
            CarportAlgorithm car = new CarportAlgorithm();
            Stykliste styklist = car.carportAlgorithm(order.getWidth(), order.getLength(), order.getRoofTilt(), order.getShedWidth(), order.getShedLength(), 1);
            order.setStyklist(styklist);
            HashMap<Integer, Material> materials = new HashMap<>();
            for (Material m : order.getStyklist().getStyklist()) {
                materials.put(m.getItem_id(), m);
            }
        %> 

        <div>
            <svg width="<% out.println(order.getLength() / 10); %>" height="<% out.println((order.getHeight() + (Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %>">

            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="<% out.println((order.getHeight() + (Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %>" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy=" <% out.println((order.getHeight() + (Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %> " r="4" stroke="black" stroke-width="3" fill="red" />

            <rect x='<% out.println((300 - (materials.get(6).getWidth())) / 10); %>' y=' <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %> ' width='<% out.println((order.getLength() - 300*2 + + (materials.get(6).getWidth())*2)/10); %>' height='<% out.println((materials.get(5).getHeight()) / 10);%>' stroke="black" fill="red"/>
            <%
                double sum = 0;
                for (int i = 0; i < (int) (order.getShedLength() / 60); i++) {
            %>
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - 300) + sum) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(7).getHeight() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum += 60;
                }
            %>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
                if (order.getShedLength() != 0 || order.getShedWidth() != 0) {
            %>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (materials.get(6).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
            } else {
            %>
            <rect x=" <% out.println((order.getLength() - (1000.0 / 7800.0 * order.getLength()) - materials.get(6).getWidth()) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((order.getLength() / 2) - (materials.get(6).getWidth() / 2)) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)))/10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
                }
            %>
            </svg>
        </div>

    </body>
</html>