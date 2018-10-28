<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url action="lecture" var="lecture"/> 


<s:url action="lecture_create" var="lecture_create"/>
<link rel="stylesheet" href="css/lecture.css">
<link rel="stylesheet" href="css/dropdown.css"/>
<html>
<head>
<title>Lecture Page</title>
</head>

<body>
<div class="w3-container" style="overflow-x:auto;">
<h1 class="w3-center"><span class="w3-h3" style = "color:indigo">Lecture</span></h1>

<s:form action="act_lecture_search" theme="simple">



<table style="width: 100%">
<tr>
<td>

<table>
<tr>
<td>

<label style="color:indigo">Language:</label><br>				
		<s:select list="language_list"
				 				name="language.LanguageID" listKey="LanguageID" 
				 				 listValue="LanguageName" value="%{language.LanguageID}"  /> 
				 				
				 				
		&nbsp;&nbsp;				 				
</td> 
<td>

<label style="color:indigo">Section:</label><br>
			<s:select list="section_list" class="styled-select1"
								name="section.SectionID" listKey="SectionID"
								listValue="SectionName" value="%{section.SectionID}" /> 
							
								
								
		&nbsp;&nbsp;
</td>
		
<td>
	<label style="color:indigo">Find by Lecture Title:</label><br>
		<s:textfield name="lecture.Title" class="style1"/>
		<s:submit class="w3-btn w3-indigo" value="Search"/>
</td>


</tr>

</table>
	
</td>
<td><br>
<s:a href="%{lecture_create}" class="w3-right" style="color:indigo">Add New Lecture</s:a>
</td>
</tr>
</table>
	
		
</s:form>
	<% int i=0;  %>
	   	
	   	<s:iterator value="list">
	   		<%i++; %>
	   	</s:iterator>
	<span class="w3-right w3-opacity">Total Result : <%=i %></span>
<%-- 	<s:form theme="simple"> --%>
	<table class="w3-container w3-table-all w3-left">
	    <tr class="w3-indigo">
	   
	    <th>Lecture Title</th>
	    <th>Sort Alphabet</th>
	    <th>Try YourSelf</th>
	    <th>Create Date</th>
	    <th>Language</th>
	    <th>Section</th>
	    <th></th>
	  </tr>
	 
	   
	   	<%
	   	if(i>0){  %>
	  
	  <s:iterator value="list" >
	  
	  <tr>
	    <td><s:property value="Title" /> </td>
	    <td><s:property value="SortAlphabet" /> </td>	    
<%-- 	    <td><s:checkbox name="TryYourSelf" value="TryYourSelf" disabled="true"/></td> --%>

 		<td>
			<%
				Boolean _yesno=(Boolean) request.getAttribute("TryYourSelf");
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
		
		
	    <td><s:property value="CreateDate" /> </td>
	    <td><s:property value="language.LanguageName" /> </td>
	    <td><s:property value="section.SectionName" /> </td>
	    
	    	
	    	<td>			
			
			<s:form action="lecture_edit" method="post" theme="simple">
						<s:hidden name="LectureID"></s:hidden>
						<s:submit value="Edit" style="text-decoration:none;color:indigo;
						background:none!important;
						border:none;
						padding:0!important;
						font:inherit;						
						cursor:pointer;"					
  							align="left" />   
 					</s:form>
 												
		<font color="indigo">|</font>
	  		<s:url id="deleteId" action="lecture_delete">
            		<s:param name="lecture.Title" value="Title"></s:param>
            		<s:param name="lecture.LectureID" value="LectureID"></s:param>
            		<s:param name="lecture.DetailDescription" value="DetailDescription"></s:param>
            		<s:param name="lecture.SampleCode" value="SampleCode"></s:param>
            		<s:param name="lecture.SortAlphabet" value="SortAlphabet"></s:param>
            		<s:param name="lecture.TryYourSelf" value="TryYourSelf"></s:param>
            		<s:param name="lecture.section.SectionID" value="section.SectionID"></s:param>
            		<s:param name="lecture.section.SectionName" value="section.SectionName"></s:param>
            		<s:param name="lecture.language.LanguageID" value="language.LanguageID"></s:param>
            		<s:param name="lecture.language.LanguageName" value="language.LanguageName"></s:param>
			</s:url>
			<s:a href="%{deleteId}"  style="text-decoration:none;color:indigo">Delete</s:a>
			
			<font color="indigo">|</font>
	  		<s:url id="detail" action="lecture_detail">
            		<s:param name="lecture.Title" value="Title"></s:param>
            		<s:param name="lecture.LectureID" value="LectureID"></s:param>
            		<s:param name="lecture.DetailDescription" value="DetailDescription"></s:param>
            		<s:param name="lecture.SampleCode" value="SampleCode"></s:param>
            		<s:param name="lecture.SortAlphabet" value="SortAlphabet"></s:param>
            		<s:param name="lecture.TryYourSelf" value="TryYourSelf"></s:param>
            		<s:param name="lecture.section.SectionID" value="section.SectionID"></s:param>
            		<s:param name="lecture.section.SectionName" value="section.SectionName"></s:param>
            		<s:param name="lecture.language.LanguageID" value="language.LanguageID"></s:param>
            		<s:param name="lecture.language.LanguageName" value="language.LanguageName"></s:param>
			</s:url>
			<s:a href="%{detail}"  style="text-decoration:none;color:indigo">Detail</s:a>
	  		</td>	    	
	   </tr>
	   
	   </s:iterator>
	   <%}else{ %>
	   	<tr><td colspan="7"><span class="w3-text-red w3-center"><b>No Result Data...</b></span></td></tr>
	   <%} %>
	
	</table>
<%-- </s:form> --%>
</div>
<br><br>
</body>
</html>
