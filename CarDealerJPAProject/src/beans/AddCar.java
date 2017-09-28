package beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Car;

public class AddCar {

	public static void main(String[] args) {
		
		// Create EntityManagerFactory
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("CarDealerJPAProject");
		
		// Create EntityManager
		EntityManager eManager = emFactory.createEntityManager();
		
		// Start the transaction.
		eManager.getTransaction().begin();
		
		// Create an instance of a car to add to the database.
		Car toAdd = new Car("Ford", "Focus", 2017);
		
		// Add the car into the database.
		eManager.persist(toAdd);
		
		// Commit to save the database DML.
		eManager.getTransaction().commit();
		
		// Clean objects.
		eManager.close();
		emFactory.close();

	}

}
