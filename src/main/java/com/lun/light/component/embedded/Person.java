package com.lun.light.component.embedded;

import javax.persistence.*;
/**
 * @version  1.0
 */
@Entity
@Table(name="person_inf")
public class Person
{
	@Id @Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int age;
	// 组件属性name
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="first", column = @Column(name="person_firstname")),
		@AttributeOverride(name="last", column = @Column(name="person_lastname"))
	})
	private Name name;

	// id的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// name的setter和getter方法
	public void setName(Name name)
	{
		this.name = name;
	}
	public Name getName()
	{
		return this.name;
	}
}