package com.stratapps.HibernateFirst;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Student student = new Student();
		
		student.setId(7);
		student.setName("Sandhya");
		student.setMarks(100.00);
		
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(student);
		System.out.println(student);

		tx.commit();
		List<Student> list = session.createQuery("from Student").list();
		for(Student st : list) {
			System.out.println(st.getName());
		}
		session.close();
		factory.close();
		
//		Session session = factory.getCurrentSession();
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
	}
}
