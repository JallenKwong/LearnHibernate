package com.lun.light.batch.update;

import org.hibernate.*;

import com.lun.light.batch.insert.User;
import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;


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
		// 查询出User表中的所有记录
		
		session.save(new User("haha",1,null));
		session.flush();
		
		ScrollableResults users = session.createQuery("from User")
			.setCacheMode(CacheMode.IGNORE)
			.scroll(ScrollMode.FORWARD_ONLY);
		int count=0;
		// 遍历User表中的全部记录
		while ( users.next() )
		{
			User u = (User) users.get(0);
			u.setName("新用户名" + count);
			// 当count为20的倍数时，
			// 将更新的结果从Session中flush到数据库。
			if ( ++count % 20 == 0 )
			{
				session.flush();
				session.clear();
			}
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
}