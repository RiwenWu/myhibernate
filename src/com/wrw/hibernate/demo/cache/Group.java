package com.wrw.hibernate.demo.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="_Group")
//…Ë÷√∂˛º∂ª∫¥Ê
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Group {
	
	@Id
	@GeneratedValue
	private Long id;
	private String GrupName;
	/*
	@OneToMany(mappedBy="group",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
	)
    private Set<User> users = new HashSet<User>();
	*/
	/*
	@OneToMany(mappedBy="group",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
	)
	@OrderBy(value="desc|asc")
	private List<User> users = new ArrayList<User>();
	*/
	@OneToMany(mappedBy="group",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	@MapKey(name="UserId")
	private Map<Long, User>users = new HashMap<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGrupName() {
		return GrupName;
	}
	public void setGrupName(String grupName) {
		GrupName = grupName;
	}
	/*
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	 */
	/*
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	*/
	public Map<Long, User> getUsers() {
		return users;
	}
	public void setUsers(Map<Long, User> users) {
		this.users = users;
	}
	
}
