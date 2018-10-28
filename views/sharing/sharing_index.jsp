<%@page import="service.DBSharing"%>
<%@page import="action.ActSharing"%>
<%@page import="java.util.List"%>
<%@page import="entity.User"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="entity.PostingComment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>SSS | Sharing</title>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-teal.css">
<link rel="stylesheet" href="css/error-message.css">

<s:url action="profile_edit" var="profile_edit" />
<script src="js/jquery.js"></script>
<script src="js/nicEdit.js" type="text/javascript"></script>
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
			<div class="w3-container w3-hide-small">
				<img src="/SoftSeekSharing/image/worldicon.png" style="width: 150px">
				<h3>Recent Posts</h3>
				<hr class="w3-clear">
				<s:iterator value="list" begin="0" end="4">
<%-- 					<s:a href="#" class="w3-hover-text-red"> --%>
						<s:label theme="simple"  class="w3-hover-text-red">
						<strong>
							<s:property value="%{Title}" />
						</strong>
						</s:label>
<%-- 					</s:a> --%>
					<hr class="w3-clear">
				</s:iterator>

			</div>
			<!-- End Left Column -->
		</div>

		<%
			int btncomment_count = 0;
			int toggle_count = 0;
			Long current_post_count=0l;
			Long all_post_count=0l;
			User _loginUser=(User)request.getServletContext().getAttribute("login_User");
			Integer _process_PostID = (Integer) request.getServletContext().getAttribute("process_PostID");
		%>
		<!-- Middle Column -->
		<div class="w3-col m8">

			<div class="w3-row-padding">
				<s:form action="user_posting_data" theme="simple" method="post" enctype="multipart/form-data" >
				<s:hidden name="load_more"></s:hidden>
				<%-- <s:param name="load_more" value="load_more"></s:param> --%>
					<div class="w3-col m12">
						<div class="w3-card-2 w3-round w3-white">
							<div class="w3-container w3-padding">								
								<h4 class="w3-text-indigo"><b>Sharing Knowledge</b></h4>
<!-- 								<label class="w3-opacity">Post title</label> -->
								<s:textfield class="w3-input w3-animate-input"
									name="postdata.Title" placeholder="post title here..."
									style="width:35%" />
									<s:fielderror fieldName="postdata.Title" />
								<br />

								<s:textarea id="area1" name="postdata.DetailDescription"
									style="width:100%"></s:textarea>
									<s:fielderror fieldName="postdata.DetailDescription" />									
								<br />

								<s:file name="uploadfile.image" accept="image/*" />
