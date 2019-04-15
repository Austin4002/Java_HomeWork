package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/guide")
public class guide extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		PrintWriter writer = response.getWriter();
		writer.write("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				"<title>导航</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<div>欢迎"+username+"</div>\r\n" + 
				"	<div>\r\n" + 
				"		<a href=\""+
				request.getContextPath()+"/index\" >首页</a>\r\n" + 
				"		<a href=\""+
				request.getContextPath()+"/userInfo\" >个人中心</a>\r\n" + 
				"	</div>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
