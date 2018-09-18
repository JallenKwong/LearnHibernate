package com.lun.light.componententity;

import java.util.*;

import javax.persistence.*;
import org.hibernate.annotations.Parent;

@Embeddable
public class Address
{
	// 代表地址详细信息的成员变量
	@Column(name="address_detail")
	private String addressDetail;
	// 定义该组件属性所在的包含实体
	@Parent
	private Person person;
	// 定义保留关联实体的Set集合
	@OneToMany(targetEntity=School.class)
	// 映射外键列，此处告诉Hibernate在School实体对应的表中增加外键列
	// 该外键列的列名为address_id，参照person_inf表的peron_id主键列
	@JoinColumn(name="address_id", referencedColumnName="person_id")
	private Set<School> schools
		= new HashSet<>();

	public Address(){}

	public Address(String addressDetail)
	{
		this.addressDetail = addressDetail;
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

	// schools的setter和getter方法
	public void setSchools(Set<School> schools)
	{
		this.schools = schools;
	}
	public Set<School> getSchools()
	{
		return this.schools;
	}
}