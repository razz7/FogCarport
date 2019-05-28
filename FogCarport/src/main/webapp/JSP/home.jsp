<%-- 
    Document   : home
    Created on : May 15, 2019, 11:07:29 AM
    Author     : rh
--%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br/>

<h2 style="text-align: center"> Velkommen til carport systemtet </h2>
<br/>
<div class="container">
    <div class="card-deck">
        <div class="card">
            <img class="card-img-top" src="img/shop.jpg" alt="Card image cap" height="215" width="10" >
            <div class="card-body">
                <h5 class="card-title">Shop</h5>
                <a href="/FogCarport/FrontController?command=shop" class="btn btn-primary stretched-link">Gå til shop</a>
            </div>

        </div>
        <div class="card">
            <img class="card-img-top" src="img/allorders.jpg" alt="Card image cap" height="215" width="10">
            <div class="card-body">
                <h5 class="card-title">Allorders</h5>
                <a href="/FogCarport/FrontController?command=AllOrders" class="btn btn-primary stretched-link">Se all ordre</a>
            </div>

        </div>
        <div class="card">
            <img class="card-img-top" src="img/mats.jpg" alt="Card image cap" height="215" width="10">
            <div class="card-body">
                <h5 class="card-title">All materials</h5>
                <a href="/FogCarport/FrontController?command=category" class="btn btn-primary stretched-link">Se alle matrialer</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
