<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/w3.css">
<s:url action="answer" var="answer" />
<s:url action="answer_edit" var="answer_edit" />
<html>
<head>
<link rel="stylesheet" href="css/dropdown.css"/>
<title>Lecture Page</title>
</head>

<body>
	<div class="w3-container" style="overflow-x: auto;">
		<h1 class="w3-center">
			<span class="w3-h3" style="color: indigo">Answer</span>
		</h1>

		<!-- answer_search_submit -->

		<s:form action="answer_search_submit" theme="simple">
			<s:hidden name="questionid"></s:hidden>

			<label style="color: indigo">Find by Answer Description:</label> <br>
			<s:textfield name="answer.DetailDescription" class="style1"></s:textfield>
			<s:submit class="w3-btn w3-indigo" value="Search"></s:submit>
		
		

		<s:url action="answer_create" var="answer_create">
			<s:param name="questionid" value="questionid" />
		</s:url>
		<s:a href="%{answer_create}" class="w3-right" style="color:indigo">Add New Answer</s:a>
		<% int i=0;  %>   	
	   	<s:iterator value="list">
	   		<%i++; %>
	   	</s:iterator>
		<br><span class="w3-right w3-opacity">Total Result : <%=i %></span>
		<br>

		
		<table class="w3-table-all w3-left">
			<tr class="w3-container w3-indigo">
				<th>Question Title</th>
				<th width="200px">Answer Description</th>
				<th>Correct Status</th>
				<th>Answer Date</th>
				<th>User Name</th>
				<th></th>
			</tr>
			
			
	   	
	   	<%if(i>0){ %>
			<s:iterator value="list">
				<tr>
					<td><s:property value="question.Title" /></td>
					<td width="200px"><s:property value="DetailDescription" /></td>
										
					<td>
						<%
							Boolean _yesno=(Boolean) request.getAttribute("Correct");
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
						
					<td><s:property value="AnswerDate" /></td>
					<td><s:property value="user.UserName" />
					<td>
					
					<s:url action="answer_edit" var="answer_edit">
							<s:param name="answer.AnswerID" value="AnswerID" />
							<s:param name="answer.DetailDescription"
								value="DetailDescription" />
							
							<s:param name="answer.Correct" value="Correct" />
							<s:param name="answer.AnswerDate" value="AnswerDate" />
														
							<s:param name="questionid" value="questionid" />

						</s:url> <s:a href="%{answer_edit}"
							style="text-decoration:none;color:indigo">Correct</s:a>
							
							<font color="indigo">|</font> 
					<s:url action="answer_delete" var="answer_delete">
							<s:param name="answer.AnswerID" value="AnswerID" />
							<s:param name="answer.DetailDescription"
								value="DetailDescription" />

							<s:param name="questionid" value="questionid" />

						</s:url> <s:a href="%{answer_delete}"
							style="color:indigo">Delete</s:a></td>
							
				</tr>
			</s:iterator>
			<%}else{ %>
	   	<tr><td colspan="6"><span class="w3-text-red w3-center"><b>No Result Data...</b></span></td></tr>
	   <%} %>
		</table>
		<br>
		<s:a href="{question}" style="text-decoration:none;color:indigo"><< Back to Question</s:a>
	</s:form>
	</div>
	<br><br>
</body>
</html>
