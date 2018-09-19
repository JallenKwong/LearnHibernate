package com.lun.light.batch.delete;

import org.hibernate.Transaction;

import com.lun.light.batch.insert.User;
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
		mgr.deleteUsers();
		HibernateUtil.sessionFactory.close();
	}
	private void deleteUsers()throws Exception
	{
		// 打开Session
		Session session = HibernateUtil.currentSession();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 定义批量删除的HQL语句
		String hqlDelete = "delete User";
		// 执行删除
		int deletedEntities = session.createQuery( hqlDelete )
			.executeUpdate();
		// 提交事务
		tx.commit();
		HibernateUtil.closeSession();
	}
}