package com.wrw.hibernate.demo;
/*
 * Ö÷¼üÉú³ÉDemo
 */
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Student {
	
	 @TableGenerator(
	           	name="empGen", 
	            table="Stu_GEN", 
	            pkColumnName="Stu_KEY", 
	            valueColumnName="Stu_VALUE", 
	            pkColumnValue="EMP_ID", 
	            allocationSize=2)

	//private int id;
	//private String stuName;
	private PKStudent pk;
	private Sex stuSex;
	private int stuAge;
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}*/
	@EmbeddedId
	public PKStudent getPk() {
		return pk;
	}
	public void setPk(PKStudent pk) {
		this.pk = pk;
	}
	public Sex getStuSex() {
		return stuSex;
	}
	@Enumerated
	public void setStuSex(Sex stuSex) {
		this.stuSex = stuSex;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	
	
}
