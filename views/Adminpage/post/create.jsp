<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url action="post" var="post"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/error-message.css">
<title>Create New Post</title>
</head>
<body>
<div class="w3-container">
	<fieldset>
		<legend><h1><span class="w3-text-indigo">Add New Post</span></h1></legend>		
	
	<s:form action="post_create_submit" theme="simple" method="post" enctype="multipart/form-data">
		<table>
			<tr height=" 50px">
				<td width="250px">Title</td>
				<td><s:textfield name="postdata.Title" size="62"/></td>
				<td><s:fielderror fieldName="postdata.Title" /></td>
			</tr>
			<tr height=" 50px">
				<td width="250px">Detail Description</td>
				<td><s:textarea name = "postdata.DetailDescription" id="area3" rows="5px" cols="60px"/></td>
				<td><s:fielderror fieldName="postdata.DetailDescription" /></td>
			</tr>
			<tr height=" 50px">
				<td width="250px">Image File Name</td>
				<td><s:file name="uploadfile.image" accept="image/*" /></td>
			<tr height=" 50px">
				<td width="250px"></td>
				<td><s:submit class="w3-btn w3-indigo w3-left" value="Save"/></td>
			</tr>
		</table>
	</s:form>
	</fieldset>
	<br>
	<s:a href="%{post}" style="text-decoration:none;color:indigo"><< Back to Post</s:a>
	
</div>
<br>

<!-- Text Editor -->
	<script src="js/nicEdit.js" type="text/javascript"></script>
	<script type="text/javascript">bkLib.onDomLoaded(function(){new nicEditor().panelInstance('area3');});</script>
	
</body>
</html>