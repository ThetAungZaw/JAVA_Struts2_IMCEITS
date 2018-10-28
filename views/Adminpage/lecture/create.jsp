<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="lecture" var="lecture" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Lecture Page</title>
<!-- Text editor  -->
	<script src="js/nicEdit.js" type="text/javascript"></script>
	<script type="text/javascript">
		bkLib.onDomLoaded(function() {
			new nicEditor().panelInstance('area3');
		});
	</script> 
<!-- try my code -->
<!-- try my code -->
<link rel="stylesheet" href="css/tryit.css" />
<link rel="stylesheet" href="css/codemirror.css" />
<link rel="stylesheet" href="css/eclipse.css" />
<link rel="stylesheet" href="css/error-message.css"/>
<link rel="stylesheet" href="css/dropdown.css"/>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/engine.js"></script>
<script type="text/javascript" src="js/codemirror.js"></script>
<script type="text/javascript" src="js/closetag.js"></script>
<script type="text/javascript" src="js/searchcursor.js"></script>
<script type="text/javascript" src="js/match-highlighter.js"></script>
<script type="text/javascript" src="js/xml.js"></script>
<script type="text/javascript" src="js/css.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript" src="js/htmlmixed.js"></script>
</head>

<body>
	<div class="w3-container">
		<fieldset>
			<legend>
				<h1>
					<span style="color: indigo">Add New Lecture</span>
				</h1>
			</legend>
			<s:form action="lecture_create_save" theme="simple">
				<table class="w3-container">

					<tr>
						<td width="250px">Language:</td>
						
						<td> 
						
							<table>
							<tr>
									<td>
									
									<s:select list="language_list" class="styled-select1"
						 				name="language.LanguageID" 
						 				listKey="LanguageID" listValue="LanguageName" 
						 				headerKey="-1" headerValue="Please select"
						 				value="%{IteratorList[#status.index].Language.{LanguageID}}"  />
						 	
						 			</td>
						 				<td>
														<s:fielderror fieldName="language.LanguageID" />	
										</td>	
								</tr>		
			 				</table>
 				
						</td>
					</tr>

					<tr style="height: 50px;">
						<td width="250px">Section:</td>
						<td>
						<table>
						<tr>
						<td>
						<s:select list="section_list" class="styled-select1"
								name="section.SectionID" listKey="SectionID"
								listValue="SectionName" headerKey="-1"
								headerValue="Please select"
								value="%{IteratorList[#status.index].Section.{SectionID}}" />
						</td>
							
							<td>
											<s:fielderror fieldName="section.SectionID" />	
							</td>	
							
							</tr>	
						</table>
						</td>
					</tr>

					<tr style="height: 50px;">
						<td width="250px">Lecture Title</td>
						<td>
							<table>
								<tr>
									<td><s:textfield name="lecture.Title" size="62"/></td>
									<td><s:fielderror fieldName="lecture.Title" /></td>		
								</tr>
							</table>
						</td>
						
						
					</tr>
					<tr style="height: 50px;">
						<td width="250px">Detail Description</td>
						
						<td><s:textarea name="lecture.DetailDescription" id="area3"
								rows="10px" cols="105px" /><br/>
								
						</td>
					<td><s:fielderror fieldName="lecture.DetailDescription"/></td>	
								
								
					</tr>
					
					
					<!-- Sample Code -->
					<tr style="height: 200px;">
						<td width="250px">Sample Code</td>
					    <td>
   							 <s:textarea class="code_input" name="lecture.SampleCode" id="code1" cols="40" rows="21"/>
    					</td>
   
   						</tr>
   						<tr class="bottomtext"><td style="text-align:left;"></td>
    					<td style="text-align:right;"><span id="statusline"></span></td>
    					</tr>
    						
					<tr class="bottomtext">
						<td style="text-align:left;"></td>
    					<td style="text-align:right;"><span id="statusline"></span></td>
   					 </tr>
					<tr style="height: 50px;">
						<td width="250px">Sort Alphabet</td>
						<td><s:textfield name="lecture.SortAlphabet" /></td>
					</tr>

					<tr style="height: 50px;">
						<td width="250px">Try YourSelf</td>
						<td><s:checkbox name="lecture.TryYourSelf" /></td>
					</tr>
					
					<tr>
						<td></td>
						<td><s:submit class="w3-btn w3-indigo w3-left" name="user" value="Create" /></td>
					</tr>
				</table>
				
			</s:form>
		</fieldset>
		<br />
		<s:a href="%{lecture}" style="text-decoration:none;color:indigo"><< Back to Lecture</s:a>
	</div>
 <br/>
</body>
</html>
