package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>login.html</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "		<form action=\"LoginServlet\" method=\"post\">\r\n"
				+ "		用户名:<input type=\"text\" name=\"username\"><br /> \r\n"
				+ "		密码:<input type=\"password\" name=\"password\"><br /> \r\n"
				+ "		<input type=\"submit\"name=\"Submit\"><br />\r\n" + "		</form>\r\n" + "</body>\r\n"
				+ "</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
