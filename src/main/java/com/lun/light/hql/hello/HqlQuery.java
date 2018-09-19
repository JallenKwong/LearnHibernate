package com.lun.light.hql.hello;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;

import java.text.SimpleDateFormat;
import java.util.*;

public class HqlQuery {
	
	public static void main(String[] args) throws Exception {

		HibernateUtil.sessionFactory = HibernateUtil
				.buildSessionFactory(SimpleConfigurationFactory.createConfiguration()
						.addAnnotatedClass(Person.class)
						.addAnnotatedClass(MyEvent.class)
						.setProperty("hibernate.hbm2ddl.import_files", "data.sql"));//插入查询数据

		HqlQuery mgr = new HqlQuery();
		
		mgr.checkWhatItWasUsedFor();
//		// 调用查询方法
//		mgr.findPersons();
//		// 调用第二个查询方法
//		mgr.findPersonsByHappenDate();
//		// 调用第二个查询方法
//		mgr.findPersonProperty();
	}

	//hibernate官方文档中的select firstName||' '||initial||' '||upper(lastName) from Person 的实验
	private void checkWhatItWasUsedFor() {
		String hql = "select name||' '||name||' '||upper(name) from Person";
		
		// 获得Hibernate Session
		Session sess = HibernateUtil.currentSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		
		List list = sess.createQuery(hql).list();
		
		for(Object obj : list) {
			System.out.println((String)obj);
		}
		
		tx.commit();
		HibernateUtil.closeSession();
		
		//实验结果 || 用于字符串拼接
		/*
		Hibernate: 
		    select
		        concat(person0_.name,
		        ' ',
		        person0_.name,
		        ' ',
		        upper(person0_.name)) as col_0_0_ 
		    from
		        person_inf person0_
		        
		//输出结果
		crazyit.org crazyit.org CRAZYIT.ORG
		老朱 老朱 老朱
		*/
	}
	
	
	// 第一个查询方法
	private void findPersons() {
		// 获得Hibernate Session
		Session sess = HibernateUtil.currentSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 以HQL语句创建Query对象.
		List pl = sess.createQuery("select distinct p from Person p " + 
						"join p.myEvents where title = :eventTitle")
				// 执行setString()方法为HQL语句的参数赋值
				.setString("eventTitle", "很普通的事情")
				// Query调用list()方法获取查询的全部实例
				.list();
		// 遍历查询的全部结果
		for (Object ele : pl) {
			Person p = (Person) ele;
			System.out.println(p.getName());
		}
		// 提交事务
		tx.commit();
		HibernateUtil.closeSession();
	}

	// 第二个查询方法
	private void findPersonsByHappenDate() throws Exception {
		// 获得Hibernate Session对象
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		// 解析出Date对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = sdf.parse("2005-01-01");
		System.out.println("系统开始通过日期查找人" + start);
		// 通过Session的createQuery方法创建Query对象
		List pl = sess
				.createQuery("select distinct p from Person p " 
						+ "inner join p.myEvents event where event.happenDate "
						+ "between :firstDate and :endDate")
				// 设置参数
				.setDate("firstDate", start).setDate("endDate", new Date())
				// 返回结果集
				.list();
		// 遍历结果集
		for (Object ele : pl) {
			Person p = (Person) ele;
			System.out.println(p.getName());
		}
		tx.commit();
		HibernateUtil.closeSession();
	}

	// 第三个查询方法：查询属性
	private void findPersonProperty() {
		// 获得Hibernate Session
		Session sess = HibernateUtil.currentSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 以HQL语句创建Query对象.
		List pl = sess.createQuery("select distinct p.id,  p.name , p.age " 
									+ "from Person p join p.myEvents")
				// Query调用list()方法访问查询得到的全部属性
				.list();
		// 遍历查询的全部结果
		for (Object ele : pl) {
			Object[] objs = (Object[]) ele;
			System.out.println(java.util.Arrays.toString(objs));
		}
		// 提交事务
		tx.commit();
		HibernateUtil.closeSession();
	}
}