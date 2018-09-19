package com.lun.light.batch.update2;

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
		mgr.updateUsers();
		HibernateUtil.sessionFactory.close();
	}
	private void updateUsers()throws Exception
	{
		// 打开Session
		Session session = HibernateUtil.currentSession();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 定义批量更新的HQL语句
		String hqlUpdate = "update User u set name = :newName";
		// 执行更新
		int updatedEntities = session.createQuery( hqlUpdate )
			.setString( "newName", "新名字" )
			.executeUpdate();
		// 提交事务
		tx.commit();
		HibernateUtil.closeSession();
	}
}