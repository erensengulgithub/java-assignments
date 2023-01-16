enum Menu{
	A("1. Create a new station"),
	B("2. Add gasoline to a station inventory"),
	C("3. Add diesel to a station inventory"),
	D("4. Display a station inventory"),
	E("5. Sell gasoline to customer"),
	F("6. Sell diesel to customer"),
	G("7. Sell car wash"), 
	H("8. Display sold services so far"),
	I("9. Add personnel/manager to a station"),
	J("10. Calculate net profit of a station"),
	K("0. Exit");
	
	private String options;
	
	Menu(String o){
		options = o ;
	}
	
	String getOptions() {
		return options;
	}
}

public class MenuItem {

	public static void printMenu() {
		for(Menu m : Menu.values())
			System.out.println(m.getOptions());
		
	}
	
}
