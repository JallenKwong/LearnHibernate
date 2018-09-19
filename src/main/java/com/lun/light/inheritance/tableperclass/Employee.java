package com.lun.light.inheritance.tableperclass;

import java.util.*;

import javax.persistence.*;



// 员工类继承了Person类
@Entity
@Table(name="employee_inf")
public class Employee extends Person
{
	// 定义该员工职位的成员变量
	private String title;
	// 定义该员工工资的成员变量
	private double salary;
	// 定义和该员工保持关联的Customer关联实体
	@OneToMany(cascade=CascadeType.ALL
		, mappedBy="employee" , targetEntity=Customer.class)
	private Set<Customer> customers
		= new HashSet<>();
	// 定义和该员工保持关联的Manager关联实体
	@ManyToOne(cascade=CascadeType.ALL
		,targetEntity=Manager.class)
	@JoinColumn(name="manager_id", nullable=true)
	private Manager manager;

	// 无参数的构造器
	public Employee()
	{
	}
	// 初始化全部成员变量的构造器
	public Employee(String title , double salary)
	{
		this.title = title;
		this.salary = salary;
	}

	// title的setter和getter方法
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// salary的setter和getter方法
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	public double getSalary()
	{
		return this.salary;
	}

	// customers的setter和getter方法
	public void setCustomers(Set<Customer> customers)
	{
		this.customers = customers;
	}
	public Set<Customer> getCustomers()
	{
		return this.customers;
	}

	// manager的setter和getter方法
	public void setManager(Manager manager)
	{
		this.manager = manager;
	}
	public Manager getManager()
	{
		return this.manager;
	}
}