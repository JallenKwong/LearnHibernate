package com.lun.light.hql.hello;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="event_inf")
public class MyEvent
{
	// 定义标识属性
	@Id @Column(name="event_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 定义事件名称的成员变量
	private String title;
	// 定义事件发生时间的成员变量
	private Date happenDate;
	// 定义该MyEvent实体关联的所有Person实体
	@ManyToMany(targetEntity=Person.class , mappedBy="myEvents")
	private Set<Person> actors
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

	// title的setter和getter方法
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// happenDate的setter和getter方法
	public void setHappenDate(Date happenDate)
	{
		this.happenDate = happenDate;
	}
	public Date getHappenDate()
	{
		return this.happenDate;
	}

	// actors的setter和getter方法
	public void setActors(Set<Person> actors)
	{
		this.actors = actors;
	}
	public Set<Person> getActors()
	{
		return this.actors;
	}
}