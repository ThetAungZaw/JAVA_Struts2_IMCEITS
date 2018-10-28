<%@taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/w3.css">
<html>
<head><title></title>
<style >

#out{
	
	background-color: #fff;
	margin: 10px 10px 10px 10px;
	margin-left: 4px;
	border-spacing: 4px;
}
#in{
	background-color: white;
	
	border-spacing: 10px;
	margin: 30px 20px 30px 40px;
	padding-top: 8px;
	padding-bottom: 8px;
	padding-left: 12px;
	padding-right: 12px;
}
#externalcss_out{
	
	background-color: #fff;
	margin: 10px 10px 10px 10px;
	margin-left: 4px;
	border-spacing: 4px;
}
#externalcss_in{
background-color: white;
	
	border-spacing: 10px;
	margin: 30px 20px 30px 40px;
	padding-top: 3px;
	padding-bottom: 8px;
	padding-left: 12px;
	padding-right: 12px;
}
#mystyle_out{
	
	background-color: #fff;
	margin: 10px 10px 10px 10px;
	margin-left: 4px;
	border-spacing: 4px;
}
#mystyle_in{
	background-color: white;
	
	border-spacing: 10px;
	margin: 30px 20px 30px 40px;
	padding-top: 8px;
	padding-bottom: 8px;
	padding-left: 12px;
	padding-right: 12px;
}
#internalcss_out{
	
	background-color: #fff;
	margin: 10px 10px 10px 10px;
	margin-left: 4px;
	border-spacing: 4px;
}
#internalcss_in{
background-color: white;
	
	border-spacing: 10px;
	margin: 30px 20px 30px 40px;
	padding-top: 8px;
	padding-bottom: 8px;
	padding-left: 12px;
	padding-right: 12px;
}
#inline_out{
	
	background-color: #fff;
	margin: 10px 10px 10px 10px;
	margin-left: 4px;
	border-spacing: 4px;
}
#inline_in{
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
<div class="w3-container" style="width:70%">

<h3>CSS Introduction</h3>
<hr/>
<div class="w3-container w3-color-brown">

<h3>What is CSS?</h3>
<ul>
<li><b>CSS</b> stands for <b>C</b>ascading <b>S</b>tyle <b>S</b>heets</li>
<li>CSS describes <b>how HTML elements are to be displayed on screen, paper, or in other media</b></li>
<li>CSS <b>saves a lot of work.</b> It can control the layout of multiple web pages all at once</li>	
<li>External stylesheets are stored in <b>CSS files</b></li>
</ul>

</div>
<hr/>
<div class="w3-container w3-color-brown">
<h3>Why Use CSS?</h3>
<p>
CSS is used to defined styles for your web pages,
including the design, layout and variations in 
display for different devices and screen sizes.
</p>
<div>
<h3>Examples in Each Chapter</h3>
This CSS tutorial contains hundreds of CSS examples.
With our online editor, you can edit the CSS, and click on a button to view the result.
</div>
<hr>
<div id="out" class="w3-card-4 w3-light-grey" >
<h3>&nbsp;CSS Example</h3>
<div id="in">

	<span style="color:brown">
	body
	<span style="color:black">{</span>
<span style="color:red">
	<br>
	&nbsp;&nbsp;&nbsp;
	background-color"
	<span style="color:mediumblue">
		<span style="color:black">:</span>
		lightblue
		<span style="color:black">;</span>
	</span>
	<br>
</span>
<span style="color:black">}</span>
<br>
<br>
h1
<span style="color:black">{</span>
	<span style="color:red">
		<br>
		&nbsp;&nbsp;&nbsp;
		color
			<span style="color:mediumblue">
				<span style="color:black">:</span>
					 White
				<span style="color:black">;</span>
			</span>
		<br>
		&nbsp;&nbsp;&nbsp;
		text-align
			<span style="color:mediumblue">
				<span style="color:black">:</span>
					 center
				<span style="color:black">;</span>
			</span>
		<br>
	</span>
		<span style="color:black">}</span>
		<br>
		<br>
		p
		<span style="color:black">{</span>
		<span style="color:red">
			<br>
			&nbsp;&nbsp;&nbsp;
			font-family
			<span style="color:mediumblue">
				<span style="color:black">:</span>
				time new roman
				<span style="color:black">;</span>
			</span>
			<br>
			&nbsp;&nbsp;&nbsp;
			font-size
			<span style="color:mediumblue">
				<span style="color:balck">:</span>
				20px
				<span style="color:black">;</span>
			</span>
			<br>
		</span>
		<span style="color:balck">}</span>
</span>
</div>
<s:submit value="Try it Yourself" class="w3-brown" align="left"/>
<br></div>

</div>

