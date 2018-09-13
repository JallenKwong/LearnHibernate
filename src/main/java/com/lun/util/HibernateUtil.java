package com.lun.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sessionFactory = null;

	/**
	 * @param cfg
	 *            like com/lun/helloworld/hibernate.cfg.xml
	 * @return
	 */
	public static SessionFactory buildSessionFactory(String cfgcp) {
		try {
			Configuration cfg = new Configuration().configure(cfgcp);
			
			// Create the SessionFactory
			return cfg.buildSessionFactory(
					new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties())
					.build());
			
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory buildSessionFactory(Configuration cfg) {
		try {
			
			// Create the SessionFactory
			return cfg.buildSessionFactory(
					new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties())
					.build());
			
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null)
			throw new NullPointerException("sessionFactory is null");
		
		return sessionFactory;
	}

	// ThreadLocal可以隔离多个线程的数据共享，因此不再需要对线程同步
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	public static Session currentSession() throws HibernateException {
		Session s = session.get();
		// 如果该线程还没有Session,则创建一个新的Session
		if (s == null) {
			s = sessionFactory.openSession();
			// 将获得的Session变量存储在ThreadLocal变量session里
			session.set(s);
		}
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}

}