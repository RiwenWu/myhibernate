package com.wrw.hibernate.demo4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

/*
 * 双向外键关键必设（mappedBy = "xxx"）
 */
@Entity
@IdClass(WifePK.class)
public class Wife {

	private int WieId;
	private String WieName;
	private int WieAge;
	
	@Id
	@GeneratedValue
	public int getWieId() {
		return WieId;
	}
	public void setWieId(int wieId) {
		WieId = wieId;
	}
	@Id
	public String getWieName() {
		return WieName;
	}
	public void setWieName(String wieName) {
		WieName = wieName;
	}
	public int getWieAge() {
		return WieAge;
	}
	public void setWieAge(int wieAge) {
		WieAge = wieAge;
	}
	
	
}
