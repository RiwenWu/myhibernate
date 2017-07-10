package com.wrw.hibernate.demo2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.wrw.hibernate.demo.Sex;

@Entity
//@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)  
public class Teacher {
	
	private int TeaId;
	private String TeaName;
	private Sex TeaSex;
	private int TeaAge;
	private String TeaTag;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	public int getTeaId() {
		return TeaId;
	}
	public void setTeaId(int teaId) {
		TeaId = teaId;
	}
	public String getTeaName() {
		return TeaName;
	}
	public void setTeaName(String teaName) {
		TeaName = teaName;
	}
	//@Column(updatable=false) 不参与更新
	public Sex getTeaSex() {
		return TeaSex;
	}
	public void setTeaSex(Sex teaSex) {
		TeaSex = teaSex;
	}
	public int getTeaAge() {
		return TeaAge;
	}
	public void setTeaAge(int teaAge) {
		TeaAge = teaAge;
	}
	public String getTeaTag() {
		return TeaTag;
	}
	public void setTeaTag(String teaTag) {
		TeaTag = teaTag;
	}
	
	
}
