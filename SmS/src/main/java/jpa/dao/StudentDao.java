package jpa.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDao {
	
	 List<Student> getAllStudents();

	    Student getStudentByEmail(String Email) throws SQLException;

	    boolean validateStudent(String sEmail, String sPassword);

	    void registerStudentToCourse(String sEmail, int cId);

	    List<Course>getStudentCourses(String sEmail);

}
