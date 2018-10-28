<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">
<body>
<s:url action="create_register" var="create_register"/> 
<!-- First Grid: Logo & About -->
 <div class="w3-row">
  <div class="w3-half w3-sand w3-container w3-center" style="height:600px;width:618px">
    <div class="w3-padding-30 ">
      <div class="w3-card-4 w3-center">

<div class="w3-container w3-deep-purple w3-margin-2px  " >
  <h2>Register Form</h2>
</div>
<s:form action ="%{create_register}" class="w3-container">

<p>      
<label class="w3-label w3-text-deep-purple"><b>UserName</b></label>
<input class="w3-input w3-sand" name="first" type="text"></p>

<p>      
<label class="w3-label w3-text-deep-purple"><b>Password</b></label>
<input class="w3-input w3-sand" name="pwd" type="password"></p>

<p>      
<label class="w3-label w3-text-deep-purple"><b>Email</b></label>
<input class="w3-input w3-sand" name="mail" type="text"></p>

<p>
<label class="w3-label w3-text-deep-purple"><b>Gender</b></label>
<input class="w3-radio" type="radio" name="gender" value="male" checked>
<label class="w3-text-deep-purple">Male</label>
<input class="w3-radio" type="radio" name="gender" value="female">
<label class="w3-text-deep-purple">Female</label>


<p>      
<label class="w3-label w3-text-deep-purple"><b>Date of Birth</b></label>
<input class="w3-input w3-sand" name="dob" type="text"></p>

 <p>      
<label class="w3-label w3-text-deep-purple"><b>Address</b></label>


<button class="w3-btn w3-deep-purple">Register</button>
</s:form>
</div>
</div>
</div>
</div>
</body>