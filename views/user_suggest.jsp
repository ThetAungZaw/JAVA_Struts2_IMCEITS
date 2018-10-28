<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="entity.User" %>
<link rel="stylesheet" href="css/error-message.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SSS | Suggestion</title>
<link rel="stylesheet" href="css/w3.css">
</head>
<body>

 <% User us=(User) request.getServletContext().getAttribute("login_User"); 
	System.out.println("Login user in user_seggest jsp >>>>>>>> "+ us);
%>


<div class="w3-content" style="max-width:700px">
<s:form action="user_suggest_submit" theme="simple">
	<h1>Suggestion for Soft Seek Sharing System </h1>
    <span>Thank you for taking time to send your feedback or suggestions regarding about our website. :)</span>
    <br>
    <hr class="w3-clear">
    <h3>Your Suggestion or Feedback </h3>
    <s:textarea rows="6" id="area1" name="suggestion.DetailDescription" style="width:100%;"></s:textarea>
    <% String _suggest = (String) request.getServletContext().getAttribute("suggestion.DetailDescription"); 
       if(_suggest == null || _suggest.equals(""))
       {%>
       <s:fielderror fieldName="suggestion.DetailDescription"/>
       <%} %>
    <br>
    <br>
    
    <% if(us==null){ %>
    	<button type="button" class="w3-btn w3-theme" onClick="document.getElementById('id03').style.display='block'">Suggest</button>
    <%}else{ %>
    <button type="button" class="w3-btn w3-theme" onClick="document.getElementById('id04').style.display='block'">Suggest</button>        
    <%} %>
<br/>
<br/>
</div>
<%-- <script src="js/nicEdit.js" type="text/javascript"></script>
				<script type="text/javascript">
					bkLib.onDomLoaded(function() {
							new nicEditor().panelInstance('area1');
						});
				</script> --%>
			

 <!-- Modal -->	
 <div id="id04" class="w3-modal">
    <div class="w3-modal-content w3-card-6 w3-animate-top" style="max-width:500px;">
      <header class="w3-container w3-teal"> 
        <span onclick="document.getElementById('id04').style.display='none'" class="w3-closebtn">x</span>
        <h2>Suggestion</h2>      
      </header>
    <div class="w3-container">
      <p>Are you sure you want to suggest ?</p>
      <span><s:submit class="w3-btn w3-teal w3-right" value="OK"/></s:form>
      <button onclick="document.getElementById('id04').style.display='none'" class="w3-btn w3-teal w3-right" style="margin-right: 15px">Cancel</button></span>
       
    </div>
   <footer class="w3-container w3-teal">
      <p>SOFT-SEEK-SHARING SYSTEM</p>
    </footer>
  </div>
</div>
						
<div id="id03" class="w3-modal">
    <div class="w3-modal-content w3-card-6 w3-animate-top" style="max-width:500px;">
     <header class="w3-container w3-teal"> 
        <span onclick="document.getElementById('id03').style.display='none'" class="w3-closebtn">x</span>
        <h2>Warning</h2>      
      </header>
    <div class="w3-container">
      <p>You must login first !!!</p>
      <br>
    </div>
   <footer class="w3-container w3-teal">
      <p>SOFT-SEEK-SHARING SYSTEM</p>
    </footer>
  </div>
</div>
	
</body>
</html>