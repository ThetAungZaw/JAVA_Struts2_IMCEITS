/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.67
 * Generated at: 2016-10-20 07:18:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.secondlayout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SecondMasterpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fimportAttribute_0026_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody;

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
    _005fjspx_005ftagPool_005ftiles_005fimportAttribute_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ftiles_005fimportAttribute_0026_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody.release();
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
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      if (_jspx_meth_tiles_005fimportAttribute_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_tiles_005fimportAttribute_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${masterCss}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /> \r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageCss}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\ta{text-decoration: none;}\r\n");
      out.write("</style>\r\n");
      out.write("<title>SSS | Home</title>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"image/sss.png\" type=\"imag/x-icon\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- Navbar -->\r\n");
      out.write("<div class=\"w3-container\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_tiles_005finsertAttribute_005f0(_jspx_page_context))
        return;
      out.write("\t\t\t\r\n");
      out.write("<!-- Side Navbar -->\t\t\r\n");
      out.write("<div class=\"w3-container\" style=\"margin-top:50px;\">\t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_tiles_005finsertAttribute_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</div>\t\t\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"w3-col m3 w3-round w3-text-white\">.</div>\r\n");
      out.write("  <div class=\"w3-col m9 w3-card-4\">\r\n");
      out.write("  ");
      if (_jspx_meth_tiles_005finsertAttribute_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_tiles_005fimportAttribute_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:importAttribute
    org.apache.tiles.jsp.taglib.ImportAttributeTag _jspx_th_tiles_005fimportAttribute_005f0 = (org.apache.tiles.jsp.taglib.ImportAttributeTag) _005fjspx_005ftagPool_005ftiles_005fimportAttribute_0026_005fname_005fnobody.get(org.apache.tiles.jsp.taglib.ImportAttributeTag.class);
    _jspx_th_tiles_005fimportAttribute_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fimportAttribute_005f0.setParent(null);
    // /views/secondlayout/SecondMasterpage.jsp(9,0) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fimportAttribute_005f0.setName("masterCss");
    int _jspx_eval_tiles_005fimportAttribute_005f0 = _jspx_th_tiles_005fimportAttribute_005f0.doStartTag();
    if (_jspx_th_tiles_005fimportAttribute_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fimportAttribute_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005fimportAttribute_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fimportAttribute_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005fimportAttribute_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fimportAttribute_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:importAttribute
    org.apache.tiles.jsp.taglib.ImportAttributeTag _jspx_th_tiles_005fimportAttribute_005f1 = (org.apache.tiles.jsp.taglib.ImportAttributeTag) _005fjspx_005ftagPool_005ftiles_005fimportAttribute_0026_005fname_005fnobody.get(org.apache.tiles.jsp.taglib.ImportAttributeTag.class);
    _jspx_th_tiles_005fimportAttribute_005f1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fimportAttribute_005f1.setParent(null);
    // /views/secondlayout/SecondMasterpage.jsp(10,0) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fimportAttribute_005f1.setName("pageCss");
    int _jspx_eval_tiles_005fimportAttribute_005f1 = _jspx_th_tiles_005fimportAttribute_005f1.doStartTag();
    if (_jspx_th_tiles_005fimportAttribute_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fimportAttribute_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005fimportAttribute_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fimportAttribute_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005fimportAttribute_005f1);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f0 = (org.apache.tiles.jsp.taglib.InsertAttributeTag) _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody.get(org.apache.tiles.jsp.taglib.InsertAttributeTag.class);
    _jspx_th_tiles_005finsertAttribute_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsertAttribute_005f0.setParent(null);
    // /views/secondlayout/SecondMasterpage.jsp(22,3) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f0.setName("menu");
    int _jspx_eval_tiles_005finsertAttribute_005f0 = _jspx_th_tiles_005finsertAttribute_005f0.doStartTag();
    if (_jspx_th_tiles_005finsertAttribute_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005finsertAttribute_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005finsertAttribute_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f1 = (org.apache.tiles.jsp.taglib.InsertAttributeTag) _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody.get(org.apache.tiles.jsp.taglib.InsertAttributeTag.class);
    _jspx_th_tiles_005finsertAttribute_005f1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsertAttribute_005f1.setParent(null);
    // /views/secondlayout/SecondMasterpage.jsp(25,3) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f1.setName("sideright");
    int _jspx_eval_tiles_005finsertAttribute_005f1 = _jspx_th_tiles_005finsertAttribute_005f1.doStartTag();
    if (_jspx_th_tiles_005finsertAttribute_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005finsertAttribute_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005finsertAttribute_005f1);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f2 = (org.apache.tiles.jsp.taglib.InsertAttributeTag) _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody.get(org.apache.tiles.jsp.taglib.InsertAttributeTag.class);
    _jspx_th_tiles_005finsertAttribute_005f2.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsertAttribute_005f2.setParent(null);
    // /views/secondlayout/SecondMasterpage.jsp(36,2) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f2.setName("body");
    int _jspx_eval_tiles_005finsertAttribute_005f2 = _jspx_th_tiles_005finsertAttribute_005f2.doStartTag();
    if (_jspx_th_tiles_005finsertAttribute_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005finsertAttribute_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsertAttribute_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005finsertAttribute_005f2);
    return false;
  }
}
