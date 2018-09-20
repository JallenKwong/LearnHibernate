package com.lun.light.interceptor;

import javax.persistence.*;

@Entity
@Table(name="user_inf")

public class User
{
	@Id @Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int age;
	private String nationality;

	// 无参数的构造器
	public User()
	{
	}
	// 初始化全部成员变量的构造器
	public User(Integer id , String name , int age , String nationality)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.nationality = nationality;
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

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// nationality的setter和getter方法
	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}
	public String getNationality()
	{
		return this.nationality;
	}

}