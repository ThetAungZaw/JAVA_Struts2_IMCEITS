<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<title>SSS | Register</title>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">
<link rel="stylesheet" href="css/error-message.css">


<s:url action="save_register" var="save_register"/> 
<s:url action="masterhome" var="masterhome"/> 

<!-- First Grid: Logo & About -->




 
<s:url action="cancel" var="cancel"/> 
 
 
  
				
<div class="w3-container">
<fieldset>
			<legend>
					<span><h1 class="w3-label w3-center">Register</h1></span>
			</legend>
			
<s:form action="register_save" theme="simple" method="post"
				enctype="multipart/form-data"> 
				
<!--     <h1 class="w3-label w3-center">Register</h1> -->
   <br/>
   <div class="w3-col m4 w3-text-white">.</div>
  <div class="w3-col m4">
   
     
       <table>
        <tr>
         <td><label class="w3-label w3-text-indigo w3-left"><b>Username</b></label></td>
         <td><s:textfield class="w3-input w3-border w3-sand w3-hover-lavender" placeholder="Enter Username" name="user.UserName" /></td>
         <td><s:fielderror fieldName="user.UserName" /></td>
							
        </tr>
        
        <tr>
         <td><label class="w3-label w3-text-indigo w3-left"><b>Email</b></label></td>
         <td><s:textfield class="w3-input w3-border w3-sand w3-hover-lavender" placeholder="xxx@gmail.com" name="user.Email" /></td>
          <td><s:fielderror fieldName="user.Email" /></td>
							
        </tr>
        
        <tr>
         <td><label class="w3-label w3-text-indigo w3-left"><b>Password</b></label></td>
         <td><s:password class="w3-input w3-border w3-sand w3-hover-lavender" placeholder="Enter Password" name="user.Password"/></td>
          <td><s:fielderror fieldName="user.Password" /></td>
        </tr>
        
        <tr>
         <td><label class="w3-label w3-text-indigo w3-left"><b>Gender</b></label> </td>
         <td><s:radio class="w3-radio" list="{'Male','Female'}" value="'Male'" name="user.Gender"  /></td>
          <td><s:fielderror fieldName="user.Gender" /></td>
        </tr>
        
        <tr>
          <td><label class="w3-label w3-text-indigo w3-left"><b>Date of Birth</b></label>
          <td><s:textfield class="w3-input w3-border w3-sand w3-hover-lavender" placeholder="dd/mm/yy" name="user.DOB" /></td>
           <td><s:fielderror fieldName="user.DOB" /></td>
        </tr>
        
        <tr>
         <td><label class="w3-label w3-text-indigo w3-left"><b>Address</b></label> </td>
         <td><s:textarea class="w3-input w3-border w3-sand w3-hover-lavender" placeholder="Enter Address" name="user.Address" /></td>
          <td><s:fielderror fieldName="user.Address" /></td>
        </tr>
       
        <tr>
        <td></td>
        
        
       	<td>
       	<table>
       		<tr>
       			<td width="50px;"></td>
	       		<td><s:a href="{masterhome}" class="w3-hover-text-indigo w3-btn w3-teal w3-right">Cancel</s:a></td>
	        
		        <td>&nbsp;&nbsp;&nbsp;</td>
		        
		         <td>
		         	<s:submit type="button" class="w3-hover-text-indigo w3-btn w3-teal w3-right" value="Save" />
		         </td>
       		</tr>
       	</table>
       	</td>
         
         
         
         <td></td>
        </tr>
        
       </table>
    
    <br/>
<%--      <s:a href="%{masterhome}" class="w3-hover-text-indigo w3-right"> << Back to Home </s:a> --%>
  <br/>
  <br/>
      
  </div>
  
  <!-- for image -->
  <div class="w3-col m2">
    <img src="image/img_avatar3.png" class="w3-circle w3-margin-top" width="120px" height="120px">
       <br/><br/>
       <s:file name="uploadfile.image" accept="image/*" />
  </div>
  
</s:form>
  
  <div class="w3-col m2 w3-text-white">.</div>
  
  </fieldset>
</div>


<!-- Modal -->
<div id="id02" class="w3-modal">
    <div class="w3-modal-content w3-card-6 w3-animate-top" style="max-width:500px;">
      <header class="w3-container w3-teal"> 
        <span onclick="document.getElementById('id02').style.display='none'" class="w3-closebtn">x</span>
        <h2>Complete</h2>      
      </header>
    <div class="w3-container">
      <p>Registeration Succesfully</p>
      <p><s:form action="%{masterhome}" theme="simple"> <s:submit class="w3-btn w3-teal w3-right" value="OK"/></s:form></p>
    </div>
   <footer class="w3-container w3-teal">
      <p>Welcome from  SOFT-SEEK-SHARING SYSTEM</p>
    </footer>
  </div>
</div>
