package com.gonzalo.flux;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gonzalo.flux.model.Persona;

public class DemosqlApplication {

	public static void main(String[] args) {
		
		/*
		String url = "jdbc:mysql://localhost:3306/pruebas2?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC";
		String url2 = "jdbc:mysql://localhost:3306/pruebas2?serverTimezone=UTC";
		String usuario = "admin";
		String contra = "admin";
		
		try {
			Connection con = DriverManager.getConnection(url2,usuario, contra);
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Persona.class)
				.buildSessionFactory();
		Session session = factory.openSession();

		try {
			Persona p = new Persona("Alberto", "Chuschin");
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			session.close();
		}finally {
			factory.close();
		}
	}

}
