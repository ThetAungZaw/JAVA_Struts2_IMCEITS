<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="comment" var="comment" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comment.css">
<link rel="stylesheet" href="css/error-message.css">
<title>New Comment</title>
</head>
<body>

	<div class="w3-container">


		<fieldset>
			<legend>
				<h1>
					<span class="w3-h3" style="color: indigo">Create Comment</span>
				</h1>
			</legend>
			<s:form action="comment_create_submit" theme="simple">
				<s:hidden name="postid"></s:hidden>
				<table>
					<tr style="height: 50px;">
						<td width="250px;">Comment</td>
						<td><s:textarea  name="postingcomment.Comment"  rows="5px" cols="60px"/></td>
						<td><s:fielderror fieldName="postingcomment.Comment" /></td>
					</tr>
					<tr>
						<td width="250px;"></td>
						<td><s:submit class="w3-btn w3-indigo w3-left" value="Create" /></td>
					</tr>
				</table>
				<br>
			</s:form>
		</fieldset>
		<br>
		<s:url action="comment" var="comment">
			<s:param name="postid" value="postid"></s:param>					
		</s:url> 
		<s:a href="%{comment}" style="text-decoration:none;color:indigo"><< Back to Comment</s:a>
	</div>
	<br>
</body>
</html>