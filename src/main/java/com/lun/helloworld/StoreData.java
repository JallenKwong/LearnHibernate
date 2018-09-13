package com.lun.helloworld;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * 
 * Hibernate 简单示例
 * 
 * @author Administrator
 *
 */
public class StoreData {

	public static void main(String[] args) {
        //creating configuration object  
        Configuration cfg = new Configuration();  
        cfg.configure("com/lun/helloworld/hibernate.cfg.xml");//populates the data of the configuration file  

        controlData(cfg);
	}

	public static void controlData(Configuration cfg) {
		//creating seession factory object  
        SessionFactory factory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder()
        								.applySettings(cfg.getProperties()).build());  

        //creating session object  
        Session session = factory.openSession();  

        //creating transaction object  
        Transaction t = session.beginTransaction();  

        Employee e1 = new Employee();
        
        e1.setId(100);
        e1.setFirstName("Max");
        e1.setLastName("Su");

        session.save(e1);//persisting the object  
        
        Job job = new Job();
        job.setName("Programmer");
        
        session.save(job);

        t.commit();//transaction is committed  
        session.close();  

        System.out.println("successfully saved"); 
        System.exit(0);
	}

}
