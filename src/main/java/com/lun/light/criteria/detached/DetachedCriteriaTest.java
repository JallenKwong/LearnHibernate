package com.lun.light.criteria.detached;

import org.hibernate.*;
import org.hibernate.criterion.*;

import com.lun.light.criteria.hello.Course;
import com.lun.light.criteria.hello.Enrolment;
import com.lun.light.criteria.hello.Student;
import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import java.util.*;



public class DetachedCriteriaTest
{
	public static void main(String[] args)
	{
		
		HibernateUtil.sessionFactory = HibernateUtil
				.buildSessionFactory(SimpleConfigurationFactory.createConfiguration()
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Enrolment.class)
						.addAnnotatedClass(Student.class)
						.setProperty("hibernate.hbm2ddl.import_files", "data2.sql"));
		
		DetachedCriteriaTest pt = new DetachedCriteriaTest();
		pt.datached();
		pt.subQuery();
		HibernateUtil.sessionFactory.close();
	}

	// 执行离线查询
	private void datached()
	{
		// 定义一个离线查询
		DetachedCriteria query = DetachedCriteria
			.forClass(Student.class)
			.setProjection(Property.forName("name"));
		// 打开Session和事务
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 执行离线查询
		List list = query.getExecutableCriteria(session)
			.list();
		// 遍历查询的结果
		for (Object obj : list)
		{
			System.out.println(obj);
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	// 执行子查询
	private void subQuery()
	{
		// 定义一个离线查询
		DetachedCriteria subQuery = DetachedCriteria
			.forClass(Student.class)
			.setProjection(Property.forName("name"));
		// 打开Session和事务
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 执行子查询
		List list = session.createCriteria(Student.class)
			// 下面两行代码的作用相同，都示范了通过子查询添加查询条件
			.add( Property.forName("name").in(subQuery))
//			.add( Subqueries.propertyIn("name" , subQuery))
			.list();
		// 遍历查询的结果
		for (Object obj : list)
		{
			System.out.println(obj);
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
}