package com.wrw.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wrw.hibernate.demo.Sex;
import com.wrw.hibernate.demo2.Teacher;

public class TeacherTest {

	private static SessionFactory sessionFactory = null;
	
	@BeforeClass
	public static void beforeClass() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void test() {
		Teacher tea = new Teacher();
		
		tea.setTeaName("hehe");
		tea.setTeaSex(Sex.femail);
		tea.setTeaAge(23);
		tea.setTeaTag("RBQ");
		
		
//		Session session = sessionFactory.openSession();//��Զ���µ�session
//		Session session1 = sessionFactory.openSession();
//		System.out.print(session == session1) false 
		Session session = sessionFactory.getCurrentSession();//��ǰ��������session�Ͳ����µģ�û����
		session.beginTransaction();
		session.save(tea);
		session.getTransaction().commit();
//		session.close();
	}
	
	@Test
	public void testDelete() {
		Teacher tea = new Teacher();
		
		tea.setTeaName("haha");
		tea.setTeaSex(Sex.femail);
		tea.setTeaAge(23);
		tea.setTeaTag("RBQ");
		
		Session session = sessionFactory.getCurrentSession();//��ǰ��������session�Ͳ����µģ�û����
		session.beginTransaction();
		session.saveOrUpdate(tea);
		session.getTransaction().commit();
		
		Session session1 = sessionFactory.getCurrentSession();
		session1.beginTransaction();
		session1.delete(tea);
		session1.getTransaction().commit();
		
	}
	

	@Test
	public void testLoad() {
		
		Teacher t = null;
		
		Session session = sessionFactory.getCurrentSession();//��ǰ��������session�Ͳ����µģ�û����
		session.beginTransaction();
		t = (Teacher)session.load(Teacher.class, 5);
		System.out.println(t.getClass());
		session.getTransaction().commit();
//		System.out.println(t.getTeaTag());
		
	}

	@Test
	public void testGet() {
		
		Teacher t = null;
		
		Session session = sessionFactory.getCurrentSession();//��ǰ��������session�Ͳ����µģ�û����
		session.beginTransaction();
		t = (Teacher)session.get(Teacher.class, 1);
		System.out.println(t.getClass());
		session.getTransaction().commit();
//		System.out.println(t.getTeaTag());
		
	}
	
	@Test
	public void testUpdate() {
		
		Teacher t = null;
		
		Session session = sessionFactory.getCurrentSession();//��ǰ��������session�Ͳ����µģ�û����
		session.beginTransaction();
		t = (Teacher)session.get(Teacher.class, 1);
		session.getTransaction().commit();
		
		t.setTeaTag("BITCH");
		
		Session session2 = sessionFactory.getCurrentSession();//��ǰ��������session�Ͳ����µģ�û����
		session2.beginTransaction();
		session2.update(t);
		session2.getTransaction().commit();	
	}
	
	/*
	 * ��ȷ����
	 * 1.HQL���
	 * Quary q = session.createQuary("update Teacher ");
	 * 2.XML <class dynamic-update="true"/>
	 * 3.@org.hibernate.annotations.Entity(dynamicUpdate=true)  
	 */
	@Test
	public void testUpdate1() {
		
		Teacher t = null;
		
		Session session = sessionFactory.getCurrentSession();//��ǰ��������session�Ͳ����µģ�û����
		session.beginTransaction();
		t = (Teacher)session.get(Teacher.class, 2);		
		t.setTeaTag("BITCH");
		session.getTransaction().commit();
		
	}
	
	@Test
	public void testSaveOrUpdata() {
		
		Teacher tea = new Teacher();
		
		tea.setTeaName("eaha");
		tea.setTeaSex(Sex.femail);
		tea.setTeaAge(23);
		tea.setTeaTag("RBQ");
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(tea);
		session.getTransaction().commit();
		
		tea.setTeaAge(18);
		
		Session session1 = sessionFactory.getCurrentSession();
		session1.beginTransaction();
		session1.saveOrUpdate(tea);
		session1.getTransaction().commit();
	}
	/*
	 * load��get��������session���棬û���������ݿ�
	 * clear�建�棬���Դ�ӡ2��
	 */
	@Test
	public void testClear() {
		
		Teacher t, t2;
		
		Session session = sessionFactory.getCurrentSession();//��ǰ��������session�Ͳ����µģ�û����
		session.beginTransaction();
		t = (Teacher)session.load(Teacher.class, 3);
		System.out.println(t.getTeaName());
		
		session.clear();
		 
		t2 = (Teacher)session.get(Teacher.class, 3);
		System.out.println(t2.getTeaName());
		session.getTransaction().commit();
		
	}
	
	/*
	 *flash ǿ�����ݿ�ͻ���ͬ�� 
	 */
	@Test
	public void testFlash() {
		
		Teacher t, t2;
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		t = (Teacher)session.load(Teacher.class, 3);
		t.setTeaAge(15);
		
		session.flush();
		
		t.setTeaAge(19);
		
		session.getTransaction().commit();
		
	}
	
}
