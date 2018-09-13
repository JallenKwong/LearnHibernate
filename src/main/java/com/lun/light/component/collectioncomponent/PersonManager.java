package com.lun.light.component.collectioncomponent;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;

import java.util.*;

/**
 * @version  1.0
 */
public class PersonManager
{
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
		//为Person对象设置属性
		person.setAge(29);
		//创建一个Map集合
		Map<String , Name> nicks =
			new HashMap<String , Name>();
		// 向List集合里放入Name对象
		person.getNicks().add(new Name("Wawa" , "Wawa"));
		person.getNicks().add(new Name("Yeeku" , "Lee"));
		// 向List集合里放入Score对象
		person.getScores().put("语文" , new Score("良好" , 85));
		person.getScores().put("数学" , new Score("优秀" , 92));
		session.save(person);
		tx.commit();
		HibernateUtil.closeSession();
	}
}