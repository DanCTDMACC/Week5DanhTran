package beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Car;

public class RemoveCar {

	public static void main(String[] args) {
		
		// Create an EntityManagerFactory instance
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("CarDealerJPAProject");
		
		// Create an EntityManager instance
		EntityManager eManager = emFactory.createEntityManager();
		
		// Start the transaction with the database
		eManager.getTransaction().begin();
		
		// Set an id to find a car
		int idToFind = 7;
		
		// Find a car with the id of 1
		Car toRemove = eManager.find(Car.class, idToFind);
		
		// Remove the car found
		eManager.remove(toRemove);
		
		// Commit to save the DML action
		eManager.getTransaction().commit();
		
		// Clean objects.
		eManager.close();
		emFactory.close();
		
	}

}
