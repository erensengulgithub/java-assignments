
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Station {

	public String stationName;
	public int ID;
	public static double averageGasolinePrice;
	public static double totalGasolineLiters;
	public static double GasolinePricePerLiter;
	public static double averageDieselPrice;
	public static double totalDieselLiters;
	public static double DieselPricePerLiter;
	public static Gasoline[] gasolineArray = new Gasoline[10] ;
	public static Diesel[] dieselArray = new Diesel[10];
	public static Service[] serviceArray = new Service[10];
	public static List<Person> personList = new ArrayList<>();
	public static List<Profitable> profitableList = new ArrayList<>();
	
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
				
				totalGasolineLiters += newGasoline.totalLiters;
				GasolinePricePerLiter += (newGasoline.pricePerLiter * newGasoline.totalLiters);
				averageGasolinePrice = GasolinePricePerLiter / totalGasolineLiters;
				
				System.out.println();
				System.out.println("The total gasoline liters in Station #" + stationArray[i].ID + " is " + totalGasolineLiters);
				System.out.println("The average gasoline price in Station #" + stationArray[i].ID + " is " + averageGasolinePrice);
				
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
				
				totalDieselLiters += newDiesel.totalLiters;
				DieselPricePerLiter += (newDiesel.pricePerLiter * newDiesel.totalLiters);
				averageDieselPrice = DieselPricePerLiter / totalDieselLiters;
				
				System.out.println();
				System.out.println("The total diesel liters in Station #" + stationArray[i].ID + " is " + totalDieselLiters);
				System.out.println("The average diesel price in Station #" + stationArray[i].ID + " is " + averageDieselPrice);
				
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
			System.out.println("The total gasoline liters in Station #" + stationArray[displayplace].ID + " is " + totalGasolineLiters);
			System.out.println("The average gasoline price in Station #" + stationArray[displayplace].ID + " is " + averageGasolinePrice);
			System.out.println();
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
			System.out.println("The total diesel liters in Station #" + stationArray[displayplace].ID + " is " + totalDieselLiters);
			System.out.println("The average diesel price in Station #" + stationArray[displayplace].ID + " is " + averageDieselPrice);
			System.out.println();
		}	
		else System.out.println("No station found with the given ID!");
	}

	public static void sellGasoline(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to sell Gasoline: ");
		int location = sc.nextInt();
		System.out.println();
		for (int i=0 ; i<stationArray.length ; i++ ) {
			if(stationArray[i].ID == location) {
				System.out.print("Please enter the car plate: ");
				String cP = sc.next();
				System.out.print("Please enter the gasoline liter: ");
				int gLiter = sc.nextInt();
				if (totalGasolineLiters >= gLiter) {
					System.out.print("Please enter if you have a coupon (y/n): ");
					if (sc.next() == "y") {
						GasolineService gsObject = new GasolineService(cP, gLiter, true);
						gsObject.makeTransaction(averageGasolinePrice);
						totalGasolineLiters -= gLiter;
						for(int j=0 ; j<10 ; j++) {
							if(stationArray[i].serviceArray[j] == null)
								stationArray[i].serviceArray[j] = gsObject;
								Collections.shuffle(personList);
								for(Person p: personList){
									p.displayInformation(personList);
									break;
								}
								break;
						}
					}
					else {
						GasolineService gsObject = new GasolineService(cP, gLiter, false);
						gsObject.makeTransaction(averageGasolinePrice);
						totalGasolineLiters -= gLiter;
						for(int j=0 ; j<10 ; j++) {
							if(stationArray[i].serviceArray[j] == null) {
								stationArray[i].serviceArray[j] = gsObject;
								Collections.shuffle(personList);
								for(Person p: personList){
									p.displayInformation(personList);
									break;
								}
								break;
							}
						}
					}	
				}
				else {
					System.out.println("Not enough gasoline in the station!");
					break;
				}	
			}
			else {
				System.out.println("No station found with the given ID!");
			}
		}
	}

	public static void sellDiesel(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to sell Diesel: ");
		int location = sc.nextInt();
		System.out.println();
		for (int i=0 ; i<stationArray.length ; i++ ) {
			if(stationArray[i].ID == location) {
				System.out.print("Please enter the car plate: ");
				String cP = sc.next();
				System.out.print("Please enter the diesel liter: ");
				int dLiter = sc.nextInt();
				
				if (totalDieselLiters >= dLiter) {
					System.out.print("Please enter if you want discounted anti-freeze (y/n): ");
					if (sc.next() == "y") {
						System.out.print("Please enter how many anti-freeze you want: ");
						int dAFC = sc.nextInt();
						DieselService dsObject = new DieselService(cP, dLiter, true, dAFC);
						dsObject.makeTransaction(averageDieselPrice);
						totalDieselLiters -= dLiter;
						for(int j=0 ; j<10 ; j++) {
							if(stationArray[i].serviceArray[j] == null) {
								stationArray[i].serviceArray[j] = dsObject;
								Collections.shuffle(personList);
								for(Person p: personList){
									p.displayInformation(personList);
									break;
								}
								break;
							}
						}
					}
					else {
						DieselService dsObject = new DieselService(cP, dLiter, false);
						dsObject.makeTransaction(averageDieselPrice);
						totalDieselLiters -= dLiter;
						for(int j=0 ; j<10 ; j++) {
							if(stationArray[i].serviceArray[j] == null) {
								stationArray[i].serviceArray[j] = dsObject;
								Collections.shuffle(personList);
								for(Person p: personList){
									p.displayInformation(personList);
									break;
								}
								break;
							}
						}
					}	
				}
				else {
					System.out.println("Not enough diesel in the station!");
					break;
				}	
			}
			else {
				System.out.println("No station found with the given ID!");
			}
		}
		
	}

	public static void displayServices(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the station you want to display: ");
		int fID = sc.nextInt();
		System.out.println();
		boolean state = false;
		for(Station s : stationArray) {
			if (s.ID == fID ) {
				state=true;
				System.out.println("Displaying the sold services of Station #"+fID);
				break;
			}
			else System.out.println("No station found with the given ID!");
		}
		if(state) {
			List<Service> slist = Arrays.asList(serviceArray);
			Collections.sort(slist);
			for(Service s : slist ) {
				s.displayServiceInfo();
			}
		}
		
	}
	
	public static void sellCarWash(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Statin you want to sell car wash: ");
		System.out.println();
		
		int findStation = sc.nextInt();
		boolean state=false; 
		
		
		for(Station st : stationArray) {
			if(st.ID == findStation) {
				state = true;
			}
		}
		
		if(state) {
			CarWash.displayServiceInfo();
			Collections.shuffle(personList);
			for(Person p: personList){
				p.displayInformation(personList);
				break;
			}
		}
			
		else
			System.out.println("No station found with the given ID!");	
	}
	
	public static void addPerson(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add a personnel");
		System.out.println("2. Add a manager");
		int option = sc.nextInt();
		boolean state =false;
		if(option == 1) {
			System.out.print("Please enter the ID of the Statin you want to add a person: ");
			int findStation = sc.nextInt();
			System.out.println();
			for(Station st: stationArray) {
				if(st.ID == findStation) {
					System.out.println("Please enter a name: ");
					String pname = sc.next();
					System.out.println("\nPlease enter a surname: ");
					String psurname = sc.next();
					Person Personnel = new Personnel(pname,psurname);
					personList.add(Personnel);
				}
			}
		}
		
		else if(option == 2) {
			System.out.print("Please enter the ID of the Statin you want to add a person: ");
			int findStation = sc.nextInt();
			System.out.println();
			for(Station st: stationArray) {
				if(st.ID == findStation) {
					System.out.println("Please enter a name: ");
					String mname = sc.next();
					System.out.println("\nPlease enter a surname: ");
					String msurname = sc.next();
					Person Manager = new Manager(mname,msurname);
					personList.add(Manager);
				}
			}
		}
	}
	
	public static void calculateNetProfit(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to calculate profit: ");
		int findStation = sc.nextInt();
		System.out.println();
		boolean state = false;
		
		for(Station st : stationArray ) {
			if(st.ID == findStation) {
				state = true;
				break;
			}
		}
		
		int sum=0;
		int nprofit=0;
		if(state) {
			for(Profitable p : profitableList) {
				System.out.println("class "+ p + ": " + Profitable.calculate());
				sum += Profitable.calculate();
			}
			nprofit = sum / profitableList.size();
			
			System.out.println("Net profit of station is: " + nprofit);
			
		}
		else{
			System.out.println("No station found with the given ID!");
		}
	}
	
	public static void displayServices2(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the station you want to display: ");
		int fID = sc.nextInt();
		System.out.println();
		boolean state = false;
		for(Station s : stationArray) {
			if (s.ID == fID ) {
				state=true;
				break;
			}
			else System.out.println("No station found with the given ID!");
		}
		CarPlateCompare cPcomp = new CarPlateCompare();
		if(state) {
			List<Service> slist = Arrays.asList(serviceArray);
			Collections.sort(slist,cPcomp);
			for(Service s : slist ) {
				s.displayServiceInfo();
			}
		}
	}
}
