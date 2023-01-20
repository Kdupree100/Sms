package Scholas.SmS;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class App {
	public static void main(String[] args)

	{

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		// creating student and course objects
		Course course1 = new Course(1, "English", "Andrea Scamaden");
		Course course2 = new Course(2, "Mathematics", "Eustace Niemetz");
		Course course3 = new Course(3, "Anatomy", "Reynolds Pastor");
		Course course4 = new Course(4, "Organic Chemistry", "Odessa Belcher");
		Course course5 = new Course(5, "Physics", "Dani Swallow");
		Course course6 = new Course(6, "Digital Logic", "Glenden Reilingen");
		Course course7 = new Course(7, "Object Oriented Programming", "Giselle Ardy");
		Course course8 = new Course(8, "Data Structures", "Carolan Stoller");
		Course course9 = new Course(9, "Politics", "Carmita De Maine");
		Course course10 = new Course(10, "Art", "Kingsly Doxsey");

	//	Student student1 = new Student("1hluckham0@google.ru ", "Hazel Luckham", "X1uZcoIh0dj");
	//	Student student2 = new Student("sbowden1@yellowbook.com", "Sonnnie Bowden", "SJc4aWSU");
	//	Student student3 = new Student("qllorens2@howstuffworks.com", "Quillan Llorens", "W6rJuxd");
	//	Student student4 = new Student("cstartin3@flickr.com", "Clem Startin", "XYHzJ1S");
	//	Student student5 = new Student("tattwool4@biglobe.ne.jp", "Thornie Attwool", "Hjt0SoVmuBz");
	//	Student student6 = new Student("hguerre5@deviantart.com", "Harcourt Guerre", "OzcxzD1PGs");
	//	Student student7 = new Student("htaffley6@columbia.edu", "Holmes Taffley", "xowtOQ");
	//	Student student8 = new Student("aiannitti7@is.gd", "Alexandra Iannitti", "TWP4hf5j");
	//	Student student9 = new Student("ljiroudek8@sitemeter.com", "Laryssa Jiroudek", "bXRoLUP");
	//	Student student10 = new Student("cjaulme9@bing.com", "Cahra Jaulme", "FnVklVgC6r6");

		session.save(course1);
		session.save(course2);
		session.save(course3);
		session.save(course4);
		session.save(course5);
		session.save(course6);
		session.save(course7);
		session.save(course8);
		session.save(course9);
		session.save(course10);

	//	session.save(student1);
	//	session.save(student2);
	//	session.save(student3);
	//	session.save(student4);
	//	session.save(student5);
	//	session.save(student6);
	//	session.save(student7);
	//	session.save(student8);
	//	session.save(student9);
	//	session.save(student10);
		factory.close();
		session.close();
		//Student student1 = new Student();
		// student1.getStudentByEmail(String Email)();
		t.commit();
	}
}
