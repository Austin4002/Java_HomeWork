package web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import domain.Cart;
import domain.CartItem;
import domain.Category;
import domain.PageBean;
import domain.Product;
import redis.clients.jedis.Jedis;
import service.ProductService;
import utils.JedisPoolUtils;

//商品模块
public class ProductServlet extends BaseServlet {

	// 清空购物车
	public void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		// 跳转回cart.jsp
		response.sendRedirect(request.getContextPath() + "/cart.jsp");
	}

	// 删除一件商品
	public void delProFromCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product_id = request.getParameter("product_id");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			Map<String, CartItem> cartItems = cart.getCartItems();
			cart.setTotal(cart.getTotal() - cartItems.get(product_id).getSubtotal());
			cartItems.remove(product_id);
			cart.setCartItems(cartItems);
		}
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getContextPath() + "/cart.jsp");
	}

	// 添加商品到购物车
	public void addProductToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ProductService service = new ProductService();
		// 商品id
		String product_id = request.getParameter("product_id");
		// 商品的购买数量
		String buyNumStr = request.getParameter("buyNum");
		int buyNum = Integer.parseInt(buyNumStr);
		Product product = service.findProductByProductId(product_id);
		// 小计
		double subtotal = product.getProduct_price() * buyNum;
		// 封装购物项
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setBuyNum(buyNum);
		cartItem.setSubtotal(subtotal);
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		double newSubTotal = 0.0;
		Map<String, CartItem> cartItems = cart.getCartItems();
		if (cartItems.containsKey(product_id)) {
			// 根据id拿出对应的购物项
			CartItem item = cartItems.get(product_id);
			// 将之前的购买数量加上当前的购买数量
			int num = item.getBuyNum();
			num += buyNum;
			item.setBuyNum(num);
			// 小计也得改啊
			// 原先的小计
			double oldsubtotal = item.getSubtotal();
			// 新的小计
			newSubTotal = product.getProduct_price() * buyNum;
			item.setSubtotal(newSubTotal + oldsubtotal);
		} else {
			// 购物车没有该商品
			cart.getCartItems().put(product_id, cartItem);
			newSubTotal = product.getProduct_price() * buyNum;
		}
		double total = cart.getTotal() + newSubTotal;
		cart.setTotal(total);
		// 将cart放到session中
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getContextPath() + "/cart.jsp");

	}

	// 获得商品详细信息
	public void productInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product_id = request.getParameter("product_id");
		String cid = request.getParameter("cid");
		String currentPage = request.getParameter("currentPage");
		ProductService service = new ProductService();
		Product product = service.findProductByProductId(product_id);
		request.setAttribute("product", product);
		request.setAttribute("cid", cid);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("/productInfo.jsp").forward(request, response);
	}

	// 获得商品分类列表
	public void categoryList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService service = new ProductService();
		// 先从缓存中查询categoryList 如果有直接使用，没有再从数据库中查询，存到缓存中
		// 1、获得jedis对象连接redis数据库
		Jedis jedis = JedisPoolUtils.getJedis();
		String categoryListJson = jedis.get("categoryListJson");
		// 2、判断categoryListJson是否为空
		if (categoryListJson == null) {
			// 准备分类数据
			List<Category> categoryList = service.findAllCategory();
			Gson gson = new Gson();
			categoryListJson = gson.toJson(categoryList);
			jedis.set("categoryListJson", categoryListJson);
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(categoryListJson);
	}

	// 根据商品的类别获得商品的列表
	public void productList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得类别id
		String cid = request.getParameter("cid");
		// 获得当前页
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null) {
			currentPageStr = "1";
		}
		int currentPage = Integer.parseInt(currentPageStr);
		// 每页显示4条数据
		int currentCount = 4;
		ProductService service = new ProductService();
		PageBean<Product> pageBean = service.findProductListByPage(cid, currentPage, currentCount);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("cid", cid);
		request.getRequestDispatcher("/product.jsp").forward(request, response);
	}

	// 首页展示最新的商品
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService = new ProductService();
		List<Product> topProduct = productService.findTop();
		request.setAttribute("topProduct", topProduct);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
