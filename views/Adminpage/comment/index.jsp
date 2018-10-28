<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="comment" var="comment" />
<s:url action="comment_edit" var="comment_edit" />
<s:url action="post" var="post" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comment.css">
<link rel="stylesheet" href="css/dropdown.css"/>
<title>Comment</title>
</head>
<body>
	<div class="w3-container" style="overflow-x: auto;">
		<h1 class="w3-center">
			<span class="w3-h3" style="color: indigo">Comment</span>
		</h1>
		
		
		<s:form action="comment_search_submit" theme="simple">
		<s:hidden name="postid"></s:hidden>
		
			<br>
			<label style="color: indigo">Find by comment:</label>
			<br>
			<s:textfield name="postingcomment.Comment" class="style1"/>
			<s:submit class="w3-btn w3-indigo" value="Search" />
		
		
		<s:url action="comment_create" var="comment_create" >
		<s:param name="postid" value="postid"></s:param>
		<s:param name="postdata.Title" value="postdata.Title"/>
		</s:url>
		<s:a href="%{comment_create}" class="w3-right" style="color:indigo">Add New Comment</s:a>
		<% int i=0;  %>   	
	   	<s:iterator value="list">
	   		<%i++; %>
	   	</s:iterator>
		<br><span class="w3-right w3-opacity">Total Result : <%=i %></span>
		<br>
		<div class="w3-container">
			<table class="w3-table-all w3-left">
				<s:hidden name="postdata.PostID" />
				<tr class="w3-container w3-indigo">
					<th>Post Title</th>
					<th>Comment</th>
					<th>Comment Date</th>
					<th>User Name</th>
					<th></th>
				</tr>
		
	   	
	   	<%
	   	if(i>0){ %>
				<s:iterator value="list">
					<tr>
						<td><s:property value="postdata.Title" /></td>
						<td><s:property value="Comment" /></td>
						<td><s:property value="CommentDate" /></td>
						<td><s:property value="user.UserName" /></td>
						<td>
							<s:url action="comment_delete" var="delete">
								<s:param name="postingcomment.CommentID" value="CommentID"></s:param>
								<s:param name="postingcomment.postdata.Title"
									value="postdata.Title"></s:param>
								<s:param name="postingcomment.Comment" value="Comment"></s:param>
								<s:param name="postingcomment.CommentDate" value="CommentDate"></s:param>
								<s:param name="postingcomment.user.UserName"
									value="user.UserName"></s:param>
									<s:param name="postid" value="postid"></s:param>
							</s:url> <s:a href="%{delete}" style="color:indigo">Delete</s:a></td>
					</tr>
				</s:iterator>
				<%}else{ %>
	   		<tr><td colspan="4"><span class="w3-text-red w3-center"><b>No Result Data...</b></span></td></tr>
	   		<%} %>
			</table>
		</div>
		<br />
		<s:a href="%{post}" style="text-decoration:none;color:indigo"><< Back to Post</s:a>
	</s:form>
	</div>
	<br><br>
</body>
</html>