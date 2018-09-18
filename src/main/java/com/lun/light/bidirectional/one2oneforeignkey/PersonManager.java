package com.lun.light.bidirectional.one2oneforeignkey;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;



public class PersonManager
{
	public static void main(String[] args)
	{
		
		HibernateUtil.sessionFactory = HibernateUtil.buildSessionFactory(
				SimpleConfigurationFactory.createConfiguration()
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Person.class));
		
		PersonManager mgr = new PersonManager();
		mgr.testPerson();
		HibernateUtil.sessionFactory.close();
	}

	private void testPerson()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 创建一个瞬态的Person对象
		Person p = new Person();
		// 设置Person的name为crazyit字符串
		p.setName("crazyit");
		p.setAge(21);
		// 创建一个瞬态的Address对象
		Address a = new Address("广州天河");
		// 由于Person实体使用@OneToOne注解时指定了mappedBy属性
		// 因此Person实体不能用于控制关联关系，只能由Address实体控制关联关系
		a.setPerson(p);
//		p.setAddress(a);
		// 先持久化Person对象（对应为插入主表记录）
		session.save(p);
		// 再持久化Address对象（对应为插入从表记录）
		session.persist(a);
		tx.commit();
		HibernateUtil.closeSession();
	}
}
