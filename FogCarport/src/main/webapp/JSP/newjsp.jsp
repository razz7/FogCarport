<%-- 
    Document   : newjsp
    Created on : May 2, 2019, 2:22:51 PM
    Author     : rh
--%>

<jsp:include page='/JSP/siteheader.jsp'></jsp:include>

<jsp:include page='/JSP/sitemenus.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<div class="container">
<div class="card-deck">
  <div class="card">
      <img class="card-img-top" src="img/bjaelke.jpg" alt="Card image cap" height="210" width="10" >
    <div class="card-body">
      <h5 class="card-title">Træ</h5>
       <a href="JSP/newjsp.jsp" class="btn btn-primary stretched-link">Se alt træ på lager</a>
    </div>

  </div>
  <div class="card">
    <img class="card-img-top" src="img/screws.jpg" alt="Card image cap" height="210" width="10">
    <div class="card-body">
      <h5 class="card-title">Skruer</h5>
      <a href="JSP/newjsp.jsp" class="btn btn-primary stretched-link">Se alle skruer på lager</a>
    </div>

  </div>
  <div class="card">
    <img class="card-img-top" src="img/rulle.jpg" alt="Card image cap" height="210" width="10">
    <div class="card-body">
      <h5 class="card-title">Ruller</h5>
      <a href="JSP/newjsp.jsp" class="btn btn-primary stretched-link">Se alle ruller på lager</a>
    </div>
  </div>
</div>
   </div>













        <jsp:include page='/JSP/sitefooter.jsp'></jsp:include>
