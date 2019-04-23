package count;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Count")
public class Count extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int count ;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("count")){
					String value = cookie.getValue();
					count = Integer.parseInt(value);
					count++;
					Cookie newCookie= new Cookie("count", count+"");
					response.addCookie(newCookie);
					PrintWriter writer = response.getWriter();
					writer.write("这是您第"+count+"次访问");
				}
			}
		}else {
			count = 1;
			Cookie cookie = new Cookie("count", count+"");
			response.addCookie(cookie);
			PrintWriter writer = response.getWriter();
			writer.write("这是您第"+count+"次访问");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
