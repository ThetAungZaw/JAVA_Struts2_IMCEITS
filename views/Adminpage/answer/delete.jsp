<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Answer Page</title>
</head>

<body>
	<div class="w3-container">
		<fieldset>
			<legend>
				<h1>
					<span class="w3-text-indigo">Delete Answer</span>
				</h1>
			</legend>



			<s:form action="answer_delete_submit" theme="simple">

				<s:hidden name="answer.AnswerID" />
				<s:hidden name="questionid"></s:hidden>
				<table>

					<tr height=" 50px">
						<td width="250px">AnswerDescription</td>
						<td><s:property
								value="answer.DetailDescription" /></td>
					</tr>

					<tr style="height: 50px;">
						<td width="250px"></td>
						<td><s:submit class="w3-btn w3-indigo w3-left"
								value="Delete" /></td>
					</tr>
					
											
					
					
				</table>

			</s:form>
		</fieldset>
		<br />


		<s:url action="back_to_answer" var="back_to_answer">
			<s:param name="questionid" value="questionid"></s:param>
		</s:url>

		<s:a href="%{back_to_answer}"
			style="text-decoration:none;color:indigo"> << Back to Answer</s:a>

	</div>
	<br/>
</body>
</html>
