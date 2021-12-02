<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accept User</title>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/We_Care/JS/Functionality.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
 <form name="myForm" > 
<%-- <bean:define id="userId" property="user_id" name="User"></bean:define> --%>
<%-- <%long userId=(long)session.getAttribute("id"); 
String userType=(String)session.getAttribute("userType");%>  --%> 
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/We_Care/MainAction.do?subaction=dashboard">We-Care</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      
        
       <li class="nav-item">
          <a class="nav-link" href="/We_Care/MainAction.do?subaction=viewRequest">View Status</a>
        </li>
        <li class="nav-item">
        	  <a class="nav-link" href="/We_Care/MainAction.do?subaction=acceptUser">Accept User</a></li>
        	   <li class="nav-item">
        	  <a class="nav-link" href="/We_Care/JSP/assignUser.jsp">Assign User</a></li>
        <li class="nav-item">
        <!--   <a class="nav-link disabled">Disabled</a> -->
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit" onclick="logout(10)">Log Out</button>
      </form>
    </div>
  </div>
</nav>
<table id="myTable" class="table table-striped" style="margin-top: 110px;">
  <thead>
    <tr>
      <th scope="col">User ID</th>
      <th scope="col">User Name</th>
      <th scope="col">Action </th>
       
    </tr>
  </thead>
  <tbody>
   <tr>
   <td>	9	</td>
   <td>	Yeeshaj Aarshin Srivastava	</td>
   <td>	<a onclick="deleteRow()">
	<img src="/We_Care/Images/approve.png"  alt="Approve"  style="width: 30px;" > </a>
	<a onclick="deleteRow()">
<img src="/We_Care/Images/reject.jpg"  alt="Reject"  style="width: 30px;" >
</a>	
	 </td>
   </tr>
    <tr>
   <td>	10</td>
   <td>	Hatake Kakashi	</td>
   <td>	<a onclick="acceptRequest()">
	<img src="/We_Care/Images/approve.png"  alt="Approve"  style="width: 30px;" > </a>
	<a onclick="acceptRequest()">
<img src="/We_Care/Images/reject.jpg"  alt="Reject"  style="width: 30px;" >
</a>	
	 </td>
   </tr>
  </tbody>
</table>
<footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top" style="position: fixed;left: 0;bottom: 0;width: 100%;">
    <div class="col-md-4 d-flex align-items-center">
      <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
        <svg class="bi" width="30" height="24"><use xlink:href="#bootstrap"></use></svg>
      </a>
      <span class="text-muted">© Bits Pilani All rights reserved</span>
    </div>

    <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
      <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter"></use></svg></a></li>
      <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram"></use></svg></a></li>
      <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"></use></svg></a></li>
    </ul>
  </footer>
  </form>
</body>
</html>