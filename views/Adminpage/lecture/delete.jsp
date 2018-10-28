<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url action="lecture" var="lecture"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Lecture Page</title>
</head>

<body>
<div class="w3-container">
	<fieldset>
	<legend><h1><span style = "color:indigo">Delete Lecture</span></h1></legend>
	<s:form action="lecture_delete_submit" theme="simple">
	<s:hidden name="lecture.LectureID"/>
	<s:hidden name="lecture.section.SectionID"/>
	<s:hidden name="lecture.language.LanguageID"/>
	<table class="w3-container">
	<tr style="height: 50px; ">
	
	<td width="250px" >Lecture Title</td>
	<td> <s:label><s:property value="lecture.Title" /> </s:label> </td>
	</tr>
	<tr style="height: 50px; ">
	<td width="250px" >Detail Description</td>
	 <td width="80%"><%=request.getParameter("lecture.DetailDescription") %></td>
	</tr>
	<tr style="height: 50px; ">
	<td width="250px" >Sample Code</td>
	<td><s:label><s:property value="lecture.SampleCode" /> </s:label> </td>
	</tr>
	<tr style="height: 50px; ">
	<td width="250px" >Sort Alphabet</td>
	<td><s:label><s:property value="lecture.SortAlphabet" /> </s:label> </td>
	</tr>
	
	<tr style="height: 50px; ">
	<td width="250px" >Try YourSelf</td>
	
<%-- 	<td><s:checkbox name="lecture.TryYourSelf" disabled="true" /></td> --%>

		<td>
		<%
			Boolean _yesno=(Boolean) request.getAttribute("lecture.TryYourSelf");
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
	<tr style="height: 50px; ">
	<td width="250px" >Language:</td>
	<td><s:label><s:property value="lecture.language.LanguageName" /> </s:label> </td>
	</tr>
	<tr style="height: 50px; ">
	<td width="250px" >Section:</td>
	<td><s:label><s:property value="lecture.section.SectionName" /> </s:label> </td>
	</tr>
	<tr>
	<td></td>
	<td><s:submit class="w3-btn w3-indigo w3-left" name="user" value="Delete" /></td>
	</tr>
	
	</table>
	</s:form>
	</fieldset>
	<br/>
	<s:a href="{lecture}" style="text-decoration:none;color:indigo"><< Back to Lecture</s:a>
</div>
<br/>
</body>
</html>
