<%-- 
    Document   : index
    Created on : Apr 11, 2019, 11:31:14 AM
    Author     : Rasmus2
--%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<div class="container text-center " style="width: 20%">
   
<h1>Fog Carport</h1>


<div class="alert alert-primary" role="alert">

            
    <form class="form-signin" action="FrontController" method="post">
        <img class = "mb-4" src="img/logofog.png" alt="" width="110" height="100" />
                <input type="hidden" name="command" value="login">
                <div class="form-group">
                    
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
                    
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
                </div>
                <div class="form-group form-check">

                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                
            </form>
        
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

        </div>
</div>
        
<% String error = (String) request.getAttribute("error");
    if (error != null) {
        out.println("<H2>Error!!</h2>");
        out.println(error);
    }
%>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>