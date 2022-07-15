package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shoe_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Create new shoe</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/auth.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"form\">\n");
      out.write("                <img src=\"img/adidass.png\" alt=\"adidass\">\n");
      out.write("        <div class=\"forms\">\n");
      out.write("\n");
      out.write("        ");
 if(session.getAttribute("sessionUser") == null){ 
      out.write("\n");
      out.write("        ");
 response.sendRedirect("login"); 
      out.write("\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("        <form action=\"shoe\" method=\"post\">\n");
      out.write("            <div class=\"regisField\">\n");
      out.write("                category\n");
      out.write("                <select name=\"category\" id=\"rName\">\n");
      out.write("                    <option></option>\n");
      out.write("                </select>\n");
      out.write("                name\n");
      out.write("                <input type=\"text\" name=\"name\" id=\"rName\">\n");
      out.write("                      description\n");
      out.write("                <input type=\"text\" name=\"description\" id=\"rPassword\" >\n");
      out.write("                          price\n");
      out.write("                <input type=\"number\" name=\"price\" id=\"rPassword\" >\n");
      out.write("                          stock\n");
      out.write("                <input type=\"number\" name=\"stock\" id=\"rPassword\" >\n");
      out.write("                 size\n");
      out.write("                <input type=\"number\" name=\"size\" id=\"rPassword\" >\n");
      out.write("                                image 1\n");
      out.write("                <input type=\"text\" name=\"image1\" id=\"rPassword\" >\n");
      out.write("                                image 2\n");
      out.write("                <input type=\"text\" name=\"image2\" id=\"rPassword\" >\n");
      out.write("                image 3\n");
      out.write("                <input type=\"text\" name=\"image3\" id=\"rPassword\" >\n");
      out.write("                image 4\n");
      out.write("                <input type=\"text\" name=\"image4\" id=\"rPassword\" >\n");
      out.write("\n");
      out.write("                <button type=\"submit\" value=\"register\">Create Shoe</button><br>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        ");
 if(session.getAttribute("isEmpty") == "true"){ 
      out.write("\n");
      out.write("            all field cannot null!\n");
      out.write("        ");
 } 
            session.setAttribute("isEmpty", null);
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");
 if(session.getAttribute("isDuplicate") == "true"){ 
      out.write("\n");
      out.write("            email or name is already registered!\n");
      out.write("        ");
 } 
            session.setAttribute("isDuplicate", null);
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
