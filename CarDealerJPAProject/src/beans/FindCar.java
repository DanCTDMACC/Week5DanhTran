package beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Car;

public class FindCar {

	public static void main(String[] args) {
		
		// Create an instance of EntityMangerFactory
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("CarDealerJPAProject");
		
		// Create an instance of EntityManger
		EntityManager eManager = emFactory.createEntityManager();
		
		// Start the transaction with the database
		eManager.getTransaction().begin();
		
		// Set an id to find a car
		int idToFind = 7;
		
		// Find a car in the database with the id of 1
		Car found = eManager.find(Car.class, idToFind);
		
		// Print out the car found
		System.out.println("Make: " + found.getMake() + 
						"\nModel: " + found.getModel() + 
						"\nYear: " + found.getYear());
		
		// Clean objects
		eManager.close();
		emFactory.close();

	}

}
