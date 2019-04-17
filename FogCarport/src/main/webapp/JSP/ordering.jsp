<%-- 
    Document   : ordering
    Created on : 16-04-2019, 23:11:39
    Author     : Ludvig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Velkommen til Fogs online bestillingsservice!</h1>

        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="order">
            <h5>Height</h5>
            <input type="text" name="height" value="">
            <h5>Width</h5>
            <input type="text" name="width" value="">
            <h5>Length</h5>
            <input type="text" name="length" value="">
            
            <fieldset id="roof">
                <input type="radio" value="high" name="roof">
                <input type="radio" value="low" name="roof">
            </fieldset>
            
            <input type="submit" value="Make order">
        </form>
        
    </body>
</html>
