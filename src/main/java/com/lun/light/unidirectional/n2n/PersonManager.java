package com.lun.light.unidirectional.n2n;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;



public class PersonManager
{
	public static void main(String[] args) {
		
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
		// 创建一个Person对象
		Person p = new Person();
		// 设置Person的name为crazyit
		p.setName("crazyit");
		p.setAge(20);
		// 持久化Person对象
		session.save(p);
		// 创建一个瞬态的Address对象
		Address a = new Address("广州天河");
		// 设置Person和Address之间的关联关系
		p.getAddresses().add(a);
		// 再持久化Address对象
		session.persist(a);
		// 创建一个瞬态的Address对象
		Address a2 = new Address("上海虹口");
		// 设置Person和Address之间的关联关系
		p.getAddresses().add(a2);
		// 再持久化Address对象
		session.persist(a2);

		Person p2 = new Person();
		p2.setName("fkit");
		p2.setAge(29);
		p2.getAddresses().add(a2);
		session.save(p2);

		tx.commit();
		HibernateUtil.closeSession();
	}
}
