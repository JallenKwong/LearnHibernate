package com.lun.light.unidirectional.n2onejointable;

import javax.persistence.*;
/**
 * @version  1.0
 */
@Entity
@Table(name="person_inf")
public class Person
{
	// 标识属性
	@Id @Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int age;
	// 定义该Person实体关联的Address实体
	@ManyToOne(targetEntity=Address.class)
	// 显式使用@JoinTable映射连接表
	@JoinTable(name="person_address", // 指定连接表的表名为person_address
		// 指定连接表中person_id外键列，参照到当前实体对应表的主键列
		joinColumns=@JoinColumn(name="person_id"
			, referencedColumnName="person_id", unique=true),
		// 指定连接表中address_id外键列，参照到当前实体的关联实体对应表的主键列
		inverseJoinColumns=@JoinColumn(name="address_id"
			, referencedColumnName="address_id")
	)
	private Address address;

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

	// address的setter和getter方法
	public void setAddress(Address address)
	{
		this.address = address;
	}
	public Address getAddress()
	{
		return this.address;
	}
}