package com.lun.light.component.embeddable2;

import javax.persistence.*;
/**
 * @version  1.0
 */
@Entity
@Table(name="person_inf")
public class Person
{
	@EmbeddedId
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