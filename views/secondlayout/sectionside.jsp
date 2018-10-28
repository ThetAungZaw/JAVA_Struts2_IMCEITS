<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">
<nav
	class="w3-sidenav w3-card-4 w3-round w3-theme-l5 w3-animate-left w3-border-bottom"
	style="z-index: 3; width: 250px;" id="mySidenav">
	<a href="javascript:void(0)" onclick="w3_close()"
		class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large"
		title="close menu"> <i class="fa fa-remove"></i>
	</a>
	<h3>&nbsp;&nbsp;<s:property value="language.LanguageName"/> </h3>

		<%
			int _sectionID = 0;
			int _currentSectionID = (Integer) request.getAttribute("CurrentSectionID");
			System.out.println("_currentSectionID " + _currentSectionID);
		%>

	<s:iterator value="section_list">
		<s:url action="selected_language" var="selected_language">
			<s:param name="section.SectionID" value="SectionID"></s:param>
			<s:param name="section.SectionName" value="SectionName"></s:param>	
			<s:param name="language.LanguageID" value="language.LanguageID"></s:param>
			<s:param name="language.LanguageName" value="language.LanguageName"></s:param>	
		</s:url>
		
		<%
			_sectionID = (Integer) request.getAttribute("SectionID");	
			System.out.println("_sectionID " + _sectionID);
			if(_currentSectionID == _sectionID){
		%>
		<s:a href="%{selected_language}" class="w3-hover-black w3-black"><s:property value="SectionName"/> </s:a>
		<%
			}else{
		%>
		<s:a href="%{selected_language}" class="w3-hover-black"><s:property value="SectionName"/> </s:a>
		<%
			}
		%>
	</s:iterator>
</nav>

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