<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="user" var="user"/> 
<s:url action="user_edit" var="user_edit"/> 
<s:url action="user_delete" var="user_delete"/> 
<s:url action="user_create" var="user_create"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/dropdown.css"/>
<title>SSS | Admin User Index</title>
</head>

<body>
<div class="w3-container" style="overflow-x: auto;">
	
	<h1 class="w3-center"><span class="w3-h3" style = "color:indigo">Member</span></h1>
	
	
	 <s:form action="user_search" theme="simple">
	<label style="color:indigo">Search by Members Name:</label><br>
	<s:textfield name="user.UserName" class="style1"/>
	<s:submit class="w3-btn w3-indigo" value="Search"/>
	<% int i=0;  %>   	
	   	<s:iterator value="list">
	   		<%i++; %>
	   	</s:iterator>
		<br><span class="w3-right w3-opacity">Total Result : <%=i %></span>
	<br>
	
	<table class="w3-table-all w3-left">
		<tr class="w3-container w3-indigo">
	   
	    <th>Members Name</th>  
	    <th>Email</th>
	    <th>Profile Picture</th>
	    <th>Gender</th>
	    <th>DOB</th>
	    <th>Address</th>
	   
	  </tr>
	   
	   	
	   	<%if(i>0){ %>
	   	
	   	 <s:iterator value="list">
	  	<tr>
	  		<td><s:property value="UserName"/></td>
	  	  	<td><s:property value="Email"/></td>
	  	  	
	  	  	<td><img height="50px" width="50px" alt=""
							src=<s:property value="ProfilePictureName" />></td>
							
	  	  	<td><s:property value="Gender"/></td>
	  	  	<td><s:property value="DOB"/></td>
	  	  	<td><s:property value="Address"/></td>
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
