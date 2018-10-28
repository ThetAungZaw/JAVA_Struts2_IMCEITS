<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<title>SSS | Register</title>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">

<!-- First Grid: Logo & About -->
 <div class="w3-row ">
  <div class="w3-half  w3-container w3-center" >
    <div class="w3-center">
    <img src="image/welcome.gif" width="175px" height="175px">
   </div>
  </div>
  


<!-- For Register -->

<s:form theme="simple" action="/registerform">
<center>
 <table class="tblregister" style="width:400px;">
   <tr>
    <td colspan="2" align="center"><h1><b>Registration</b></h1></td>
   </tr>
   <tr>
    <td align="center"><s:label>Email Address</s:label></td>
    <td><s:textfield class="w3-input w3-border w3-sand" name="reg.email" placeholder="Enter Email Address" /></td>
   </tr>
   <td align="center"><s:label>Create Username</s:label></td>
    <td><s:textfield class="w3-input w3-border w3-sand" name="reg.regusername" placeholder="Enter Username" /></td>
   </tr>
   <tr>
    <td align="center"><s:label>Password</s:label></td>
    <td><s:password class="w3-input w3-border w3-sand" name="reg.regpassword" placeholder="Enter Password"/></td>
   </tr>
   <tr>
    <td align="center"><s:label>Retype Password</s:label></td>
    <td><s:password class="w3-input w3-border w3-sand" name="reg.regretypepassword" placeholder="Enter Retype password" /></td>
   </tr>
   <tr>
   <td>&nbsp;</td>
   </tr>
   <tr>
    <td colspan="2" align="center"><s:submit type="button" class="w3-btn w3-purple" value="Register>>" /></td>
   </tr>
   <tr>
   <td>&nbsp;</td>
   </tr>
 </table>
 </center>
</s:form>
</div>

</div>
