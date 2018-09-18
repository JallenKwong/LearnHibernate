package com.lun.light.bidirectional.one2onejointable;


import javax.persistence.*;

@Entity
@Table(name="address_inf")
public class Address
{
	// 标识属性
	@Id @Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	// 定义地址详细信息的成员变量
	private String addressDetail;
	// 定义该Address实体关联的Person实体
	@OneToOne(targetEntity=Person.class)
	// 映射底层连接表，表名为person_address
	@JoinTable(name="person_address",
		// 映射连接表的外键列，增加unique=true表明是1-1关联
		joinColumns=@JoinColumn(name="address_id"
			, referencedColumnName="address_id", unique=true),
		// 映射连接表的外键列，增加unique=true表明是1-1关联
		inverseJoinColumns=@JoinColumn(name="person_id"
			, referencedColumnName="person_id" , unique=true)
	)
	private Person person;

	// 无参数的构造器
	public Address()
	{
	}
	// 初始化全部成员变量的构造器
	public Address(String addressDetail)
	{
		this.addressDetail = addressDetail;
	}

	// addressId的setter和getter方法
	public void setAddressId(int addressId)
	{
		this.addressId = addressId;
	}
	public int getAddressId()
	{
		return this.addressId;
	}

	// addressDetail的setter和getter方法
	public void setAddressDetail(String addressDetail)
	{
		this.addressDetail = addressDetail;
	}
	public String getAddressDetail()
	{
		return this.addressDetail;
	}

	// person的setter和getter方法
	public void setPerson(Person person)
	{
		this.person = person;
	}
	public Person getPerson()
	{
		return this.person;
	}
}