package com.wrw.hibernate.demo.hql;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private long category_id;
	private String CategoryName;
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	private Set<Topic> topics = new HashSet<Topic>();
	
	public long getId() {
		return category_id;
	}
	public void setId(long category_id) {
		this.category_id = category_id;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public Set<Topic> getTopics() {
		return topics;
	}
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	
}
