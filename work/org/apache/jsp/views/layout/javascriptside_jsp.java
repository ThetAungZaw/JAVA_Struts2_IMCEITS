/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.27
 * Generated at: 2016-10-03 15:22:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class javascriptside_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("<link rel=\"stylesheet\" href=\"css/w3.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/w3-theme-black.css\">\r\n");
      out.write("  <nav class=\"w3-sidenav w3-collapse w3-theme-l5 w3-animate-left w3-border-bottom w3-border-red \" style=\"z-index:3;width:300px;\" id=\"mySidenav\">\r\n");
      out.write("  <a href=\"javascript:void(0)\" onclick=\"w3_close()\" class=\"w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large\" title=\"close menu\">\r\n");
      out.write("    <i class=\"fa fa-remove\"></i>\r\n");
      out.write("  </a>\r\n");
      out.write("\r\n");
      out.write("  <a href=\"#\" class=\"w3-hover-black\">JacaScript Home</a>\r\n");
      out.write("  <a href=\"#\" class=\"w3-hover-black\">JacaScript Introduction</a>\r\n");
      out.write("  <a href=\"#\" class=\"w3-hover-black\">JacaScript Editor</a> \r\n");
      out.write("</nav>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
