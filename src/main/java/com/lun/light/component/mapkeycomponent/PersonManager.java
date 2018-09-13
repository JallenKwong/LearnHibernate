package com.lun.light.component.mapkeycomponent;

import org.hibernate.Transaction;

import com.lun.util.HibernateUtil;

import org.hibernate.Session;


/**
 * @version  1.0
 */
public class PersonManager
{
	public static void main(String[] args)
	{
		PersonManager mgr = new PersonManager();
		mgr.createAndStorePerson();
		HibernateUtil.sessionFactory.close();
	}
	private void createAndStorePerson(){
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 创建Person对象
		Person person = new Person();
		person.setAge(21);
		// 向Map集合里放入Name对象
		person.getNickPower().put(new Name("Wawa" , "Wawa") , 92);
		person.getNickPower().put(new Name("crazyit.org" , "疯狂Java联盟") , 96);
		session.save(person);
		tx.commit();
		HibernateUtil.closeSession();
	}
}