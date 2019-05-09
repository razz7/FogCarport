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
        <h1>SVG FLAT!</h1>

        <%
            Order order = new Order(1, 6000, 7800, 2300, 0, 5300, 2100);
            //Order order = new Order(1, 6000, 7800, 2300, 0, 0, 0);
            CarportAlgorithm car = new CarportAlgorithm();
            Stykliste styklist = car.carportAlgorithm(order.getWidth(), order.getLength(), order.getRoofTilt(), order.getShedWidth(), order.getShedLength(), 1);
            order.setStyklist(styklist);
            HashMap<Integer, Material> materials = new HashMap<>();
            for (Material m : order.getStyklist().getStyklist()) {
                materials.put(m.getItem_id(), m);
            }
        %> 

        <div>
            <svg width="<% out.println(order.getLength() / 10); %>" height="<% out.println(order.getHeight() / 10); %>">

            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="<% out.println(2300 / 10); %>" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy=" <% out.println(2300 / 10); %> " r="4" stroke="black" stroke-width="3" fill="red" />

            <rect x='<% out.println(25 / 10); %>' y=' <% out.println((((materials.get(2).getHeight()) / 3) + materials.get(1).getHeight()) / 10); %> ' width='<% out.println(((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) - 50) / 10); %>' height='<% out.println((materials.get(5).getHeight()) / 10);%>'  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> )' stroke="black" fill="green"/>
            <%
                double sum = 0;
                for (int i = 0; i < (int) (order.getShedLength() / 60); i++) {
            %>
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - 300) + sum) / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(7).getHeight() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum += 60;
                }
            %>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
                if (order.getShedLength() != 0 || order.getShedWidth() != 0) {
            %>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (materials.get(6).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
            } else {
            %>
            <rect x=" <% out.println((order.getLength() - (1000.0 / 7800.0 * order.getLength()) - materials.get(6).getWidth()) / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((order.getLength() / 2) - (materials.get(6).getWidth() / 2)) / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
                }
            %>
            <rect x='0' y=' <% out.println(((materials.get(2).getHeight()) / 3) / 10); %> ' width='<% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) / 10); %>' height='<% out.println((materials.get(1).getHeight()) / 10);%>'  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> )'/>
            <rect x='0' y='0' width='<% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) / 10); %>' height='<% out.println((materials.get(2).getHeight()) / 10);%>'  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> )' stroke="black" fill="red"/>
            </svg>
        </div>

        <br>

        <div>
            <svg width="<% out.println(order.getWidth() / 10); %>" height="<% out.println(order.getHeight() / 10); %>">
            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getWidth() / 10); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="<% out.println(2300 / 10); %>" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getWidth() / 10); %>" cy=" <% out.println(2300 / 10);%> " r="4" stroke="black" stroke-width="3" fill="red" />

            <%
                double sum2 = 0;
                for (int j = 0; j < (int) (order.getShedWidth() / 60); j++) {
            %>
            <rect x=" <% out.println(((700 / 2) + sum2) / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(7).getHeight() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum2 += 60;
                }
            %>
            <rect x=" <% out.println((700 / 2) / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
                if (order.getShedLength() != 0 || order.getShedWidth() != 0) {
            %>
            <rect x=" <% out.println(((order.getWidth() / 2) - materials.get(6).getWidth() / 2) / 10); %> " y=" <% out.println((order.getHeight() - (materials.get(6).getLength() - 900)) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10);%> " stroke="black" fill="red"/>
            <%
                }
            %>
            <rect x='0' y=' <% out.println(((materials.get(2).getHeight()) / 3) / 10); %> ' width='<% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getWidth(), 2))) / 10); %>' height='<% out.println((materials.get(1).getHeight()) / 10);%>' />
            <rect x='0' y='0' width='<% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getWidth(), 2))) / 10); %>' height='<% out.println((materials.get(2).getHeight()) / 10);%>' stroke="black" fill="red"/>
            <rect x=" <% out.println((700 / 2) / 10); %> " y=' <% out.println((((materials.get(2).getHeight()) / 3) + materials.get(1).getHeight()) / 10); %> ' width='<% out.println((materials.get(5).getWidth()) / 10); %>' height='<% out.println((materials.get(1).getHeight()) / 10);%>' stroke="black" fill="red"/>
            <rect x=" <% out.println(((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) + ((materials.get(6).getWidth()) - materials.get(5).getWidth())) / 10); %> " y=' <% out.println((((materials.get(2).getHeight()) / 3) + materials.get(1).getHeight()) / 10); %> ' width='<% out.println((materials.get(5).getWidth()) / 10); %>' height='<% out.println((materials.get(5).getHeight()) / 10);%>' stroke="black" fill="red"/>

            </svg>
        </div>

        <br>

        <div>
            <svg width="<% out.println(order.getLength() / 10); %>" height="<% out.println(order.getWidth() / 10); %>">
            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="<% out.println(order.getWidth() / 10); %>" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy=" <% out.println(order.getWidth() / 10);%> " r="4" stroke="black" stroke-width="3" fill="red" />

            <%
                double sum3 = 0;
                for (int k = 0; k < (int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1; k++) {
            %>
            <rect x=" <% out.println((sum3) / 10); %> " y="0" height=" <% out.println(order.getWidth() / 10); %> " width=" <% out.println(materials.get(5).getWidth() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum3 += (((order.getLength() - ((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) * materials.get(5).getWidth()) / (((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) - 1)) + materials.get(5).getWidth());
                }
            %>
            <rect x='0' y='0' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(1).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x='0' y='<% out.println(order.getWidth() / 10); %>' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(1).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (materials.get(6).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (materials.get(6).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x="0" y=' <% out.println((700 / 2) / 10); %> ' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(5).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x="0" y=' <% out.println(((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) + ((materials.get(6).getWidth()) - materials.get(5).getWidth())) / 10); %>  ' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(5).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <%
                if (order.getShedLength() != 0 || order.getShedWidth() != 0) {
            %>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println(((order.getWidth() / 2) - materials.get(6).getWidth() / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println(((order.getWidth() / 2) - materials.get(6).getWidth() / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
                }
            %>
            <%
                double sum4 = 0;
                for (int l = 0; l < (int) (order.getShedWidth() / 60); l++) {
            %>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - materials.get(7).getWidth() - 300) / 10); %> " y=" <% out.println((((700 / 2) - materials.get(7).getWidth()) + sum4) / 10); %> " height=" <% out.println((materials.get(7).getHeight() / 10)); %> " width=" <% out.println(materials.get(7).getWidth() / 10); %> " />
            <rect x=" <% out.println((order.getLength() + materials.get(6).getWidth() - 300) / 10); %> " y=" <% out.println((((700 / 2) - materials.get(7).getWidth()) + sum4) / 10); %> " height=" <% out.println((materials.get(7).getHeight() / 10)); %> " width=" <% out.println(materials.get(7).getWidth() / 10); %> " />
            <%
                    sum4 += 60;
                }
            %>
            <%
                double sum5 = 0;
                for (int h = 0; h < (int) ((order.getShedLength() + materials.get(6).getWidth()) / 60); h++) {
            %>
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - materials.get(7).getWidth() - 300) + sum5) / 10); %> " y=" <% out.println((((700 / 2) - materials.get(7).getWidth())) / 10); %> " height=" <% out.println(materials.get(7).getWidth() / 10); %> " width=" <% out.println((materials.get(7).getHeight() / 10)); %> " />
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - materials.get(7).getWidth() - 300) + sum5) / 10); %> " y=" <% out.println((order.getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(materials.get(7).getWidth() / 10); %> " width=" <% out.println((materials.get(7).getHeight() / 10)); %> " />
            <%
                    sum5 += 60;
                }
            %>
            <rect x=" <% out.println((((700 / 2) / Math.sin(45 * Math.PI / 180)) + 180) / 10); %> " y=" -20" height=" <% out.println((materials.get(10).getHeight() / 10)); %> " width=" <% out.println(((order.getWidth() - 700) / Math.sin(45 * Math.PI / 180)) / 10);%> " transform='rotate( 45 )'  />
            <rect x=" <% out.println((((700 / 2) / Math.sin(45 * Math.PI / 180)) - 4060) / 10); %> " y=" 440" height=" <% out.println((materials.get(10).getHeight() / 10)); %> " width=" <% out.println(((order.getWidth() - 700) / Math.sin(45 * Math.PI / 180)) / 10);%> " transform='rotate( 315 )'  />
            </svg>
        </div>

    </body>
</html>