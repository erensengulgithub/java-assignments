
public class GasolineService extends FuelService{
	
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

}
