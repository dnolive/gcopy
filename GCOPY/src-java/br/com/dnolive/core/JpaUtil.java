package br.com.dnolive.core;

import java.util.Calendar;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaUtil 
{
	EntityManagerFactory emf; 
	EntityManager em;
	String pu;

	private static EntityManager instance;
	
	private JpaUtil(String pu) {
		this.emf = Persistence.createEntityManagerFactory(pu);
		this.em = emf.createEntityManager();
	}

	public static EntityManager getEntityManager(String pu) {
		if (instance == null) {
			JpaUtil jpa = new JpaUtil(pu);
			instance = jpa.em;
		}
		return instance;
	}
	
	
	public static String getSema4() {
		Random r = new Random();
		Calendar c = Calendar.getInstance();
		Long ms = Math.abs(r.nextLong()*c.getTimeInMillis());
		String result = ms.toString();
		return result;
	}
}
