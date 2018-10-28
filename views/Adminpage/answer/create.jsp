<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/error-message.css">
<title>Lecture Page</title>
</head>

<body>
<div class="w3-container">
	<fieldset>
		<legend><h2><span class="w3-text-indigo">Add New Answer</span></h2></legend>
	
	<s:form action="answer_create_submit" theme="simple">
		<s:hidden name="questionid"/>
		<table>
			<tr height=" 50px">
				<td width="250px">Answer Description</td>
				<td><s:textarea  rows="5px" cols="60px" name="answer.DetailDescription"/></td>
				<td><s:fielderror fieldName="answer.DetailDescription" /></td>
			</tr>
			<tr height=" 50px">
				<td width="250px"></td>
				<td><s:submit class="w3-btn w3-indigo w3-left" value="Create"/></td>
			</tr>
		</table>
	</s:form>
	</fieldset>
	<br/>
	<s:url action="answer" var="answer"> 
	<s:param name="questionid" value="questionid"/>
	</s:url>
	<s:a href="%{answer}" style="text-decoration:none;color:indigo"><< Back to Answer</s:a>
	
</div>
<br/>
</body>
</html>
