package com.lun.light.filter;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;

import java.util.*;
import java.text.SimpleDateFormat;


public class ProductManager {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws Exception{
		
		HibernateUtil.sessionFactory = HibernateUtil
				.buildSessionFactory(SimpleConfigurationFactory.createConfiguration()
						.addAnnotatedClass(Product.class)
						.addAnnotatedClass(Category.class)
						.setProperty("hibernate.hbm2ddl.import_files", "data4.sql"));
		
		ProductManager mgr = new ProductManager();
		mgr.test();
		HibernateUtil.sessionFactory.close();
	}

	private void test() throws Exception
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		// 启动effectiveDate过滤器，并设置参数
		session.enableFilter("effectiveDate")
			.setParameter("asOfDate", new Date());
		// 启动category过滤器，并设置参数
		session.enableFilter("category")
			.setParameter("catId", 2);
		// 查询所有Product实体，不加任何筛选条件，但effectiveDate过滤器会起作用
		List list = session.createQuery("from Product as p").list();     // ①
		for (Object obj : list)
		{
			Product p = (Product)obj;
			System.out.println(p.getName());
			// 获取Product对象关联的Category试题，2个过滤器会起作用。
			System.out.println("----" + p.getCategories());     // ②
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
}
