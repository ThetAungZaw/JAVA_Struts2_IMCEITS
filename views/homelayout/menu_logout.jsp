<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" href="css/w3-font-awesome.min.css">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">
<link rel="stylesheet" href="css/w3-theme-teal.css">
<link rel="stylesheet" href="css/menu-li-active.css">

<script src="js/jquery.js"></script>
<s:url action="about" var="about" />
<s:url action="masterhome" var="masterhome" />
<s:url action="masterhome_logout" var="masterhome_logout" />
<s:url action="htmllearn" var="htmllearn" />
<s:url action="seek" var="seek" />
<s:url action="sharing" var="sharing" />
<s:url action="adminhome" var="adminhome" />
<s:url action="login" var="login" />
<s:url action="register" var="register" />
<s:url action="contact" var="contact" />
<s:url action="software" var="software" />
<s:url action="language" var="language" />
<!-- N----------------------------------------------navbar--------------------------------------------------------------------------------r -->

<ul class="w3-navbar w3-black w3-large menu" style="z-index: 1;">
	<li class="w3-hide-medium w3-hide-large w3-opennav w3-right"><a
		class="w3-padding-large" href="javascript:void(0)"
		onclick="myFunction()" title="Toggle Navigation Menu"><i
			class="fa fa-bars"></i></a></li>
	
	
<%
		String _selected=(String)request.getServletContext().getAttribute("selectedLink");
	%>	
	
<!-- 	HOME -->
	<%
		if(_selected != null && _selected.equals("masterhome")){	
	%>		
	<li class="w3-hide-small active"><a href="${masterhome}" class="w3-hover-white"><i class="fa fa-home w3-margin-right"></i>Home</a></li>
	<%
		}else{
	%>
	<li class="w3-hide-small"><a href="${masterhome}" class="w3-hover-white"><i class="fa fa-home w3-margin-right"></i>Home</a></li>
	<%
		}
	%>	
	


<!-- 	SOFTWARE -->
	<%
		if(_selected != null && _selected.equals("software")){	
	%>		
	<li class="w3-hide-small active"><a href="${software}" class="w3-hover-white">Software</a></li>
	<%
		}else{
	%>
	<li class="w3-hide-small"><a href="${software}" class="w3-hover-white">Software</a></li>
	<%
		}
	%>
	
			
	
<!-- 	SEEK -->
	<%
		if(_selected != null && _selected.equals("seek")){	
	%>
	<li class="w3-hide-small active"><a href="${seek}" class="w3-hover-white">Seek</a></li>
	<%
		}else{
	%>
	<li class="w3-hide-small"><a href="${seek}" class="w3-hover-white">Seek</a></li>
	<%
		}
	%>	


<!-- 	SHARING -->
	<%
		if(_selected != null && _selected.equals("sharing")){	
	%>
		<li class="w3-hide-small active"><a href="${sharing}" class="w3-hover-white">Sharing</a></li>
	<%
		}else{
	%>
	<li class="w3-hide-small"><a href="${sharing}" class="w3-hover-white">Sharing</a></li>
	<%
		}
	%>
	
	
	<li class="w3-hide-small w3-right">
	<s:a href="%{masterhome_logout}" class="w3-hover-white"
 		onclick="noBack()" value='"++"'><i class="fa fa-sign-out"></i>&nbsp;Log out</s:a></li>		 
				
		
</ul>



<!-- M---------------------------------------------------------modal-------------------------------------------------------------l -->
<div id="id01" class="w3-modal">
	<div class="w3-modal-content w3-card-6 w3-animate-top"
		style="width: 500px;">
		<header class="w3-container w3-teal">
			<span onclick="document.getElementById('id01').style.display='none'"
				class="w3-closebtn">x</span>
			<h4>Login</h4>
		</header>
		<s:form class="w3-container" action="act_login"  method="post" theme="simple">
		
			<div class="w3-center">
				<img src="/SoftSeekSharing/image/usericon.png" class="w3-circle w3-margin-top"
					width="175px" height="175px">
			</div>
			<p>
				<label class="w3-label w3-text-brown"><b>Username</b></label>
				<s:textfield class="w3-input w3-border w3-sand w3-hover-sand"
					placeholder="Enter Username" name="user.UserName" />
			</p>
			<p>
				<label class="w3-label w3-text-brown"><b>Password</b></label>
				<s:password class="w3-input w3-border w3-sand"
					placeholder="Enter Password" name="user.Password" />
			</p>
			<p>
				<s:submit class="w3-btn w3-teal w3-left" value="Login" />
				
			</p>

			<s:a href="%{register}" class="w3-hover-text-indigo w3-btn w3-teal w3-right">&nbsp;Register</s:a>
			<br/>


		</s:form>
	 <br/>
	</div>
</div>
<!-- Overlay --------------------------------------effect when opening sidenav on small------------------------------ screens -->

<div class="w3-overlay w3-hide-xlarge" onclick="w3_close()"
	style="cursor: pointer" title="close side menu" id="myOverlay"></div>

<!-- Navbar---------------------------- on small ---------------------------------------------------------------------screens -->
<div id="navDemo" class="w3-hide w3-hide-large w3-hide-medium"
	style="margin-top: 30px">
	<ul class="w3-navbar w3-left-align w3-black">
		<li class="w3-padding-large"><a href="${masterhome}"><i
				class="fa fa-home w3-margin-right"></i>Home</a></li>
		<li class="w3-padding-large"><a href="${software}">Software</a></li>
		<li class="w3-padding-large"><a href="${seek}">Seek</a></li>
		<li class="w3-padding-large"><a href="${sharing}">Sharing</a></li>
		<li class="w3-padding-large w3-right"><s:a href="%{masterhome_logout}">Logout</s:a></li>
	</ul>
</div>

<!-- Navbar--------------------------------------------------- on Open and Close------------------------------------------  Javascript-->
<script>
	// Automatic Slideshow - change image every 4 seconds
	var myIndex = 0;
	carousel();

	function carousel() {
		var i;
		var x = document.getElementsByClassName("mySlides");
		for (i = 0; i < x.length; i++) {
			x[i].style.display = "none";
		}
		myIndex++;
		if (myIndex > x.length) {
			myIndex = 1
		}
		x[myIndex - 1].style.display = "block";
		setTimeout(carousel, 4000);
	}

	// Used to toggle the menu on small screens when clicking on the menu button
	function myFunction() {
		var x = document.getElementById("navDemo");
		if (x.className.indexOf("w3-show") == -1) {
			x.className += " w3-show";
		} else {
			x.className = x.className.replace("w3-show", "");
		}
	}

	// When the user clicks anywhere outside of the modal, close it
	var modal = document.getElementById('ticketModal');
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
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





