<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>SSS | Home</title>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/stdtheme.css">
<s:url action="seek" var="seek"/> 
<s:url action="sharing" var="sharing"/> 
<s:url action="software" var="software"/> 
</head>
<body>
	<img src="/SoftSeekSharing/image/bubbles.png"
		style="float: right; margin-right: 50px; width: 50%; margin-top: 0px">
	<div class="w3-row" style="margin-left:70px; margin-top: 50px;">
		<div class="w3-third">
			<img src="/SoftSeekSharing/image/Computer_new.png"
				style="width: 100%">
		</div>

		<div class="w3-tow w3-margin-top">

			<div class="w3-container w3-margin-top"
				style="float: right; display: block;">
				<h2>
					<font style="font-family: cursive; font-size: 28px; font-weight: bold;">What
						is Soft Seek Sharing System</font>
				</h2>
				<p>
					&nbsp;&nbsp;<span class="w3-badge  w3-teal">1</span>&nbsp;&nbsp;The
					System is optimized for learning, code testing, and training.
				</p>
				<p>
					&nbsp;&nbsp;<span class="w3-badge  w3-teal">2</span>&nbsp;&nbsp;In
					system, user can ask question with multiple language and answer the
					question.
				</p>
				<p>
					&nbsp;&nbsp;<span class="w3-badge  w3-teal">3</span>&nbsp;&nbsp;User
					can share their knowledge in our system for software developer.
				</p>
				<br>
			</div>
		</div>
	</div>
	
	<div class="w3-container">
		<div class="w3-third w3-center">
		<a href="${software}">
			<img src="/SoftSeekSharing/image/Soft.png" style="width: 200px;"></a>
		</div>
		<div class="w3-third w3-center">
		<a href="${seek}">
			<img src="/SoftSeekSharing/image/Seek.png" style="width: 200px"></a>
		</div>
		<div class="w3-third w3-center">
		<a href="${sharing}">
			<img src="/SoftSeekSharing/image/Share.png" style="width: 200px"></a>
		</div>
	</div>
</body>
</html>