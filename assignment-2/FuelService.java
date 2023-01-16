
public class FuelService extends Service {
	
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