<%
if (_loginUser == null) {%>
	<button type="button" class="w3-btn w3-theme w3-right" onClick="document.getElementById('id05').style.display='block'">Post</button>
<%} else {%>
	<s:submit type="button" class="w3-btn w3-theme w3-right"
			value="Post" />
<%	
}
%>
							
							</div>
						</div>
					</div>
				</s:form>
			</div>

			<s:iterator value="list">
			<%							
							Integer postidOfPost = (Integer) request.getAttribute("PostID");
							DBSharing dbs=new DBSharing();
							current_post_count++;
							all_post_count=dbs.FunCountAllPostList();
					%>
					
					
				<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
					<br> <img src=<s:property value="user.ProfilePictureName"/> alt="user image"
						class="w3-left w3-circle w3-margin-right" style="width: 60px">
					<span class="w3-right w3-opacity"> <%-- <s:label name="post_time" />  --%>
					<%-- <%=acts.ShowMinAgo(postidOfPost) %> --%><!-- ago -->
					<s:property value="PostingDate"/>
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
								alt="Image file" class="w3-margin-bottom">
						</div>

					</div>

					<%
						}
					%>
					
					<%
						btncomment_count++;
							toggle_count++;
					%>

					<script>
	$(document).ready(function() {
		$("#btncomment<%=btncomment_count%>").click(function() {
			$("#toggle_comment<%=toggle_count%>").toggle();
			});
		});
					</script>

					<s:form action="user_like" method="post" theme="simple">
					<s:hidden name="PostID"></s:hidden>
					<s:hidden name="load_more"></s:hidden>
				<%
				if (_loginUser == null) {%>	
					<span class="w3-btn w3-theme-d2 w3-margin-bottom" onClick="document.getElementById('id05').style.display='block'">Like</span>
									
					
				<%} else {
				
				 	Boolean f = dbs.FunDisableLike(postidOfPost, _loginUser.getUserID());
					if(f)
					{
					
					%>
					<span class="w3-btn w3-red w3-margin-bottom" >Like</span>
					
					<%
					}
					else {%>
					<s:submit class="w3-btn w3-theme-d2 w3-margin-bottom" value="Like"/>
					
					<%
					}
				}
				%>		
					<button id="btncomment<%=btncomment_count%>" type="button"
						class="w3-btn w3-theme-d2 w3-margin-bottom">
						<i class="fa fa-comment"></i> &nbsp;Comment
					</button>
					
					<span class="w3-right">
					<%= dbs.FunCountComment(postidOfPost) %>
						comments </span> <span class="w3-right"><%-- <s:label name="like_count" /> --%>
					<%= dbs.FunCountLike(postidOfPost) %> Likes &nbsp; </span>
					</s:form>	
								
					<!--  for comment box -->
					<div id="toggle_comment<%=toggle_count%>" hidden="true">
						<s:form action="user_posting_comment" method="post" theme="simple">
							<s:hidden name="PostID"></s:hidden>
							<s:hidden name="load_more"></s:hidden>
							<s:iterator value="comment_list">

					<%
							Integer postidOfComment = (Integer) request.getAttribute("postdata.PostID");
							if(postidOfPost.equals(postidOfComment)){
					 %>

								<img src=<s:property value="user.ProfilePictureName"/> alt="User Image"
									class="w3-left w3-circle w3-margin-right" style="width: 30px">
								<span class="w3-right w3-opacity">
								<s:property	value="CommentDate" /></span>
								<h4>
									<s:property value="user.UserName" />
								</h4>
								<span><s:property value="Comment" /></span>
								<hr class="w3-clear">

								 <%
				}
%> 
							</s:iterator>



						<%
							//for comment validation post id//
							if(postidOfPost.equals(_process_PostID)){	
						%>
							<s:fielderror fieldName="postingcomment.Comment" />
						<%
							}
						%>

							<s:textarea style="width:100%" name="postingcomment.Comment"></s:textarea>
							<br />
							<br />
							<%
				if (_loginUser == null) {%>	
							<span	class="w3-btn w3-medium w3-teal w3-right" value="Comment" 
							onClick="document.getElementById('id05').style.display='block'">Comment</span>
							<%} else {%>
					<s:submit action="user_posting_comment"
								class="w3-btn w3-medium w3-teal w3-right" value="Comment" />
					<%	
						}
					%>
							
							<br>
							<hr class="w3-clear">

						</s:form>
					</div>

					<!-- end of comment box -->

				</div>
			</s:iterator>


			<!-- for load more data..	 -->
			
			<s:url var="sharing" action="sharing">		<!-- also call to sharing action when click load more btn -->
				<s:param name="load_more" value="load_more"></s:param>
			</s:url>

	<%if(current_post_count != all_post_count){ %>
	
	<div class="w3-center">
		
			<table>
				<tr style="width: 100%">
				<td width="370px">
				</td>
				<td class="w3-center">
				<s:a href="%{sharing}"
					class="w3-btn w3-indigo w3-margin-bottom w3-round">Load More...</s:a>
				</td>
				<td width="370px">
				<span class="w3-right w3-opacity">Result &nbsp;<%=current_post_count %>/<%=all_post_count %>&nbsp;&nbsp;&nbsp;&nbsp;</span>

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
				<span class="w3-right w3-opacity">Result &nbsp;<%=current_post_count %>/<%=all_post_count %>&nbsp;&nbsp;&nbsp;&nbsp;</span>

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
							<img src=<%= _loginUser.getProfilePictureName() %>  class="w3-circle"
								style="max-height: 106px; max-width: 106px" >
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
<div id="id05" class="w3-modal">
    <div class="w3-modal-content w3-card-6 w3-animate-top" style="max-width:500px;">
     <header class="w3-container w3-teal"> 
        <span onclick="document.getElementById('id05').style.display='none'" class="w3-closebtn">x</span>
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



