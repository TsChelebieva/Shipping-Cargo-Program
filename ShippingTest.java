
public class ShippingTest{ 

	public static void main(String[] args){
		//The Manager of the shipping company receives 3 orders
		//The orders are stored in an array
		Order[] orders = 	{
								new Order("Argos", 10, 0, "London", 10), //customerName, numberOfCargo, numberOfPassengers, destination, distance
								new Order("Seven Seas", 0, 10, "Amsterdam", 15),
								new Order("Amazon", 5, 0, "Anwerp", 20)
							};
		

	    
		//Creating an instance of a CargoShip                           
		CargoShip aCargoShip = new CargoShip(10, 7); //length, speed
		
		//Print the instantiated CargoShip - given the length
		System.out.println("This is the Cargo Ship: " + aCargoShip.getShipRepresentation() );

		//Creating an instance of a FerryShip                            
		FerryShip aFerryShip = new FerryShip(15, 10); // length, speed
		
        //Print the instantiated FerryShip - given the length
		System.out.println("This is the Ferry: " + aFerryShip.getShipRepresentation() );
		
		//Create an instance of the ShippingManager
		ShippingManager manager = new ShippingManager(orders, aCargoShip, aFerryShip);

		//Call the method for completing the shipment of containers and transfer of passengers.
        manager.completeOrders();
	}
}
