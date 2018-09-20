package com.lun.light.currentsession;

import org.hibernate.*;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;


public class NewsManager
{
	public static void main(String[] args)
		throws Exception
	{
//		Configuration conf = new Configuration().configure();
//		// 以Configuration实例创建SessionFactory实例
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//			.applySettings(conf.getProperties()).build();
		
		
		SessionFactory sf = HibernateUtil
				.buildSessionFactory(SimpleConfigurationFactory.createConfiguration()
						.setProperty("hibernate.current_session_context_class", "thread")
						.addAnnotatedClass(News.class));
		// 打开上下文相关的Session
		Session sess = sf.getCurrentSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 创建消息实例
		News n = new News();
		// 设置消息标题和消息内容
		n.setTitle("疯狂Java联盟成立了");
		n.setContent("疯狂Java联盟成立了，"
			+ "网站地址http://www.crazyit.org");
		// 保存消息
		sess.save(n);
		// 提交事务
		tx.commit();
		// Session随事务的提交自动关闭，因此无需手动关闭
	}
}
