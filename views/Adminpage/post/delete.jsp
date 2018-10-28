<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url action="post" var="post"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/postdata.css">
<title>Delete Post</title>
</head>
<body>
<div class="w3-container">
	<fieldset>
		<legend><h1><span class="w3-text-indigo">Delete Post</span></h1></legend>
	
	<s:form action="post_delete_submit" theme="simple">
		<table>
		<s:hidden name="postdata.PostID"/>
			<tr height=" 50px">
				<td width="150px">Title</td>
				<td width="150px"><s:property value="postdata.Title"/></td>
			</tr>
			<tr height=" 50px">
				<td width="150px">DetailDescription</td>
				<td width="80%"><%=request.getParameter("postdata.DetailDescription") %></td>
			</tr>
			<tr height=" 50px">
				<td width="150px">ImageFileName</td>
				<td width="150px">
					<img height="100px" width="150px" alt=""
							src=<s:property value="postdata.ImageFileName" />>
				</td>
			</tr>
			<tr height=" 50px">
				<td width="150px">UserName</td>
				<td width="150px"><s:property value="postdata.user.UserName"/></td>
			</tr>
			<tr>
				<td></td>
				<td><s:submit class="w3-btn w3-indigo w3-left" value="Delete"/></td>
			</tr>
		</table>
		</s:form>
		</fieldset>
		<br>
				<s:a href="%{post}" style="text-decoration:none;color:indigo"><< Back to Post</s:a>
			
	
</div>
<br>
</body>
</html>