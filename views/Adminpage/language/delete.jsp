<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url action="language" var="language" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comment.css">
<title>Delete Language</title>
</head>
<body>
	<div class="w3-container">
		<fieldset>
			<legend>
				<h1>
					<span style="color: indigo">Delete Language</span>
				</h1>
			</legend>
			<s:form action="language_delete_submit" theme="simple">
				<table>


					<s:hidden name="language.LanguageID"></s:hidden>

					<tr style="height: 50px;">
						<td width="250px">Language Name</td>
						<td><s:label name="language.LanguageName" /></td>
					</tr>

					<tr style="height: 50px;">
						<td width="250px">Logo</td>
						<td><img height="100px" width="150px" alt=""
							src=<s:property value="language.LogoName" />></td>
					</tr>



					<tr style="height: 50px;">
						<td width="250px">Testing</td>
<%-- 						<td><s:checkbox name="language.CanTest" disabled="true"/></td> --%>
						
						
						<td>
						<%
							Boolean _yesno=(Boolean) request.getAttribute("language.CanTest");
							if(_yesno==true){
						%>
							Yes
						<%
							}
							else{
						%>
							No
						<%
							}
						%>
						</td>
					
					
					</tr>


					<tr style="height: 50px;">
						<td width="250px"></td>
						<td><s:submit class="w3-btn w3-indigo w3-left" value="Delete" /></td>
					</tr>
				</table>
				<br>
			</s:form>
		</fieldset>
	<br>
	<s:a href="{language}" style="text-decoration:none;color:indigo"><< Back to Language</s:a>
	</div>
	<br>
</body>
</html>