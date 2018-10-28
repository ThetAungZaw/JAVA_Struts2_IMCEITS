<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<s:url action="about" var="about"/> 
<s:url action="contact" var="contact"/> 
<s:url action="user_suggest" var="user_suggest"/> 
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-teal.css">


<%-- <s:form action="trycode" target="_blank"> --%>
<%-- <s:submit value="Try it Yourself" class="w3-btn w3-indigo" align="left" /> --%>
<%-- </s:form> --%>

  
 <footer class="w3-container w3-center w3-teal ">
  <h4>Follow Us</h4>
  <a class="w3-btn-floating w3-teal" href="https://www.facebook.com/" title="Facebook" target="_blank"><i class="fa fa-facebook"></i></a>
  <a class="w3-btn-floating w3-teal" href="https://www.twitter.com/" title="Twitter" target="_blank"><i class="fa fa-twitter"></i></a>
  <a class="w3-btn-floating w3-teal" href="https://www.google.com/" title="Google +" target="_blank"><i class="fa fa-google-plus"></i></a>
  <a class="w3-btn-floating w3-teal" href="https://www.linkedin.com/" title="Linkedin" target="_blank"><i class="fa fa-linkedin"></i></a>
  

  <div class="w3-large">
	  <s:a href="%{about}" class="w3-hover-text-red">About Us</s:a> &nbsp; &nbsp;
	  <s:a href="%{contact}" class=" w3-hover-text-red">Contact Us</s:a> &nbsp; &nbsp;
	  <s:a href="%{user_suggest}" class="w3-hover-text-red">Suggestion</s:a>
	   
  </div>
  <p>Powered by Group 2, IMCEITS</p>

  <div style="position:relative;bottom:100px;z-index:1;" class="w3-tooltip w3-right">
    <span class="w3-text w3-padding w3-teal w3-hide-small">Go To Top</span>   
    <a class="w3-btn w3-theme" href="#"><span class="w3-xlarge">
    <i class="fa fa-chevron-circle-up"></i></span></a>
  </div>
</footer>