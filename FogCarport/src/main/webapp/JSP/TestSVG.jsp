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
            <svg width="<% out.println(order.getLength() / 10); %>" height="<% out.println(order.getHeight() / 10); %>">

            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="<% out.println(2300 / 10); %>" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy=" <% out.println(2300 / 10); %> " r="4" stroke="black" stroke-width="3" fill="red" />

            <rect x='<% out.println(25 / 10); %>' y=' <% out.println((((order.getStyklist().getStyklist().get(13).getHeight()) / 3) + order.getStyklist().getStyklist().get(11).getHeight()) / 10); %> ' width='<% out.println(((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) - 50) / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(1).getHeight()) / 10);%>'  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> )' stroke="black" fill="red"/>
            <%
                double sum = 0;
                for (int i = 0; i < (int) (order.getShedLength() / 60); i++) {
            %>
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - 300) + sum) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum += 60;
                }
            %>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (order.getStyklist().getStyklist().get(0).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x='0' y=' <% out.println(((order.getStyklist().getStyklist().get(13).getHeight()) / 3) / 10); %> ' width='<% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(11).getHeight()) / 10);%>'  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> )'/>
            <rect x='0' y='0' width='<% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getLength(), 2))) / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(13).getHeight()) / 10);%>'  transform='rotate( <% out.println(90 - Math.toDegrees(Math.atan((7800 / (2300 - 2200)))));%> )' stroke="black" fill="red"/>
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
            <rect x=" <% out.println(((700 / 2) + sum2) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum2 += 60;
                }
            %>
            <rect x=" <% out.println((700 / 2) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getWidth() - order.getStyklist().getStyklist().get(0).getWidth() - (700 / 2)) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((order.getWidth() / 2) - order.getStyklist().getStyklist().get(0).getWidth() / 2) / 10); %> " y=" <% out.println((order.getHeight() - (order.getStyklist().getStyklist().get(0).getLength() - 900)) / 10); %> " height=" <% out.println(((order.getStyklist().getStyklist().get(0).getLength() - 900) / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10);%> " stroke="black" fill="red"/>
            <rect x='0' y=' <% out.println(((order.getStyklist().getStyklist().get(13).getHeight()) / 3) / 10); %> ' width='<% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getWidth(), 2))) / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(11).getHeight()) / 10);%>' />
            <rect x='0' y='0' width='<% out.println((Math.sqrt(Math.pow(2300 - 2200, 2) + Math.pow(order.getWidth(), 2))) / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(13).getHeight()) / 10);%>' stroke="black" fill="red"/>
            <rect x=" <% out.println((700 / 2) / 10); %> " y=' <% out.println((((order.getStyklist().getStyklist().get(13).getHeight()) / 3) + order.getStyklist().getStyklist().get(11).getHeight()) / 10); %> ' width='<% out.println((order.getStyklist().getStyklist().get(1).getWidth()) / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(1).getHeight()) / 10);%>' stroke="black" fill="red"/>
            <rect x=" <% out.println(((order.getWidth() - order.getStyklist().getStyklist().get(0).getWidth() - (700 / 2)) + ((order.getStyklist().getStyklist().get(0).getWidth()) - order.getStyklist().getStyklist().get(1).getWidth())) / 10); %> " y=' <% out.println((((order.getStyklist().getStyklist().get(13).getHeight()) / 3) + order.getStyklist().getStyklist().get(11).getHeight()) / 10); %> ' width='<% out.println((order.getStyklist().getStyklist().get(1).getWidth()) / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(1).getHeight()) / 10);%>' stroke="black" fill="red"/>

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
            <rect x=" <% out.println((sum3) / 10); %> " y="0" height=" <% out.println(order.getWidth() / 10); %> " width=" <% out.println(order.getStyklist().getStyklist().get(4).getWidth() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum3 += (((order.getLength() - ((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) * order.getStyklist().getStyklist().get(5).getWidth()) / (((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) - 1)) + order.getStyklist().getStyklist().get(4).getWidth());
                }
            %>
            <rect x='0' y='0' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(11).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x='0' y='<% out.println(order.getWidth() / 10); %>' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(11).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(order.getStyklist().getStyklist().get(0).getHeight() / 10); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(order.getStyklist().getStyklist().get(0).getHeight() / 10); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(order.getStyklist().getStyklist().get(0).getHeight() / 10); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (order.getStyklist().getStyklist().get(0).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(order.getStyklist().getStyklist().get(0).getHeight() / 10); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println((order.getWidth() - order.getStyklist().getStyklist().get(0).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(order.getStyklist().getStyklist().get(0).getHeight() / 10); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println((order.getWidth() - order.getStyklist().getStyklist().get(0).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(order.getStyklist().getStyklist().get(0).getHeight() / 10); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println((order.getWidth() - order.getStyklist().getStyklist().get(0).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(order.getStyklist().getStyklist().get(0).getHeight() / 10); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (order.getStyklist().getStyklist().get(0).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println((order.getWidth() - order.getStyklist().getStyklist().get(0).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(order.getStyklist().getStyklist().get(0).getHeight() / 10); %> " width=" <% out.println(order.getStyklist().getStyklist().get(0).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x="0" y=' <% out.println((700 / 2) / 10); %> ' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(1).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x="0" y=' <% out.println(((order.getWidth() - order.getStyklist().getStyklist().get(0).getWidth() - (700 / 2)) + ((order.getStyklist().getStyklist().get(0).getWidth()) - order.getStyklist().getStyklist().get(1).getWidth())) / 10); %>  ' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((order.getStyklist().getStyklist().get(1).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <%
                double sum4 = 0;
                for (int l = 0; l < (int) (order.getShedWidth() / 60); l++) {
            %>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - order.getStyklist().getStyklist().get(20).getWidth() - 300) / 10); %> " y=" <% out.println((((700 / 2) - order.getStyklist().getStyklist().get(20).getWidth()) + sum4) / 10); %> " height=" <% out.println((order.getStyklist().getStyklist().get(20).getHeight() / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(20).getWidth() / 10); %> " />
            <rect x=" <% out.println((order.getLength() + order.getStyklist().getStyklist().get(0).getWidth() - 300) / 10); %> " y=" <% out.println((((700 / 2) - order.getStyklist().getStyklist().get(20).getWidth()) + sum4) / 10); %> " height=" <% out.println((order.getStyklist().getStyklist().get(20).getHeight() / 10)); %> " width=" <% out.println(order.getStyklist().getStyklist().get(20).getWidth() / 10); %> " />
            <%
                    sum4 += 60;
                }
            %>
            <%
                double sum5 = 0;
                for (int h = 0; h < (int) ((order.getShedLength() + order.getStyklist().getStyklist().get(0).getWidth()) / 60); h++) {
            %>
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - order.getStyklist().getStyklist().get(20).getWidth() - 300) + sum5) / 10); %> " y=" <% out.println((((700 / 2) - order.getStyklist().getStyklist().get(20).getWidth())) / 10); %> " height=" <% out.println(order.getStyklist().getStyklist().get(20).getWidth() / 10); %> " width=" <% out.println((order.getStyklist().getStyklist().get(20).getHeight() / 10)); %> " />
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - order.getStyklist().getStyklist().get(20).getWidth() - 300) + sum5) / 10); %> " y=" <% out.println((order.getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(order.getStyklist().getStyklist().get(20).getWidth() / 10); %> " width=" <% out.println((order.getStyklist().getStyklist().get(20).getHeight() / 10)); %> " />
            <%
                    sum5 += 60;
                }
            %>

            </svg>
        </div>

    </body>
</html>