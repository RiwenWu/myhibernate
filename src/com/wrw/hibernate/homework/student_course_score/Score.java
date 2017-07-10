package com.wrw.hibernate.homework.student_course_score;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score {
	
	@Id
	@GeneratedValue
	private Long ScoreId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student stu;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	private Course course;
	private float fenshu;
	
	public Long getScoreId() {
		return ScoreId;
	}
	public void setScoreId(Long scoreId) {
		ScoreId = scoreId;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public float getFenshu() {
		return fenshu;
	}
	public void setFenshu(float fenshu) {
		this.fenshu = fenshu;
	}
	
	
}
