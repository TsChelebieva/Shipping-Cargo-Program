public class Order {

	private String customerName;
	private int numberOfCargo;
	private int numberOfPassengers;
	private String destination;
	private int distance;
	
	Order(String customerName, int numberOfCargo, int numberOfPassengers, String destination, int distance){
		this.customerName = customerName;
		this.numberOfCargo = numberOfCargo;
		this.numberOfPassengers = numberOfPassengers;
		this.destination = destination;
		this.distance = distance;
	}


	public String getCustomerName(){
		return customerName;
	}
	
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	
	public int getNumberOfCargo(){
		return numberOfCargo;
	}
	
	public void setNumberOfCargo(int numberOfCargo){
		this.numberOfCargo = numberOfCargo;
	}
	
	public int getNumberOfPassengers(){
		return numberOfPassengers;
	}
	
	public void setNumberOfPassengers(int numberOfPassengers){
		this.numberOfPassengers = numberOfPassengers;
	}
	
	public String getDestination(){
		return destination;
	}
	
	public void setDestination(String destination){
		this.destination = destination;
	}
	
	public int getDistance(){
		return distance;
	}
	
	public void setDistance(int distance){
		this.distance = distance;
	}
}