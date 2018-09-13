package com.lun.light.component.collectioncomponent;

import javax.persistence.*;
import org.hibernate.annotations.Parent;
/**
 * @version  1.0
 */
@Embeddable
public class Name
{
	// 定义first成员变量
	@Column(name="person_firstname")
	private String first;
	// 定义last成员变量
	@Column(name="person_lastname")
	private String last;
	// 引用拥有该Name的Person对象
	@Parent
	private Person owner;

	// 无参数的构造器
	public Name()
	{
	}
	// 初始化全部成员变量的构造器
	public Name(String first , String last)
	{
		this.first = first;
		this.last = last;
	}

	// first的setter和getter方法
	public void setFirst(String first)
	{
		this.first = first;
	}
	public String getFirst()
	{
		return this.first;
	}

	// last的setter和getter方法
	public void setLast(String last)
	{
		this.last = last;
	}
	public String getLast()
	{
		return this.last;
	}

	// owner的setter和getter方法
	public void setOwner(Person owner)
	{
		this.owner = owner;
	}
	public Person getOwner()
	{
		return this.owner;
	}

}