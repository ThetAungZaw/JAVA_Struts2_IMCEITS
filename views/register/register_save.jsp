<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<title>SSS | Register</title>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">
<s:url action="edit_register" var="edit_register"/> 

<div class="w3-container w3-card-8 w3-sand " style="margin-left:300px;margin-top:50px;margin-bottom:20px; width:700px;">
    <div class="w3-container s9 w3-padding-10 " >
      <s:form action="{edit_register}" theme="simple">
       <table class="w3-table w3-bordered w3-striped w3-border w3-hoverable">
        <tr>
         <td colspan="2" ><h1 class="w3-label w3-center "><b>Your info</b></h1></td>
        </tr>
        <tr>
         <td><s:label class="w3-label w3-text-indigo w3-center">Username</s:label>
         <td><s:label class="w3-label w3-text-indigo w3-center">Ma Ma</s:label>
        </tr>
        <tr>
         <td><s:label class="w3-label w3-text-indigo w3-center">Email</s:label>
         <td><s:label class="w3-label w3-text-indigo w3-center">mama@gmail.com</s:label>
        </tr>
        <tr>
         <td><s:label class="w3-label w3-text-indigo w3-center">Password</s:label>
         <td><s:label class="w3-label w3-text-indigo w3-center">123</s:label>
        </tr>
        <tr>
         <td><s:label class="w3-label w3-text-indigo w3-center">Confirm Password</s:label>
         <td><s:label class="w3-label w3-text-indigo w3-center">123</s:label>
        </tr>
        <tr>
         <td><s:label class="w3-label w3-text-indigo w3-center">Gender</s:label>
         <td><s:label class="w3-label w3-text-indigo w3-center">Female</s:label>
        </tr>
        <tr>
         <td><s:label class="w3-label w3-text-indigo w3-center">Date of Birth</s:label>
         <td><s:label class="w3-label w3-text-indigo w3-center">7/7/90</s:label>
        </tr>
        <tr>
         <td><s:label class="w3-label w3-text-indigo w3-center">Address</s:label>
         <td><s:label class="w3-label w3-text-indigo w3-center">No.1,Sin G, Tamine Township , Yangon</s:label>
        </tr>
        <tr>
         <td><s:label class="w3-label w3-text-indigo w3-center">Phone</s:label>
         <td><s:label class="w3-label w3-text-indigo w3-center">0943217889</s:label>
        </tr>
       
       </table>
      </s:form>
      </div>
      <div class="w3-right">
       <s:a href="%{edit_register}" class="w3-btn w3-teal w3-right"> Wanna Edit Info</s:a>
      </div>
      
 </div>