package com.lun.light.inheritance.singletable;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
// 定义辨别者列的列名为person_type，列类型为字符串
@DiscriminatorColumn(name="person_type" ,
	discriminatorType=DiscriminatorType.STRING)
// 指定Person实体对应的记录在辨别者列的值为"普通人"
@DiscriminatorValue("普通人")
@Table(name="person_inf")
public class Person
{
	// 标识属性
	@Id @Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private char gender;
	// 定义该Person实体的组件属性：address
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="detail",
		column=@Column(name="address_detail")),
		@AttributeOverride(name="zip",
		column=@Column(name="address_zip")),
		@AttributeOverride(name="country",
		column=@Column(name="address_country"))
	})
	private Address address;
	// 无参数的构造器
	public Person()
	{
	}
	// 初始化全部成员变量的构造器
	public Person(Integer id , String name , char gender)
	{
		this.id = id;
		this.name = name;
		this.gender = gender;
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

	// gender的setter和getter方法
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	public char getGender()
	{
		return this.gender;
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