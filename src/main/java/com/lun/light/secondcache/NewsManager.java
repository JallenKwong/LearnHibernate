package com.lun.light.secondcache;

import org.hibernate.*;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import java.util.*;

public class NewsManager {
	// static Configuration conf = new Configuration()
	// .configure();
	// // 以Configuration实例创建SessionFactory实例
	// static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	// .applySettings(conf.getProperties()).build();
	static SessionFactory sf = HibernateUtil.buildSessionFactory(SimpleConfigurationFactory.createConfiguration()
			.setProperty("hibernate.cache.use_second_level_cache", "true")
			.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory")
			.setProperty("hibernate.generate_statistics", "true")
			.setProperty("hibernate.cache.use_structured_entries", "true")
			.setProperty("hibernate.current_session_context_class", "thread")
			.setProperty("hibernate.hbm2ddl.import_files", "data5.sql")
			.addAnnotatedClass(News.class));

	public static void main(String[] args) {
		NewsManager mgr = new NewsManager();
		mgr.secondCacheTest();
		mgr.stat();
	}

	// 测试二级缓存
	private void secondCacheTest() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		List list = session.createQuery("from News news").list();
		session.getTransaction().commit();
		System.out.println("----------------------");
		// 打开第二个Session
		Session sess2 = sf.getCurrentSession();
		sess2.beginTransaction();
		// 根据主键加载实体，系统将直接从二级缓存读取
		// 因此不会发出查询的SQL语句
		News news = (News) sess2.load(News.class, 1);
		System.out.println(news.getTitle());
		sess2.getTransaction().commit();
	}

	private void stat() {
		// ----------统计二级缓存----------
		Map cacheEntries = sf.getStatistics()
				// 二级缓存的名字默认与持久化类的类名相同
				.getSecondLevelCacheStatistics("com.lun.light.secondcache.News")
				.getEntries();
		System.out.println(cacheEntries);
	}
}
