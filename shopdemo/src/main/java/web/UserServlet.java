package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import domain.User;
import service.UserService;

public class UserServlet extends BaseServlet {
	
	//用户登录
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,String> map = request.getParameterMap();
		HttpSession session = request.getSession();
		User user=new User();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		UserService service=new UserService();
		User u=service.login(user);
		if(u!=null) {
			session.setAttribute("loginUser",u);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			request.setAttribute("msg","用户名或密码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	//用户注册
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,String[]> parameterMap = request.getParameterMap();
		User user=new User();
		try {
			/*ConvertUtils.register(new Converter() {
				
				@Override
				public Object convert(Class type, Object value) {
					// TODO Auto-generated method stub
					SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
					Date parse=null;
					try {
						parse = format.parse(value.toString());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return parse;
				}
			},Date.class);*/
			BeanUtils.populate(user,parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		user.setId((UUID.randomUUID().toString()));
		UserService service=new UserService();
		boolean ifRegisterSucces=service.register(user);
		if(ifRegisterSucces) {
			response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/registerFail.jsp");

		}
	}
}
