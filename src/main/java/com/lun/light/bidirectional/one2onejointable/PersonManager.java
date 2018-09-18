package com.lun.light.bidirectional.one2onejointable;

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
		// 设置Person和Address之间的关联关系
//		p.setAddress(a);
		a.setPerson(p);
		// 持久化Address对象
		session.persist(a);
		// 持久化Person对象
		session.save(p);
		tx.commit();
		HibernateUtil.closeSession();
	}
}
