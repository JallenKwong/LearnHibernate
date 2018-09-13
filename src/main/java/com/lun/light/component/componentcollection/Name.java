package com.lun.light.component.componentcollection;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Parent;

/**
 * @version 1.0
 */
@Embeddable
public class Name {
	// 定义first成员变量
	@Column(name = "person_firstname")
	private String first;
	// 定义last成员变量
	@Column(name = "person_lastname")
	private String last;
	// 引用拥有该Name的Person对象
	@Parent
	private Person owner;
	
	// 集合属性，保留该对象关联的考试成绩
	@ElementCollection(targetClass = Integer.class)
	@Column(name = "name_power", nullable = false)
	@CollectionTable(name = "power_inf"
		, joinColumns = @JoinColumn(name = "person_name_id", nullable = false))

	@MapKeyColumn(name = "name_aspect")
	@MapKeyClass(String.class)
	private Map<String, Integer> power = new HashMap<>();

	// 无参数的构造器
	public Name() {
	}

	// 初始化全部成员变量的构造器
	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	// first的setter和getter方法
	public void setFirst(String first) {
		this.first = first;
	}

	public String getFirst() {
		return this.first;
	}

	// last的setter和getter方法
	public void setLast(String last) {
		this.last = last;
	}

	public String getLast() {
		return this.last;
	}

	// owner的setter和getter方法
	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public Person getOwner() {
		return this.owner;
	}

	// power的setter和getter方法
	public void setPower(Map<String, Integer> power) {
		this.power = power;
	}

	public Map<String, Integer> getPower() {
		return this.power;
	}
}