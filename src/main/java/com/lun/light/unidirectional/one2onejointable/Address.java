package com.lun.light.unidirectional.one2onejointable;


import javax.persistence.*;
/**
 * @version  1.0
 */
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
}