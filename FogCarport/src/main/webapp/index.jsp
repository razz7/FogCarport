<%-- 
    Document   : index
    Created on : Apr 11, 2019, 11:31:14 AM
    Author     : Rasmus2
--%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<div class="col-sm-8 offset-sm-4 text-left">
   
<h1>Fog Carport</h1>

<table>
    <tr>
        <td>
            
            <form action="FrontController" method="post">
                <input type="hidden" name="command" value="login">
                <div class="form-group">
                    
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else. :=)</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                
            </form>
        </td>
        <%--
        <td>Register</td>
        <td>
            <form name="register" action="FrontController" method="POST">
                <input type="hidden" name="command" value="register">
                Email:<br>
                <input type="text" name="email" value="">
                <br>
                Password:<br>
                <input type="password" name="password1" value="">
                <br>
                Retype Password:<br>
                <input type="password" name="password2" value="">
                <br>
                <input type="submit" value="Submit">
            </form>
        </td>
        --%>
</table>
        </div>
        
<% String error = (String) request.getAttribute("error");
    if (error != null) {
        out.println("<H2>Error!!</h2>");
        out.println(error);
    }
%>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>