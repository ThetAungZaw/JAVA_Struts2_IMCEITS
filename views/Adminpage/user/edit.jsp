<%@ taglib prefix="s" uri="/struts-tags"%>
   <s:url action="section" var="section"/> 
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>SSS | Admin Edit User</title>
</head>

<body>
<div class="w3-container">
	<p><span class="w3-jumbo">Edit Members...</span></p><br>
	<s:form theme="simple">
	<table>
	<tr>
	<td>Members ID</td>
	<td>U001</td>
	</tr>
	<tr>
	<td>Members Name</td>
	<td><s:textfield name="uname" value="Ma Ma"/></td>
	</tr>
	<tr>
	<td>Password</td><td><s:password name="upwd"/></td>
	</tr>
	<tr>
	<td>Email</td><td><s:textfield name="uemail" value="mama@gmail.com"/></td>
	</tr>
	<tr>
	<td>Gender</td><td><s:textfield name="ugender" value="Female"/></td>
	</tr>
	<tr>
	<td>DOB</td><td><s:textfield name="udbo" value="3/4/1987"/></td>
	</tr>
	<tr>
	<td>Address</td><td><s:textfield name="uaddress" value="Yangon"/></td>
	</tr>
	<tr>
	<td>Vote</td><td><s:textfield name="uvote" value="Voted"/></td>
	</tr>
	<tr>
	<td>IsAdmin</td><td><s:textfield name="uadmin" value="No"/></td>
	</tr>
	<tr>
	<td></td>
	<td><s:submit class="w3-btn w3-indigo" value="Save"/></td>
	</tr>
	</table>
	<br>
	<s:a href="%{section}" style="text-decoration:none;color:indigo"><< Back to Section</s:a>
	</s:form>
</div>
<br>
</body>

</html>
