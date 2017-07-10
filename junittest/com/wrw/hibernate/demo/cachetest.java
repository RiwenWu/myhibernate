package com.wrw.hibernate.demo;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wrw.hibernate.demo.cache.Group;
import com.wrw.hibernate.demo.cache.User;

public class cachetest {

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
	public void testload() {
		User user = new User();
		user.setUserName("hehe");
		Group group = new Group();
		group.setGrupName("Group1");
		user.setGroup(group);
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	@Test
	public void testloadGroup() {
		Group g = new Group();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		g = (Group)s.load(Group.class, (long)2);
		
		System.out.println(g.getGrupName());
		
		s.getTransaction().commit();
		
		Session s2 = sessionFactory.getCurrentSession();
		s2.beginTransaction();
		g = (Group)s2.load(Group.class, (long)2);
		
		System.out.println(g.getGrupName());
		
		s2.getTransaction().commit();
	}
	
	public static void main(String[] args){
		beforeClass();
	}

}
