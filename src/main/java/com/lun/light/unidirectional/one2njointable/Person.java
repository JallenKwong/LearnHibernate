package com.lun.light.unidirectional.one2njointable;

import java.util.*;

import javax.persistence.*;

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
	// 定义该Person实体所有关联的Address实体
	@OneToMany(targetEntity=Address.class)
	// 映射连接表为person_address
	@JoinTable(name="person_address",
		// 定义连接表中名为person_id的外键列，该外键列参照当前实体对应表的主键列
		joinColumns=@JoinColumn(name="person_id"
			, referencedColumnName="person_id"),
		// 定义连接表中名为address_id的外键列，
		// 该外键列参照当前实体的关联实体对应表的主键列
		inverseJoinColumns=@JoinColumn(name="address_id"
			, referencedColumnName="address_id", unique=true)
	)
	private Set<Address> addresses
		= new HashSet<>();

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

	// addresses的setter和getter方法
	public void setAddresses(Set<Address> addresses)
	{
		this.addresses = addresses;
	}
	public Set<Address> getAddresses()
	{
		return this.addresses;
	}
}