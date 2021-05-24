package com.luv2code.web.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.sql.DataSource;

public class StudentDbUtil {
	private DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			// get a connection
			myConn = dataSource.getConnection();

			// create sql statement
			String sql = "select * from student order by last_name";
			myStmt = myConn.createStatement();
			// excute query
			myRs = myStmt.executeQuery(sql);

			// process result set

			while (myRs.next()) {
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				// create new student object
				// add it to the list of students
				students.add(new Student(id, firstName, lastName, email));
			}

			// close JDBC objects
			return students;
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}

	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close(); // does'nt really close it.. just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public void addStudent(Student theStudent) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get dc conection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert into student " + "(first_name, last_name, email)" + "values (?, ?, ?)";
			myStmt = myConn.prepareStatement(sql);
			// set the param values for the student
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());

			// execute sql insert
			myStmt.execute();

		} // close JDBC objects
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Student getStudent(String theStudentId) throws Exception {
		Student theStudent = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;
		
		try {
			// convert student id to  int
			studentId = Integer.parseInt(theStudentId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from student where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theStudentId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if(myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				theStudent = new Student(studentId, firstName, lastName, email);
			}
			else throw new Exception("Could not find student id: " + studentId);
			
			return theStudent;
		}
		finally {
			close(myConn, myStmt, myRs);
		}
		
	}

	public void updateStudent(Student theStudent) throws Exception{
		// do nothing for now...
		Connection myConn = null;
		PreparedStatement myStmt = null;
		String id = String.valueOf(theStudent.getId());
		try {
			// get dc conection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "UPDATE student "
					+ "SET first_name = ? , last_name = ?, email = ? "
					+ "WHERE id = ?";
			myStmt = myConn.prepareStatement(sql);
			// set the param values for the student
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());
			myStmt.setString(4, id);

			// execute sql insert
			myStmt.execute();

		} // close JDBC objects
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteStudent(String id) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for delete
			String sql = "DELETE from student where id = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, id);
			myStmt.execute();
		}
		finally {
			close(myConn, myStmt, null);
		}
	}
}
