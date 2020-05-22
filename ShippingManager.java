
public class ShippingManager{
	Order[] orders;
	CargoShip aCargoShip;
	FerryShip aFerryShip;
	 
	public ShippingManager(Order[] orders, CargoShip aCargoShip, FerryShip aFerryShip){
		 this.orders = orders;
		 this.aCargoShip = aCargoShip;
		 this.aFerryShip = aFerryShip;
	}
	

	public void completeOrders() {
	
		for(int i = 0; i < orders.length; i++){

			if(orders[i].getNumberOfPassengers() == 0){
				transportAllCargo(orders[i].getNumberOfCargo(), aCargoShip, orders[i].getDistance());
			}else{
				transportAllPassengers(orders[i].getNumberOfPassengers(), aFerryShip, orders[i].getDistance());
			}

			printOrderSummary(orders[i]);

		}

		//loop through the array of orders
			//if necessary transportAllCargo();
			//if necessary transportAllPassengers();
			//printOrderSummary();

	}
	
	public void printOrderSummary(Order order){
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Summary of the order to:  " + order.getDestination());
		System.out.println("Number of cargo transported:  " + order.getNumberOfCargo());
		System.out.println("Number of cargo ship journeys:  " + calculateNumberOfCargoShipJourneys(order.getNumberOfCargo()));
		System.out.println("Total distance covered by the cargo vessel: " + totalDistanceByCargoShip(order) );
		System.out.println("Total time for transporting the cargo and ship return: " + String.format ("%.2f", totalTimeForTransportingCargo(order)));
		System.out.println("Number of passengers transported:  " + order.getNumberOfPassengers());
		System.out.println("Number of ferry ship journeys:  " + calculateNumberOfFerryShipJouneys(order.getNumberOfPassengers()));
		System.out.println("Total distance covered by the ferry vessel: " + totalDistanceByFerryShip(order));
		System.out.println("Total time for transporting the passengers and ship return: " + String.format ("%.2f", totalTimeForTransportingPassengers(order)));
		System.out.println("-------------------------------------------------------------------------------------\n\n");
	}
	

	// calculate the total distance covered by the ship, which should include the 
	// distance of the journey to the destination and back.
		public int totalDistanceByCargoShip(Order order){

		if(order.getNumberOfCargo() != 0){
		int distance = order.getDistance();
		distance *= 2;
		return distance;}
		else{
			return 0;
		} //should return the correct distance and not 0
    }
	
	
	// calculate the total distance covered by the ship, which should include the 
	// distance of the journey to the destination and back.
	
	public int totalDistanceByFerryShip(Order order){
		if(order.getNumberOfPassengers() != 0){
		int distance = order.getDistance();
		distance *= 2;
		return distance; //should return the correct distance and not 0
	}else{
		return 0;
	}
	}
	

	// calculate the total time needed for the journey to the destination and back. 
	
	public double totalTimeForTransportingCargo(Order order){

		double totalTime = (double) totalDistanceByCargoShip(order) / aCargoShip.getMaxSpeed();
		return totalTime; //Should return the correct time 
	}
	

	// calculate the total time needed for the journey to the destination and back. 

	
	public double totalTimeForTransportingPassengers(Order order){
		double totalTime = (double) totalDistanceByFerryShip(order) / aFerryShip.getMaxSpeed();
		return totalTime; //Should return the correct time 
	}
	

	//calculate the the number of journeys to be made for transporting all the cargo. 
	
	public int calculateNumberOfCargoShipJourneys(int containers){
		int length = aCargoShip.getLength(); 
		int journey = 0;
		if(containers%length == 0) 
		journey = containers/length;
		else if (containers%length != 0){
			journey = containers/length;
			journey += 1;
		}
		return journey; // should return the correct number of journeys.
	}
	
	// calculate the the number of journeys to be made for transporting all the passengers. 

	public int calculateNumberOfFerryShipJouneys(int passengers){
		int length = aFerryShip.getLength();
		int journey = 0;
		if(passengers%length == 0)
		journey = passengers/length;
		else if (passengers%length != 0){
			journey = passengers/length;
			journey += 1;
		}
		return journey; // should return the correct number of journeys.
	}
	
	public int transportAllCargo(int containers, CargoShip aCargoShip, int travelDistance){
		int numberOfJourneys = calculateNumberOfCargoShipJourneys(containers);
		int remainingContainers = containers;
		
		for (int i = 0; i < numberOfJourneys; i++){
			System.out.println("Loading for journey : " + (i + 1));
			aCargoShip.loadCargo((aCargoShip.getLength() > remainingContainers) ?  remainingContainers : aCargoShip.getLength());
			System.out.println("Starting journey number: " + (i + 1));
			String travel = aCargoShip.move(travelDistance);
			aCargoShip.unloadCargo(travel, (aCargoShip.getLength() > remainingContainers) ?  remainingContainers : aCargoShip.getLength());
			remainingContainers -= aCargoShip.getLength();
			System.out.println("Moving back...");
			aCargoShip.moveBack(travel);
			System.out.println("Ship journey : " + (i + 1) + " is completed.");
		}
		return numberOfJourneys;
	}

	// Provide functionality identical to the transportAllCargo method BUT for passengers

	public int transportAllPassengers(int passengers, FerryShip aFerryShip, int travelDistance){
		int numberOfJourneys = calculateNumberOfFerryShipJouneys(passengers); // This should be obtained by using the method you have implemented.
		//int numberOfJourneys = 1;
		int remainingPassengers = passengers;

		for (int i = 0; i < numberOfJourneys; i++){
			System.out.println("Loading for journey : " + (i + 1));
			aFerryShip.boardPassengers((aFerryShip.getLength() > remainingPassengers) ?  remainingPassengers : aFerryShip.getLength());
			System.out.println("Starting journey number: " + (i + 1));
			String travel = aFerryShip.move(travelDistance);
			aFerryShip.disembark(travel, (aFerryShip.getLength() > remainingPassengers) ?  remainingPassengers : aFerryShip.getLength());
			remainingPassengers -= aFerryShip.getLength();
			System.out.println("Moving back...");
			aFerryShip.moveBack(travel);
			System.out.println("Ship journey : " + (i + 1) + " is completed.");
		}
		return numberOfJourneys;
	}

}

