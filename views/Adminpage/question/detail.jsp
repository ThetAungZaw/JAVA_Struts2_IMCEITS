<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <s:url action="question" var="question" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Detail</title>
</head>
<body>
<div class="w3-container">
		<fieldset>
			<legend>
				<h1>
					<span class="w3-text-indigo">Detail</span>
				</h1>
			</legend>
			<s:form action="question_delete_submit" theme="simple">
				<table>
					<s:hidden name="question.QuestionID" />

					<tr height=" 50px">
						<td width="250px">Language Name</td>
						<td><s:property
								value="question.language.LanguageName" /></td>
					</tr>

					<tr height=" 50px">


						<td width="250px">Question Title</td>
						<td><s:property value="question.Title" /></td>
					</tr>
					<tr height=" 50px">
						<td width="250px">Detail Description</td>
						<td width="80%"><%=request.getParameter("question.DetailDescription") %></td>
					</tr>
					<tr height=" 50px">
						<td width="250px">User Name</td>
						<td><s:property value="question.user.UserName" /></td>
					</tr>
					<tr height=" 50px">
						<td width="150px">Image</td>
						<td width="150px">
							<img height="100px" width="150px" alt=""
							src=<s:property value="question.ImageFileName"/>></td>
					</tr>
			

					
												
				</table>
				<br>
			</s:form>
		</fieldset>
		<br>
		<s:a href="{question}" style="text-decoration:none; color:indigo;"> << Back to Question</s:a>

	</div>
	<br>
</body>
</html>
</body>
</html>