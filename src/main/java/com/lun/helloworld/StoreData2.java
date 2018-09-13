package com.lun.helloworld;

import org.hibernate.cfg.Configuration;

/**
 * 
 * 以硬编码的方式进行配置
 * 
 * @author 白居布衣
 *
 */
public class StoreData2 {

	public static void main(String[] args) {
		Configuration conf = new Configuration()
				.addAnnotatedClass(com.lun.helloworld.Job.class)
				.addClass(Employee.class)
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
				.setProperty("hibernate.hbm2ddl.auto" , "update")
				.setProperty("hibernate.show_sql","true")
				;
		StoreData.controlData(conf);	
	}

}
