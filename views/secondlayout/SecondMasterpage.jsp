<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<tiles:importAttribute name="masterCss" />
<tiles:importAttribute name="pageCss" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/${masterCss}" /> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/${pageCss}" />
<style type="text/css">
	a{text-decoration: none;}
</style>
<title>SSS | Home</title>
<link rel="shortcut icon" href="image/sss.png" type="imag/x-icon"/>
</head>
<body>
<!-- Navbar -->
<div class="w3-container">
			<tiles:insertAttribute name="menu" />			
<!-- Side Navbar -->		
<div class="w3-container" style="margin-top:50px;">			
			<tiles:insertAttribute name="sideright" />
</div>			
	<%-- <div class="w3-main w3-card-4 w3-padding-24 w3-light-grey" style="width:75%;margin-left:23%;margin-top:5px;">

  <div class="w3-row" style="margin-left:3%;margin-top:20px;">		
			<tiles:insertAttribute name="body" />
	</div>			
	</div> --%>
	
	<div class="w3-col m3 w3-round w3-text-white">.</div>
  <div class="w3-col m9 w3-card-4">
  <tiles:insertAttribute name="body" />
  </div>
	
</div>
</body>
</html>