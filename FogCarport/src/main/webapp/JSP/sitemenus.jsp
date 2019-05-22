<jsp:include page='/JSP/siteheader.jsp'></jsp:include>


<div id="sitemenus">

    <nav class="navbar navbar-expand-lg navbar-light " style="background-color: #e3f2fd;">
        <img src="img/logofog.png" width="53" height="50" alt="">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/FogCarport/FrontController?command=home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/FogCarport/FrontController?command=category">Materials</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/FogCarport/FrontController?command=shop">Shop</a>
                </li>
                <li>
                    <a class="nav-link" href="JSP/graphicInput.jsp">Grafik</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="/FogCarport/FrontController?command=AllOrders">Allorders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/FogCarport/FrontController?command=logout">Logout</a>
                </li>
                
                </li>
            </ul>
        </div>
    </nav>

</div>