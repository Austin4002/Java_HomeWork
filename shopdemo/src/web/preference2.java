package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/preference2")
public class preference2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String schoolName = request.getParameter("schoolName");
		String major = request.getParameter("major");
		PrintWriter writer = response.getWriter();
		writer.write("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				"<title>preference2</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<div align=\"center\" >\r\n" + 
				"		<form action=\""+
				request.getContextPath()+"/AddPreference\" method=\"post\">\r\n" + 
				"		<table border=\"0\">\r\n" + 
				"		<tr>\r\n" + 
				"			<td>掌握技术</td>\r\n" + 
				"			<td>\r\n" + 
				"			<input type=\"checkbox\" name=\"tech\" value=\"android\">android\r\n" + 
				"			<input type=\"checkbox\" name=\"tech\" value=\"IOS\">IOS\r\n" + 
				"			<input type=\"checkbox\" name=\"tech\" value=\"java_web\">java web\r\n" + 
				"			<input type=\"checkbox\" name=\"tech\" value=\"c#\">c#\r\n" + 
				"			</td>\r\n" + 
				"		</tr>\r\n" +
				"		<tr>\r\n" +
				"			<td><input type=\"hidden\" name=\"schoolName\" value=\""+schoolName+"\">\r\n" +
				"		</tr>\r\n" +
				"		<tr>\r\n" +
				"			<td><input type=\"hidden\" name=\"major\" value=\""+major+"\">\r\n" +
				"		</tr>\r\n" +
				"		<tr>\r\n" + 
				"			<td colspan=\"2\"><input type=\"submit\" value=\"完成\"/></td>\r\n" + 
				"		</tr>\r\n" + 
				"		</table>\r\n" + 
				"		</form>\r\n" + 
				"	</div>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
