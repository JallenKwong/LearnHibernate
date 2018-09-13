package com.lun.light.mapfile.sortedset;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;

/**
 * @version 1.0
 */
public class PersonManager {
	public static void main(String[] args) {
		
		HibernateUtil.sessionFactory = HibernateUtil.buildSessionFactory(
				SimpleConfigurationFactory.createConfiguration().addAnnotatedClass(Person.class));
		
		PersonManager mgr = new PersonManager();
		mgr.createAndStorePerson();
		HibernateUtil.sessionFactory.close();
	}

	private void createAndStorePerson() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 创建Person对象
		Person wawa = new Person();
		wawa.setAge(21);
		wawa.setName("crazyit.org");
		// 为trainings集合属性添加2个元素
		wawa.getTrainings().add("Wild Java Camp");
		wawa.getTrainings().add("Sun SCJP");
		session.save(wawa);
		Person p = (Person) session.get(Person.class, 1);
		// 再次添加一个集合元素
		p.getTrainings().add("CCNP");
		tx.commit();
		HibernateUtil.closeSession();
	}
}