package com.luv2code.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 1: set the content type
		response.setContentType("text/html");

		// Step 2: get the printwriter
		PrintWriter out = response.getWriter(); // writer co thi step 3 ms chay dc

		// step 3: generate html
		out.println("<html><body>");
		out.println("name confirm: " 
				+ request.getParameter("firstName") + " " 	
				+ request.getParameter("lastName"));
		out.println("</br>Day la doGet");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Step 1: set the content type
				response.setContentType("text/html");

				// Step 2: get the printwriter
				PrintWriter out = response.getWriter(); // writer co thi step 3 ms chay dc

				// step 3: generate html
				out.println("<html><body>");
				out.println("name confirm: " 
						+ request.getParameter("firstName") + " " 
						+ request.getParameter("lastName"));
				out.println("</br>Day la doPost");
				out.println("</body></html>");
	}

}
