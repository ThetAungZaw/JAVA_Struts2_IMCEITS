/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.67
 * Generated at: 2016-10-24 05:22:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.homelayout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fa_0026_005fonclick_005fhref;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fa_0026_005fonclick_005fhref = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005fa_0026_005fonclick_005fhref.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/w3-font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/w3.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/w3-theme-black.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/w3-theme-teal.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/menu-li-active.css\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/jquery.js\"></script>\r\n");
      if (_jspx_meth_s_005furl_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f3(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f4(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f5(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f6(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f7(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f8(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f9(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f10(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- N----------------------------------------------navbar--------------------------------------------------------------------------------r -->\r\n");
      out.write("\r\n");
      out.write("<ul class=\"w3-navbar w3-black w3-large menu\" style=\"z-index: 1;\">\r\n");
      out.write("\t<li class=\"w3-hide-medium w3-hide-large w3-opennav w3-right\"><a\r\n");
      out.write("\t\tclass=\"w3-padding-large\" href=\"javascript:void(0)\"\r\n");
      out.write("\t\tonclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i\r\n");
      out.write("\t\t\tclass=\"fa fa-bars\"></i></a></li>\r\n");
      out.write("\t\t\r\n");
      out.write("\t");

		String _selected=(String)request.getServletContext().getAttribute("selectedLink");
	
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<!-- \tHOME -->\r\n");
      out.write("\t");

		if((_selected == null) || (_selected != null && _selected.equals("masterhome"))){	
	
      out.write("\t\t\r\n");
      out.write("\t<li class=\"w3-hide-small active\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${masterhome}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"w3-hover-white\"><i class=\"fa fa-home w3-margin-right\"></i>Home</a></li>\r\n");
      out.write("\t");

		}else{
	
      out.write("\r\n");
      out.write("\t<li class=\"w3-hide-small\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${masterhome}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"w3-hover-white\"><i class=\"fa fa-home w3-margin-right\"></i>Home</a></li>\r\n");
      out.write("\t");

		}
	
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \tSOFTWARE -->\r\n");
      out.write("\t");

		if(_selected != null && _selected.equals("software")){	
	
      out.write("\t\t\r\n");
      out.write("\t<li class=\"w3-hide-small active\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${software}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"w3-hover-white\">Software</a></li>\r\n");
      out.write("\t");

		}else{
	
      out.write("\r\n");
      out.write("\t<li class=\"w3-hide-small\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${software}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"w3-hover-white\">Software</a></li>\r\n");
      out.write("\t");

		}
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\r\n");
      out.write("<!-- \tSEEK -->\r\n");
      out.write("\t");

		if(_selected != null && _selected.equals("seek")){	
	
      out.write("\r\n");
      out.write("\t<li class=\"w3-hide-small active\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seek}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"w3-hover-white\">Seek</a></li>\r\n");
      out.write("\t");

		}else{
	
      out.write("\r\n");
      out.write("\t<li class=\"w3-hide-small\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seek}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"w3-hover-white\">Seek</a></li>\r\n");
      out.write("\t");

		}
	
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \tSHARING -->\r\n");
      out.write("\t");

		if(_selected != null && _selected.equals("sharing")){	
	
      out.write("\r\n");
      out.write("\t\t<li class=\"w3-hide-small active\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sharing}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"w3-hover-white\">Sharing</a></li>\r\n");
      out.write("\t");

		}else{
	
      out.write("\r\n");
      out.write("\t<li class=\"w3-hide-small\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sharing}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"w3-hover-white\">Sharing</a></li>\r\n");
      out.write("\t");

		}
	
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("<!-- \tLOGIN -->\r\n");
      out.write("\t");

		if(_selected != null && _selected.equals("login")){	
	
      out.write("\r\n");
      out.write("\t\t<li class=\"w3-hide-small w3-right active\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"w3-hover-white\"\r\n");
      out.write("\t\t\t><i class=\"fa fa-sign-in\"></i>&nbsp;Login</a></li>\r\n");
      out.write("\t");

		}else{
	
      out.write("\r\n");
      out.write("\t<li class=\"w3-hide-small w3-right\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"w3-hover-white\"\r\n");
      out.write("\t\t\t><i class=\"fa fa-sign-in\"></i>&nbsp;Login</a></li>\r\n");
      out.write("\t");

		}
	
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- M---------------------------------------------------------modal-------------------------------------------------------------l -->\r\n");
      out.write("<!-- <div id=\"id01\" class=\"w3-modal\"> -->\r\n");
      out.write("<!-- \t<div class=\"w3-modal-content w3-card-6 w3-animate-top\" -->\r\n");
      out.write("<!-- \t\tstyle=\"width: 500px;\"> -->\r\n");
      out.write("<!-- \t\t<header class=\"w3-container w3-teal\"> -->\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!-- \t\t\t<h4>Login</h4> -->\r\n");
      out.write("<!-- \t\t</header> -->\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("<!-- \t\t\t<div class=\"w3-center\"> -->\r\n");
      out.write("<!-- \t\t\t\t<img src= \"image/img_avatar3.png\" class=\"w3-circle w3-margin-top\" -->\r\n");
      out.write("<!-- \t\t\t\t\talt=\"image/img_avatar3.png\" width=\"175px\" height=\"175px\"> -->\r\n");
      out.write("<!-- \t\t\t</div> -->\r\n");
      out.write("<!-- \t\t\t<p> -->\r\n");
      out.write("<!-- \t\t\t\t<label class=\"w3-label w3-text-brown\"><b>Username</b></label> -->\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!-- \t\t\t</p> -->\r\n");
      out.write("<!-- \t\t\t<p> -->\r\n");
      out.write("<!-- \t\t\t\t<label class=\"w3-label w3-text-brown\"><b>Password</b></label> -->\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!-- \t\t\t</p> -->\r\n");
      out.write("<!-- \t\t\t<p> -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("<!-- \t\t\t</p> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t<br/> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \t <br/> -->\r\n");
      out.write("<!-- \t</div> -->\r\n");
      out.write("<!-- </div> -->\r\n");
      out.write("<!-- Overlay --------------------------------------effect when opening sidenav on small------------------------------ screens -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"w3-overlay w3-hide-xlarge\" onclick=\"w3_close()\"\r\n");
      out.write("\tstyle=\"cursor: pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\r\n");
      out.write("\r\n");
      out.write("<!-- Navbar---------------------------- on small ---------------------------------------------------------------------screens -->\r\n");
      out.write("<div id=\"navDemo\" class=\"w3-hide w3-hide-large w3-hide-medium\"\r\n");
      out.write("\tstyle=\"margin-top: 30px\">\r\n");
      out.write("\t<ul class=\"w3-navbar w3-left-align w3-black\">\r\n");
      out.write("\t\t<li class=\"w3-padding-large\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${masterhome}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><i\r\n");
      out.write("\t\t\t\tclass=\"fa fa-home w3-margin-right\"></i>Home</a></li>\r\n");
      out.write("\t\t<li class=\"w3-padding-large\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${software}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">Software</a></li>\r\n");
      out.write("\t\t<li class=\"w3-padding-large\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seek}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">Seek</a></li>\r\n");
      out.write("\t\t<li class=\"w3-padding-large\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sharing}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">Sharing</a></li>\r\n");
      out.write("\t\t<li class=\"w3-padding-large w3-right\">");
      if (_jspx_meth_s_005fa_005f0(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Navbar--------------------------------------------------- on Open and Close------------------------------------------  Javascript-->\r\n");
      out.write("<script>\r\n");
      out.write("\t// Automatic Slideshow - change image every 4 seconds\r\n");
      out.write("\tvar myIndex = 0;\r\n");
      out.write("\tcarousel();\r\n");
      out.write("\r\n");
      out.write("\tfunction carousel() {\r\n");
      out.write("\t\tvar i;\r\n");
      out.write("\t\tvar x = document.getElementsByClassName(\"mySlides\");\r\n");
      out.write("\t\tfor (i = 0; i < x.length; i++) {\r\n");
      out.write("\t\t\tx[i].style.display = \"none\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tmyIndex++;\r\n");
      out.write("\t\tif (myIndex > x.length) {\r\n");
      out.write("\t\t\tmyIndex = 1\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tx[myIndex - 1].style.display = \"block\";\r\n");
      out.write("\t\tsetTimeout(carousel, 4000);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t// Used to toggle the menu on small screens when clicking on the menu button\r\n");
      out.write("\tfunction myFunction() {\r\n");
      out.write("\t\tvar x = document.getElementById(\"navDemo\");\r\n");
      out.write("\t\tif (x.className.indexOf(\"w3-show\") == -1) {\r\n");
      out.write("\t\t\tx.className += \" w3-show\";\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tx.className = x.className.replace(\"w3-show\", \"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t// When the user clicks anywhere outside of the modal, close it\r\n");
      out.write("\tvar modal = document.getElementById('ticketModal');\r\n");
      out.write("\twindow.onclick = function(event) {\r\n");
      out.write("\t\tif (event.target == modal) {\r\n");
      out.write("\t\t\tmodal.style.display = \"none\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- /////////////////////////////////////////////////////////////////////////////////// -->\r\n");
      out.write("\r\n");
      out.write(" <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("function noBack()\r\n");
      out.write(" {\r\n");
      out.write("\t    window.history.forward()\r\n");
      out.write(" }\r\n");
      out.write("noBack();\r\n");
      out.write("window.onload = noBack;\r\n");
      out.write("window.onpageshow = function(evt) { if (evt.persisted) noBack() }\r\n");
      out.write("window.onunload = function() { void (0) }\r\n");
      out.write("</script> ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f0 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f0.setParent(null);
    // /views/homelayout/menu_login.jsp(13,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f0.setAction("about");
    // /views/homelayout/menu_login.jsp(13,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f0.setVar("about");
    int _jspx_eval_s_005furl_005f0 = _jspx_th_s_005furl_005f0.doStartTag();
    if (_jspx_th_s_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f1 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f1.setParent(null);
    // /views/homelayout/menu_login.jsp(14,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f1.setAction("masterhome");
    // /views/homelayout/menu_login.jsp(14,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f1.setVar("masterhome");
    int _jspx_eval_s_005furl_005f1 = _jspx_th_s_005furl_005f1.doStartTag();
    if (_jspx_th_s_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f2 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f2.setParent(null);
    // /views/homelayout/menu_login.jsp(15,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f2.setAction("htmllearn");
    // /views/homelayout/menu_login.jsp(15,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f2.setVar("htmllearn");
    int _jspx_eval_s_005furl_005f2 = _jspx_th_s_005furl_005f2.doStartTag();
    if (_jspx_th_s_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f3 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f3.setParent(null);
    // /views/homelayout/menu_login.jsp(16,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f3.setAction("seek");
    // /views/homelayout/menu_login.jsp(16,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f3.setVar("seek");
    int _jspx_eval_s_005furl_005f3 = _jspx_th_s_005furl_005f3.doStartTag();
    if (_jspx_th_s_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f4 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f4.setParent(null);
    // /views/homelayout/menu_login.jsp(17,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f4.setAction("sharing");
    // /views/homelayout/menu_login.jsp(17,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f4.setVar("sharing");
    int _jspx_eval_s_005furl_005f4 = _jspx_th_s_005furl_005f4.doStartTag();
    if (_jspx_th_s_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f5 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f5.setParent(null);
    // /views/homelayout/menu_login.jsp(18,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f5.setAction("adminhome");
    // /views/homelayout/menu_login.jsp(18,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f5.setVar("adminhome");
    int _jspx_eval_s_005furl_005f5 = _jspx_th_s_005furl_005f5.doStartTag();
    if (_jspx_th_s_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f6(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f6 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f6.setParent(null);
    // /views/homelayout/menu_login.jsp(19,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f6.setAction("login");
    // /views/homelayout/menu_login.jsp(19,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f6.setVar("login");
    int _jspx_eval_s_005furl_005f6 = _jspx_th_s_005furl_005f6.doStartTag();
    if (_jspx_th_s_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f6);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f7(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f7 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f7.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f7.setParent(null);
    // /views/homelayout/menu_login.jsp(20,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f7.setAction("register");
    // /views/homelayout/menu_login.jsp(20,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f7.setVar("register");
    int _jspx_eval_s_005furl_005f7 = _jspx_th_s_005furl_005f7.doStartTag();
    if (_jspx_th_s_005furl_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f7);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f8(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f8 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f8.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f8.setParent(null);
    // /views/homelayout/menu_login.jsp(21,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f8.setAction("contact");
    // /views/homelayout/menu_login.jsp(21,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f8.setVar("contact");
    int _jspx_eval_s_005furl_005f8 = _jspx_th_s_005furl_005f8.doStartTag();
    if (_jspx_th_s_005furl_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f8);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f9(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f9 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f9.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f9.setParent(null);
    // /views/homelayout/menu_login.jsp(22,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f9.setAction("software");
    // /views/homelayout/menu_login.jsp(22,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f9.setVar("software");
    int _jspx_eval_s_005furl_005f9 = _jspx_th_s_005furl_005f9.doStartTag();
    if (_jspx_th_s_005furl_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f9);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f10(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f10 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f10.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f10.setParent(null);
    // /views/homelayout/menu_login.jsp(23,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f10.setAction("language");
    // /views/homelayout/menu_login.jsp(23,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f10.setVar("language");
    int _jspx_eval_s_005furl_005f10 = _jspx_th_s_005furl_005f10.doStartTag();
    if (_jspx_th_s_005furl_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f10);
    return false;
  }

  private boolean _jspx_meth_s_005fa_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f0 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_0026_005fonclick_005fhref.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f0.setParent(null);
    // /views/homelayout/menu_login.jsp(169,40) name = href type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f0.setHref("#");
    // /views/homelayout/menu_login.jsp(169,40) name = onclick type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f0.setOnclick("document.getElementById('id01').style.display='block'");
    int _jspx_eval_s_005fa_005f0 = _jspx_th_s_005fa_005f0.doStartTag();
    if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f0.doInitBody();
      }
      do {
        out.write("LogIn");
        int evalDoAfterBody = _jspx_th_s_005fa_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_0026_005fonclick_005fhref.reuse(_jspx_th_s_005fa_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_0026_005fonclick_005fhref.reuse(_jspx_th_s_005fa_005f0);
    return false;
  }
}
