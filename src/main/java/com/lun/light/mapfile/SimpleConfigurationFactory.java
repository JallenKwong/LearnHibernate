package com.lun.light.mapfile;

import org.hibernate.cfg.Configuration;


/**
 * 
 * 解决hibernate.cfg.xml 部分配置片段不能复用的问题
 * 
 * @author 白居布衣
 *
 */
public class SimpleConfigurationFactory {
	
	public static Configuration createConfiguration() {
		return new Configuration()
				.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
				.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/learnhibernate?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC")
				.setProperty("hibernate.connection.username" , "root")
				.setProperty("hibernate.connection.password" , "123")
				
				.setProperty("hibernate.c3p0.max_size" , "20")
				.setProperty("hibernate.c3p0.min_size" , "1")
				.setProperty("hibernate.c3p0.timeout" , "5000")
				.setProperty("hibernate.c3p0.max_statements" , "100")
				.setProperty("hibernate.c3p0.idle_test_period" , "3000")
				.setProperty("hibernate.c3p0.acquire_increment" , "2")
				.setProperty("hibernate.c3p0.validate" , "true")
				
				.setProperty("hibernate.dialect"
					, "org.hibernate.dialect.MySQL5InnoDBDialect")
				.setProperty("hibernate.hbm2ddl.auto" , "create")
				.setProperty("hibernate.show_sql","true")
				.setProperty("hibernate.format_sql", "true")
				;
	}
}
