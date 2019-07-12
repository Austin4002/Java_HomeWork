package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import domain.Category;
import domain.Order;
import domain.Product;
import service.AdminService;

public class AdminServlet extends BaseServlet {
	// 获得List<Category>,并转换为json串
	public void findAllCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminService service = new AdminService();
		List<Category> categoryList = service.findAllCategory();

		Gson gson = new Gson();
		String json = gson.toJson(categoryList);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	// 查询所有的订单
	public void findAllOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminService service = new AdminService();
		List<Order> orderList = service.findAllOrder();

		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/admin/order/list.jsp").forward(request, response);
	}

	// 根据订单编号查询订单信息(多表查询)
	public void findOrderInfoByOid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");
		AdminService service = new AdminService();
		List<Map<String, Object>> OrderList = service.findOrderInfoByOid(oid);

		Gson gson = new Gson();
		String json = gson.toJson(OrderList);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
		// 传输json串到页面上，页面取值
	}

	// 商品列表
	public void productList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 传递请求到service层
		AdminService service = new AdminService();
		List<Product> productList = null;
		productList = service.findAllProduct();
		// 将productList放到request域
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}

	// 更新商品页面
	public void updateProductUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得要查询Product的pid
		String pid = request.getParameter("pid");
		// 传递pid查询商品信息
		AdminService service = new AdminService();
		Product product = service.findProductByPid(pid);
		// 获得所有的商品的类别数据
		List<Category> categoryList = service.findAllCategory();

		request.setAttribute("categoryList", categoryList);
		request.setAttribute("product", product);

		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
	}

	// 显示分类列表
	public void categoryList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminService service = new AdminService();
		List<Category> categoryList = service.findAllCategory();
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("/admin/category/list.jsp").forward(request, response);
	}

	//更新分类页面
	public void updateCategoryUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		AdminService service = new AdminService();
		Category category = service.findCategoryById(cid);
		request.setAttribute("category", category);
		request.getRequestDispatcher("/admin/category/edit.jsp").forward(request, response);
	}

	// 更新分类
	public void updateCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> map = request.getParameterMap();
		Category category = new Category();
		try {
			BeanUtils.populate(category, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		AdminService service = new AdminService();
		int i = service.updateCategory(category);
		this.categoryList(request, response);
	}

	// 删除分类
	public void delCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		AdminService service = new AdminService();
		service.delCategoryByPid(cid);
		this.categoryList(request, response);
	}

	//删除商品
	public void delProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取要删除的pid
		String pid = request.getParameter("pid");
		// 传递pid到service层
		AdminService service = new AdminService();
		service.delProductByPid(pid);
		this.productList(request,response);
	}
	
	//添加分类
	public void addCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cname = request.getParameter("cname");
		AdminService service = new AdminService();
		service.addCategory(cname);
		this.categoryList(request, response);
	}

}
