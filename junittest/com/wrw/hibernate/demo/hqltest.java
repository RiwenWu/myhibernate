package com.wrw.hibernate.demo;

import static org.junit.Assert.*;

import java.util.Date;




import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wrw.hibernate.demo.hql.Category;
import com.wrw.hibernate.demo.hql.Msg;
import com.wrw.hibernate.demo.hql.MsgInfo;
import com.wrw.hibernate.demo.hql.Topic;

public class hqltest {
	
	private static SessionFactory sessionFactory;
	private Query q;
	
	@BeforeClass
	public static void beforeClass(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass(){
		sessionFactory.close();
	}

	@Test
	public void testSava() {
		
		Session session  = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		for	(int i = 0; i < 10 ; i++){
			Category c = new Category();
			c.setCategoryName("c" + i);
			session.save(c);
		}
		
		for	(int i = 0 ; i < 10 ; i++){
			Category c = new Category();
			c.setId(1);
			Topic t = new Topic();
			t.setCategory(c);
			t.setTopicName("t" + i);
			t.setCreatedate(new Date());
			t.setCont("I am topic " + i);
			session.save(t);
		}
		
		for (int i = 0 ; i < 10 ; i++){
			Topic t = new Topic();
			t.setId(12);
			Msg m = new Msg();
			m.setTopic(t);
			m.setCont("msg" + i);
			m.setCreateData(new Date());
			session.save(m);
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHql_01(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		q = session.createQuery("from Category");
		List<Category> catgories = q.list();
		for (Category c : catgories){
			System.out.println(c.getCategoryName());
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHql_02(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		q = session.createQuery("from Category c where c.CategoryName > 'c5'");
		List<Category> categories = q.list();
		for	(Category c : categories){
			System.out.println(c.getCategoryName());
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHql_03(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		q = session.createQuery("from Category c order by c.CategoryName desc");
		List<Category> categories = q.list();
		for	(Category c : categories){
			System.out.println(c.getCategoryName());
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHql_04(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		q = session.createQuery("select distinct c from Category c order by c.CategoryName desc");
		List<Category> categories = q.list();
		for	(Category c : categories){
			System.out.println(c.getCategoryName());
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHql_05(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		q = session.createQuery("from Category c where c.category_id > :min and c.category_id < :max ");
//		q.setParameter("min", (long)2);
//		q.setParameter("max", (long)9);
//		q.setLong("min", 2);
//		q.setLong("max", 8);
//		q.setInteger("min", 2);
		List<Category> categories = q.list();
		for	(Category c : categories){
			System.out.println(c.getId() + "-" +c.getCategoryName());
		}
		
		session.getTransaction().commit();
	}
	
	//¡¥ Ω≤È—Ø
	@Test
	public void testHql_06(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category c where c.category_id > :min and c.category_id < :max ")
				.setLong("min", 2)
				.setLong("max", 8);
		List<Category> categories = q.list();
		for	(Category c : categories ){
			System.out.println(c.getId() + "-" +c.getCategoryName());
		}
		session.getTransaction().commit();
	}
	
	//∑÷“≥
	@Test
	public void testHql_07(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query q = session.createQuery("from Category c order by c.CategoryName desc");
		q.setMaxResults(6);
		q.setFirstResult(2);
		List<Category> categories = q.list();
		for	(Category c : categories) {
			System.out.println(c.getId() + "-" +c.getCategoryName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testHql_08(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		q = session.createQuery("select c.category_id,  c.CategoryName from Category c order by c.CategoryName desc");
		List<Object[]> categories = q.list();
		for(Object[] o : categories) {
			System.out.println(o[0] + "-" + o[1]);
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_09() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		q = session.createQuery("from Msg m where m.topic.category.category_id = 1");
		
		for(Object o : q.list()) {
			Msg m = (Msg)o;
			System.out.println(m.getCont());
		}
		session.getTransaction().commit();
		
	}
	
	@Test
	public void testHql_10(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		q = session.createQuery("select new com.wrw.hibernate.demo.hql.MsgInfo(m.id, m.cont, m.topic.TopicName, m.topic.category.CategoryName) from Msg");
		
		for(Object o : q.list()) {
			MsgInfo m = (MsgInfo)o;
			System.out.println(m.getCont());
		}
		session.getTransaction().commit();
	}
	
	public static void main(String[] args){
		beforeClass();
	}

}
