package com.lun.light.inheritance.tableperclass;

import javax.persistence.*;

import java.util.Set;
import java.util.HashSet;


// 经理类继承员工类
@Entity
@Table(name="manager_inf")
public class  Manager extends Employee
{
	// 定义经理管辖部门的属性
	private String department;
	// 定义和该经理保持关联的Employee关联实体
	@OneToMany(cascade=CascadeType.ALL
		, mappedBy="manager" , targetEntity=Employee.class)
	private Set<Employee> employees
		= new HashSet<>();
	// 无参数的构造器
	public Manager()
	{
	}
	// 初始化全部成员变量的构造器
	public Manager(String department)
	{
		this.department = department;
	}

	// department的setter和getter方法
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public String getDepartment()
	{
		return this.department;
	}

	// employees的setter和getter方法
	public void setEmployees(Set<Employee> employees)
	{
		this.employees = employees;
	}
	public Set<Employee> getEmployees()
	{
		return this.employees;
	}
}