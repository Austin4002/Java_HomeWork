package web;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddPreference")
public class AddPreference extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] parameterValues = request.getParameterValues("tech");
		String schoolName = request.getParameter("schoolName");
		String major = request.getParameter("major");
		System.out.println("学校名称是:"+schoolName);
		System.out.println("专业是:"+major);
		System.out.print("掌握的技术有:");
		for (int i = 0; i < parameterValues.length; i++) {
			System.out.println(parameterValues[i]);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
