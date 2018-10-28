<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-black.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<title>SSS | Software</title>
<%@ taglib prefix="s" uri="/struts-tags"%>





<meta name="viewport" content="width=device-width, initial-scale=1">

<div class="w3-container"
	style="margin-buttom: 70px; margin-bottom: 40px;">
	<br>
	<br>
	<div class="w3-container">
		<div class="w3-row-padding">

			<s:iterator value="list">

				<s:url action="selected_language" var="selected_language">
					<s:param name="language.LanguageID" value="LanguageID"></s:param>
					<s:param name="language.LanguageName" value="LanguageName"></s:param>
					
				</s:url>

				<div>
					<div class="w3-col s3">
						<s:a href="%{selected_language}" class="w3-hover-white">
							<img class="" src=<s:property value="LogoName" />
								style="width: 100%; height: 200 px">
						</s:a>
						
							<br>
							<br>							
							<br>
							<br>
					</div>
				</div>
			

			</s:iterator>

		</div>
	</div>
	<br>
	<br>

</div>