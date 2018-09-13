package com.lun.light.mapfile.sortedset;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.SortNatural;

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
	// 映射保存集合元素的表
	@CollectionTable(name="training_inf",
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	// 定义保存集合元素的数据列
	@Column(name="training_name" , nullable=false)
	// 使用@SortNatural指定使用自然排序
	@SortNatural
	private SortedSet<String> trainings
		= new TreeSet<>();

	// id的setter和getter方法
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
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
	public void setTrainings(SortedSet<String> trainings)
	{
		this.trainings = trainings;
	}
	public SortedSet<String> getTrainings()
	{
		return this.trainings;
	}
}