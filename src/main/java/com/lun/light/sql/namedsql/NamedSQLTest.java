package com.lun.light.sql.namedsql;

import org.hibernate.*;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import java.util.*;



public class NamedSQLTest
{
	public static void main(String[] args)
	{
		HibernateUtil.sessionFactory = HibernateUtil
				.buildSessionFactory(SimpleConfigurationFactory.createConfiguration()
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Enrolment.class)
						.addAnnotatedClass(Student.class)
						.setProperty("hibernate.hbm2ddl.import_files", "data2.sql,data3.sql"));
						//data3.sql来创建存储过程
		
		NamedSQLTest test = new NamedSQLTest();
		test.simpleQuery();
		test.query();
		test.callProcedure();
		HibernateUtil.sessionFactory.close();
	}

	// 执行简单的命名SQL查询
	private void simpleQuery()
	{
		// 打开Session和事务
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 调用命名查询，直接返回结果
		List list = session.getNamedQuery("simpleQuery")
			.list();
		tx.commit();
		HibernateUtil.closeSession();
		// 遍历结果集
		for(Object ele : list)
		{
			// 每个集合元素是Student对象
			Student s = (Student)ele;
			System.out.println(s.getName() + "\t");
		}
	}

	// 执行命名SQL查询
	private void query()
	{
		// 打开Session和事务
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 调用命名查询，直接返回结果
		List list = session.getNamedQuery("queryTest")
			.setInteger("targetYear" , 2005)
			.list();
		tx.commit();
		HibernateUtil.closeSession();
		// 遍历结果集
		for(Object ele : list)
		{
			// 每个集合元素是Student、Enrolment
			// 和stuName三个元素的数组
			Object[] objs = (Object[])ele;
			Student s = (Student)objs[0];
			Enrolment e = (Enrolment)objs[1];
			Course c = (Course)objs[2];
			String stuName = (String)objs[3];
			System.out.println(s.getName() + "\t"
				+ e.getYear() + "\t" + e.getSemester()
				+ "\t=" + e.getCourse().getName() + "=\t" + stuName);
		}
	}

	// 调用存储过程
	private void callProcedure()
	{
		// 打开Session和事务
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 调用命名查询，直接返回结果
		List list = session.getNamedQuery("callProcedure")
			.list();
		tx.commit();
		HibernateUtil.closeSession();
		// 遍历结果集
		for(Object ele : list)
		{
			// 每个集合元素是Student对象
			Student s = (Student)ele;
			System.out.println(s.getName());
		}
	}
}
