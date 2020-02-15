package com.lun.light.bidirectional.one2njoinable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

public class SubjectManager {
	
	public static void main(String[] args){
		
		HibernateUtil.sessionFactory = HibernateUtil.buildSessionFactory(
				SimpleConfigurationFactory.createConfiguration()
				.addAnnotatedClass(Subject.class)
				);
		
		SubjectManager mgr = new SubjectManager();
		mgr.crud();
		mgr.crud2();
		HibernateUtil.sessionFactory.close();
	}
	
	public void crud() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		Subject sj = new Subject();
		sj.setName("英语");
		
		
		Subject sj1 = new Subject();
		sj1.setName("美式英语");
		sj1.setParent(sj);
		
		Subject sj11 = new Subject();
		sj11.setName("纽约美式英语");
		sj11.setParent(sj1);
		
		Subject sj12 = new Subject();
		sj12.setName("洛杉矶美式英语");
		sj12.setParent(sj1);
		
		
		Subject sj2 = new Subject();
		sj2.setName("英式英语");
		sj2.setParent(sj);
		
		Subject sj21 = new Subject();
		sj21.setName("伦敦英式英语");
		sj21.setParent(sj2);
		
		Subject sj22 = new Subject();
		sj22.setName("利物浦英式英语");
		sj22.setParent(sj2);
		
		session.saveOrUpdate(sj);
		session.saveOrUpdate(sj1);
		session.saveOrUpdate(sj11);
		session.saveOrUpdate(sj12);
		
		session.saveOrUpdate(sj2);
		session.saveOrUpdate(sj21);
		session.saveOrUpdate(sj22);
		
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	public void crud2() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		Subject sj = (Subject)session.get(Subject.class, 2);
		Subject sj1 = (Subject)session.get(Subject.class, 4);
		
		System.out.println(sj);
		System.out.println(sj1);
		
		//sj.getSubjects().forEach((a)->System.out.println(a));
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	
}
