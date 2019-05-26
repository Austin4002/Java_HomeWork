package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import domain.Product;
import service.CategoryService;
import service.ProductService;

public class IndexServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CategoryService categoryService = new CategoryService();
		ProductService productService = new ProductService();

		List<Category> allCategory = categoryService.findAll();
		List<Product> topProduct = productService.findTop();

		request.setAttribute("allCategory", allCategory);
		request.setAttribute("topProduct", topProduct);

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
