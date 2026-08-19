package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveStudent {
	public static void main(String[] args) {
		Student s=new Student();
		
		s.setSid(103);
		s.setName("Jam");
		s.setEmail("jam@gmail.com");
		s.setPassword("jam@123");
		s.setAddress("Delhi");
		s.setContact(6608965321L);
		
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("Saq");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(s);
		et.commit();
	}
}
