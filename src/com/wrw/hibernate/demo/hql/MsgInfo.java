package com.wrw.hibernate.demo.hql;

public class MsgInfo {

	private long id;
	private String title;
	private String name;
	private String cont;
	
	public MsgInfo(int id, String cont, String name,String title){
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.cont = cont;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	
	
}
