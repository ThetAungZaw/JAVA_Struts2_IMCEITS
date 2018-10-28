<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> Delete Suggestions</title>

</head>

<body>
<div class="w3-container">
	
	<fieldset>
	<legend><h1><span style = "color:indigo">Delete Suggestion</span></h1></legend>
	
	<s:form action="suggest_delete_submit" theme="simple">
	<table>
	<s:hidden name="suggestion.SuggestID"></s:hidden>
	
	<tr style="height: 50px;">
	<td width="250px" >Suggest Description</td>
	<td><s:property value="suggestion.DetailDescription"/></td>
	</tr>
	
	<tr style="height: 50px;">
	<td width="250px" >Suggest Date</td>
	<td><s:property value="suggestion.SuggestDate"/></td>
	</tr>
	
	<tr style="height: 50px;">
	<td width="250px" >Reply</td>
<%--  	<td><s:checkbox name="suggestion.IsReply" disabled="true" theme="simple"/></td> --%> 
	
 	<td> 
 		<%  
 			Boolean _yesno=(Boolean) request.getAttribute("suggestion.IsReply"); 
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
	<td width="250px" >User Name</td>
	<td><s:property value="suggestion.user.UserName"/></td>
	</tr>
	
	<tr style="height: 50px;">
	<td width="250px" >Email</td>
	<td><s:property value="suggestion.user.Email"/></td>
	</tr>
	
	<tr style="height: 50px;">
	<td width="250px"></td>
	<td><s:submit class="w3-btn w3-indigo w3-left" value="Delete" /> </td>	
	</tr>
	
	</table>
	</s:form>
</fieldset>

	<br/>
	
	<s:a href="%{suggest}" style="text-decoration:none;color:indigo"><< Back to Suggestion</s:a>
	
</div>
<br/>
</body>
</html>
