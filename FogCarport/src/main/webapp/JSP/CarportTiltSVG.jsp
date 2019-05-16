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


<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

        <h1>SVG TILT!</h1>

        <%
            //Order order = new Order(1, 3600, 7300, 2300, 30, 3200, 2100);
            Order order = new Order(1, 6060, 7300, 2300, 30, 5330, 2110);
            //Order order = new Order(1, 3600, 7300, 2300, 30, 0, 0);
            CarportAlgorithm car = new CarportAlgorithm();
            Stykliste styklist = car.carportAlgorithm(order.getWidth(), order.getLength(), order.getRoofTilt(), order.getShedWidth(), order.getShedLength(), 1);
            order.setStyklist(styklist);
            HashMap<Integer, Material> materials = new HashMap<>();
            for (Material m : order.getStyklist().getStyklist()) {
                materials.put(m.getItem_id(), m);
            }
        %> 

        <h4><% out.println("getHeight" + order.getHeight()); %> </h4>
        <h4><% out.println("getLength" + order.getLength()); %> </h4>
        <h4><% out.println("getOrder_id" + order.getOrder_id()); %> </h4>
        <h4><% out.println("getWidth" + order.getWidth()); %> </h4>
        <h4><% out.println("getRoofTilt" + order.getRoofTilt()); %> </h4>
        <h4><% out.println("getShedLength" + order.getShedLength()); %> </h4>
        <h4><% out.println("getShedWidth" + order.getShedWidth()); %> </h4>

        <div>
            <svg width="<% out.println(order.getLength() / 10); %>" height="<% out.println((order.getHeight() + (Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %>">

            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="<% out.println((order.getHeight() + (Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %>" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getLength() / 10); %>" cy=" <% out.println((order.getHeight() + (Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " r="4" stroke="black" stroke-width="3" fill="red" />

            <rect x='<% out.println((300 - (materials.get(6).getWidth())) / 10); %>' y=' <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> ' width='<% out.println((order.getLength() - 300 * 2 + +(materials.get(6).getWidth()) * 2) / 10); %>' height='<% out.println((materials.get(5).getHeight()) / 10);%>' stroke="black" fill="green"/>
            <%
                double sum = 0;
                for (int i = 0; i < (int) (order.getShedLength() / 60); i++) {
            %>
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - 300) + sum) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(7).getHeight() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum += 60;
                }
            %>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
                if (order.getShedLength() != 0 || order.getShedWidth() != 0) {
            %>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (materials.get(6).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
            } else {
            %>
            <rect x=" <% out.println((order.getLength() - (1000.0 / 7800.0 * order.getLength()) - materials.get(6).getWidth()) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((order.getLength() / 2) - (materials.get(6).getWidth() / 2)) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <%
                }
            %>
            <rect x='<% out.println((materials.get(23).getWidth()) / 10); %>' y=' <% out.println((((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) - materials.get(23).getHeight()) / 10); %> ' width='<% out.println((order.getLength() - materials.get(23).getWidth() * 2) / 10); %>' height='<% out.println((materials.get(23).getHeight()) / 10);%>' stroke="black" fill="red"/>
            <rect x='0' y='0' width='<% out.println((materials.get(23).getWidth()) / 10); %>' height='<% out.println((((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) - materials.get(23).getHeight()) / 10); %>' stroke="black" fill="red"/>
            <rect x='<% out.println((order.getLength() - materials.get(23).getWidth()) / 10); %>' y='0' width='<% out.println((materials.get(23).getWidth()) / 10); %>' height='<% out.println((((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) - materials.get(23).getHeight()) / 10);%>' stroke="black" fill="red"/>
            <%
                double sum2 = 0;
                for (int j = 0; j < Math.floor((order.getLength() - materials.get(23).getWidth() * 2) / materials.get(7).getHeight()); j++) {
            %>
            <rect x=" <% out.println((materials.get(23).getWidth() + sum2) / 10); %> " y=" <% out.println(materials.get(23).getWidth() / 10); %> " height=" <% out.println((((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) - materials.get(23).getHeight() - materials.get(23).getWidth()) / 10);%> " width=" <% out.println(materials.get(7).getHeight() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum2 += materials.get(7).getHeight();
                }
            %>
            <rect x=" <% out.println((materials.get(23).getWidth() + sum2) / 10); %> " y=" <% out.println(materials.get(23).getWidth() / 10); %> " height=" <% out.println((((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) - materials.get(23).getHeight() - materials.get(23).getWidth()) / 10);%> " width=" <% out.println((order.getLength() - materials.get(23).getWidth() - (materials.get(23).getWidth() + sum2)) / 10);%> " stroke="black" fill="blue"/>
            <rect x=" <% out.println((materials.get(23).getWidth()) / 10); %> " y=" <% out.println(materials.get(23).getWidth() / 10); %> " height=" <% out.println(materials.get(26).getHeight() / 10);%> " width=" <% out.println((order.getLength() - materials.get(23).getWidth() * 2) / 10);%> " stroke="black" fill="red"/>
            </svg>
        </div>

        <br>

        <div>
            <svg width="<% out.println(order.getWidth() / 10); %>" height="<% out.println((order.getHeight() + (Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %>">

            <circle cx="0" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getWidth() / 10); %>" cy="0" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="0" cy="<% out.println((order.getHeight() + (Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %>" r="4" stroke="black" stroke-width="3" fill="red" />
            <circle cx="<% out.println(order.getWidth() / 10); %>" cy=" <% out.println((order.getHeight() + (Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " r="4" stroke="black" stroke-width="3" fill="red" />

            <%
                double widthPrPlank = (order.getWidth()) / 60;
                double currentWidth = materials.get(23).getHeight() * 2;
                double sum4 = 0;
                for (int j = 0; j < (int) ((order.getWidth() / 2) / 60) - 1; j++) {
            %>
            <rect x="0" y="0" height=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * currentWidth) / 10)); %> " width=" <% out.println(materials.get(7).getHeight() / 10); %> " transform="translate( <% out.println(((materials.get(23).getWidth()) + sum4) / 10); %> , <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %>) scale(1,-1)" stroke="black" fill="blue"/>
            <%
                    currentWidth += widthPrPlank;
                    sum4 += 60;
                }

                for (int k = (int) ((order.getWidth() / 2) / 60) - 1; k > 0; k--) {
            %>
            <rect x="0" y="0" height=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * currentWidth) / 10)); %> " width=" <% out.println(materials.get(7).getHeight() / 10); %> " transform="translate( <% out.println(((materials.get(23).getWidth()) + sum4) / 10); %> , <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %>) scale(1,-1)" stroke="black" fill="blue"/>
            <%
                    currentWidth -= widthPrPlank;
                    sum4 += 60;
                }
            %>
            <rect x="0" y="0" height=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * materials.get(23).getHeight() * 2) / 10)); %> " width=" <% out.println(materials.get(7).getHeight() / 10); %> " transform="translate( <% out.println(((materials.get(23).getWidth()) + sum4) / 10); %> , <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %>) scale(1,-1)" stroke="black" fill="blue"/>
            <%
                if (order.getShedLength() != 0 || order.getShedWidth() != 0) {

                    double sum3 = 0;
                    for (int k = 0; k < (int) (order.getShedWidth() / 60); k++) {
            %>
            <rect x=" <% out.println((((order.getWidth() - order.getShedWidth()) / 2) + sum3) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(7).getHeight() / 10); %> " stroke="black" fill="blue"/>
            <%
                    sum3 += 60;
                }
            %>
            <rect x=" <% out.println(((order.getWidth() - order.getShedWidth()) / 2) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getWidth() - materials.get(6).getWidth() - ((order.getWidth() - order.getShedWidth()) / 2)) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x='0' y=' 0 ' width='<% out.println(((order.getWidth() / 2 / Math.sin((180 - 90 - order.getRoofTilt()) * Math.PI / 180)) - 30) / 10); %>' height='<% out.println((materials.get(23).getHeight()) / 10);%>' transform='translate(<% out.println((materials.get(23).getWidth()) / 10); %>, <% out.println((((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) - materials.get(23).getHeight() - (materials.get(23).getHeight())) / 10);%>) rotate( <% out.println(-order.getRoofTilt());%> ) skewX(-30)' stroke="black" fill="red"/>
            <rect x='0' y=' 0 ' width='<% out.println(((order.getWidth() / 2 / Math.sin((180 - 90 - order.getRoofTilt()) * Math.PI / 180)) - 30) / 10); %>' height='<% out.println((materials.get(23).getHeight()) / 10);%>' transform='translate(<% out.println((order.getWidth() - materials.get(23).getWidth()) / 10); %>, <% out.println((((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) + materials.get(23).getWidth() - (materials.get(23).getHeight())) / 10);%>) rotate( <% out.println(180 + order.getRoofTilt());%> ) skewX(30)' stroke="black" fill="red"/>
            <rect x='0' y='<% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)) - (materials.get(23).getHeight())) / 10); %>' width='<% out.println((materials.get(23).getWidth()) / 10); %>' height='<% out.println((materials.get(23).getHeight()) / 10); %>' stroke="black" fill="red"/>
            <rect x='<% out.println((order.getWidth() - materials.get(23).getWidth()) / 10); %>' y='<% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)) - (materials.get(23).getHeight())) / 10); %>' width='<% out.println((materials.get(23).getWidth()) / 10); %>' height='<% out.println((materials.get(23).getHeight()) / 10); %>' stroke="black" fill="red"/>
            <rect x=" <% out.println(((order.getWidth() - order.getShedWidth()) / 2) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(5).getHeight()) / 10)); %> " width=" <% out.println(materials.get(5).getWidth() / 10); %> " stroke="black" fill="green"/>
            <rect x=" <% out.println((order.getWidth() - materials.get(5).getWidth() - ((order.getWidth() - order.getShedWidth()) / 2)) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(5).getHeight()) / 10)); %> " width=" <% out.println(materials.get(5).getWidth() / 10); %> " stroke="black" fill="green"/>
            <%
            } else {
            %>
            <rect x=" <% out.println(((700) / 2) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getWidth() - materials.get(6).getWidth() - ((700) / 2)) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(6).getLength() - 900) / 10)); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x='0' y=' 0 ' width='<% out.println(((order.getWidth() / 2 / Math.sin((180 - 90 - order.getRoofTilt()) * Math.PI / 180)) - 30) / 10); %>' height='<% out.println((materials.get(23).getHeight()) / 10);%>' transform='translate(<% out.println((materials.get(23).getWidth()) / 10); %>, <% out.println((((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) - materials.get(23).getHeight() - (materials.get(23).getHeight())) / 10);%>) rotate( <% out.println(-order.getRoofTilt());%> ) skewX(-30)' stroke="black" fill="red"/>
            <rect x='0' y=' 0 ' width='<% out.println(((order.getWidth() / 2 / Math.sin((180 - 90 - order.getRoofTilt()) * Math.PI / 180)) - 30) / 10); %>' height='<% out.println((materials.get(23).getHeight()) / 10);%>' transform='translate(<% out.println((order.getWidth() - materials.get(23).getWidth()) / 10); %>, <% out.println((((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) + materials.get(23).getWidth() - (materials.get(23).getHeight())) / 10);%>) rotate( <% out.println(180 + order.getRoofTilt());%> ) skewX(30)' stroke="black" fill="red"/>
            <rect x='0' y='<% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)) - (materials.get(23).getHeight())) / 10); %>' width='<% out.println((materials.get(23).getWidth()) / 10); %>' height='<% out.println((materials.get(23).getHeight()) / 10); %>' stroke="black" fill="red"/>
            <rect x='<% out.println((order.getWidth() - materials.get(23).getWidth()) / 10); %>' y='<% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2)) - (materials.get(23).getHeight())) / 10); %>' width='<% out.println((materials.get(23).getWidth()) / 10); %>' height='<% out.println((materials.get(23).getHeight()) / 10); %>' stroke="black" fill="red"/>
            <rect x=" <% out.println(((700) / 2) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(5).getHeight()) / 10)); %> " width=" <% out.println(materials.get(5).getWidth() / 10); %> " stroke="black" fill="green"/>
            <rect x=" <% out.println((order.getWidth() - materials.get(5).getWidth() - ((700) / 2)) / 10); %> " y=" <% out.println(((Math.tan(order.getRoofTilt() * Math.PI / 180) * (order.getWidth() / 2))) / 10); %> " height=" <% out.println(((materials.get(5).getHeight()) / 10)); %> " width=" <% out.println(materials.get(5).getWidth() / 10); %> " stroke="black" fill="green"/>
            <%
                }
            %>
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
                double sum7 = 0;
                if (order.getShedLength() != 0 || order.getShedWidth() != 0) {
                    sum7 = ((order.getWidth() - order.getShedWidth()) / 2);
                } else {
                    sum7 = (700 / 2);
                }
                for (int k = 0; k < materials.get(24).getStryklistQty(); k++) {
            %>
            <rect x=" <% out.println((sum7) / 10); %> " y="0" height=" <% out.println(order.getWidth() / 10); %> " width=" <% out.println(materials.get(5).getWidth() / 10); %> " stroke="black" fill="blue"/>
            <%
                    if (order.getShedLength() != 0 || order.getShedWidth() != 0) {
                        sum7 += (((order.getLength() - (order.getWidth() - order.getShedWidth()) - ((int) Math.ceil((order.getLength() - 45) / (45 + 1100)) + 1) * materials.get(5).getWidth()) / (((int) Math.ceil((order.getLength() - 45) / (45 + 1100)) + 1) - 1)) + materials.get(5).getWidth());
                    } else {
                        sum7 += (((order.getLength() - (700) - ((int) Math.ceil((order.getLength() - 45) / (45 + 1100)) + 1) * materials.get(5).getWidth()) / (((int) Math.ceil((order.getLength() - 45) / (45 + 1100)) + 1) - 1)) + materials.get(5).getWidth());
                    }
                }
            %>
            <%
                if (order.getShedLength() != 0 || order.getShedWidth() != 0) {
            %>
            <rect x='0' y='0' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(23).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x='0' y='<% out.println(order.getWidth() / 10); %>' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(23).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println(((order.getWidth() - order.getShedWidth()) / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println(((order.getWidth() - order.getShedWidth()) / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println(((order.getWidth() - order.getShedWidth()) / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (materials.get(6).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println(((order.getWidth() - order.getShedWidth()) / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - ((order.getWidth() - order.getShedWidth()) / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - 300) / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - ((order.getWidth() - order.getShedWidth()) / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - 300) / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - ((order.getWidth() - order.getShedWidth()) / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((1000.0 / 7800.0 * order.getLength()) + (materials.get(6).getWidth()) + (3100.0 / 7800 * order.getLength())) / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - ((order.getWidth() - order.getShedWidth()) / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x="0" y=' <% out.println(((order.getWidth() - order.getShedWidth()) / 2) / 10); %> ' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(5).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x="0" y=' <% out.println(((order.getWidth() - materials.get(6).getWidth() - ((order.getWidth() - order.getShedWidth()) / 2)) + ((materials.get(6).getWidth()) - materials.get(5).getWidth())) / 10); %>  ' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(5).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x='0' y='0' width='<% out.println((materials.get(23).getWidth()) / 10);%>' height='<% out.println(order.getWidth() / 10); %>' stroke="black" fill="red"/>
            <rect x='<% out.println((order.getLength() - materials.get(23).getWidth()) / 10); %>' y='0' width='<% out.println((materials.get(23).getWidth()) / 10);%>' height='<% out.println(order.getWidth() / 10); %>' stroke="black" fill="red"/>
            <%
            } else {
            %>
            <rect x='0' y='0' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(23).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x='0' y='<% out.println(order.getWidth() / 10); %>' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(23).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - (1000.0 / 7800.0 * order.getLength()) - materials.get(6).getWidth()) / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((order.getLength() / 2) - (materials.get(6).getWidth() / 2)) / 10); %> " y=" <% out.println((700 / 2) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(1000.0 / 7800.0 * order.getLength() / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println((order.getLength() - (1000.0 / 7800.0 * order.getLength()) - materials.get(6).getWidth()) / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x=" <% out.println(((order.getLength() / 2) - (materials.get(6).getWidth() / 2)) / 10); %> " y=" <% out.println((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) / 10); %> " height=" <% out.println(materials.get(6).getHeight() / 10); %> " width=" <% out.println(materials.get(6).getWidth() / 10); %> " stroke="black" fill="red"/>
            <rect x="0" y=' <% out.println((700 / 2) / 10); %> ' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(5).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x="0" y=' <% out.println(((order.getWidth() - materials.get(6).getWidth() - (700 / 2)) + ((materials.get(6).getWidth()) - materials.get(5).getWidth())) / 10); %>  ' width='<% out.println(order.getLength() / 10); %>' height='<% out.println((materials.get(5).getWidth()) / 10);%>' stroke="black" fill="red"/>
            <rect x='0' y='0' width='<% out.println((materials.get(23).getWidth()) / 10);%>' height='<% out.println(order.getWidth() / 10); %>' stroke="black" fill="red"/>
            <rect x='<% out.println((order.getLength() - materials.get(23).getWidth()) / 10); %>' y='0' width='<% out.println((materials.get(23).getWidth()) / 10);%>' height='<% out.println(order.getWidth() / 10); %>' stroke="black" fill="red"/>
            <%
                }
            %>
            <%
                double sum5 = 0;
                for (int l = 0; l < (int) (order.getShedWidth() / 60); l++) {
            %>
            <rect x=" <% out.println((order.getLength() - order.getShedLength() - materials.get(7).getWidth() - 300) / 10); %> " y=" <% out.println(((((order.getWidth() - order.getShedWidth()) / 2) - materials.get(7).getWidth()) + sum5) / 10); %> " height=" <% out.println((materials.get(7).getHeight() / 10)); %> " width=" <% out.println(materials.get(7).getWidth() / 10); %> " />
            <rect x=" <% out.println((order.getLength() + materials.get(6).getWidth() - 300) / 10); %> " y=" <% out.println(((((order.getWidth() - order.getShedWidth()) / 2) - materials.get(7).getWidth()) + sum5) / 10); %> " height=" <% out.println((materials.get(7).getHeight() / 10)); %> " width=" <% out.println(materials.get(7).getWidth() / 10); %> " />
            <%
                    sum5 += 60;
                }
            %>
            <%
                if (order.getShedLength() != 0 || order.getShedWidth() != 0) {
            %>
            <%
                double sum6 = 0;
                for (int h = 0; h < (int) ((order.getShedLength() + materials.get(6).getWidth()) / 60); h++) {
            %>
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - materials.get(7).getWidth() - 300) + sum6) / 10); %> " y=" <% out.println(((((order.getWidth() - order.getShedWidth()) / 2) - materials.get(7).getWidth())) / 10); %> " height=" <% out.println(materials.get(7).getWidth() / 10); %> " width=" <% out.println((materials.get(7).getHeight() / 10)); %> " />
            <rect x=" <% out.println(((order.getLength() - order.getShedLength() - materials.get(7).getWidth() - 300) + sum6) / 10); %> " y=" <% out.println((order.getWidth() - ((order.getWidth() - order.getShedWidth()) / 2)) / 10); %> " height=" <% out.println(materials.get(7).getWidth() / 10); %> " width=" <% out.println((materials.get(7).getHeight() / 10)); %> " />
            <%
                    sum6 += 60;
                }
            %>
            <rect x="0" y="0" height=" <% out.println((materials.get(10).getHeight() / 10)); %> " width=" <% out.println(((order.getWidth() - ((order.getWidth() - order.getShedWidth()))) / Math.sin(45 * Math.PI / 180)) / 10);%> " transform="translate(<% out.println((((order.getLength() - ((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) * materials.get(5).getWidth()) / (((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) - 1)) + materials.get(5).getWidth()) / 10); %>,<% out.println((((order.getWidth() - order.getShedWidth()) / 2)) / 10); %>) rotate( 45 )" stroke="black" fill="red"/>
            <rect x="0" y="0" height=" <% out.println((materials.get(10).getHeight() / 10)); %> " width=" <% out.println(((order.getWidth() - ((order.getWidth() - order.getShedWidth()))) / Math.sin(45 * Math.PI / 180)) / 10);%> " transform="translate(<% out.println((((order.getLength() - ((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) * materials.get(5).getWidth()) / (((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) - 1)) + materials.get(5).getWidth()) / 10); %>,<% out.println((order.getWidth() - ((order.getWidth() - order.getShedWidth()) / 2)) / 10); %>) rotate( 315 )" stroke="black" fill="red"/>
            <%
            } else {
            %>
            <rect x="0" y="0" height=" <% out.println((materials.get(10).getHeight() / 10)); %> " width=" <% out.println(((order.getWidth() - ((700))) / Math.sin(45 * Math.PI / 180)) / 10);%> " transform="translate(<% out.println((((order.getLength() - ((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) * materials.get(5).getWidth()) / (((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) - 1)) + materials.get(5).getWidth()) / 10); %>,<% out.println(((700 / 2)) / 10); %>) rotate( 45 )" stroke="black" fill="red"/>
            <rect x="0" y="0" height=" <% out.println((materials.get(10).getHeight() / 10)); %> " width=" <% out.println(((order.getWidth() - ((700))) / Math.sin(45 * Math.PI / 180)) / 10);%> " transform="translate(<% out.println((((order.getLength() - ((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) * materials.get(5).getWidth()) / (((int) Math.ceil((order.getLength() - 45) / (45 + 600)) + 1) - 1)) + materials.get(5).getWidth()) / 10); %>,<% out.println((order.getWidth() - (700 / 2)) / 10); %>) rotate( 315 )" stroke="black" fill="red"/>
            <%
                }
            %>

            <%
                double sum8 = 0;
                for (int m = 0; m < (((int) Math.ceil(((float) Math.ceil(((((order.getWidth() / 2) / Math.sin((180 - 90 - order.getRoofTilt()) * Math.PI / 180)) - (350 + 30)) / (38 + 307))) + 1))) * 2) + 1; m++) {
            %>
            <rect x="" y=" <% out.println(((sum8) / 10)); %> " height=" <% out.println(materials.get(26).getWidth() / 10); %> " width=" <% out.println(order.getLength() / 10); %> " />
            <%
                    sum8 += ((order.getWidth() - materials.get(26).getWidth()) / (((int) Math.ceil(((float) Math.ceil(((((order.getWidth() / 2) / Math.sin((180 - 90 - order.getRoofTilt()) * Math.PI / 180)) - (350 + 30)) / (38 + 307))) + 1))) * 2));
                }
            %>
            <rect x="" y=" <% out.println((((order.getWidth() / 2) - (materials.get(26).getHeight()) / 2) / 10)); %> " height=" <% out.println(materials.get(26).getHeight() / 10); %> " width=" <% out.println(order.getLength() / 10);%> " />
            </svg>
        </div>

    </body>
</html>