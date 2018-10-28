<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- try my code -->
<link rel="stylesheet" href="css/tryit.css" />
<link rel="stylesheet" href="css/codemirror.css" />
<link rel="stylesheet" href="css/eclipse.css" />
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
	<table class="maintable" summary="UI">
		<tr>
			<td><button style="margin-bottom: 5px;" id="submit"
					onclick="startit()" accesskey="x">Try Yourself >></button></td>
			<td><div class="centered">
					<span id="titletext">(Title should appear here)</span>
				</div></td>
		</tr>
		<tr>
			<s:form theme="simple">

				<td style="width: 50%;"><textarea class="code_input" id="code1"
						cols="40" rows="21"><s:property value="SampleCode" /> </textarea>
				</td>
			</s:form>

			<td><iframe class="result_output" id="view" name="view"
					src="javascript:''" style="frameborder: 0; height: 480px">Sorry,
					you need iframes to use Try My Code .</iframe></td>
		</tr>
		<tr class="bottomtext">
			<td style="text-align: left;">Edit the code above and click the
				button to see the result.</td>
			<td style="text-align: right;">Status: ready <span
				id="statusline">loading...</span></td>
		</tr>
	</table>
	<br />
	<div id="everythingElse"
		style="font-family: calibri, verdana, ms sans serif"></div>
</body>
</html>