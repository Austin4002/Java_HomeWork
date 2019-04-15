package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/preference1")
public class preference1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				"<title>preference1</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<div align=\"center\" >\r\n" + 
				"		<form action=\""+
				request.getContextPath()+"/preference2\" method=\"post\">\r\n" + 
				"		<table border=\"0\">\r\n" + 
				"		<tr>\r\n" + 
				"			<td>学校名称:</td>\r\n" + 
				"			<td><input type=\"text\" name = \"schoolName\" /></td>\r\n" + 
				"		<tr>\r\n" + 
				"			<td>专业方向:</td>\r\n" + 
				"			<td>\r\n" + 
				"				<select name=\"major\">\r\n" + 
				"					<option value=\"bigData\">大数据</option>\r\n" + 
				"					<option value=\"financial\">金融软件开发</option>\r\n" + 
				"					<option value=\"mobile\">移动软件开发</option>\r\n" + 
				"					<option value=\"outstanding\" selected=\"selected\">卓越班</option>\r\n" + 
				"				</select>\r\n" + 
				"			</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td colspan=\"2\"><input type=\"submit\" value=\"下一步\"/></td>\r\n" + 
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
