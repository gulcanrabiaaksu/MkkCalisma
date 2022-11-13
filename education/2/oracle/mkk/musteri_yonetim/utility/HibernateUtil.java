package com.mkk.ugd.oracle.mkk.musteri_yonetim.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author haluk
 *
 *	veritabanına bağlantı ile ilgili
 *  yardımcı işlemleri barındıran sınıf
 */
public final class HibernateUtil 
{
	private static SessionFactory SESSION_FACTORY;
	
	private HibernateUtil()
	{
		
	}
	
	public static SessionFactory getSessionFactory()
	{
		if(SESSION_FACTORY == null) // null degil ise olusturmaz
		{
			Configuration configuration = new Configuration().configure();
			/*
			 * configure metodu sayesinde, hibernate.cfg.xml kaynaginin 
			 * "map" ve "property"lerini kullaniriz.
			 */
			/*
			 * configuration nesnesi uzerinden, sessionFactory olusturuyoz.
			 * Bir uygulama tek bir configuration nesnesi uzerinden tek bir
			 * sessionFactory nesnesi kullanir ve buradan 
			 * pek cok farkli session olusturulur. Bunlar thread'dir.
			 */
			
			
			
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			/*
			 * StandardServiceRegistry ana ServiceRegistry'i tanimlar.
			 * StandardServiceRegistryBuilder sinifinin applySettings metodu ile
			 * hangi dosyadan ozellik cekecegimizi belirleriz.
			 * 
			 * 2 parametreli olan applySettings metodu ozellik adi ve ozellik degerini,
			 * tek parametreli olan ise "map" alir.getProperties metodu ile xml dosyasinin icindeki
			 * property'leri map olarak aliriz.
			 */
			
			
			
			SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
			/*
			 * configuration nesnesine, hangi servisleri kullanacagimizi belirtmemiz gerekiyor.
			 * Hangi servisleri kullanacagimizi (servis kayit listesi = service registry) 
			 * serviceRegistry nesnesi ile belirtiriz.
			 * Bu servis bilgilerini kullanarak Configuration sinifinin buildSessionFactory metodu 
			 * araciligiyla bir "session" havuzu olustururuz.
			 */
		}
	
		return SESSION_FACTORY;
	}
	
	public static Session getSession()
	{
		if(getSessionFactory().getCurrentSession() != null)
		{
			return getSessionFactory().getCurrentSession().isOpen()
					? getSessionFactory().getCurrentSession()
					: getSessionFactory().openSession();						
		}
		else
		{
			return getSessionFactory().openSession();
		}
	}
	
	public static Transaction getTransaction()
	{
		if(getSession().getTransaction() != null)
		{
			return getSession().getTransaction().isActive()
					? getSession().getTransaction()
					: getSession().beginTransaction();
		}
		else
		{
			return getSession().beginTransaction();
		}
	}
	
	public static void closeSession()
	{
		if(getSession() != null) getSession().close();
	}
	
	public static void closeSessionFactory()
	{
		if(getSessionFactory() != null) getSessionFactory().close();
	}
	
}
