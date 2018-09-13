package com.lun.light.mapfile.orderby;

import java.util.*;
import javax.persistence.*;
/**
 * @version  1.0
 */
@Entity
@Table(name="person_inf")
public class Person
{
	@Id @Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// 标识属性
	private Integer id;
	private String name;
	private int age;
	// 有序集合属性
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="training_inf",
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	@Column(name="training_name" , nullable=false)
	@OrderBy("training_name desc")
	private Set<String> trainings
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

	// trainings的setter和getter方法
	public void setTrainings(Set<String> trainings)
	{
		this.trainings = trainings;
	}
	public Set<String> getTrainings()
	{
		return this.trainings;
	}
}