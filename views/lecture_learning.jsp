<%@page import="sun.invoke.empty.Empty"%>
<%@page import="entity.Lecture"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:url action="trycode" var="trycode" />
<link rel="stylesheet" href="css/w3.css">
<html>
<head>
<title>SSS | Learning CSS</title>
<style>
#out {
	background-color: #fff;
	margin: 10px 10px 10px 10px;
	margin-left: 4px;
	border-spacing: 4px;
}

#in {
	background-color: white;
	border-spacing: 10px;
	margin: 30px 20px 30px 40px;
	padding-top: 8px;
	padding-bottom: 8px;
	padding-left: 12px;
	padding-right: 12px;
}

#externalcss_out {
	background-color: #fff;
	margin: 10px 10px 10px 10px;
	margin-left: 4px;
	border-spacing: 4px;
}

#externalcss_in {
	background-color: white;
	border-spacing: 10px;
	margin: 30px 20px 30px 40px;
	padding-top: 3px;
	padding-bottom: 8px;
	padding-left: 12px;
	padding-right: 12px;
}

#mystyle_out {
	background-color: #fff;
	margin: 10px 10px 10px 10px;
	margin-left: 4px;
	border-spacing: 4px;
}

#mystyle_in {
	background-color: white;
	border-spacing: 10px;
	margin: 30px 20px 30px 40px;
	padding-top: 8px;
	padding-bottom: 8px;
	padding-left: 12px;
	padding-right: 12px;
}

#internalcss_out {
	background-color: #fff;
	margin: 10px 10px 10px 10px;
	margin-left: 4px;
	border-spacing: 4px;
}

#internalcss_in {
	background-color: white;
	border-spacing: 10px;
	margin: 30px 20px 30px 40px;
	padding-top: 8px;
	padding-bottom: 8px;
	padding-left: 12px;
	padding-right: 12px;
}

#inline_out {
	background-color: #fff;
	margin: 10px 10px 10px 10px;
	margin-left: 4px;
	border-spacing: 4px;
}

#inline_in {
	background-color: white;
	border-spacing: 10px;
	margin: 30px 20px 30px 40px;
	padding-top: 8px;
	padding-bottom: 8px;
	padding-left: 12px;
	padding-right: 12px;
}
</style>
</head>
<body>
	<div class="w3-container">

		<h2>
			<s:property value="section.SectionName" />
		</h2>
		<hr />



		<s:iterator value="lecture_list">
			<div class="w3-container w3-color-brown">
				<h3>
					<s:property value="Title" />
				</h3>
				<p>${DetailDescription}</p>

				<%
					String _sampleCode = (String) request.getAttribute("SampleCode");
						if (_sampleCode != null && !_sampleCode.isEmpty()) {
				%>

				<div id="out" class="w3-card-4 w3-light-grey">
					<h3>&nbsp;Example</h3>
					<div id="in">

						<s:property value="SampleCode" />
					</div>



					<%
						Boolean _trycode = (Boolean) request.getAttribute("TryYourSelf");
								if (_trycode == true) {
					%>
					<s:form action="trycode" target="_blank" method="post">
						<s:hidden name="SampleCode"></s:hidden>
						<s:submit value="Try it Yourself" class="w3-btn w3-indigo"
							align="left" />
					</s:form>

					<%
						}
					%>
					<br>
				</div>




				<%
					//for sample code block //	
						}
				%>

			</div>

			<hr />
		</s:iterator>





	</div>
</body>
</html>