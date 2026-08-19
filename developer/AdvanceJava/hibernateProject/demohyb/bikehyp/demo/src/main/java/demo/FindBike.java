package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBike {
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Saq");
		EntityManager em=emf.createEntityManager();
		
		Bike b=em.find(Bike.class, 101);
		System.out.println(b);
	}
}
