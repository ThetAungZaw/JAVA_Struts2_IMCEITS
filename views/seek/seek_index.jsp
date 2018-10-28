<%@page import="service.DBSeek"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>SSS | Seek</title>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-teal.css">
<link rel="stylesheet" href="css/error-message.css">

<s:url action="profile_edit" var="profile_edit" />

<script src="js/nicEdit.js" type="text/javascript"></script>
<%@page import="entity.*"%>
<%@page import="action.*"%>
<script src="js/jquery.js"></script>
<style>
a {
	text-decoration: none;
}
</style>
<script type="text/javascript">
	bkLib.onDomLoaded(function() {
		new nicEditor().panelInstance('area1');
		new nicEditor().panelInstance('area2');
	});
</script>

<!-- Page Container -->
<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 25px;">
	<!-- The Grid -->
	<div class="w3-row">
		<!-- Left Column -->
		<div class="w3-col m2">
			<div>
				<div class="w3-container w3-hide-small">
					<img src="/SoftSeekSharing/image/quizicon.jpg" style="width: 150px">
					<hr class="w3-clear">
					
					
					<%
						int _languageID = 0;
						int _currentLanguageID = (Integer) request.getAttribute("currentLanguageID");
						System.out.println("currentLanguageID " + _currentLanguageID);
					%>
		
					<s:iterator value="list">
						
						<s:url id="lasId" action="select">
							<s:param name="language.LanguageID" value="LanguageID" />
							<s:param name="load_more_count">1</s:param> 			
						</s:url>
							
							
							<%
								_languageID = (Integer) request.getAttribute("LanguageID");	
								if(_currentLanguageID == _languageID){
							%>
								<s:a href="%{lasId}" class="w3-hover-text-red w3-text-red">
									<strong><s:property value="LanguageName" /></strong>
								</s:a>
							<%
								}else{
							%>
								<s:a href="%{lasId}" class="w3-hover-text-red">
									<strong><s:property value="LanguageName" /></strong>
								</s:a>
							<%
								}
							%>
						
						
						<hr class="w3-clear">
					</s:iterator>
				</div>
			</div>
			<br>
		</div>
		<%
			User _loginUser=(User)request.getServletContext().getAttribute("login_User");		
			Integer _process_QuestionID = (Integer) request.getServletContext().getAttribute("process_QuestionID");
			Long current_q_count = 0l;
			Long all_q_count = 0l;
			  all_q_count =(Long) request.getServletContext().getAttribute("all_q_count");
			 
			%>
		<!-- Middle Column -->
		<div class="w3-col m8">

			<div class="w3-row-padding">

				<div class="w3-col m12">
					<div class="w3-card-2 w3-round w3-white">

						<div class="w3-container w3-padding">

							<s:form action="saveques" theme="simple" method="post"
								enctype="multipart/form-data">
								
								<s:hidden name="language.LanguageID" />
								<s:hidden name="load_more_count"></s:hidden>
								<h4 class="w3-text-indigo"><b>Asking Question</b></h4>
								
								
									<s:textfield class="w3-input w3-animate-input"
									name="question.Title" placeholder="question title here..."
									style="width:35%" />
									 <s:fielderror fieldName="question.Title" />
								<br/>

								<s:textarea id="area1" name="question.DetailDescription"
									style="width:100%"></s:textarea>
									 <s:fielderror fieldName="question.DetailDescription" />
								<br/>
								
								<s:file name="uploadfile.image" accept="image/*" />								
								<%
if (_loginUser == null) {%>
	<button type="button" class="w3-btn w3-theme w3-right" onClick="document.getElementById('id06').style.display='block'">Ask</button>
<%} else {%>
	<s:submit type="button" class="w3-btn w3-theme w3-right"
			value="Ask" />
<%	
}
%>
							</s:form>
						
						</div>
					</div>
				</div>
			</div>
			<!-- modify for update seek -->
			
			<s:iterator value="listq">
			<%							
							Integer Qid = (Integer) request.getAttribute("QuestionID");
							current_q_count++;
					%>
					
					
				<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
					<br> <img src=<s:property value="user.ProfilePictureName"/> alt="image"
						class="w3-left w3-circle w3-margin-right" style="width: 60px">
					<span class="w3-right w3-opacity">					
					<s:property value="QuestionDate"/>
					</span>
					<h4>
						<s:property value="user.UserName" />
					</h4>

					<br>
					<h5>
					<b>
						<s:property value="Title" />
						</b>
					</h5>
					<hr class="w3-clear">
					<p>${DetailDescription}</p>
					
					<%
					String _ImageFileName = (String) request.getAttribute("ImageFileName");
						if (_ImageFileName != null && !_ImageFileName.isEmpty()) {
					%>
					
					<div class="w3-row-pFadding" style="margin: 0 -16px">
						<div class="w3-container w3-center">
							<img src=<s:property value="ImageFileName" /> style="max-width: 80%"
								alt="image" class="w3-margin-bottom">
						</div>

					</div>
					
					<%
						}
					%>
					<h5 class="w3-text-indigo"><b> Answers</b></h5>
				<hr class="w3-clear">				
					<!--  for answer area -->
					
						<s:form action="answer_save" method="post" theme="simple">
							<s:hidden name="QuestionID"/>
							<s:hidden name="language.LanguageID" />
							<s:hidden name="load_more_count"></s:hidden>
							
							<s:iterator value="list_answer">
							
							
					<%
							Integer QidOfAns = (Integer) request.getAttribute("question.QuestionID");
					/* System.out.println("Qid in seek jsp >> "+QidOfAns);
					System.out.println("Qid in external loop >> " +Qid);
					 */		if(Qid.equals(QidOfAns)){
					 %>

								<img src=<s:property value="user.ProfilePictureName"/> alt="image"
									class="w3-left w3-circle w3-margin-right" style="width: 30px">
									
								<span class="w3-right w3-opacity">
								<s:property	value="AnswerDate" /></span>
								<h4>
									<s:property value="user.UserName" />
									
									&nbsp;&nbsp;
									
									<%
									Boolean _correct = (Boolean) request.getAttribute("Correct");
										if(_correct){
									%>
									<img alt="" src="image/correct3.png">
									<%
										}
									%>
								
								</h4>
								
							
									
								<span><s:property value="DetailDescription" /></span>
								
								<hr class="w3-clear">

								 <%
				}
