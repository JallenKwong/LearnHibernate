package com.lun.light.component.embeddedid;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;

/**
 * @version 1.0
 */
public class PersonManager {
	public static void main(String[] args) {

		HibernateUtil.sessionFactory = HibernateUtil
				.buildSessionFactory(SimpleConfigurationFactory.createConfiguration().addAnnotatedClass(Person.class));

		PersonManager mgr = new PersonManager();
		mgr.createAndStorePerson();
		HibernateUtil.sessionFactory.close();
	}

	private void createAndStorePerson() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 创建Person对象
		Person person = new Person();
		// 为Person对象设置属性
		person.setAge(21);
		// 创建一个Name对象作为Person对象的标识属性值
		person.setName(new Name("crazyit.org", "疯狂Java联盟"));
		session.save(person);
		tx.commit();
		HibernateUtil.closeSession();
	}
}