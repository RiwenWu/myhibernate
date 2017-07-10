package com.wrw.hibernate.homework.student_course_score;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long CouseId;
	private String CouseName;
	private String Coursedescript;
	@ManyToMany
	@JoinTable(name="score",
	joinColumns = @JoinColumn(name="student_id"),
	inverseJoinColumns=@JoinColumn(name="course_id")
		)
	private Set<Student> students;
	@OneToMany(mappedBy="course",cascade = CascadeType.ALL)
	private Set<Score> scores;
	
	public Long getCouseId() {
		return CouseId;
	}
	public void setCouseId(Long couseId) {
		CouseId = couseId;
	}
	public String getCouseName() {
		return CouseName;
	}
	public void setCouseName(String couseName) {
		CouseName = couseName;
	}
	public String getCoursedescript() {
		return Coursedescript;
	}
	public void setCoursedescript(String coursedescript) {
		Coursedescript = coursedescript;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Score> getScores() {
		return scores;
	}
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
	
	
	
}
