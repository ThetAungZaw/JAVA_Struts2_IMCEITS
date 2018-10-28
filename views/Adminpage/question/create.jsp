<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="question" var="question" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/w3.css"/>
<link rel="stylesheet" href="css/error-message.css"/>
<link rel="stylesheet" href="css/dropdown.css"/>

<title>Question Creation</title>
</head>
<body>
	<div class="w3-container">
		<fieldset>
			<legend>
				<h1>
					<span class="w3-text-indigo">Ask New Question</span>
				</h1>
			</legend>

			<s:form action="question_create_submit" theme="simple" method="post"
				enctype="multipart/form-data">
				<table class="w3-container">
				
				<tr>
						<td width="250px">Select a Language:</td>
						<td>
						
								<table>
										<tr>
											<td>
											<s:select list="language_list" class="styled-select1"
													name="language.LanguageID"
													listKey="LanguageID" listValue="LanguageName"
													headerKey="-1" headerValue="Please select"
													value="%{IteratorList[#status.index].Language.{LanguageID}}" />
											</td>
											<td>
												<s:fielderror fieldName="language.LanguageID" />	
											</td>	
										</tr>
								</table>
						
						</td>
						
					</tr>
					
					
					<tr height=" 50px" >
						<td width="250px">Question Title</td>
						<td><s:textfield name="question.Title" size="62" /></td>
						<td><s:fielderror fieldName="question.Title" /></td>
												
					</tr>
					<tr height=" 50px">
						<td width="250px">Detail Description</td>
						<td><s:textarea name="question.DetailDescription" id="area3" rows="5px" cols="60px"/></td>
<%-- 						<td><s:fielderror fieldName="question.DetailDescription" /></td> --%>
					</tr>
					
					<tr height=" 50px">
						<td width="250px">Image File Name</td>
						<td><s:file name="uploadfile.image" accept="image/*" /></td>
					</tr>
					<tr height=" 50px">
						<td width="250px"></td>
						<td><s:submit class="w3-btn w3-indigo w3-left"
								name="question_create" value="Create" /></td>
					</tr>

				</table>
				<br>
			</s:form>
		</fieldset>
		<br>
		<s:a href="%{question}" style="text-decoration:none; color:indigo;"> << Back to Question</s:a>

	</div>
	<br>
	<!-- Text Editor -->
	<script src="js/nicEdit.js" type="text/javascript"></script>
	<script type="text/javascript">bkLib.onDomLoaded(function(){new nicEditor().panelInstance('area3');});</script>
</body>
</html>