public class CargoShip extends Ship{
	
	CargoShip(){
		super();
	}
	
	CargoShip(int length, int speed){
		super(length, speed);
	}
	
	public int loadCargo(int numberOfContainers){
		System.out.println("Loading Cargo...");
		load(numberOfContainers, this.containerChar);
		return numberOfContainers;
	}
	
	public boolean unloadCargo(String travel, int numberOfContainers){
		System.out.println("Unloading Cargo...");
		unload(travel, numberOfContainers, this.containerChar);
		return true;
	}
	
	public void transport(int containers){
		int numberOfJourneys = containers/this.getLength();
	}
}
