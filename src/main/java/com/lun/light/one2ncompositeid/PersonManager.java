package com.lun.light.one2ncompositeid;

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
		mgr.createAndStorePerson();
		HibernateUtil.sessionFactory.close();
	}
	private void createAndStorePerson()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 创建Person对象
		Person person = new Person();
		person.setAge(29);
		// 为复合主键的两个成员设置值
		person.setFirst("crazyit.org");
		person.setLast("疯狂Java联盟");
		Address a1 = new Address("广州天河");
		a1.setPerson(person);
		Address a2 = new Address("上海虹口");
		a2.setPerson(person);
		// 先保存主表实体
		session.save(person);
		// 再保存从表实体
		session.save(a1);
		session.save(a2);
		tx.commit();
		HibernateUtil.closeSession();
	}
}