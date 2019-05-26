package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import domain.User;
import service.UserService;

public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> properties = request.getParameterMap();
		User user = new User();
		try {
			// 指定类型转换器
			ConvertUtils.register(new Converter() {
				@Override
				public Object convert(Class arg0, Object arg1) {
					// 将String转成Date
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date parse = null;
					try {
						parse = format.parse(arg1.toString());
					} catch (ParseException e) {
						e.printStackTrace();
					}

					return parse;
				}
			}, Date.class);

			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		user.setId(UUID.randomUUID().toString());
		user.setState(0);
		user.setCode(null);
		UserService service = new UserService();
		boolean IsRegisterSuccess = service.register(user);
		if (IsRegisterSuccess) {
			response.sendRedirect(request.getContextPath() + "/registerSuccess.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/registerFail.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
