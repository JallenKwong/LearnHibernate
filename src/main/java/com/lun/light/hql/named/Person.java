package com.lun.light.hql.named;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "person_inf")
// 定义命名查询
@NamedQuery(name = "myNamedQuery"
	, query = "from Person as p where p.age > ?")
public class Person
{
	// 定义标识属性
	@Id @Column(name = "person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 定义Person实例的name成员变量
	private String name;
	// 定义Person实例的age成员变量
	private int age;
	// 定义该Person实体关联的所有MyEvent实体
	@ManyToMany(targetEntity=MyEvent.class)
	@JoinTable(name = "person_event" ,
		joinColumns = @JoinColumn(name = "person_id"
			, referencedColumnName="person_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id"
			, referencedColumnName="event_id")
	)
	private Set<MyEvent> myEvents
		= new HashSet<>();
	// 定义一个集合属性
	// 集合属性，保留该对象关联的学校
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="person_email_inf",
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	@Column(name="email_detail" , nullable=false)
	private Set<String> emails
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

	// myEvents的setter和getter方法
	public void setMyEvents(Set<MyEvent> myEvents)
	{
		this.myEvents = myEvents;
	}
	public Set<MyEvent> getMyEvents()
	{
		return this.myEvents;
	}

	// emails的setter和getter方法
	public void setEmails(Set<String> emails)
	{
		this.emails = emails;
	}
	public Set<String> getEmails()
	{
		return this.emails;
	}

}