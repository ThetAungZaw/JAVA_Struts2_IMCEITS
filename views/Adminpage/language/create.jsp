<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="language" var="language" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comment.css">
<link rel="stylesheet" href="css/error-message.css">
<title>New Language</title>
</head>
<body>
	<div class="w3-container">
		<fieldset>
			<legend>
				<h1>
					<span style="color: indigo">Add New Language</span>
				</h1>
			</legend>
			<s:form action="language_create_submit" theme="simple" method="post"
				enctype="multipart/form-data">
				<table>
					<tr style="height: 50px;">
						<td width="250px">Language Name</td>
						<td><s:textfield name="language.LanguageName"
								style="width:100%;" /></td>
						<td><s:fielderror fieldName="language.LanguageName" /></td>
					</tr>

					<tr style="height: 50px;">
						<td width="250px">Logo</td>
						<td><s:file name="uploadfile.image" accept="image/*" /></td>
						<td><s:fielderror fieldName="uploadfile.imageFileName" /></td>
					</tr>


					<tr style="height: 50px;">
						<td width="250px">Testing</td>
						<td><s:checkbox name="language.CanTest" /></td>
					</tr>
					<tr style="height: 50px;">
						<td width="250px"></td>
						<td><s:submit class="w3-btn w3-indigo w3-left" value="Save" /></td>
					</tr>
				</table>
			</s:form>
		</fieldset>
		<br>
		<s:a href="%{language}" style="text-decoration:none;color:indigo"><< Back to Language</s:a>
	</div>
	<br>
</body>
</html>