<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="language" var="language" />


<s:url action="language_create" var="language_create" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comment.css">
<link rel="stylesheet" href="css/dropdown.css"/>
<title>Language</title>
</head>
<body>
	<div class="w3-container" style="overflow-x: auto;">
		<h1 class="w3-center">
			<span class="w3-h3" style="color: indigo">Language</span>
		</h1>
		<s:form action="language_search" theme="simple">
			<label style="color: indigo">Find by Language Name:</label>
			<br>
			<s:textfield name="language.LanguageName" class="style1"/>
			<s:submit class="w3-btn w3-indigo" value="Search" />
			<s:a href="%{language_create}" class="w3-right" style="color:indigo">Add New Language</s:a>
			<% int i=0;  %>   	
	   	<s:iterator value="list">
	   		<%i++; %>
	   	</s:iterator>
		<br><span class="w3-right w3-opacity">Total Result : <%=i %></span>
			<br>
			<table class="w3-table-all w3-left">
				<tr class="w3-container w3-indigo">
					<th>Language Name</th>
					<th>Logo</th>
					<th>Testing</th>
					<th></th>
				</tr>
	   	
	   	<%if(i>0){ %>
				<s:iterator value="list">


					<tr>

						<td><s:property value="LanguageName" /></td>

						<td><img height="50px" width="50px" alt=""
							src=<s:property value="LogoName" />></td>
<%-- 						<td><s:checkbox name="CanTest" disabled="true" /></td> --%>

					<td>
						<%
							Boolean _yesno=(Boolean) request.getAttribute("CanTest");
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


						<s:url action="language_edit" var="language_edit">
							<s:param name="language.LanguageID" value="LanguageID"></s:param>
							<s:param name="language.LanguageName" value="LanguageName"></s:param>
							<s:param name="language.CanTest" value="CanTest"></s:param>
							<s:param name="language.LogoName" value="LogoName"></s:param>
						</s:url>


						<s:url action="language_delete" var="language_delete">
							<s:param name="language.LanguageID" value="LanguageID"></s:param>
							<s:param name="language.LanguageName" value="LanguageName"></s:param>
							<s:param name="language.CanTest" value="CanTest"></s:param>
							<s:param name="language.LogoName" value="LogoName"></s:param>
						</s:url>

						<td><s:a href="%{language_edit}" style="color:indigo">Edit</s:a>
							<font color="indigo">|</font> <s:a href="%{language_delete}"
								style="color:indigo">Delete</s:a></td>
					</tr>

				</s:iterator>
		<%}else{ %>
			<tr><td colspan="4"><span class="w3-text-red w3-center"><b>No Result Data...</b></span></td></tr>
		<%} %>
			</table>
		</s:form>
	</div>
	<br><br>
</body>
</html>