package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userInfo")
public class userInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		PrintWriter writer = response.getWriter();
		writer.write("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				"<title>个人中心</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<div>首页-->个人中心</div>\r\n" + 
				"	<div>姓名:"+username+"</div>\r\n" + 
				"	<form action=\""+
				request.getContextPath()+"/preference1\" method=\"post\">\r\n" + 
				"		<button type=\"submit\">完善个人信息</button>\r\n" + 
				"		\r\n" + 
				"	</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
