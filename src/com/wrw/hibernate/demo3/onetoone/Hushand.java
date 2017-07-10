package com.wrw.hibernate.demo3.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Hushand {

	private int HsbId;
	private String HsbName;
	private Wife wife;
	
	@Id
	@GeneratedValue
	public int getHsbId() {
		return HsbId;
	}
	public void setHsbId(int hsbId) {
		HsbId = hsbId;
	}
	public String getHsbName() {
		return HsbName;
	}
	public void setHsbName(String hsbName) {
		HsbName = hsbName;
	} 
	@OneToOne
	//外键关联
	@JoinColumn(name="WieId")
	//主键关联
	//@PrimaryKeyJoinColumn
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	
	
	
}
