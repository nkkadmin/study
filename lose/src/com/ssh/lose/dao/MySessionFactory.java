package com.ssh.lose.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MySessionFactory {

	private static SessionFactory sessionFactory;

	// ���췽��˽�л�����֤����ģʽ
	private MySessionFactory(){
			
	}

	// ��ûỰ����
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties())
					.buildServiceRegistry();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}

 
}
