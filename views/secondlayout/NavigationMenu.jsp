<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">
<link rel="stylesheet" href="css/w3-theme-teal.css">
<link rel="stylesheet" href="css/icon.css">
<script src="js/jquery.js"></script>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="masterhome" var="masterhome" />
<s:url action="htmllearn" var="htmllearn" />
<s:url action="csslearn" var="csslearn" />
<s:url action="javascriptlearn" var="javascriptlearn" />

<!-- N------------------------------------------------navbar--------------------------------------------------------------------------r -->

<ul class="w3-navbar w3-black w3-top w3-large" style="z-index: 10;">
	<li class="w3-hide-medium w3-hide-large w3-opennav w3-right"><a
		class="w3-padding-large" href="javascript:void(0)" onclick="w3_open()"
		title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a></li>
	<li class="w3-hide-small"><s:a href="%{masterhome}"
			class="w3-hover-white">
			<i class="fa fa-home w3-margin-right"></i>Home</s:a></li>
			

	<s:iterator value="language_list_user">
		<s:url action="selected_language" var="selected_language">
			<s:param name="language.LanguageID" value="LanguageID"></s:param>
			<s:param name="language.LanguageName" value="LanguageName"></s:param>						
		</s:url>

		<li class="w3-hide-small"><s:a href="%{selected_language}"
				class="w3-hover-white">
				<s:property value="LanguageName" />
			</s:a></li>

	</s:iterator>

</ul>

<!-- J------------------------------------------------Open and Close Script---------------------------------------------------------t -->
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
</script>
