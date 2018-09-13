package com.lun.light.component.embeddedid;

import javax.persistence.*;
/**
 * @version  1.0
 */
@Entity
@Table(name="person_inf")
public class Person
{
	// 以Name组件作为标识属性
	@EmbeddedId
	@AttributeOverrides({
		// 指定
		@AttributeOverride(name="first",
			column = @Column(name="person_firstname")),
		@AttributeOverride(name="last",
			column = @Column(name="person_lastname"))
	})
	private Name name;
	private int age;

	// name的setter和getter方法
	public void setName(Name name)
	{
		this.name = name;
	}
	public Name getName()
	{
		return this.name;
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
}