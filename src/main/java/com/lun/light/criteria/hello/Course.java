package com.lun.light.criteria.hello;

import javax.persistence.*;

@Entity
@Table(name="course_inf")
public class Course
{
	// 代表课程编号的成员变量，将作为标识属性
	@Id @Column(name="course_code")
	private String courseCode;
	// 代表课程名成员变量
	private String name;

	// 无参数的构造器
	public Course()
	{
	}
	// 初始化全部成员变量的构造器
	public Course(String courseCode , String name)
	{
		this.courseCode = courseCode;
		this.name = name;
	}

	// courseCode的setter和getter方法
	public void setCourseCode(String courseCode)
	{
		this.courseCode = courseCode;
	}
	public String getCourseCode()
	{
		return this.courseCode;
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