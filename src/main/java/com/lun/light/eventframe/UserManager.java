package com.lun.light.eventframe;

import org.hibernate.*;
import org.hibernate.internal.*;

import com.lun.light.interceptor.User;
import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.event.spi.*;
import org.hibernate.event.service.spi.*;


public class UserManager {
//	static Configuration cfg = new Configuration()
//		// 加载hibernate.cfg.xml配置文件
//		.configure();
//	// 以Configuration实例来创建SessionFactory实例
//	static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//		.applySettings(cfg.getProperties()).build();
	static SessionFactory sf = HibernateUtil.buildSessionFactory(SimpleConfigurationFactory.createConfiguration()
			.setProperty("hibernate.current_session_context_class", "thread")
			.addAnnotatedClass(User.class));
	
	static{
		// 获取该SessionFactory的事件监听器注册器
		EventListenerRegistry elr = ((SessionFactoryImpl)sf)
			.getServiceRegistry().getService(EventListenerRegistry.class);
		// 使用用户指定的拦截器序列代替系统默认的save拦截器序列
		elr.setListeners(EventType.SAVE, MySaveListener.class);
		// 使用用户指定的拦截器序列代替系统默认的load拦截器序列
		elr.setListeners(EventType.LOAD, MyLoadListener.class);
	}
	
	public static void main(String[] args) {
		UserManager mgr = new UserManager();
		mgr.testUser();
		sf.close();
	}
	
	private void testUser() {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		// 创建一个User对象
		User u1 = new User();
		// 设置基本属性
		u1.setName("crazyit.org");
		u1.setAge(30);
		u1.setNationality("china");
		// 保存一个User对象
		session.save(u1);
		// 装载一个已有的User对象
		User u = (User)session.get(User.class , 1);
		// 改变属性
		u.setName("疯狂Java联盟");
		tx.commit();
	}
}
