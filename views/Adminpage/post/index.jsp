<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="comment" var="comment" />
<s:url action="post" var="post" />
<s:url action="post_edit" var="post_edit" />

<s:url action="post_create" var="post_create" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="css/dropdown.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sharing Post</title>
</head>
<body>
	<div class="w3-container" style="overflow-x: auto;">
		<h1 class="w3-center">
			<span class="w3-h3" style="color: indigo">Post</span>
		</h1>

		
		
		<s:form action="post_search_submit" theme="simple">
		
		<br>
		<label style="color: indigo">Find by Post Title:</label>
		<br>
		
			<s:textfield name="postdata.Title" class="style1"/>
			<s:submit class="w3-btn w3-indigo" value="Search" />
				
		
		<s:a href="%{post_create}" class="w3-right" style="color:indigo">Add New Post</s:a>
		<% int i=0;  %>   	
	   	<s:iterator value="list">
	   		<%i++; %>
	   	</s:iterator>
		<br><span class="w3-right w3-opacity">Total Result : <%=i %></span>
		<br>
		<table class="w3-table-all w3-left">
			<tr class="w3-indigo">
				<th>Title</th>
				<th>Detail Description</th>
				<th>Image</th>
				<th>Posting Date</th>
				<th>User Name</th>
				<th></th>
			</tr>

	   	
	   	<%if(i>0){ %>
			<s:iterator value="list">
				<tr>
					<td><s:property value="Title" /></td>
<%-- 					<td>${DetailDescription}</td> --%>
					
						<td>
						
						<%
							String detail_description=(String)request.getAttribute("DetailDescription");
						
							if(detail_description.length() > 100)
								detail_description = detail_description.substring(0, 100) + "...";
						
						%>
						<%= detail_description %>
									
						
						</td> 
						
						
					<td>
					<img height="50px" width="50px" alt="" src=<s:property value="ImageFileName" />>
					</td>
					<td><s:property value="PostingDate"/></td>
					<td><s:property value="user.UserName" /></td>
					<td>
						<s:url action="post_delete" var="delete">
							<s:param name="postdata.PostID" value="PostID"></s:param>
							<s:param name="postdata.Title" value="Title"></s:param>
							<s:param name="postdata.DetailDescription"
								value="DetailDescription"></s:param>
							<s:param name="postdata.ImageFileName" value="ImageFileName"></s:param>
							<s:param name="postdata.user.UserName" value="user.UserName"></s:param>
						</s:url>
						<s:a href="%{delete}" style="color:indigo">Delete</s:a>
						<font color="indigo">|</font> 
						
							<!-- 2079 -->	
						<s:url action="post_detail" var="detail">
							<s:param name="postdata.PostID" value="PostID"></s:param>
							<s:param name="postdata.Title" value="Title"></s:param>
							<s:param name="postdata.DetailDescription"
								value="DetailDescription"></s:param>
							<s:param name="postdata.ImageFileName" value="ImageFileName"></s:param>
							<s:param name="postdata.user.UserName" value="user.UserName"></s:param>
						</s:url>
						<s:a href="%{detail}" style="color:indigo">Detail</s:a>
						<font color="indigo">|</font> 
					<!-- 2079 -->						
		
		
						<s:url action="comment" var="post_comment">
							<s:param name="postdata.PostID" value="PostID" />
							<s:param name="postdata.Title" value="Title" />
							<s:param name="postid" value="PostID"/>
						</s:url> 
						<s:a action="%{post_comment}" style="color:indigo">Comment</s:a>
					</td>
				</tr>
			</s:iterator>
			
			 <%}else{ %>
	   	<tr><td colspan="6"><span class="w3-text-red w3-center"><b>No Result Data...</b></span></td></tr>
	   <%} %>
		</table>
		</s:form>
	</div>
	<br><br>
</body>
</html>