<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">
<link rel="stylesheet" href="css/w3-theme-teal.css">
<s:url action="masterhome" var="masterhome" />
<s:url action="answer" var="answer" />
<s:url action="comment" var="comment" />
<s:url action="language" var="language" />
<s:url action="lecture" var="lecture" />
<s:url action="post" var="post" />
<s:url action="question" var="question" />
<s:url action="section" var="section" />
<s:url action="member" var="member" />
<s:url action="suggest" var="suggest" />
<%-- <s:url action="user" var="user" /> --%>


<!-- S---------------------------------------sidenav/menu-----------------------------------------------------------------------------------u -->
<nav
	class="w3-sidenav w3-card-4 w3-collapse w3-white w3-animate-left w3-light-grey"
	style="z-index: 3; width: 250px;" id="mySidenav">
	<br>
	<div class="w3-container w3-row">
	<a href="javascript:void(0)" onclick="w3_close()"
				class="w3-margin-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large"
				title="close menu"> <i class="fa fa-remove"></i>
			</a>
		<div class="w3-col s4 ">
			 <img src="/SoftSeekSharing/upload_image/user/admin.png"
				class="w3-circle w3-margin-right" style="width: 46px">
				
				<b><hr></b>
		</div>
		
		<div class="w3-col s8">
			<span>Welcome, <strong>Admin</strong></span><br> <a href="#"
				class="w3-hover-none w3-hover-text-red w3-show-inline-block"><i
				class="fa fa-envelope"></i></a> <a href="#"
				class="w3-hover-none w3-hover-text-green w3-show-inline-block"><i
				class="fa fa-user"></i></a> <a href="#"
				class="w3-hover-none w3-hover-text-blue w3-show-inline-block"><i
				class="fa fa-cog"></i></a>
		</div>
	</div>
	<hr>
	<div class="w3-container">
		<h5>
			<span class="w3-h3" style="color: indigo">Admin Menu</span>
		</h5>
				
		
	</div>


	<%
		String _selected=(String)request.getServletContext().getAttribute("selectedLinkAdmin");
	%>	
	

<!-- 	language -->
	<%
		if(_selected == null || (_selected != null && _selected.equals("language"))){	
	%>		
	<s:a href="{language}" class="w3-padding w3-hover-indigo w3-indigo">
		<i class="fa fa-users fa-fw"></i>Language </s:a>
	<%
		}else{
	%>
	<s:a href="{language}" class="w3-padding w3-hover-indigo">
		<i class="fa fa-users fa-fw"></i>Language </s:a>
	<%
		}
	%>	
	
	
	<!-- 	section -->
	<%
		if(_selected != null && _selected.equals("section")){	
	%>		
		<s:a href="{section}" class="w3-padding w3-hover-indigo w3-indigo">
		<i class="fa fa-bank fa-fw"></i>Section</s:a>
	<%
		}else{
	%>
	<s:a href="{section}" class="w3-padding w3-hover-indigo">
		<i class="fa fa-bank fa-fw"></i>Section</s:a>
	<%
		}
	%>	
	
	<!-- 	lecture -->
	<%
		if(_selected != null && _selected.equals("lecture")){	
	%>		
		<s:a href="{lecture}" class="w3-padding w3-hover-indigo w3-indigo">
		<i class="fa fa-bullseye fa-fw"></i>Lecture</s:a>
	<%
		}else{
	%>
	<s:a href="{lecture}" class="w3-padding w3-hover-indigo">
		<i class="fa fa-bullseye fa-fw"></i>Lecture</s:a>
	<%
		}
	%>	
	
	
	<!-- 	question -->
	<%
		if(_selected != null && _selected.equals("question")){	
	%>		
		<s:a href="{question}" class="w3-padding w3-hover-indigo w3-indigo">
		<i class="fa fa-bell fa-fw"></i>Question</s:a>
	<%
		}else{
	%>
	<s:a href="{question}" class="w3-padding w3-hover-indigo">
		<i class="fa fa-bell fa-fw"></i>Question</s:a>
	<%
		}
	%>	
	
	
	<!-- 	post -->
	<%
		if(_selected != null && _selected.equals("post")){	
	%>		
		<s:a href="{post}" class="w3-padding w3-hover-indigo w3-indigo">
		<i class="fa fa-diamond fa-fw"></i>Post </s:a>
	<%
		}else{
	%>
	<s:a href="{post}" class="w3-padding w3-hover-indigo">
			<i class="fa fa-diamond fa-fw"></i>Post </s:a>
	<%
		}
	%>	
	
	
	<!-- 	suggest -->
	<%
		if(_selected != null && _selected.equals("suggest")){	
	%>		
		<s:a href="{suggest}" class="w3-padding w3-hover-indigo w3-indigo">
		<i class="fa fa-comments-o fa-fw"></i>Suggest</s:a>
	<%
		}else{
	%>
	<s:a href="{suggest}" class="w3-padding w3-hover-indigo">
		<i class="fa fa-comments-o fa-fw"></i>Suggest</s:a>
	<%
		}
	%>	
	
	
	<!-- 	member -->
	<%
		if(_selected != null && _selected.equals("member")){	
	%>	
		<s:a href="{member}" class="w3-padding w3-hover-indigo w3-indigo">
		<i class="fa fa-users fa-fw"></i>Member</s:a>
	<%
		}else{
	%>
	<s:a href="{member}" class="w3-padding w3-hover-indigo">
		<i class="fa fa-users fa-fw"></i>Member</s:a>
	<%
		}
	%>	
		
	
	
	
		
	 <s:a href="{masterhome}" class="w3-padding w3-hover-indigo" onclick="noBack">	 	
		<i class="fa fa-sign-out fa-fw"></i>Log out</s:a>							<!-- asjdfhashfdsajdfl;jasldf -->
	<%--   <s:a href="%{comment}" class="w3-padding"><i class="fa fa-cog fa-fw"></i>&nbsp; Delete</s:a><br><br> --%>
</nav>
<!-- Overlay effect when opening sidenav on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()"
	style="cursor: pointer" title="close side menu" id="myOverlay"></div>
<!-- O------------------------------------------------Open and close sctipt--------------------------------------------------------------------------t -->
<script>
	// Get the Sidenav
	var mySidenav = document.getElementById("mySidenav");

	// Get the DIV with overlay effect
	var overlayBg = document.getElementById("myOverlay");

	// Toggle between showing and hiding the sidenav, and add overlay effect
	function w3_open() {
		if (mySidenav.style.display === 'block') {
			mySidenav.style.display = 'none';
			overlayBg.style.display = "none";
		} else {
			mySidenav.style.display = 'block';
			overlayBg.style.display = "block";
		}
	}

	// Close the sidenav with the close button
	function w3_close() {
		mySidenav.style.display = "none";
		overlayBg.style.display = "none";
	}

	
</script>

<!-- /////////////////////////////////////////////////////////////////////////////////// -->

 <script type="text/javascript">

function noBack()
 {
	    window.history.forward()
 }
noBack();
window.onload = noBack;
window.onpageshow = function(evt) { if (evt.persisted) noBack() }
window.onunload = function() { void (0) }
</script> 

