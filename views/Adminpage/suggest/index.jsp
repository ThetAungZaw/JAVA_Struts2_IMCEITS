<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/lecture.css">
<link rel="stylesheet" href="css/w3.css">
<s:url action="suggest" var="suggest" />
<s:url action="suggest_create" var="suggest_create" />
<s:url action="suggest_edit" var="suggest_edit" />
<s:url action="suggest_delete" var="suggest_delete" />
<html>
<head>
<link rel="stylesheet" href="css/dropdown.css"/>
<title>Suggest Page</title>

</head>

<body>
	<div class="w3-container" style="overflow-x: auto;">
		<h1 class="w3-center">
			<span class="w3-h3" style="color: indigo">Suggest</span>
		</h1>

		<s:form action="suggest_search" theme="simple">
			<label style="color: indigo">Find by description:</label>
			<br>
			<s:textfield name="suggestion.DetailDescription" class="style1"/>
			<s:submit name="search" class="w3-btn w3-indigo" value="Search" />
		
		<% int i=0;  %>   	
	   	<s:iterator value="list">
	   		<%i++; %>
	   	</s:iterator>
		<br><span class="w3-right w3-opacity">Total Result : <%=i %></span>
		<br>
			<table class="w3-table-all w3-left">
				<tr class="w3-container w3-indigo">
					<!-- <th>SuggestID</th> -->
					<th>Suggest Description</th>
					<th>Suggest Date</th>
					<th>Reply Status</th>
					<th>User Name</th>
					<th>Email</th>
					<th></th>
				</tr>

	   	<%if(i>0){ %>
				<s:iterator value="list">
					<tr>
						<td><s:property value="DetailDescription" /></td>
						<td><s:property value="SuggestDate" /></td>
<%-- 						<td><s:checkbox name="check" value="IsReply" disabled="true" /></td> --%>
						
						<td>
						<%
							Boolean _yesno=(Boolean) request.getAttribute("IsReply");
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
						
						<td><s:property value="user.UserName" /></td>
						<td><s:property value="user.Email" /></td>

						<td>
						
<%-- 						<s:url id="edit" action="suggest_edit">
								<s:param name="suggestion.SuggestID" value="SuggestID"></s:param>
								<s:param name="suggestion.DetailDescription"
									value="DetailDescription"></s:param>
								<s:param name="suggestion.SuggestDate" value="SuggestDate"></s:param>
								<s:param name="suggestion.IsReply" value="IsReply"></s:param>
								<s:param name="suggestion.user.UserName" value="user.UserName"></s:param>
								<s:param name="suggestion.user.Email" value="user.Email"></s:param>

							</s:url> <s:a href="%{edit}" style="text-decoration:none;color:indigo">Reply</s:a> 
 --%>							
								<%
							Boolean _reply=(Boolean) request.getAttribute("IsReply");
							if(_reply==true){
						%>
							<font color="red">Replied</font>
						<%
							}
							else{
						%>
							<s:url id="edit" action="suggest_edit"> 
 								<s:param name="suggestion.SuggestID" value="SuggestID"></s:param> 
 								<s:param name="suggestion.DetailDescription" value="DetailDescription"></s:param> 
 								<s:param name="suggestion.SuggestDate" value="SuggestDate"></s:param>
 								<s:param name="suggestion.IsReply" value="IsReply"></s:param> 
 								<s:param name="suggestion.user.UserName" value="user.UserName"></s:param> 
 								<s:param name="suggestion.user.Email" value="user.Email"></s:param> 

 							</s:url> <s:a href="%{edit}" style="text-decoration:none;color:indigo">Reply</s:a>
						<%
							}
						%>
						
						
							<font color="indigo">|</font> 
							<s:url action="suggest_delete" var="delete">
								<s:param name="suggestion.SuggestID" value="suggestID" />
								<s:param name="suggestion.DetailDescription"
									value=" DetailDescription" />
								<s:param name="suggestion.SuggestDate" value="SuggestDate"></s:param>
								<s:param name="suggestion.IsReply" value="IsReply"></s:param>
								<s:param name="suggestion.user.UserName" value="user.UserName" />
								<s:param name="suggestion.user.Email" value="user.Email"></s:param>
							</s:url> <s:a href="%{delete}" style="text-decoration:none;color:indigo">Delete</s:a></td>
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
