
public class Service {
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
