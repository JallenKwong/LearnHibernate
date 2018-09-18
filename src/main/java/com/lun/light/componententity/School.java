package com.lun.light.componententity;

import javax.persistence.*;

@Entity
@Table(name="school_inf")
public class School
{
	// 定义标识属性
	@Id @Column(name="school_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 定义该学校的name成员变量
	private String name;

	// 无参数的构造器
	public School()
	{
	}
	// 初始化全部成员变量的构造器
	public School(String name)
	{
		this.name = name;
	}

	// id的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
}