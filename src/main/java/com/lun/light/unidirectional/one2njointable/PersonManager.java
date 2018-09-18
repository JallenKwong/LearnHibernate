package com.lun.light.unidirectional.one2njointable;

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
		// 设置Person的name为crazyit.org字符串
		p.setName("crazyit.org");
		p.setAge(21);
		// 创建一个瞬态的Address对象
		Address a = new Address("广州天河");
		// 设置Person和Address之间的关联关系
		p.getAddresses().add(a);
		// 创建一个瞬态的Address对象
		Address a2 = new Address("上海虹口");
		// 设置Person和Address之间的关联关系
		p.getAddresses().add(a2);
		// 由于采用了连接表来维护1-N关联关系，因此不存在主从表关系，
		// 程序可以随意控制先持久化哪个实体。
		// 持久化Address对象
		session.persist(a2);
		// 持久化Person对象
		session.save(p);
		// 持久化Address对象
		session.persist(a);
		tx.commit();
		HibernateUtil.closeSession();
	}
}
