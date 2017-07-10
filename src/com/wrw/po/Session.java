package com.wrw.po;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Session {
	
	String tablename = "_Students";
	Map<String, String> cfs;
	String[] methodName;
	
	public Session(){
		cfs = new HashMap<String, String>();
		
		cfs.put("_stu_id", "stu_id");
		cfs.put("_stu_name","stu_name");
		cfs.put("_stu_age","stu_age");
		
		methodName = new String[cfs.size()];
	}

	public void save(Student stu) throws ClassNotFoundException, SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String sql = createMySql();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/myhibernate", "root", "249991189");
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		
		for	(int i =0 ; i < methodName.length ; i++){
			Method m1 = stu.getClass().getMethod(methodName[i]);
			//System.out.println(m1);
			Class r = m1.getReturnType();
			//System.out.println(r);
			if (r.getName().equals("class java.lang.String")) {
				String returnValue = (String) m1.invoke(0);
				//System.out.println(returnValue);
				ps.setString(i + 1, "'" + returnValue + "'");
			}
			if (r.getName().equals("class int")) {
				Integer returnValue = (Integer) m1.invoke(0);
				ps.setInt(i + 1, returnValue);
			}
			System.out.println(m1.getName() + m1.getReturnType());
		}
		
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	private String createMySql() {
		
		int index = 0;
		String columName = "";
		for(String s : cfs.keySet()){
			String v = cfs.get(s);
			v = Character.toUpperCase(v.charAt(0)) + v.substring(1, v.length());
			methodName[index] = "get" + v;
			index++;
			columName += s + ", ";
		}
		columName = columName.substring(0, columName.length() - 2 );
		System.out.println(columName);
		
		String str = "";
		for(int i = 0 ; i < cfs.size() ; i++) {
			str += "?, ";
			
		}
		str = str.substring(0, str.length() - 2);
		System.out.println(str);
		
		String sql = "insert into " + tablename + " (" + columName +")" + " value (" + str + ");";
		System.out.println(sql);
		return sql;
	}

}
