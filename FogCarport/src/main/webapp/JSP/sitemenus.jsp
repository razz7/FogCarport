<%@page import="FunctionLayer.User"%>

<div id="sitemenus">

    <nav class="navbar navbar-expand-lg navbar-light " style="background-color: #e3f2fd;">

        <img src="img/logofog.png" width="53" height="50" alt="">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item <% if (request.getParameter("command").equals("home")) {
                        out.println("active");
                    } %>">
                    <a class="nav-link" href="/FogCarport/FrontController?command=home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item <% if (request.getParameter("command").equals("category")) {
                        out.println("active");
                    } %>">
                    <a class="nav-link" href="/FogCarport/FrontController?command=category">Materials</a>
                </li>
                <li class="nav-item <% if (request.getParameter("command").equals("shop")) {
                        out.println("active");
                    } %>" >
                    <a class="nav-link" href="/FogCarport/FrontController?command=shop">Shop</a>
                </li>                
                <li class="nav-item <% if (request.getParameter("command").equals("AllOrders")) {
                        out.println("active");
                    } %>">
                    <a class="nav-link" href="/FogCarport/FrontController?command=AllOrders">Allorders</a>
                </li>
                <li class="nav-item" <% if (request.getParameter("command").equals("logout")) {
                        out.println("active");
                    } %>>
                    <a class="nav-link" href="/FogCarport/FrontController?command=logout">Logout</a>
                </li>
            </ul>
            <form >
                <%
                    if (session.getAttribute("user") != null) {
                        User userLoggedIn = (User) session.getAttribute("user");
                %>
                <a class="nav-link" > <% out.println("Email: " + userLoggedIn.getEmail() + ", Role: " + userLoggedIn.getRole());%> </a>
                <%
                    }
                %>
            </form>
        </div>
    </nav>

</div>
