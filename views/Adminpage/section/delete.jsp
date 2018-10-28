<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="section" var="section"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comment.css">
<title>Session Delete</title>
</head>
<body>
<div class="w3-container" style="overflow-x:auto;">
	<h3>Are you sure want to delete?</h3><fieldset>
	<legend><h1><span style = "color:indigo">Delete Section</span></h1></legend>
	<s:form theme="simple" action="section_delete_submit">
	
	<table>
		<tr style="height: 50px;">
			<s:hidden name="section.SectionID"></s:hidden>
			<td width="250px" >Section Name:</td>
			<td><s:property value="section.SectionName"/></td>
		</tr>
		<tr style="height: 50px;">
			<td width="250px" ></td>
			<td><s:submit class="w3-btn w3-indigo w3-left" value="Delete"/></td>
		</tr>
	</table>
	<br>
 </s:form>
</fieldset>
<br>
<s:a href="{section}" style="text-decoration:none;color:indigo"><< Back to Section</s:a>
</div>
<br>
</body>
</html>