package com.wrw.hibernate.demo.Tree;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Organization {
	
	@Id
	@GeneratedValue
	private long id;
	private String PartName;
	@OneToMany(mappedBy="parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Organization> child = new HashSet<Organization>();
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Organization parent;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPartName() {
		return PartName;
	}
	public void setPartName(String partName) {
		PartName = partName;
	}
	public Set<Organization> getChild() {
		return child;
	}
	public void setChild(Set<Organization> child) {
		this.child = child;
	}
	public Organization getParent() {
		return parent;
	}
	public void setParent(Organization parent) {
		this.parent = parent;
	}
	

	
}
