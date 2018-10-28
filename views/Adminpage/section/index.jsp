<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="entity.*"%>

<s:url action="section" var="section"/> 
<s:url action="question" var="question"/> 
<s:url action="section_edit" var="section_edit"/> 
<s:url action="section_delete" var="section_delete"/> 
<s:url action="section_create" var="section_create"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/dropdown.css"/>
<title>Section</title>
</head>
<body>
<div class="w3-container" style="overflow-x:auto;">	
	<h1 class="w3-center"><span class="w3-h3" style = "color:indigo">Section</span></h1>
	
	
	
	<s:form action="section_search" theme="simple">
	<label style="color:indigo">Search by Section Name:</label><br>
	<s:textfield name="section.SectionName" class="style1"/>
	<s:submit class="w3-btn w3-indigo" value="Search"/>
	
	
    <s:a href="%{section_create}" class="w3-right" style="color:indigo">Add New Section</s:a>
    <% int i=0;  %>   	
	   	<s:iterator value="list">
	   		<%i++; %>
	   	</s:iterator>
		<br><span class="w3-right w3-opacity">Total Result : <%=i %></span>
    <br>
	<table class="w3-table-all w3-left">
		<tr class="w3-container w3-indigo">
	  		<th>Section Name</th>
	  		<th></th>
	   	</tr>
	   	
	
	   	
	   	<%if(i>0){ %>
	   	
	   	 <s:iterator value="list">
	  	<tr>
	  		<td><s:property value="SectionName"/></td>
	  		<td>
	  		<s:url id="editId" action="section_edit">
            		<s:param name="section.SectionName" value="SectionName"></s:param>
            		<s:param name="section.SectionID" value="SectionID"></s:param>
			</s:url>
			<s:a href="%{editId}" style="color:indigo">Edit</s:a>
	  		<font color="indigo">&nbsp;|&nbsp;</font>


	  		<s:url id="deleteId" action="section_delete">
	  			
            		<s:param name="section.SectionID" value="SectionID"></s:param>
            		<s:param name="section.SectionName" value="SectionName"></s:param>
			</s:url>
			<s:a href="%{deleteId}" style="color:indigo">Delete</s:a>
	  		</td>
	  		
	  	</tr>
	  	</s:iterator>	
	  	  <%}else{ %>
	  	  		<tr><td colspan="2"><span class="w3-text-red w3-center"><b>No Result Data...</b></span></td></tr>
	  	  <%} %>
	  
	   		
	</table>
	</s:form>
	</div>
<br><br>
</body>
</html>