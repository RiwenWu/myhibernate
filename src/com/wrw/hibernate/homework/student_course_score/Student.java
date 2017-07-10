package com.wrw.hibernate.homework.student_course_score;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class Student {
	
	@TableGenerator(
           	name="empGen", 
            table="Stu_GEN", 
            pkColumnName="Stu_KEY", 
            valueColumnName="Stu_VALUE", 
            pkColumnValue="EMP_ID", 
            allocationSize=1)	
	@Id
	@GeneratedValue
	private Long StuId;
	private String name;
	@Enumerated
	private Sex StuSex;
	@ManyToMany
	@JoinTable(name="score",
		joinColumns = @JoinColumn(name="student_id"),
		inverseJoinColumns=@JoinColumn(name="course_id")
			)
	private Set<Course> courses = new HashSet<Course>();
	@OneToMany(mappedBy="stu",cascade = CascadeType.ALL)
	private Set<Score> scores;
	
	public Long getStuId() {
		return StuId;
	}
	public void setStuId(Long stuId) {
		StuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sex getStuSex() {
		return StuSex;
	}
	public void setStuSex(Sex stuSex) {
		StuSex = stuSex;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Set<Score> getScores() {
		return scores;
	}
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	
}
