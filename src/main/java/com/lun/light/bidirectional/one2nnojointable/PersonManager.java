package com.lun.light.bidirectional.one2nnojointable;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

public class PersonManager {
	public static void main(String[] args) {
		
		HibernateUtil.sessionFactory = HibernateUtil.buildSessionFactory(
				SimpleConfigurationFactory.createConfiguration()
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Person.class));
		
		PersonManager mgr = new PersonManager();
		mgr.testPerson();
		HibernateUtil.sessionFactory.close();
	}

	private void testPerson() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 创建一个瞬态的Person对象
		Person p = new Person();
		// 设置Person的name为crazyit.org字符串
		p.setName("crazyit.org");
		p.setAge(29);
		// 持久化Person对象(对应于插入主表记录)
		session.save(p);//最佳实践，先存主表，后存从表
		// 创建一个瞬态的Address对象
		Address a = new Address("广州天河");
		// 先设置Person和Address之间的关联关系
		a.setPerson(p);
		// 再持久化Address对象(对应于插入从表记录)
		session.persist(a);
		// 创建一个瞬态的Address对象
		Address a2 = new Address("上海虹口");
		// 先设置Person和Address之间的关联关系
		a2.setPerson(p);
		// 再持久化Address对象(对应于插入从表记录)
		session.persist(a2);
		
		// address表会少很了person的字段
//		p.getAddresses().add(a);
//		p.getAddresses().add(a2);
//		session.save(p);
		
		Integer id = p.getId();
		System.out.println(id);
		tx.commit();
		
		HibernateUtil.closeSession();
		
		
		session = HibernateUtil.currentSession();
		
		
		//需要重创一个新Session出来，否则Person.getAddresses()会得不出来，这可能跟session的缓存有关
		tx = session.beginTransaction();
		
		
		Person p2 = (Person)session.get(Person.class, id);
		
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println(p2.getAddresses());
		
		System.out.println("----");
		
		p2 = (Person)session.createQuery("from Person p where p.id=:id")
			.setParameter("id", id)
			.uniqueResult();
		
//		没有输出结果 
		System.out.println(p2.getAddresses());
		
		session.delete(p2);//由于级联关系，从表的相关联的记录也会被删除
		
		tx.commit();
		HibernateUtil.closeSession();
	}

}
