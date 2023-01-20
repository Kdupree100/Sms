package jpa.service;

import org.hibernate.SessionFactory;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javassist.bytecode.Descriptor.Iterator;

import jpa.dao.StudentDao;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.StudentCourses;

public class StudentService implements StudentDao {
	
	   

public List<Student> getAllStudents() {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	  Session session = factory.openSession();

	  
  
      @SuppressWarnings("rawtypes")
      TypedQuery query = session.getNamedQuery("SelectStudents");

      @SuppressWarnings("unchecked")
      List<Student> students = query.getResultList();
      
      factory.close();
      session.close();
      

      return students;

  }
	
	@Override
	public Student getStudentByEmail(String sEmail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		  Session session = factory.openSession();
          Student student = session.find(Student.class, sEmail);
		
      
        
        factory.close();
        session.close();
        
        return student;
	}
	      
	
	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Student student = session.find(Student.class, sEmail);
		List<Course> courses = student.getsCourses(); // Courses that student has already been registered
		Course course = session.find(Course.class, cId); // Course that student wants to register
		if (!courses.contains(course)) {
			StudentCourses sc = new StudentCourses(sEmail, cId);
			session.save(sc);
			t.commit();
		}
		session.close();
		factory.close(); 	   
}

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		
		
		//Create Employee object using session.get()
        Student student = (Student) session.get(Student.class,new String(sEmail));
        
       
        
        List <Course> studentClassList = student.getsCourses();		
        	
        
        factory.close();
	    session.close();
		return studentClassList;
	}
	

	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		  Session session = factory.openSession();

//		  Transaction t = session.beginTransaction();
	  
		 Student student = (Student) session.get(Student.class,new String(sEmail));
			
	        String validPassword = student.getsPass();
	        
	        if(sPassword.equalsIgnoreCase(validPassword)) {
	        	return true;
	        }else {
	        	System.out.println("Wrong Credentials");
	        }
	        factory.close();
	        session.close();
		return false;
	
	}
	}
  	























