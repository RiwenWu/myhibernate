package com.wrw.hibernate.demo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/*@Embeddable*/
public class PKStudent implements Serializable{
	
	private int StuId;
	private String StuName;
	public int getStuId() {
		return StuId;
	}
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	public void setStuId(int stuId) {
		StuId = stuId;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	
	public boolean equals(Object o) //靠主键区分pk，所以必须 
    { 
        if(o instanceof  PKStudent) 
        { 
        	PKStudent pk = (PKStudent)o;//强转 
            if(this.StuId == pk.getStuId() && this.StuName.equals(pk.getStuName())) 
            { 
                return true;//id和name都分别相等，才是同一主键 
            } 
        } 
        return false;//其余所有情况都返回false 
    } 
 
    public int hashCode()//根据pk的哈希码去查找，所以必须 
    { 
        return this.StuName.hashCode();     
    }

}
