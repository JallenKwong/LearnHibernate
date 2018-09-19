package com.lun.light.inheritance.singletable;

import javax.persistence.*;


// 顾客类继承了Person类
@Entity
// 指定Customer实体对应的记录在辨别者列的值为"顾客"
@DiscriminatorValue("顾客")
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