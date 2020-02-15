package com.lun.light.bidirectional.one2njoinable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject implements Serializable{

	private static final long serialVersionUID = -2852971187808497951L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToOne(targetEntity = Subject.class)
	@JoinColumn(name="parent_id" , referencedColumnName="id"
		, nullable=true)
	private Subject parent;
	
	//mappedBy指的是Subject的字段parent, 双向关系的mappedBy要有，单向关系的就不用mappedBy
	@OneToMany(targetEntity = Subject.class, mappedBy="parent") 
	private Set<Subject> subjects = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getParent() {
		return parent;
	}

	public void setParent(Subject parent) {
		this.parent = parent;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", parent=" + parent + "]";
	}
	
	
}
