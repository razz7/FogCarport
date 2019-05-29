<%-- 
    Document   : createNewUser
    Created on : May 20, 2019, 6:58:22 PM
    Author     : Rumle
--%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>


<br>
<div class="container text-center " style="width: 20%">

    <div class="alert alert-primary" role="alert">
    
    
        <img class = "mb-4" src="img/logofog.png" alt="" width="110" height="100" />
                <input type="hidden" name="command" value="login">
                
        <form name="register" action="FrontController" method="POST">
            
            <input type="hidden" name="command" value="createuser">
            <label for="email" >Email</label>
            <input type="email" name="email" id="email" value="" aria-describedby="emailHelp" placeholder="Enter email">
            
            <label for="password">Password</label>
            <input type="password" id="password" name="password1" value="" placeholder="Password">
            
            <label for="password2">Retype password</label>
            <input type="password" id="password2" name="password2" value="" placeholder="Password">
            <br/>
            <br/>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

</div>
</div>   