<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="user" var="user"/> 
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>SSS | Admin Create User</title>
</head>

<body>
<div class="w3-container">
	<p><span class="w3-jumbo">Create Members</span></p>
	<s:form theme="simple">
	<table>
	<tr>
	<td>Members ID</td>
	<td><s:textfield name="uid"/></td>
	</tr>
	<tr>
	<td>Members Name</td>
	<td><s:textfield name="uname"/></td>
	</tr>
	<tr>
	<td>Password</td><td>
	<s:password name="upwd"/></td>
	</tr>
	<tr>
	<td>Email</td>
	<td><s:textfield name="uemail"/></td>
	</tr>
	<tr>
	<td>Gender</td>
	<td><s:textfield name="ugender"/></td>
	</tr>
	<tr>
	<td>DOB</td>
	<td><s:textfield name="udbo"/></td>
	</tr>
	<tr>
	<td>Address</td>
	<td><s:textfield name="uaddress"/></td>
	</tr>
	<tr>
	<td>Vote</td>
	<td><s:textfield name="uvote"/></td>
	</tr>
	<tr>
	<td>IsAdmin</td>
	<td><s:textfield name="uadmin"/></td>
	</tr>
	<tr>
	<td></td>
	<td><s:submit class="w3-btn w3-indigo" value="Create"/></td>
	</tr>
	</table>
	<br>
	<s:a href="%{user}" style="text-decoration:none;color:indigo"><< Back to Users</s:a>
	</s:form>
</div>
<br>
</body>

</html>
