package com.lun.light.mapfile.dataobject;

import org.hibernate.cfg.*;
import org.hibernate.tool.hbm2ddl.*;

import com.lun.light.mapfile.SimpleConfigurationFactory;

//import org.hibernate.service.*;
//import org.hibernate.boot.registry.*;
/**
 * @version 1.0
 */
public class NewsManager {
	public static void main(String[] args) throws Exception {
		// 实例化Configuration，configure()方法默认加载hibernate.cfg.xml文件
		Configuration conf = SimpleConfigurationFactory.createConfiguration()
				.addResource("com/lun/light/mapfile/dataobject/News.hbm.xml")
				;
		// // 以Configuration实例创建SessionFactory实例
		// ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		// .applySettings(conf.getProperties()).build();
		// conf.buildSessionFactory(serviceRegistry);
		// 创建SchemaExport对象
		SchemaExport se = new SchemaExport(conf);
		// 设置输出格式良好的SQL脚本
		se.setFormat(true)
				// 设置保存SQL脚本的文件名
				.setOutputFile("new.sql")
				// 输出SQL脚本，并执行SQL脚本
				.create(true, true);
	}
}
