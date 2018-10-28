<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="s" uri="/struts-tags"%>
<div class="w3-container">
      <div class="w3-container w3-gray">
  <h2>USER LOGIN</h2>

<form class="w3-container" action="form.asp">

<p>      
<label class="w3-label w3-text-brown"><b>First Name</b></label>
<input class="w3-input w3-border w3-sand  name="first" type="text"></p>

<p>      
<label class="w3-label w3-text-brown"><b>Password</b></label>
<input class="w3-input w3-border " name="last" type="password"></p>

<p>
<button class="w3-btn w3-brown">Login</button></p>

</form>
<s:form action="create_register">
<button class="w3-btn w3-brown">Create New Account</button>
</s:form>
</div>
</div>