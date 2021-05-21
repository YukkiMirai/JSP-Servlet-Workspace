package com.luv2code.servletdemo.mvctwo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
	
	
	public static List<Student> getStudents(){
		//create an empty list
		List<Student> students = new ArrayList<>();
		
		//add sample data
		students.add(new Student("Mary","Public","mary@luv2code.com"));
		students.add(new Student("Yuuki","Mirai","mary@luv2code.com"));
		students.add(new Student("Yukki","Asuna","Yukki@bakie.com"));
		//return the list
		return students;
	}
}
