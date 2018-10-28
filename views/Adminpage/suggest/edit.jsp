<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url action="suggest" var="suggest"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Suggest Page</title>
</head>

<body>
<div class="w3-container">
 <fieldset>
	<legend><h1 class="w3-center"><span class="w3-h3" style = "color:indigo">Reply Suggestion</span></h1></legend>
	<s:form action="suggest_edit_submit" theme="simple">
	<table>
	<!-- <tr style="height: 50px; ">
	<td width="150px" >SuggestID</td>
	<td>001</td>
	</tr> -->
	<s:hidden name="suggestion.SuggestID"></s:hidden>
	<tr style="height: 50px; ">
	<td width="150px" >Suggest Description</td>
	<td><s:property value="suggestion.DetailDescription"/></td>
	<%--  <td><s:textarea name="suggestion.DetailDescription"/></td>  --%>
	<%-- <td>${suggestion.DetailDescription}</td> --%>
	</tr>
	
	<tr style="height: 50px; ">
	<td width="250px" >Suggest Date</td>
	<td><s:property value="suggestion.SuggestDate"/></td>
	</tr>
	
	<%-- <tr style="height: 50px; ">
	<td>Reply</td>
	<td><s:checkbox name="suggestion.IsReply" theme="simple"/></td>

	<td>
		<%
			Boolean _reply=(Boolean) request.getAttribute("suggestion.IsReply");
			if(_reply==true){
		%>
			Yes
		<%
			}
			else{
		%>
			<s:checkbox name="suggestion.IsReply" theme="simple"/>
		<%
			}
		%>
	</td> --%>


<!-- 	</tr>	 -->
		
	<tr style="height: 50px; ">
	<td width="250px" >User Name:</td>
	<td><s:property value="suggestion.user.UserName"/></td>
	</tr>
	
	<tr style="height: 50px;">
	<td width="250px" >Email:</td>
	<td><s:property value="suggestion.user.Email"/></td>
	</tr>
	
	<tr style="height: 50px; ">
	<td width="250px"></td>
	<td><s:submit class="w3-btn w3-indigo w3-left" value="Reply"/></td>
	</tr>
	</table>
	<br/>
	
	</s:form>
</fieldset>
<br/>
<s:a href="%{suggest}" style="text-decoration:none;color:indigo"><< Back to Suggestion</s:a>
</div>
<br/>
</body>
</html>