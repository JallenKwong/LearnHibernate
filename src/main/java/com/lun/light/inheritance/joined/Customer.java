package com.lun.light.inheritance.joined;

import javax.persistence.*;


// 顾客类继承了Person类
@Entity
@Table(name="customer_inf")
public class Customer extends Person
{
	// 顾客的评论信息
	private String comments;
	// 定义和该顾客保持关联的Employee关联实体
	@ManyToOne(cascade=CascadeType.ALL
		,targetEntity=Employee.class)
	@JoinColumn(name="employee_id", nullable=true)
	private Employee employee;
	// 无参数的构造器
	public Customer()
	{
	}
	// 初始化comments成员变量的构造器
	public Customer(String comments)
	{
		this.comments = comments;
	}

	// comments的setter和getter方法
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	public String getComments()
	{
		return this.comments;
	}

	// employee的setter和getter方法
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	public Employee getEmployee()
	{
		return this.employee;
	}
}