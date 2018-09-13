package com.lun.light.component.embeddable2;

import javax.persistence.*;

/**
 * @version  1.0
 */
@Embeddable
public class Name
	implements java.io.Serializable
{
	// 定义first成员变量
	@Column(name="person_firstname")
	private String first;
	// 定义last成员变量
	@Column(name="person_lastname")
	private String last;

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

	// 重写equals()方法，根据first、last进行判断
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj != null && obj.getClass() == Name.class)
		{
			Name target = (Name)obj;
			return target.getFirst().equals(getFirst())
				&& target.getLast().equals(getLast());
		}
		return false;
	}
	// 重写hashCode()方法，根据first、last计算hashCode值
	public int hashCode()
	{
		return getFirst().hashCode() * 31
			+ getLast().hashCode();
	}
}