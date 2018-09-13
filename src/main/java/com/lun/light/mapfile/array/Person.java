package com.lun.light.mapfile.array;

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
	// 指定保存集合元素的列为 school_name
	@Column(name = "school_name")
	// 映射集合元素索引的列
	@OrderColumn(name = "array_order")
	private String[] schools;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public void setSchools(String[] schools) {
		this.schools = schools;
	}

	public String[] getSchools() {
		return this.schools;
	}
}