import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Station[] stationArray = new Station[10];
		int counter = 0;

		String choice = null;

		while (true) {
			MenuItem.printMenu();

			choice = sc.nextLine();

			if (choice.equals("1")) {
				stationArray[counter++] = Station.createStation();
			} else if (choice.equals("2")) {
				Station.findStationAndAddGasoline(stationArray);
			} else if (choice.equals("3")) {
				Station.findStationAndAddDiesel(stationArray);
			} else if (choice.equals("4")) {
				Station.displayStationInventory(stationArray);
			} else if (choice.equals("5")) {
				Station.sellGasoline(stationArray);
			} else if (choice.equals("6")) {
				Station.sellDiesel(stationArray);
			} else if (choice.equals("7")) {
				Station.displayServices(stationArray);
			} else if (choice.equals("8")) {
				break;
			} else {
				System.out.println("Wrong choice!");
			}
			System.out.println();
		}

	}

}
