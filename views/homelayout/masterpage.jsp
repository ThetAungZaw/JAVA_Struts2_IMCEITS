<%@page import="entity.User"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SSS | Home</title>
<link rel="shortcut icon" href="image/sss.png" type="imag/x-icon"/>
</head>

<tiles:importAttribute name="masterCss" />
<tiles:importAttribute name="pageCss" />


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/${masterCss}" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/${pageCss}" />

</head>
<body>
	<div class="w3-container w3-round-large">
		<!-- H------------------Header--------------------------------------------------r -->
		<div class=" w3-card-4">
			<tiles:insertAttribute name="header" />
		</div>
		<!-- M------------------Menu Bar ------------------------------------------------r -->
		
		<%
			User _loginUser = (User)  getServletContext().getAttribute("login_User");
			if(_loginUser == null)
			{
		%>
		
		<tiles:insertAttribute name="menu_login" />
		
		<%
			}
			else
			{
		%>
		<tiles:insertAttribute name="menu_logout" />
		
		<%
			}
		%>
		
		<!-- B-------------------Body Content----------------------------------------------t -->
		<div class=" w3-container w3-card-2">
			<div class="w3-row">
				<!-- Main Content -->
				<div class="w3-col" style="width: 100%">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
		</div>
		<!-- F--------------FOOTER----------------------------------------------R -->
		<div class="w3-container w3-card-4 w3-teal ">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>