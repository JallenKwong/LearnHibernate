package com.lun.light.bidirectional.one2njoinable;

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
//	@OneToMany(targetEntity=Address.class ,mappedBy="person")
	@OneToMany(targetEntity=Address.class)
	// 映射连接表，指定连接表为person_address
	@JoinTable(name="person_address",
		// 指定连接表中person_id列参照当前实体对应数据表的person_id主键列
		joinColumns=@JoinColumn(name="person_id"
			, referencedColumnName="person_id"),
		// 指定连接表中address_id列参照当前实体的关联实体对应数据表的address_id主键列
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