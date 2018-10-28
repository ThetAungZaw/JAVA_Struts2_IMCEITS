<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="question" var="question" />
<s:url action="question_delete" var="question_delete" />
<s:url action="question_create" var="question_create" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/dropdown.css"/>


<title>Questions</title>
</head>
<body>
	<div class="w3-container" style="overflow-x: auto;">
		<h1 class="w3-center">
			<span class="w3-h3" style="color: indigo">Question</span>
		</h1>


		<s:form action="question_search_submit" theme="simple">
		

		<table style="width: 100%">
		<tr>
		<td>
		
		<table>
		<tr>
		<td>
		
		<label style="color:indigo">Language:</label><br>				
				<s:select list="language_list" class="styled-select1"
						 				name="language.LanguageID" listKey="LanguageID" 
						 				 listValue="LanguageName" value="%{language.LanguageID}"  /> 
						 				
						 				
				&nbsp;&nbsp;		 				
		</td> 		
		<td>
			<label style="color: indigo">Find By Question Title:</label>
					<br>
					<s:textfield name="question.Title" class="style1"/>			
					<s:submit class="w3-btn w3-indigo" value="Search" />
		</td>
		
		
		</tr>
		
		</table>
			
		</td>
		<td><br>
		<s:a href="%{question_create}" class="w3-right" style="color:indigo">Ask New Question</s:a>
		</td>
		</tr>
		</table>		
			
		
		
		<% int i=0;  %>   	
	   	<s:iterator value="list">
	   		<%i++; %>
	   	</s:iterator>
		<span class="w3-right w3-opacity">Total Result : <%=i %></span> 
		<br>
			<table class="w3-table-all w3-left">
				<tr class="w3-indigo">
					<th>Title</th>
					<th>Detail Description</th>
					<th>Image</th>
					<th>Question Date</th>
					<th>User Name</th>
					<th>Language Name</th>
					<th></th>
				</tr>
				
		
	   	
	   	<%if(i>0){ %>
				<s:iterator value="list">
					<tr>
						<td><s:property value="Title" /></td>
<%-- 						<td>${DetailDescription }</td> --%>

					<td>
						
						<%
							String detail_description=(String)request.getAttribute("DetailDescription");
						
							if(detail_description.length() > 100)
								detail_description = detail_description.substring(0, 100) + "...";
						
						%>
						<%= detail_description %>
									
						
						</td> 
						
						<td><img height="50px" width="50px" alt=""
							src=<s:property value="ImageFileName" />></td>
						<td><s:property value="QuestionDate"></s:property></td>
						<td><s:property value="user.UserName" /></td>
						<td><s:property value="language.LanguageName" /></td>

					<td><s:url action="question_delete" var="delete">
								<s:param name="question.QuestionID" value="QuestionID"></s:param>
								<s:param name="question.user.UserID" value="user.UserID"></s:param>
								<s:param name="question.language.LanguageID"
									value="language.LanguageID"></s:param>
								<s:param name="question.Title" value="Title"></s:param>
								<s:param name="question.DetailDescription"
									value="DetailDescription"></s:param>
								<s:param name="question.user.UserName" value="user.UserName"></s:param>
								<s:param name="question.QuestionDate" value="QuestionDate"></s:param>
								<s:param name="question.language.LanguageName"
									value="language.LanguageName"></s:param>
								<s:param name="question.ImageFileName" value="ImageFileName"></s:param>

							</s:url> 
							
								<!-- 2079 -->
								
					<s:url id="detail" action="question_detail">
	            		<s:param name="question.QuestionID" value="QuestionID"></s:param>
								<s:param name="question.user.UserID" value="user.UserID"></s:param>
								<s:param name="question.language.LanguageID"
									value="language.LanguageID"></s:param>
								<s:param name="question.Title" value="Title"></s:param>
								<s:param name="question.DetailDescription"
									value="DetailDescription"></s:param>
								<s:param name="question.user.UserName" value="user.UserName"></s:param>
								<s:param name="question.QuestionDate" value="QuestionDate"></s:param>
								<s:param name="question.language.LanguageName"
									value="language.LanguageName"></s:param>
								<s:param name="question.ImageFileName" value="ImageFileName"></s:param>
				</s:url>
		<!-- 2079 -->
		
		<s:url action="answer" var="question_answer">
								<s:param name="question.QuestionID" value="QuestionID" />
								<s:param name="question.Title" value="Title" />
								<s:param name="questionid" value="QuestionID" />
							</s:url> 
							<s:a href="%{delete}" style="text-decoration: none; color: indigo;">Delete</s:a> 
							<font color="indigo">|</font>
							<s:a href="%{detail}"  style="text-decoration:none;color:indigo">Detail</s:a>
							<font color="indigo">|</font>
							<s:a href="%{question_answer}" style="text-decoration: none; color: indigo;">Answer</s:a></td>
					</tr>
				</s:iterator>
 		<%}else{ %>
	   	<tr><td colspan="7"><span class="w3-text-red w3-center"><b>No Result Data...</b></span></td></tr>
	   <%} %>
			</table>
			<br>
			<br>
		</s:form>
	</div>
	<br>
			<br>
</body>
</html>