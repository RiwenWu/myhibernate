package com.wrw.hibernate.demo;

import static org.junit.Assert.*;

import java.util.EnumSet;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wrw.hibernate.demo3.onetoone.Hushand;
import com.wrw.hibernate.demo5.onetomany.Group;
import com.wrw.hibernate.demo5.onetomany.User;

public class Realisionshoptest {
	
	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void beforeClass() {
		sessionFactory = new  Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	/*
	 * 在uer @mangtoone加cascade={CascadeType.ALL}
	 */
	@Test
	public void testUser() {
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

	/*
	 * 双向关系都设cascade={CascadeType.ALL}
	 */
	/*
	@Test
	public void testGroup() {
		User u1 = new User();
		u1.setUserName("u1");
		User u2 = new User();
		u2.setUserName("u2");
		Group g = new Group();
		g.setGrupName("Group2");
		g.getUsers().add(u1);
		g.getUsers().add(u2);
		u1.setGroup(g);
		u2.setGroup(g);
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		//s.save(g);
		s.save(g);
		s.getTransaction().commit();
	}
	*/
	/*
	@Test
	public void testloadGroup() {
		Group g = new Group();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		g = (Group)s.load(Group.class, (long)1);
		for(User u : g.getUsers()){
			System.out.println(u.getUserName());
		}
		s.getTransaction().commit();
	}
	*/
	/*
	 * 多对一 设 eager
	 * 一对多 设 lazy
	 */
	@Test
	public void testloadUser() {
		User u = new User();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		u = (User)s.load(User.class, (long)2);
		System.out.println(u.getGroup().getGrupName());
		s.getTransaction().commit();
	}
	
	@Test
	public void testUpdataUser() {
		User u = new User();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		u = (User)s.load(User.class, (long)2);
		
		u.setUserName("heh");
		u.getGroup().setGrupName("G3");
	
		s.update(u);
		s.getTransaction().commit();
	}
	
	/*
	 *有相互关联关系   delete会全部delete
	 *除非先取消关联再删除
	 *或者用HQL语句
	 */
	@Test
	public void testDeleteUser() {
		User u = new User();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		u = (User)s.load(User.class, (long)4);
		u.setGroup(null);
		s.delete(u);
		//s.createQuery("delete from User u where u.id = 1").executeUpdate();
		s.getTransaction().commit();
	}
	
	@Test
	public void testDeleteGroup() {
		Group g = new Group();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		/*
		g = (Group) s.load(Group.class, (long)9);
		s.delete(g);
		*/
		s.createQuery("delete from Group g where g.id = 7").executeUpdate();
		s.getTransaction().commit();
	}
	
	@Test
	public void testloadMapUser() {
		Group g = new Group();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		g = (Group) s.load(Group.class, (long)3);
		for (Entry<Long, User> entry : g.getUsers().entrySet()){
			System.out.println(entry.getValue().getUserName());
		}
		s.getTransaction().commit();
	}
}
