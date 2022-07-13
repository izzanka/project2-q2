package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Controller.ShoeController;
import Controller.CategoryController;
import java.sql.ResultSet;
import com.google.gson.Gson;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"index.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <p id=\"p3\">Adidas</p>\n");
      out.write("             ");
 if(session.getAttribute("sessionUser") != null){ 
      out.write("\n");
      out.write("            welcome, ");
      out.print( session.getAttribute("sessionUser") );
      out.write(" |\n");
      out.write("                <a id=\"p4\" href=\"logout\"> logout</a><a id=\"p5\" href=\"cart\"> cart</a>\n");
      out.write("            ");
 }else { 
      out.write("\n");
      out.write("            <a id=\"p4\" href=\"login\">login</a><a href=\"register\" id=\"p5\">register</a>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </header>\n");
      out.write("        \n");
      out.write("        <main>\n");
      out.write("        \n");
      out.write("        <img id=\"color\" src=\"img/INI BARUAN.png\" alt=\"adiasa\">\n");
      out.write("        \n");
      out.write("        <div class=\"bestselle\">\n");
      out.write("            <div class=\"display\">\n");
      out.write("               <h1 id=\"displayNumber\">Categories</h1>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"flex-container-row\">\n");
      out.write("\n");
      out.write("                ");
 
                    CategoryController cc = new CategoryController();
                    ResultSet rs1 = cc.getAll();
                
      out.write("\n");
      out.write("\n");
      out.write("                ");
 while(rs1.next()) { 
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"buttons\">\n");
      out.write("                        <a href=\"");
      out.print( "category?id=" + rs1.getInt("id") );
      out.write('"');
      out.write('>');
      out.print( rs1.getString("name") );
      out.write("</a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"bestselle\">\n");
      out.write("            <div class=\"display\">\n");
      out.write("                <h1 id=\"displayNumber\">Best Shoe</h1>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"flex-container-row\">\n");
      out.write("                ");
 
                    ShoeController sc = new ShoeController();
                    ResultSet rs2 = sc.getAll();
                
      out.write("\n");
      out.write("                \n");
      out.write("                ");
 while(rs2.next()) { 
      out.write("\n");
      out.write("                    ");

                        Gson gson = new Gson();
                        String[] images = gson.fromJson(rs2.getString("images"), String[].class);
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"button\">\n");
      out.write("                       <img id='ho'  src=\"");
      out.print( images[0] );
      out.write("\" alt=\"adidas12\">\n");
      out.write("                       <p>");
      out.print(  rs2.getString("name") );
      out.write("</p>\n");
      out.write("                       <p>Rp");
      out.print( rs2.getInt("price") );
      out.write("</p>\n");
      out.write("                       <button><a href='");
      out.print( "detail?id=" + rs2.getInt("id") );
      out.write("'>Detail</a></button>\n");
      out.write("                    </div>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        </main>\n");
      out.write("        <footer>\n");
      out.write("            <div class=\"one\">\n");
      out.write("                <p>Adidas</p>\n");
      out.write("                <p>Lorem ipsum, dolor sit amet consectetur <br>\n");
      out.write("                    adipisicing elit. Iste, quaerat.</p>\n");
      out.write("                <a href=\"https://www.instagram.com/adidas/\"><img src=\"img/ig.png\"></a>\n");
      out.write("                <a href=\"https://www.facebook.com/adidasID/\"><img src=\"img/fb.png\"></a>\n");
      out.write("                <a href=\"https://twitter.com/adidas\"><img src=\"img/twitter.png\"></a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"two\">\n");
      out.write("                <p>Get Help</p>\n");
      out.write("                <p>About Us</p>\n");
      out.write("                <p>Contact Us</p>\n");
      out.write("                <p>Return policy</p>\n");
      out.write("                <p>Privacy Policy</p>\n");
      out.write("                <p>Payment Policy</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"three\">\n");
      out.write("                <p>About us</p>\n");
      out.write("                <p>News</p>\n");
      out.write("                <p>Service</p>\n");
      out.write("                <p>Our Policy</p>\n");
      out.write("                <p>Customer Care</p>\n");
      out.write("                <p>Faq's</p>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
