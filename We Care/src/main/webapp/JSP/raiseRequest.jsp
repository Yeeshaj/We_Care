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
 <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<meta charset="ISO-8859-1">
<title>Raise Request</title>
<script type="text/javascript" src="JS/Functionality.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<%long userId=(long)session.getAttribute("id"); %>  
 <form name="myForm" > 
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
        
        <li class="nav-item">
          <a class="nav-link" href="/We_Care/MainAction.do?subaction=orgList">Join Org</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
         <button class="btn btn-outline-success" type="submit" onclick="logout('<%=userId%>')">Log Out</button>
      </form>
    </div>
  </div>
</nav>
<h1>Raise Requests</h1>
<table class="table table-striped" style="margin-top: 50px;border:1px">
<marquee>We expect that your request is genuine</marquee>
  <tr>   
  	<td> Request Description  </td>
  	<td><input type="text" id="request_description"> </td>
  </tr>
    <tr>   
  	<td> Country  </td>
  	<td>
  			<html:select styleId="country"  name="User" property="countryList" onchange="populateState(this.value);" >
                <html:option value="0">Select Country</html:option>
                <html:optionsCollection name="User" property="countryList" label="countryName" value="countryId" />
            </html:select>
  	</td>
  </tr>
    <tr>   
  	<td> State </td>
  	<td>
  	<select id="state" onchange="populateCity(this.value);">
  	<option value="0">Select State</option>
  	</select>
  	 </td>
  </tr>
    <tr>   
  	<td> City   </td>
  		<td>
  	<select id="city" onchange="populateNGO();">
  	<option value="0">Select City</option>
  	</select>
  	</td>
  </tr>
     <tr>   
  	<td> Area   </td>
  	<td><input type="text" id="area"> </td>
  </tr>
   <tr>   
  	<td> NGO/Organizations   </td>
  	<td>
  	<select id="org" >
  	<option value="0">Select Organization</option>
  	</select>
  	 </td>
  </tr>
     <tr>   
  	<td> Upload Images   </td>
  	<td><input type="file" id="upload_images" enctype="multipart/form-data"> </td>
  </tr>
  <tr>   
  	<td colspan='2'> <center><button type="submit" onclick='raiseRequest()'>Submit</input> </center>  </td>
  	
  </tr>
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