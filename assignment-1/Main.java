
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Station[] stationArray = new Station[10];
		int counter = 0;

		String choice = null;

		while (true) {
			System.out.println("1. Create a new station");
			System.out.println("2. Add gasoline to a station inventory");
			System.out.println("3. Add diesel to a station inventory");
			System.out.println("4. Display a station inventory");
			System.out.println("5. Exit");

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
				break;
			} else {
				System.out.println("Wrong choice!");
			}
			System.out.println();
		}
	}
}
