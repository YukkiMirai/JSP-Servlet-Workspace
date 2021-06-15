package com.yukkiasuna.jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtilYukki {
	private DataSource dataSource;

	public StudentDbUtilYukki(DataSource dataSource) {

		this.dataSource = dataSource;
	}

	public List<Student> getStudents() throws Exception  {
		List<Student> students = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		// get a connection
		try {
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

	public void addStudent(Student tempStudent) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
		String sql = "Insert into student "
				+ "(first_name, last_name, email) "
				+ "values(?, ?, ?)";
		myConn = dataSource.getConnection();
		myStmt = myConn.prepareStatement(sql);
		
		myStmt.setString(1, tempStudent.getFirstName());
		myStmt.setString(2, tempStudent.getLastName());
		myStmt.setString(3, tempStudent.getEmail());
		
		myStmt.execute();
		
		}finally {
			close(myConn, myStmt, null);
		}
	}
}








