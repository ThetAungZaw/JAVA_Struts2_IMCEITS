<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="user" var="user"/> 
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>SSS | Admin Delete User</title>
</head>

<body>
<div class="w3-container">
	<h3>Are you sure want to delete this Members?</h3>
	<s:form theme="simple">
	<table>
	<tr>
	<td>Members ID:</td>
	<td>U001</td>
	</tr>
	<tr>
	<td>Members Name:</td>
	<td>Ma Ma</td>
	</tr>
	<tr>
	<td>Password:</td>
	<td>123</td>
	</tr>
	<tr>
	<td>Email:</td>
	<td>mama@gmail.com</td>
	</tr>
	<tr>
	<td>Gender:</td>
	<td>Female</td>
	</tr>
	<tr>
	<td>DOB:</td>
	<td>3/4/1987</td>
	</tr>
	<tr>
	<td>Address:</td>
	<td>Yangon</td>
	</tr>
	<tr>
	<td>Vote:</td>
	<td>Voted</td>
	</tr>
	<tr>
	<td>IsAdmin:</td>
	<td>No</td>
	</tr>
	<tr>
	<td></td>
	<td><s:submit class="w3-btn w3-indigo" value="Delete"/></td>
	</tr>
	</table>
	<br>
	<s:a href="%{user}" style="text-decoration:none;color:indigo"><< Back to Users</s:a>
	</s:form>
</div>
<br>
</body>

</html>
