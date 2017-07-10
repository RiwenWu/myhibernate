package com.wrw.po;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class studenttest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Student stu = new Student();
		stu.setStu_id("stu01");
		stu.setStu_name("hehe");
		stu.setStu_age(16);
		
		Session session = new Session();
		session.save(stu);
	}
}
