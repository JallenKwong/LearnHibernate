package com.lun.light.component.mapkeycomponent;

import java.util.*;
import javax.persistence.*;
/**
 * @version  1.0
 */
@Entity
@Table(name="person_inf")
public class Person {
	// 标识属性
	@Id @Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int age;
	// 集合属性nickPower
	@ElementCollection(targetClass=Integer.class)
	@CollectionTable(name="nick_power_inf", joinColumns
		=@JoinColumn(name="person_id" , nullable=false))
	@Column(name="nick_power" , nullable=false)
	// 指定Map key的类型
	@MapKeyClass(Name.class)
	private Map<Name , Integer> nickPower
		= new HashMap<Name , Integer>();

	// id的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
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

	// nickPower的setter和getter方法
	public void setNickPower(Map<Name , Integer> nickPower)
	{
		this.nickPower = nickPower;
	}
	public Map<Name , Integer> getNickPower()
	{
		return this.nickPower;
	}
}