<%-- 
    Document   : createNewUser
    Created on : May 20, 2019, 6:58:22 PM
    Author     : Rumle
--%>
<jsp:include page='/JSP/siteheader.jsp'></jsp:include>


<br>
<div class="container text-center " style="width: 20%">

    <h1>Register</h1>
    <div class="alert alert-primary" role="alert">

        <form name="register" action="FrontController" method="post">
        <img class = "mb-4" src="img/logofog.png" alt="" width="110" height="100" />
        
            <div class="form-group">
                <input type="hidden" name="command" value="createuser">
                <label for="email" >Email</label>
                <input type="email"  class="form-control" name="email" id="email" value="" aria-describedby="emailHelp" name="email" placeholder="Enter email">
            
            
                <label for="password">Password</label>
                <input type="password"  class="form-control" id="password1" name="password1" placeholder="Password" name="password" value="">
            

            <label for="password2">Retype password</label>
            <input type="password" class="form-control" id="password2" name="password2" value="" placeholder="Password">
            <br/>
            <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>

    </div>
</div>   