package autoLogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AutoLogin")
public class AutoLogin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("autoLogin");
		Cookie[] cookies = request.getCookies();
		if(autoLogin!=null) {
			Cookie cookie = new Cookie("user", username+"@"+password);
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);
		}
		
		if(cookies!=null && autoLogin!=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("user")) {
					String user = cookie.getValue();
					String[] split = user.split("@");
					String uname = split[0];
					String pwd = split[1];
					if(uname.equals("Austin")&& pwd.equals("123456")) {
						request.getRequestDispatcher("/success.jsp").forward(request, response);
					}
				}
			}
		}else {
			if(username.equals("Austin") && password.equals("123456")) {
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