%> 
							</s:iterator>
						
						<%
							//for answer validation question id//
							if(Qid.equals(_process_QuestionID)){	
						%>
							<s:fielderror fieldName="answer.DetailDescription" />
						<%
							}
						%>
							
							<s:textarea style="width:100%" name="answer.DetailDescription"/>
							
							<br />
							<br />
							<%
				if (_loginUser == null) {%>	
							<span	class="w3-btn w3-medium w3-teal w3-right"
							onClick="document.getElementById('id06').style.display='block'">Answer</span>
							<%} else {%>
					<s:submit class="w3-btn w3-medium w3-teal w3-right" value="Answer" />
					<%	
						}
					%>
							
							<br>
							<hr class="w3-clear">
			</s:form>
						
					<!--end of  answer area -->

				</div>
				
			</s:iterator>
			<!-- end of modify for update seek -->


			<!-- for load more data..	 -->
			
			<s:url var="seek" action="seek">		<!-- also call to sharing action when click load more btn -->
				<s:param name="load_more_count" value="load_more_count"></s:param>
				<s:param name="language.LanguageID" value="language.LanguageID"></s:param>
			</s:url>
			
			<%if(current_q_count != all_q_count){ %>
			
			<div class="w3-center">
		
			<table>
				<tr style="width: 100%">
				<td width="370px">
				</td>
				<td class="w3-center">
				<s:a href="%{seek}"
					class="w3-btn w3-indigo w3-margin-bottom w3-round">Load More...</s:a>
				</td>
				<td width="370px">
				<span class="w3-right w3-opacity">Result &nbsp;<%=current_q_count %>/<s:label theme="simple" name="all_q_count"></s:label>&nbsp;&nbsp;&nbsp;&nbsp;</span>

				</td>
				</tr>
			
			</table>	
										
			</div>
			
			<%}else{ %>
			
			
			<div class="w3-center">
		
			<table>
				<tr style="width: 100%">
				<td width="370px">
				</td>
				<td class="w3-center">
				<span class="w3-btn w3-red w3-margin-bottom w3-round">No More Data!</span>
				</td>
				<td width="370px">
					<span class="w3-right w3-opacity">Result &nbsp;<%=current_q_count %>/<%=all_q_count %>&nbsp;&nbsp;&nbsp;&nbsp;</span>
				</td>
				</tr>
			
			</table>	
										
			</div>
		
			<%} %>
			
			<!-- End Middle Column -->
		</div>


		<!-- Right Column -->
		<div class="w3-col m2">
			<div class="w3-card-2 w3-round w3-white">

				<div class="w3-container">
					
					<h4 class="w3-center">My Profile</h4>
			<%		if (_loginUser == null) {%>
					<p class="w3-center">					
							<img src="/SoftSeekSharing/image/img_avatar3.png" class="w3-circle"
								style="max-height: 106px; max-width: 106px" alt="image">
					</p>
					<hr>
					<p>
						<i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i>
						Visitor
					</p>
			<%} else {%>
					<p class="w3-center">
						<s:a href="%{profile_edit}">
							<img src=<%= _loginUser.getProfilePictureName() %> class="w3-circle"
								style="max-height: 106px; max-width: 106px">
						</s:a>
					</p>
					<hr>
					<p>
						<i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i>
						<%= _loginUser.getUserName() %>
					</p>
		<%	
		}
		%>
			
				</div>
			</div>

			<!-- End Right Column -->
		</div>

		<!-- End Grid -->
	</div>

	<!-- End Page Container -->
</div>

<!-- .......................Modal............................ -->
<div id="id06" class="w3-modal">
    <div class="w3-modal-content w3-card-6 w3-animate-top" style="max-width:500px;">
     <header class="w3-container w3-teal"> 
        <span onclick="document.getElementById('id06').style.display='none'" class="w3-closebtn">x</span>
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

