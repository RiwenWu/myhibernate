package com.wrw.hibernate.demo3.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * ˫������ؼ����裨mappedBy = "xxx"��
 */
@Entity
public class Wife {

	private int WieId;
	private String WieName;
	
	@Id
	@GeneratedValue
	public int getWieId() {
		return WieId;
	}
	public void setWieId(int wieId) {
		WieId = wieId;
	}
	public String getWieName() {
		return WieName;
	}
	public void setWieName(String wieName) {
		WieName = wieName;
	}
	
	
}
