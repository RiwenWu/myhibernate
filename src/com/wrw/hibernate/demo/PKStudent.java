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
	
	public boolean equals(Object o) //����������pk�����Ա��� 
    { 
        if(o instanceof  PKStudent) 
        { 
        	PKStudent pk = (PKStudent)o;//ǿת 
            if(this.StuId == pk.getStuId() && this.StuName.equals(pk.getStuName())) 
            { 
                return true;//id��name���ֱ���ȣ�����ͬһ���� 
            } 
        } 
        return false;//�����������������false 
    } 
 
    public int hashCode()//����pk�Ĺ�ϣ��ȥ���ң����Ա��� 
    { 
        return this.StuName.hashCode();     
    }

}
