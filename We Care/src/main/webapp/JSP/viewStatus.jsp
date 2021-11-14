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
<title>View Status</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<%long userId=(long)session.getAttribute("id"); %>  
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/We_Care/MainAction.do?subaction=dashboard">We-Care</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/We_Care/MainAction.do?subaction=raiseRequest">Raise Request</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="approveRequest.jsp">Approve Request</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/We_Care/MainAction.do?subaction=viewRequest">View Status</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/We_Care/MainAction.do?subaction=orgList">Join Org</a>
        </li>
       <!--  <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li> -->
        <li class="nav-item">
        <!--   <a class="nav-link disabled">Disabled</a> -->
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
       <button class="btn btn-outline-success" type="submit" onclick="logout('<%=userId%>')">Log Out</button>
      </form>
    </div>
  </div>
</nav>
<table class="table table-striped" style="margin-top: 110px;">
  <thead>
    <tr>
      <th scope="col">Request No</th>
      <th scope="col">Description</th>
      <th scope="col">Organization/User </th>
      <th scope="col">status</th>
      <!-- <th scope="col">Upload Images</th> -->
    </tr>
  </thead>
  <logic:iterate id="viewStatusList" name="User" type="Beans.ViewStatus" property="viewStatusList">
  <tr>
  <td><bean:write  name="viewStatusList" property="transaction_id"/>  </td>
  <td><bean:write name="viewStatusList" property="description"/></td>
  <td><bean:write  name="viewStatusList" property="NGO"/></td>
  <td><bean:write  name="viewStatusList" property="status"/></td>
<!--  <td> <input type="file" id="upload_images" multiple="true" accept="image/*"></td> -->
  </tr>
  
  
  </logic:iterate>

  <tbody>
   
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
</body>
</html>