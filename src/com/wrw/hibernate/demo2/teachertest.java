package com.wrw.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wrw.hibernate.demo.Sex;

public class teachertest {
	public static void main(String[] args){
	Teacher tea = new Teacher();
			
			tea.setTeaName("nene");
			tea.setTeaSex(Sex.femail);
			tea.setTeaAge(23);
			tea.setTeaTag("RBQ");
			
	Teacher tea1 = new Teacher();
				
				tea1.setTeaName("meme");
				tea1.setTeaSex(Sex.femail);
				tea1.setTeaAge(23);
				tea1.setTeaTag("RBQ");
			
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();//��ǰ��������session�Ͳ����µģ�û����
			session.beginTransaction();
			session.save(tea);
			session.save(tea1);
			session.getTransaction().commit();
			session.close();
	
	}
}
