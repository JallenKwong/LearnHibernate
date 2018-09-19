package com.lun.light.hql.named;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;

import java.util.*;


public class HqlQuery {
	public static void main(String[] args) throws Exception {
		
		HibernateUtil.sessionFactory = HibernateUtil
				.buildSessionFactory(SimpleConfigurationFactory.createConfiguration()
						.addAnnotatedClass(Person.class)
						.addAnnotatedClass(MyEvent.class)
						.setProperty("hibernate.hbm2ddl.import_files", "data.sql"));
		
		HqlQuery mgr = new HqlQuery();
		mgr.findByNamedQuery();
		HibernateUtil.sessionFactory.close();
	}

	private void findByNamedQuery() throws Exception {
		// 打开Hibernate的Session和事务
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		System.out.println("===执行命名查询===");
		// 执行命名查询
		List pl = sess.getNamedQuery("myNamedQuery")
				// 根据HQL语句里参数索引为参数赋值
				.setInteger(0, 20).list();
		// 迭代输出查询得到的每个Person对象
		for (Object ele : pl) {
			Person p = (Person) ele;
			System.out.println(p.getName());
		}
		// 提交事务、关闭Session
		tx.commit();
		HibernateUtil.closeSession();
	}
}
