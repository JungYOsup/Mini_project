/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.82
 * Generated at: 2018-01-23 07:59:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sign_005fup_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!--- 페이지 디렉티브");
      out.write(" : JSP페이지에 대한 설정 정보를 지정 -->\r\n");
      out.write("<!--인코딩은 UTF-8이고 , html이다.  -->\r\n");
      out.write("<!--이렇게 3가지를 구성해줘야지 한글이 안깨짐  -->\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("utf-8");

      out.write('\r');
      out.write('\n');

	response.setContentType("text/html; charset=UTF-8");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- <!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> HTML4버전     -->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--HTML5로 버전을 지정해줌 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"http://code.jquery.com/jquery-latest.js\"></script>\r\n");
      out.write("\t<!-- 합쳐지고 최소화된 최신 CSS -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- 부가적인 테마 -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- 합쳐지고 최소화된 최신 자바스크립트 -->\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction check(id) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (id ==\"\") {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"span[id=sp]\").text(\"아이디를 입력해주세요.\");\r\n");
      out.write("\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\turl : \"AjaxController.do\",\r\n");
      out.write("\t\t\t\tdata : \"id=\" + id,\r\n");
      out.write("\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\tdatatype : \"json\",\r\n");
      out.write("\t\t\t\tsuccess : function name(obj) {\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t//json형태로 값이 전달받았다. 그렇기때문에 key로써 값을 찾을수 있다. \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar dto = obj[\"dto\"];\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif (dto==null) {//데이터베이스에 아이디가 없을 경우\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t$(\"span[id=sp]\").text(\"사용가능한 아이디입니다.\");\r\n");
      out.write("\t\t\t\t\t\t$(\"input[name=isS]\").val(\"Y\");\r\n");
      out.write("\t\t\t\t\t\t$(\"input[name=pw]\").focus();\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t$(\"span[id=sp]\").text(\"이미존재하는 아이디입니다.\");\r\n");
      out.write("\t\t\t\t\t\t$(\"input[name=isS]\").val(\"N\");\r\n");
      out.write("\t\t\t\t\t\t$(\"input[id=idchk]\").val(\"\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form action=\"Controller.do\" method=\"post\" class=\"form-inline\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"command\" value=\"signup\">\r\n");
      out.write("\t\t<input type=\"hidden\" value=\"N\" name=\"isS\">\r\n");
      out.write("\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td><label for=\"exampleInputName2\">아이디</label></td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"id\" id=\"idchk\" required=\"required\" ></td>\r\n");
      out.write("\t\t\t\t<td><input type=\"button\" value=\"중복확인\" onclick=\"check(idchk.value)\" ><span id=\"sp\"></span></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td>비밀번호</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"pw\" required=\"required\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td>이름</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"name\" id=\"a\" required=\"required\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td>이메일</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"email\" name=\"email\" required=\"required\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input type=\"submit\" value=\"회원등록\"/></td>\r\n");
      out.write("\t\t\t\t<td><input type=\"button\" value=\"취소\" onclick=\"location.href='Controller.do?command=loginform'\"></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
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
}
