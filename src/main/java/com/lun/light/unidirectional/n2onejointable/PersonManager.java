package com.lun.light.unidirectional.n2onejointable;

import org.hibernate.Transaction;

import com.lun.light.mapfile.SimpleConfigurationFactory;
import com.lun.util.HibernateUtil;

import org.hibernate.Session;


/**
 * @version  1.0
 */
public class PersonManager
{
	public static void main(String[] args)
	{
		
		HibernateUtil.sessionFactory = HibernateUtil.buildSessionFactory(
				SimpleConfigurationFactory.createConfiguration()
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Address.class))
				;
		
		PersonManager mgr = new PersonManager();
		mgr.testPerson();
		HibernateUtil.sessionFactory.close();
	}

	private void testPerson()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ����һ��Person����
		Person p = new Person();
		// ����Person��nameΪcrazyit�ַ���
		p.setName("crazyit");
		p.setAge(21);
		// ����һ��˲̬��Address����
		Address a = new Address("�������");
		// ����Person��Address֮��Ĺ�����ϵ
		p.setAddress(a);
		// �ٳ־û�Address����
		session.persist(a);
		// ����һ��˲̬��Address����
		Address a2 = new Address("�Ϻ����");
		// ����Person��Address֮��Ĺ�����ϵ
		p.setAddress(a2);
		// ���ڲ��������ӱ���ά��N-1������ϵ����˲��������ӱ��ϵ��
		// ���������������ȳ־û��ĸ�ʵ�塣
		// �־û�Address����
		session.persist(a2);
		// �־û�Person����
		session.save(p);
		// �־û�Address����
		session.save(a);
		tx.commit();
		HibernateUtil.closeSession();
	}
}
