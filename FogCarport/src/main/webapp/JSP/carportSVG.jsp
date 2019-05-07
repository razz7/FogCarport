<%-- 
    Document   : newjsp
    Created on : Apr 29, 2019, 10:53:18 AM
    Author     : Rasmus2
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%
            int height = 1000;
            int length = 1500;
            int beamwidth = 100;
            int width = 100;
            int mindistance = 10;

            double numberofbeams = Math.floor((length - width) / (width + mindistance)) + 1;
            double space = ((length - numberofbeams * width) / (numberofbeams - 1));

            out.println(numberofbeams);
            out.println(space);

        %>
        <svg x="400mm" y="500mm">

        <% out.print("<rect height=\"" + beamwidth + "mm\" width=\"" + length + "mm\""); %>
        style="stroke:#006600; fill: #0000ff"/>

        <% out.print("<rect y=\"" + (height - beamwidth) + "mm\" height=\"" + beamwidth + "mm\" width=\"" + length + "mm\""); %>
        style="stroke:#006600; fill: #0000ff"/>

        <%
            double sum = 0;
            for (int i = 0; i < numberofbeams; i++) {


        %>

        <% out.print("<rect x=\"" + sum + "mm\" height=\"" + height + "mm\" width=\"" + width + "mm\""); %>
        style="stroke:#006600; fill: #ff0000"/>

        <%
                sum = sum + space + width;
            }
        %>

        </svg>

    </body>
</html>
