package com.lun.light.componententity;

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
				.addAnnotatedClass(School.class)
				.addAnnotatedClass(Person.class));
		
		
		PersonManager mgr = new PersonManager();
		mgr.testPerson();
		HibernateUtil.sessionFactory.close();
	}
	// 保存Person和School对象
	private void testPerson()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 创建一个Person对象
		Person p = new Person();
		// 设置Person的name为crazyit
		p.setName("crazyit");
		p.setAge(21);
		session.save(p);
		// 创建一个Address对象
		Address a = new Address("广州天河");
		// 设置Person对象的Address属性
		p.setAddress(a);
		// 创建2个School对象
		School s1 = new School("疯狂iOS训练营");
		School s2 = new School("疯狂Java训练营");
		// 保存2个School实体
		session.save(s1);
		session.save(s2);
		// 设置Address对象和两个School的关联关系
		a.getSchools().add(s1);
		a.getSchools().add(s2);
		tx.commit();
		HibernateUtil.closeSession();
	}
}
