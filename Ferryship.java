
public class FerryShip extends Ship{
	
	public FerryShip(){
		super();
	}

	FerryShip(int length, int speed){
		super(length,speed); //calls superclass's constructor in order to access the private instance variables
	}

	public int boardPassengers(int numberOfPassengers){
		System.out.println("Passengers boarding...");
		load(numberOfPassengers, this.passengerChar);
		return numberOfPassengers;
	}
	
	public boolean disembark(String travel, int numberOfPassengers){
		System.out.println("Unloading Cargo...");
		unload(travel, numberOfPassengers, this.passengerChar);
		return true;
	}
}
