package com.lun.light.mapfile.orderby;

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
		// 插入数据
		 Person p = new Person();
		 p.setName("crazyit.org");
		 p.setAge(21);
		 p.getTrainings().add("SCJP");
		 p.getTrainings().add("疯狂Java实训营");
		 p.getTrainings().add("疯狂软件教育中心");
		 session.save(p);

		// 执行查询
		p = (Person) session.get(Person.class, 1);
		System.out.println(p.getTrainings());

		tx.commit();
		HibernateUtil.closeSession();
	}
}