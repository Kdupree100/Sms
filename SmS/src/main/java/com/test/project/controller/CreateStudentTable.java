package com.test.project.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Student;

public class CreateStudentTable {
   public static void main(String[] args) {
       SessionFactory factory = new Configuration().configure().buildSessionFactory();
       Session session = factory.openSession();
       Transaction t = session.beginTransaction();

       Student student = new Student();
       
      
       session.save(student);
   	 
       t.commit();
       System.out.println("successfully created user table");
       factory.close();
       session.close();
       //create proxy
   }
}




///Create User table using hibernate.