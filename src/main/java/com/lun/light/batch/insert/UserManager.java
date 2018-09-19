package com.lun.light.batch.insert;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;


public class UserManager
{
	public static void main(String[] args)throws Exception
	{
		
		HibernateUtil.sessionFactory = HibernateUtil.buildSessionFactory(
				SimpleConfigurationFactory.createConfiguration()
					.setProperty("hibernate.cache.use_second_level_cache", "false")
					.addAnnotatedClass(User.class));
		
		UserManager mgr = new UserManager();
		mgr.addUsers();
		HibernateUtil.sessionFactory.close();
	}
	private void addUsers()throws Exception
	{
		// 打开Session
		Session session = HibernateUtil.currentSession();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 循环100000次，插入100000条记录
		for (int i = 0 ; i < 100000 ; i++ )
		{
			// 创建User实例
			User u1 = new User();
			u1.setName("xxxxx" + i);
			u1.setAge(i);
			u1.setNationality("china");
			// 在Session级别缓存User实例
			session.save(u1);
			// 每当累加器是20的倍数时，将Session中数据刷入数据库，
			// 并清空Session缓存。
			if (i % 20 == 0)
			{
				session.flush();
				session.clear();
			}
		}
		// 提交事务
		tx.commit();
		// 关闭事务
		HibernateUtil.closeSession();
	}
}