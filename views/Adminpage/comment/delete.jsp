<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="comment" var="comment" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comment.css">
<title>Delete Comment</title>
</head>
<body>
	<div class="w3-container">
		<br>
		<fieldset>
			<legend>
				<h1>
					<span style="color: indigo">Delete Comment</span>
				</h1>
			</legend>
			<s:form action="comment_delete_submit" theme="simple">
				<s:hidden name="postingcomment.CommentID" />
				<s:hidden name="postid"></s:hidden>
				<table>
					<tr style="height: 50px;">
						<td width="250px">Post Title</td>
						<td><s:property value="postingcomment.postdata.Title" /></td>
					</tr>
					<tr style="height: 50px;">
						<td width="250px">Comment</td>
						<td><s:property value="postingcomment.Comment" /></td>
					</tr>
					<tr style="height: 50px;">
						<td width="250px">Comment Date</td>
						<td><s:property value="postingcomment.CommentDate" /></td>
					</tr>
					<tr style="height: 50px;">
						<td width="250px">User Name</td>
						<td><s:property value="postingcomment.user.UserName" /></td>
					</tr>
					<tr>
						<td width="250px"></td>
						<td><s:submit class="w3-btn w3-indigo w3-left" value="Delete" /></td>
					</tr>
				</table>
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