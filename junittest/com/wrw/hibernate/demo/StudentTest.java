package com.wrw.hibernate.demo;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.wrw.hibernate.demo.PKStudent;
import com.wrw.hibernate.demo.Sex;
import com.wrw.hibernate.demo.Student;

public class StudentTest {

	private static SessionFactory sessionFactory = null;
	
	@BeforeClass
	public static void beforeClass() {
		sessionFactory = new  Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void test() {
		
		PKStudent pk = new PKStudent();	
		pk.setStuName("hehe");
		
		Student stu = new Student();
// 		stu.setStuName("hehe");
		stu.setPk(pk);
		stu.setStuSex(Sex.mail);
		stu.setStuAge(16);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(stu);
		session.getTransaction().commit();
		session.close();
	}
	
}
