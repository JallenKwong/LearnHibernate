package com.lun.light.mapfile.formula;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.lun.light.mapfile.SimpleConfigurationFactory;

public class NewsManager {
	public static void main(String[] args) throws Exception {
		// 实例化Configuration，
		Configuration conf = SimpleConfigurationFactory
				.createConfiguration().addAnnotatedClass(News.class);
		// configure();//用这该提示hibernate.cfg.xml的配置文字

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
				.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 创建消息对象
		News n = (News) sess.get(News.class, 1);

		if (n == null) {
			// 设置消息标题和消息内容
			n= new News();
			n.setTitle("疯狂Java联盟成立了");
			n.setContent("疯狂Java联盟成立了，" + "网站地址http://www.crazyit.org");
			// 保存消息
			sess.save(n);
		} else {
			//n = (News) sess.get(News.class, 1);
			// 输出fullContent值
			System.out.println(n.getFullContent());
		}
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
	}
}
