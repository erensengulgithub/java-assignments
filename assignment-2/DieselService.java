
public class DieselService extends FuelService {
	
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
	
}


