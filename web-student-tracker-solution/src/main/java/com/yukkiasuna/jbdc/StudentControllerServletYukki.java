package com.yukkiasuna.jbdc;

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
 * Servlet implementation class StudentControllerServletYukki
 */
@WebServlet("/StudentControllerServletYukki")
public class StudentControllerServletYukki extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtilYukki studentDbUtilYukki;

	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentControllerServletYukki() {

		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		studentDbUtilYukki = new StudentDbUtilYukki(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String thecommand = request.getParameter("command");
			if (thecommand == null) {
				thecommand = "LIST";
			}

			switch (thecommand) {
			case "LIST": {
				listStudents(request, response);
				break;
			}
			case "ADD": {
				addStudent(request, response);
				break;
			}
			default:
				listStudents(request, response);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Student tempStudent = new Student(firstName, lastName, email);
		studentDbUtilYukki.addStudent(tempStudent);
		listStudents(request, response);		
		
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Student> students = studentDbUtilYukki.getStudents();

		request.setAttribute("LIST_STUDENTS", students);
		RequestDispatcher dispacher = request.getRequestDispatcher("/list-students.jsp");
		dispacher.forward(request, response);

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
