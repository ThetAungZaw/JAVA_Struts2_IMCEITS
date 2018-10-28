<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">
<link rel="stylesheet" href="css/w3-theme-teal.css">
<s:url action="register" var="register"/> 
<!-- First Grid: Logo & About -->
 <div class="w3-row">
  <div class="w3-half w3-black w3-container w3-center" style="height:600px;width:618px">
    <div class="w3-padding-30 ">
      <img src="image/registerlogo.jpg" width="618px" height="600px">
    </div>
  </div>
 
  
<div class="w3-half w3-col-m4 w3-sand w3-container w3-card-4" style="height:600px;width:400px;">
  <div class="w3-container w3-center">
     <div class="w3-container w3-teal">
        <h2>Existing User</h2>
     </div>
  <form class="w3-container" >
    
    <p>      
      <label class="w3-label w3-large w3-text-teal"><b>User Name</b></label>
      <input class="w3-input w3-sand" type="text">
    </p>

    <p>      
      <label class="w3-label w3-large w3-text-teal"><b>Password</b></label>
      <input class="w3-input w3-sand" type="password">
   </p>

   <p>
      <button class="w3-btn w3-teal">Login</button>
   </p>
       

 </form> 
 </div>
 
 <!-- register  -->
 <div class="w3-container w3-sand w3-padding-15">
        <h2>New User?</h2>
     </div>
  <s:form class="w3-container w3-bordered w3-center" action="%{create_register}">
    
    
   <p>
      <button class="w3-btn w3-teal">Create Account</button>
   </p>
       

 </s:form>
 </div> 
 </div>
