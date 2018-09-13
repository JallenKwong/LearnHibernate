package com.lun.light.mapfile.set;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;

/**
 * @version 1.0
 */
@Entity
@Table(name = "person_inf")
public class Person {
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// 标识属性
	private Integer id;
	private String name;
	private int age;
	// 集合属性，保留该对象关联的学校
	@ElementCollection(targetClass = String.class)
	// 映射保存集合属性的表
	@CollectionTable(name = "school_inf", // 指定表名为school_inf
			joinColumns = @JoinColumn(name = "person_id", nullable = false))
	// 指定保存集合元素的列为 school_name，nullable=false增加非空约束
	@Column(name = "school_name", nullable = false)
	private Set<String> schools = new HashSet<>();

	// id的setter和getter方法
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// name的setter和getter方法
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// age的setter和getter方法
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	// schools的setter和getter方法
	public void setSchools(Set<String> schools) {
		this.schools = schools;
	}

	public Set<String> getSchools() {
		return this.schools;
	}

}