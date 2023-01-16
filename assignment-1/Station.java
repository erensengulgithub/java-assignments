import java.util.Scanner;

public class Station {

	public String stationName;
	public int ID;
	public Gasoline[] gasolineArray = new Gasoline[10] ;
	public Diesel[] dieselArray = new Diesel[10];
	
	public static Station createStation(){
		Scanner sc = new Scanner(System.in);
		Station newStation = new Station();
		System.out.print("Please enter the name of the Station: ");
		newStation.stationName = sc.nextLine();
		System.out.print("Please enter the Station ID: ");
		newStation.ID = sc.nextInt();
		
		return newStation;
	}	

	public static void findStationAndAddGasoline(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		int defaultlength = stationArray.length;
		boolean gflag=false;
		int gplace=0;
		Gasoline newGasoline = new Gasoline();
		
		System.out.print("Please enter the ID of the Station you want to search:");
		int findStation = sc.nextInt();
		
		for(int i=0 ; i<defaultlength; i++) {
			if(stationArray[i].ID == findStation) {
				gflag=true;
				for(int j=0 ; j<defaultlength ; j++) {
					if(stationArray[i].gasolineArray[j] == null) {
						gplace = j;
						break;
					}
				}
			}
			if(gflag) {
				System.out.println();
				System.out.print("Please enter the origin of gasoline: ");
				newGasoline.origin = sc.next();  // When i use .nextLine it prints the "price per liter" and when i try to write something error occurs. //
				System.out.print("Please enter the price per liter: ");
				newGasoline.pricePerLiter = sc.nextDouble(); // While trying to give double numbers with (.) it gives an error but (,) solves the problem instead of (.)	//			
				System.out.print("Please enter the total shipment volume in liter: ");
				newGasoline.totalLiters = sc.nextDouble();	
				
				stationArray[i].gasolineArray[gplace] = newGasoline;
				break;
			}
		}
		
		if(!gflag) System.out.println("No station found with the given ID!");
		System.out.println();
	}
	
	public static void findStationAndAddDiesel(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		int defaultlength = stationArray.length;
		boolean dflag=false;
		int dplace=0;
		Diesel newDiesel = new Diesel();
		
		System.out.print("Please enter the ID of the Station you want to search:");
		int findStation = sc.nextInt();
		
		for(int i=0 ; i<defaultlength; i++) {
			if(stationArray[i].ID == findStation) {
				dflag=true;
				for(int j=0 ; j<defaultlength ; j++) {
					if(stationArray[i].dieselArray[j] == null) {
						dplace = j;
						break;
					}
				}
			}
			if(dflag) {
				System.out.println();
				System.out.print("Please enter the origin of diesel: ");
				newDiesel.origin = sc.next();
				System.out.print("Please enter the price per liter: ");
				newDiesel.pricePerLiter = sc.nextDouble();
				System.out.print("Please enter the total shipment volume in liter: ");
				newDiesel.totalLiters = sc.nextDouble();	
				
				stationArray[i].dieselArray[dplace] = newDiesel;
				break;
			}
		}
		if(!dflag) System.out.println("No station found with the given ID!");
		System.out.println();
	}
	
	public static void displayStationInventory(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		int defaultlength = stationArray.length;
		boolean displayflag = false;
		int displayplace=0;
		System.out.print("Please enter the ID of the Station you want to display: ");
		int displayingStation = sc.nextInt();
		
		for(int i=0 ; i<defaultlength; i++) {
			if(stationArray[i].ID == displayingStation) {
				System.out.println("\nDisplaying the inventory of Station #"+displayingStation);
				System.out.println();
				displayflag =true;
				displayplace=i;
				break;
			}		
		}		
		if(displayflag) {
			for(int j=0 ; j<defaultlength ; j++) {
				if(stationArray[displayplace].gasolineArray[j] != null) {
					System.out.println("Gasoline...");
					System.out.println("The origin is: "+ stationArray[displayplace].gasolineArray[j].origin);
					System.out.println("Price per liter is: "+ stationArray[displayplace].gasolineArray[j].pricePerLiter);
					System.out.println("Total liters of this gasoline is: "+ stationArray[displayplace].gasolineArray[j].totalLiters);
					System.out.println();
				}
				else 
					break;
			}
		}	
		if(displayflag)	{
			for(int k=0 ; k<defaultlength ; k++) {
				if(stationArray[displayplace].dieselArray[k] != null) {
					System.out.println("Diesel...");
					System.out.println("The origin is: "+ stationArray[displayplace].dieselArray[k].origin );
					System.out.println("Price per liter is: "+ stationArray[displayplace].dieselArray[k].pricePerLiter);
					System.out.println("Total liters of this diesel is: "+ stationArray[displayplace].dieselArray[k].totalLiters);
					System.out.println();
				}
				else 
					break;
			}
		}	
		else System.out.println("No station found with the given ID!");
	}
}
