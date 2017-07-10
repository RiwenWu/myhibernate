package com.wrw.hibernate.demo;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wrw.hibernate.demo.Tree.Organization;

public class Orgnaziationtest {
	
	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void beforeClass(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass(){
		sessionFactory.close();
	}

	@Test
	public void testSave() {
		Organization org = new Organization();
		org.setPartName("总公司");
		Organization org1 = new Organization();
		org1.setPartName("子公司1");
		Organization org2 = new Organization();
		org2.setPartName("子公司2");
		Organization org1_1 = new Organization();
		org1_1.setPartName("子公司1部门1");
		Organization org2_1 = new Organization();
		org2_1.setPartName("子公司2部门2");
		
		org.getChild().add(org1);
		org.getChild().add(org2);
		org1.getChild().add(org1_1);
		org2.getChild().add(org2_1);
		
		org2_1.setParent(org2);
		org1_1.setParent(org1);
		org1.setParent(org);
		org2.setParent(org);
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(org);
		session.getTransaction().commit();
	}
	
	@Test
	public void testLoad(){
		testSave();
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Organization o;
		o = (Organization)session.load(Organization.class, (long)1);
		print(o, 0);
		
		session.getTransaction().commit();
	}
	
	public static void main(String[] args){
		beforeClass();
	}
	
	private void print(Organization o, int level){
		String perStr ="";
		for (int i = 0; i < level; i++) {
			perStr += "--";
		}
		System.out.println(perStr + o.getPartName());
		for	(Organization child : o.getChild()){
			print(child, level + 1);
		}
	}

}
