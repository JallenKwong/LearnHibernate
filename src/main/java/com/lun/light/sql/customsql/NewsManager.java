package com.lun.light.sql.customsql;

import org.hibernate.*;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;



public class NewsManager {
	public static void main(String[] args) throws Exception{
		// 实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
//		Configuration conf = new Configuration().configure();
//		// 以Configuration实例创建SessionFactory实例
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//			.applySettings(conf.getProperties()).build();
//		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		
		HibernateUtil.sessionFactory = HibernateUtil
				.buildSessionFactory(SimpleConfigurationFactory.createConfiguration()
						.addAnnotatedClass(News.class));
		
		// 实例化Session
		Session sess = HibernateUtil.sessionFactory.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
//		// 创建消息实例
		News n = new News();
		// 设置消息标题和消息内容
		n.setTitle("疯狂Java联盟成立了");
		n.setContent("疯狂Java联盟成立了，"
			+ "网站地址http://www.crazyit.org");
		// 保存消息
		sess.save(n);
		News n2 = (News)sess.get(News.class, 1);
		System.out.println(n2.getTitle());
		System.out.println(n2.getContent());
		n2.setContent("aaaaaaaa");
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
	}
}
