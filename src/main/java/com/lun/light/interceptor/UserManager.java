package com.lun.light.interceptor;

import org.hibernate.*;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

public class UserManager {
//	static Configuration cfg = new Configuration()
//		// 加载hibernate.cfg.xml配置文件
//		.configure()
//		// 设置启用全局拦截器
//		.setInterceptor(new MyInterceptor());
//	// 以Configuration实例创建SessionFactory实例
//	static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//		.applySettings(cfg.getProperties()).build();
	
	static SessionFactory sf = HibernateUtil.buildSessionFactory(SimpleConfigurationFactory.createConfiguration()
			.setProperty("hibernate.current_session_context_class", "thread")
			.addAnnotatedClass(User.class)
			.setInterceptor(new MyInterceptor()));
	
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
		u1.setName("crazyit.org");
		u1.setAge(30);
		u1.setNationality("china");
		session.save(u1);
		User u = (User)session.load(User.class , 1);
		u.setName("疯狂Java联盟");
		tx.commit();
	}
}
