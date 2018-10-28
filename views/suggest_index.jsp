<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suggestion | Feedback</title>
<link rel="stylesheet" href="css/w3.css">
</head>
<body>


<div class="w3-container " style="margin-left:200px;margin-top:25px;margin-bottom:20px;">
<s:form action="#" theme="simple">
	<h1>Suggestion for Soft Seek Sharing System </h1>
    <span>Thank you for taking time to send your feedback or suggestions regarding about our website. :)</span>
    <br>
    <hr class="w3-clear">
    <h3>Your Suggestion or Feedback <span class="w3-text-red">*</span></h3>
    <s:textarea cols="85" rows="6" id="area1" name=""></s:textarea>
    <br>
    <br>
    <s:submit type="button" class="w3-btn w3-theme" value="Suggest"/>
    <s:reset type="button" class="w3-btn w3-theme" value="Cancel"/>
</s:form>
</div>
<script src="js/nicEdit.js" type="text/javascript"></script>
				<script type="text/javascript">
					bkLib.onDomLoaded(function() {
							new nicEditor().panelInstance('area1');
						});
				</script>
				
</body>
</html>