<div>
<hr>
<h2>Three way to Insert CSS</h2>
<p>There are three ways of inserting a style sheet:</p>
<ul>
<li>External style sheet</li>
<li>Internal style sheet</li>
<li>Inline style</li>
</ul>
<hr>
<h2>External Style Sheet</h2>
<p>With an external style sheet you can change the look of an entire website by chaning just one file!
</p>
<p>Each page must include a reference to the external style sheet file inside the link element. The link element goes inside the head section:
</p>
<div id="externalcss_out" class="w3-card-4 w3-light-grey">
<h3>Example</h3>
<div id="externalcss_in">
	<span style="color:brown"><
		<span style="color:mediumblue"></span>
		head
		<span style="color:mediumblue"></span>>
	</span>
	<br>
	<span style="color:brown"><
		<span style="color:mediumblue"></span>
		link
		<span style="color:red">
		rel
			<span style="color:mediumblue">="stylesheet"</span>
			type
			<span style="color:mediumblue">="text/css"</span>
			href
			<span style="color:mediumblue">="mystyle.css"</span>
		</span>
		<span style="color:brown">></span>
	</span>
	<br>
	<span style="color:brown"><
		<span style="color:mediumblue"></span>
		head
		<span style="color:mediumblue"></span>>
	</span>
	
</div>
<s:submit value="Try it Yourself" class="w3-brown" align="left"/>
<br>
<br>
</div><%--end of external css --%>

<p>An external style can be written in any text editor. The file should not contain any html tags.
The style sheet file must be saved with a .css extension.
</p>
<p>Here is how the "myStyle.css" looks:</p>
<div id="mystyle_out" class="w3-card-4 w3-light-grey">
<br>
<div id="mystyle_in">
<span style="color:brown">
	body
	<span style="color:black">{</span>
<span style="color:red">
	<br>
	&nbsp;&nbsp;&nbsp;
	background-color"
	<span style="color:mediumblue">
		<span style="color:black">:</span>
		lightblue
		<span style="color:black">;</span>
	</span>
	<br>
</span>
<span style="color:black">}</span>
<br>
<br>
h1
<span style="color:black">{</span>
	<span style="color:red">
		<br>
		&nbsp;&nbsp;&nbsp;
		color
			<span style="color:mediumblue">
				<span style="color:black">:</span>
					 White
				<span style="color:black">;</span>
			</span>
		<br>
		&nbsp;&nbsp;&nbsp;
		text-align
			<span style="color:mediumblue">
				<span style="color:black">:</span>
					 center
				<span style="color:black">;</span>
			</span>
		<br>
	</span>
		<span style="color:black">}</span>
</span>
</div>
<br>
</div>
<%--end of myStyle.css --%>
<h2>Internal Style Sheet</h2>
<p>Internal styles atr defined within the [style] elements, inside the head section of an HTML page:
</p>
<div id="internalcss_out" class="w3-card-4 w3-light-grey">
<h3>Example</h3>
<div id="internalcss_in">
<span style="color:brown"><
		<span style="color:mediumblue"></span>
		head
		<span style="color:mediumblue"></span>>
</span>
<br>
<span style="color:brown">
	<span style="color:mediumblue"></span>
</span>
<br>
<span style="color:brown"><
	<span style="color:mediumblue"></span>
	style
	<span style="color:mediumblue"></span>>
</span>
<br><br>
<span style="color:brown">
	body
	<span style="color:black">{</span>
<span style="color:red">
	<br>
	&nbsp;&nbsp;&nbsp;
	background-color"
	<span style="color:mediumblue">
		<span style="color:black">:</span>
		lightblue
		<span style="color:black">;</span>
	</span>
	<br>
</span>
<span style="color:black">}</span>
<br>
<br>
h1
<span style="color:black">{</span>
	<span style="color:red">
		<br>
		&nbsp;&nbsp;&nbsp;
		color
			<span style="color:mediumblue">
				<span style="color:black">:</span>
					 White
				<span style="color:black">;</span>
			</span>
		<br>
		&nbsp;&nbsp;&nbsp;
		text-align
			<span style="color:mediumblue">
				<span style="color:black">:</span>
					 center
				<span style="color:black">;</span>
			</span>
		<br>
	</span>
		<span style="color:black">}</span>
</span>
<br>
<span style="color:brown"><
	<span style="color:mediumblue"></span>
	/style>
</span>
<br>
<span style="color:brown"><
	<span style="color:mediumblue"></span>
	/head>
</span>
</div>
<br>
</div>
<%--end of internal style sheet --%>

<h2>Inline Style</h2>
<p>An inline style may e used to apply a unique style for a single element.</p>
<p>To use inline styles, add the style attribute to the relavant element. The style attribute can contain any CSS property.
</p>
<p>The example below shows how to change the color and the left margin of a h1 element:</p>

<div id="inline_out" class="w3-card-4 w3-light-grey">
<h3>Example</h3>
<div id=inline_in>
<span style="color:brown"><
<span style="color:mediumblue"></span>
h1
<span style="color:red">
style
	<span style="color:mediumblue">="color:blue;margin-left:30px;"</span>
	<span style="color:brown">></span>
	This is heading.
<span style="color:brown">
</span>
</span>
	
</div>
<s:form theme="simple">
<s:submit value="Try it Yourself" class="w3-brown" align="left"/>
</s:form>
<br>
</div>
<%--end of inline css --%>
</div>
</div>
</body>
</html>