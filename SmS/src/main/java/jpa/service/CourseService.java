package jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javassist.bytecode.Descriptor.Iterator;
import jpa.dao.CourseDao;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class CourseService implements CourseDao {
	
	public List<Course> getAllCourses() {
		
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();
    
    TypedQuery query = session.getNamedQuery("SelectAllCourses");
    
    List<Course> courses = query.getResultList();
    
    
   
    for(Course c: courses){
    	System.out.println("Course Id: " + c.getcId() +" | Course instructor : "+ c.getcInstructorName()+" | course name: "+ c.getcName());
     }
 
    
    factory.close();  
	session.close();
	return courses;
}

	@SuppressWarnings("removal")
	public Course GetCourseById(int courseId) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session = factory.openSession();
	    
	    Course course = (Course) session.get(Course.class,new Integer(courseId));
	    
	   
	    System.out.println("courseName");
	    System.out.println(course.getcName());
	   
	 	return course;
}

}