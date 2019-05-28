<%-- 
    Document   : createNewUser
    Created on : May 20, 2019, 6:58:22 PM
    Author     : Rumle
--%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>



<div class="container text-center" style="margin-top: 200px"> 

    <td>Register</td>
    <td>
        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="command" value="createuser">
            Email:<br>
            <input type="email" name="email" value="" aria-describedby="emailHelp" placeholder="Enter email">
            <br>
            Password:<br>
            <input type="password" name="password1" value="" placeholder="Password">
            <br>
            Retype Password:<br>
            <input type="password" name="password2" value="" placeholder="Password">
            <br>
            <input type="submit" value="Submit">
        </form>

</div>