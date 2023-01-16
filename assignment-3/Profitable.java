
import java.util.List;

interface Profitable {
	static double calculate(){
		return 0;
	}
}

class Service implements Profitable{
	public static String carPlate;
	public static double revenue;
	
	public Service(String cP) {
		cP = carPlate;
	}
	
	public static void displayServiceInfo() {
		FuelService.displayServiceInfo();
	}
	public static double makeTransaction(double AgPrice, double AdPrice) {
		revenue = FuelService.makeTransaction(AgPrice , AdPrice);
		return revenue;
	}
		
	
}

class Person implements Profitable{
	String name;
	String surname;
	double salary = 100;
	
	public Person(String name, String surname) {
		this.name=name;
		this.surname=surname;
	}
	
	void displayInformation(List<Person> personList) {
		System.out.println("Name: " + personList.get(0).name);
		System.out.println("Surname: " + personList.get(0).surname);
	}

	public String calculate() {
		return null;
	}
}

class FuelService extends Service{
	
	public FuelService(String cP, double lt) { //constructor
		super(cP);
		litersBought = lt;
		
	}



	public static double litersBought;
	public static void displayServiceInfo() {
		
		GasolineService.displayServiceInfo();
		DieselService.displayServiceInfo();
	}
	
	
	public static double makeTransaction(double AGP, double ADP) {
		return GasolineService.makeTransaction(AGP) + DieselService.makeTransaction(ADP); 
	}
	
	
}

class CarWash extends Service{
	public CarWash(String cP) {
		super(cP);
	}
	final static double basePrice = 10;
	
	public static void displayServiceInfo() {
		System.out.print("Please enter the car plate: ");
		
		System.out.println("\n Personnel that helped during this service:");
	}
	
	public static double calculate() {
		return basePrice;
	}
}

class Personnel extends Person{
	public Personnel(String pname, String psurname) {
		super(pname,psurname);
	}

	public double calculate(int jobCount) {
		return 100+(jobCount*3/2);
	}
	
	int jobCount;
	
	void incJobCount() {}
		
}

class Manager extends Person{
	
	public Manager(String mname, String msurname) {
		super(mname,msurname);
	}

	public double calculate(int jobYear) {
		return 100+200+(jobYear*50);
	}
	
	int jobYear;
	
}

class GasolineService extends FuelService{
	public GasolineService(String cP,double lt, boolean hC) { // constructor
		super(cP,lt);
		hasCoupon = hC;
	}
	
	public static boolean hasCoupon;
	public static void displayServiceInfo() {
		System.out.println("Gasoline Service...");
		System.out.println("Bought "+ litersBought + " liters");
		System.out.println("Car Plate is " + carPlate);
		System.out.println("The revenue from this service is " + revenue);
		if(hasCoupon == true)
			System.out.println("Has 10% discount coupon");  
			System.out.println();
			
	}
	
	public static double makeTransaction(double price) {
		double gasolineT;
		double liters = litersBought;
		
		if (hasCoupon) {
			gasolineT = price*liters*(9/10);
		}
		else
			gasolineT = price*liters;
			
		return gasolineT;
	}
	
	public static double calculate() {
		return revenue;
	}
	
}

class DieselService extends FuelService{
	public DieselService(String cP, double lt , boolean dAF, int dAFC, double dAFP) { //constructor
		super(cP, lt);
		dAF = discountedAntiFreeze;
		dAFC = discountedAntiFreezeCount;
		dAFP = discountedAntiFreezePrice;
	}


	public DieselService(String cP, double lt, boolean dAF) {
		super(cP,lt);
		dAF=discountedAntiFreeze;
	}
	
	public DieselService(String cP, double lt, boolean dAF, int dAFC) {
		super(cP,lt);
		dAF=discountedAntiFreeze;
		dAFC=discountedAntiFreezeCount;
	}

	public boolean discountedAntiFreeze;
	public static int discountedAntiFreezeCount;
	public double discountedAntiFreezePrice;
	
	public static void displayServiceInfo() {
		System.out.println("Diesel Service...");
		System.out.println("Bought " + litersBought + " liters");
		System.out.println("Car Plate is " + carPlate);
		System.out.println("The revenue from this service is " + revenue);
		System.out.println("Bought " + discountedAntiFreezeCount + " discounted anti-freeze");
		System.out.println();
	}
	
	
	public static double makeTransaction(double price) {
		double  dieselT;
		double liters = litersBought;
		int itemcount = discountedAntiFreezeCount;
		
		dieselT = ( price*liters ) + (antiFreezePrice(25)*itemcount);
		
		return dieselT;
	}


	private static int antiFreezePrice(int i) {
		
		return i;
	}
	
	public static double calculate() {
		return revenue;
	}
}

