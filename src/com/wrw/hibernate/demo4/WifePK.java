package com.wrw.hibernate.demo4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class WifePK {

	private int WieId;
	private String WieName;

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
