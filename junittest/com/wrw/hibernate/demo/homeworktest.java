package com.wrw.hibernate.demo;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wrw.hibernate.homework.student_course_score.Course;
import com.wrw.hibernate.homework.student_course_score.Score;
import com.wrw.hibernate.homework.student_course_score.Sex;
import com.wrw.hibernate.homework.student_course_score.Student;

public class homeworktest {

	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void beforeClass() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void testSave() {
		Student s = new Student();
		s.setName("stu1");
		s.setStuSex(Sex.femail);
		Course c = new Course();
		c.setCouseName("Math");
		Score score = new Score(); 
		
		score.setStu(s);
		score.setCourse(c);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(score);
		session.getTransaction().commit();
	}
	
	public static void main(String[] args){
		beforeClass();
	}

}
