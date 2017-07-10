package com.wrw.hibernate.demo.hql;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Topic {
	
	@Id
	@GeneratedValue
	private long topic_id;
	private String TopicName;
	private Date createdate;
	private String cont;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@OneToMany(mappedBy="topic", cascade = CascadeType.ALL)
	private Set<Msg> msgs = new HashSet<Msg>();
	
	public long getId() {
		return topic_id;
	}
	public void setId(long topic_id) {
		this.topic_id = topic_id;
	}
	public String getTopicName() {
		return TopicName;
	}
	public void setTopicName(String topicName) {
		TopicName = topicName;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Msg> getMsgs() {
		return msgs;
	}
	public void setMsgs(Set<Msg> msgs) {
		this.msgs = msgs;
	}
	
	
	
	
}
