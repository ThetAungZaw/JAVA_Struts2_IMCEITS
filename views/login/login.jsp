<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>SSS | Login</title>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">
<link rel="stylesheet" href="css/error-message.css">

<s:url action="masterhome" var="masterhome" />

<div class="w3-container">

	<s:form action="act_login" theme="simple" method="post"
		enctype="multipart/form-data">
		<br>
		<br>
		<div class="w3-col m6">
			<img src=/SoftSeekSharing/image/Splash.png width="500px"
				height="370px" />
		</div>

		<br>
		<div class="w3-col m6">
			<fieldset>
				<legend>
					<span><h1 class="w3-label w3-center">Login</h1></span>
				</legend>


				<br>
				

				<table class="w3-center">
					<!-- 			<caption><h1 class="w3-text-teal">Login</h1></caption>		 -->
					<tr>
						<td colspan="4"><s:actionerror /></td>
					</tr>
					<tr height="65px">
						<td width="100px"></td>
						<td width="100px"><label
							class="w3-label w3-text-indigo w3-left"><b>Username</b></label></td>
						<td><s:textfield
								class="w3-input w3-border w3-sand w3-hover-lavender"
								placeholder="Enter Username" name="user.UserName" /></td>
						<td><s:fielderror fieldName="user.UserName" /></td>
					</tr>
					<tr height="65px">
						<td width="100px"></td>
						<td width="100px"><label
							class="w3-label w3-text-indigo w3-left"><b>Password</b></label></td>
						<td><s:password
								class="w3-input w3-border w3-sand w3-hover-lavender"
								placeholder="Enter Password" name="user.Password" /></td>
						<td><s:fielderror fieldName="user.Password" /></td>
					</tr>
					<tr height="65px">
						<td width="100px"></td>
						<td width="100px"></td>
						<td><table>
								<tr>
									<td width="50px;"></td>

									<td><s:submit
											class="w3-btn w3-hover-text-indigo w3-teal w3-center"
											value="Login" /></td>
									<td>&nbsp;&nbsp;&nbsp;</td>
									<td><s:a href="%{register}"
											class="w3-hover-text-indigo w3-btn w3-teal w3-right">Register</s:a></td>
								</tr>
							</table></td></tr>
				</table>
				<br>

				
				
				
			</fieldset>
		</div>



	</s:form>
	<br>
	<br>
	<br>
	<div class="w3-col m2 w3-text-white">.</div>
</div>

