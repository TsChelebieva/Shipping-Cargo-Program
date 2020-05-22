public class Ship {
	private final int DEFAULT_MAX_SPEED = 5;
	private final int DEFAULT_LENGTH = 10;
	private final int MAX_LENGTH = 50;
	private final int MAX_SPEED = 12;
	
	private int length;
	private int speed;

	//String Representation of the ship. A ship that is not loaded should look like this: \___________/
	private String shipRepresentation = "";
	
	//Character ▓ represents a container. When 4 containers are loaded on a ship the  representation should be: \▓▓▓▓___/ 
	protected final char containerChar = (char)9619;
	//protected final char containerChar = (char)178;
	
	//Character ± represents a passenger. When 4 passengers are loaded on a ship the  representation should be: \±±±±___/ 
	protected final char passengerChar = (char)177;
	//protected final char passengerChar = (char)241;
	
	public Ship(){
		this.length = DEFAULT_LENGTH;
		this.speed = DEFAULT_MAX_SPEED;
		this.shipRepresentation = buildShipRepresentation();
	}
	
	public Ship(int length, int speed){
		this.length = checkShipLength(length);
		this.speed = checkShipSpeed(speed);
		this.shipRepresentation = buildShipRepresentation();
	}
	
	// check whether the length of the vessel provided to the constructor 
	// is between MAX_LENGTH and <= 0; 

	public int checkShipLength(int length){

		if(!(length <= 0 || length < MAX_LENGTH)){
			return DEFAULT_LENGTH;
		}else{
		return length; //Should return the number according to the description in the comment
	}
	}
	

	// check whether the speed of the vessel provided to the constructor 
	//  is between MAX_SPEED and <= 0; 

	public int checkShipSpeed(int speed){ 
		if(!(speed < MAX_SPEED || speed <= 0)){                                          
		return DEFAULT_MAX_SPEED;//Should return the number according to the description in the comment
	}else{
		return speed;
	}
	}
	
	public String buildShipRepresentation(){
		String shipString = "\\"; 
		for (int i = 1; i <= this.length; i++){
			shipString += "_";
		}
		shipString += "/"; 
		return shipString;
	}
	
	public void printShip(){
		System.out.println(this.shipRepresentation);
	}
	
	public String move(int movingDistance){
		String travel = "";
		try{
			for (int i = 0; i < movingDistance; i++){
				travel += " ";
				Thread.sleep(1000/speed);
				System.out.print("\r" + travel + this.shipRepresentation);
			}
			System.out.println();
		} 
		catch( InterruptedException exception){
			System.out.println(exception);
		}  
		return travel;
	}
	
	public String moveBack(String travel){
		String backTrack = "";
		try{
			for (int i = travel.length(); i >= 0; i--){
				travel = travel.substring(0, i);
				backTrack += " ";
				Thread.sleep(1000/speed);
				System.out.print("\r" + travel + this.shipRepresentation + backTrack);
			}
			System.out.println("");
		}
		catch( InterruptedException exception){
			System.out.println(exception);
		}  
		return travel;
	}
	
	public void load(int numberOfItems, char itemCharacter){
		String ship = this.getShipRepresentation();
		try{
			for (int i = 1; i <= numberOfItems; i++){
				ship = ship.replaceFirst("_", Character.toString(itemCharacter));
				Thread.sleep(200);
				System.out.print("\r Loading  " + i + "\t" + ship);
				this.setShipRepresentation(ship);
			}
			System.out.println("");
		}
		catch( InterruptedException exception){
			System.out.println(exception);
		}
	}
	
	public boolean unload(String travel, int numberOfContainers, char itemCharacter){
		System.out.println("Unloading ...");
		String ship = this.getShipRepresentation();
		String items = "";
		try{
			while(ship.contains(String.valueOf(itemCharacter))){
				Thread.sleep(200);
				ship = ship.replaceFirst(Character.toString(itemCharacter), "_");
				items += Character.toString(itemCharacter);
				System.out.print("\r" + travel + ship + "\t\t" + items);
			}
			this.setShipRepresentation(ship); 
			System.out.println("");
		}
		catch( InterruptedException exception){
			System.out.println(exception);
		}  
		return true;
	}
	
	public int getLength(){
		return length;
	}

	public void setLength(int length){
		this.length = length;
	}

	public int getMaxSpeed(){
		return speed;
	}
	
	public void setMaxSpeed(int maxSpeed){
		this.speed = maxSpeed;
	}
	
	public String getShipRepresentation(){
		return shipRepresentation;
	}
	
	public void setShipRepresentation(String shipRepresentation){
		this.shipRepresentation = shipRepresentation;
	}
}
