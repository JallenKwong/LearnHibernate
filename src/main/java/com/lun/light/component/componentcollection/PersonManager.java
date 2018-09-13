package com.lun.light.component.componentcollection;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;


/**
 * @version  1.0
 */
public class PersonManager {
	public static void main(String[] args) {
		HibernateUtil.sessionFactory = HibernateUtil.buildSessionFactory(
				SimpleConfigurationFactory.createConfiguration()
				.addAnnotatedClass(Person.class));
		
		PersonManager mgr = new PersonManager();
		mgr.createAndStorePerson();
		HibernateUtil.sessionFactory.close();
	}

	private void createAndStorePerson() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 创建Person对象
		Person person = new Person();
		person.setAge(29);
		
		Name n = new Name("crazyit.org" , "疯狂Java联盟");
		n.getPower().put("运气" , 96);
		n.getPower().put("智慧" , 98);
		person.setName(n);
		session.save(person);
		
		tx.commit();
		HibernateUtil.closeSession();
	}
}