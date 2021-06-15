package com.minishop;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class MinishopController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/minishop")
	private DataSource dataSource;

	private MiniShopDbUTil miniShopDbUtil;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		miniShopDbUtil = new MiniShopDbUTil(dataSource);
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null) {
				command = "LIST";
			}
			switch (command) {
			case "LIST": {
				listProduct(request, response);
				break;
			}
			case "GETPRODUCT_byCATE": {
				categoryProduct(request, response);
				break;
			}
			case "ITEM": {
				itemProduct(request, response);
				break;
			}
			case "ADDCATE": {
				addCategory(request, response);
				break;
			}
			case "DELETECATE":{
				deleteCategory(request, response);
				break;
			}
			case "LOADCATE":{
				loadCategory(request, response);
				break;
			}
			case "UPDATECATE":{
				updateCategory(request, response);
				break;
			}
			default:
				listProduct(request, response);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theCategoryId = request.getParameter("categoryId");
		String theCategoryName = request.getParameter("categoryName");
		Category category = new Category(Integer.parseInt(theCategoryId), theCategoryName);
		miniShopDbUtil.updateCategory(category);
		listProduct(request, response);
		
	}

	private void loadCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String categoryId = request.getParameter("categoryId");
		Category tempCategory = miniShopDbUtil.getCategoryById(categoryId);
		request.setAttribute("category", tempCategory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-category-form.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theCategoryId = request.getParameter("categoryId");
		miniShopDbUtil.deleleCategory(theCategoryId);
		listProduct(request, response);
		
	}

	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
		String categoryName = request.getParameter("categoryName");
		int  categoryId= Integer.parseInt(request.getParameter("categoryId")) ;
		
		
		Category theCategory = new Category(categoryId, categoryName);
		
		miniShopDbUtil.addCategory(theCategory);
		listProduct(request, response);
		
	}

	private void itemProduct(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		String productId = request.getParameter("productId");

		Product theProduct = miniShopDbUtil.getProduct(productId);

		request.setAttribute("theProduct", theProduct);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/item.jsp");
		dispatcher.forward(request, response);
	}

	private void categoryProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String categoryId = request.getParameter("categoryId");

		List<Product> listProducts = miniShopDbUtil.getProductsByCategory(categoryId);
		// load product
		request.setAttribute("list_products", listProducts);

		// load category menu
		List<Category> listCategorys = miniShopDbUtil.getCategorys();
		request.setAttribute("list_categorys", listCategorys);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
		dispatcher.forward(request, response);
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		List<Product> listProducts = miniShopDbUtil.getProducts();
		request.setAttribute("list_products", listProducts);

		List<Category> listCategorys = miniShopDbUtil.getCategorys();
		request.setAttribute("list_categorys", listCategorys);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
