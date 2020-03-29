// Sebastian S, Jinghua Z
// Java A170
// Date: 03-10-2020
// Project One - Task #1
// Calculating the price of pizzes and toppings
import java.util.Scanner;
public class PizzaOrder {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// init
		String name;
		double due;
		int size;
		String crust;
		String[] toppingData;
		double tax;
		final boolean taxReq = true;
		boolean discount=false;
		String totalDiscount = "";
		
		// greeting
		System.out.println("Welcoem to Sebastian and Jinghua's Pizza Company! ");
		System.out.print("Please enter your name: ");
		name = in.next();
		
		if(name.equalsIgnoreCase("Sebastian")||name.equalsIgnoreCase("Jinghua")) {
			discount=true;
			System.out.println("You're eligible for a $2.00 discount.");
			totalDiscount="*** $2 Discount Applied ***\n";
		}
	
		
		// based price
		size = sizeInput();
		due = sizePricing(size);
		size = (due==12.99)?12:size;
		
		// crust
		do {
			crust = crustCheck();
		}
		while (crust.equals("N"));
		
		// toppings
		toppingData = topping();
		
		// pre tax
		due = due+ Double.parseDouble(toppingData[2]);
		
		// discount
		due=(discount)?due-2.0:due;
		
		// tax
		tax = (taxReq)?due*0.0775:0;
		
		System.out.printf("%n%n---Thank You For Your Order!--- %n%n"
				+ "%s, %n"
				+ "Your order is as follows: %n"
				+ "%d-inch pizza%n"
				+ "%s crust%n"
				+ "[%s Topping(s)] %s %n"
				+ "%sThe cost of your order is: $%.2f%n"
				+ "The tax is: $%.2f %n"
				+ "The total due is: $%.2f %n"
				+ "Your order will be ready for pickup in 30 minutes.",
				name,
				size,
				curstFull(crust),
				toppingData[1],
				toppingData[0],
				totalDiscount,
				due,
				tax,
				due+tax);
		
	}

	
	static int sizeInput () {
		System.out.printf("%19s%21s%n"
				+ "%10s%30s%n"
				+ "%10s%30s%n"
				+ "%10s%30s%n"
				+ "%10s%30s",
				"Pizza size (inches)","Cost",
				"10","$10.99",
				"12","$12.99",
				"14","$14.99",
				"16","$16.99");
		
		System.out.printf("%n%nWhat size pizza would you like? %n"
				+ "10, 12, 14 or 16 (number only): ");
		return in.nextInt();
	}
	
	static double sizePricing(int size) {
		//getting the size-based price
		double price = 0;
		if(size==10) {
			price = 10.99;
		}else if(size==12) {
			price = 12.99;
		}else if(size==14) {
			price = 14.99;
		}else if(size==16) {
			price = 16.99;
		}else {
			System.out.println("You'll get the 12 inches size.");
			price = 12.99;
		}
		return price;
	}
	
	static String crustCheck() {
		String crust;
		String result;
		System.out.printf("What type of crust do you want? %n"
				+ " (H)Hand-tossed, (T) Thin-crust, or (D) Deep-dish %n"
				+ " (enter H, T, or D): ");
		crust = in.next();
		switch (crust.toUpperCase()) {
			case "H":
			case "T":
			case "D":
				result=crust;
				break;
			default:
				System.out.println("Invalid input.");
				result="N";
		}
		return result;
	}
	
	static String[] topping() {
		String pepperoni;
		String sausage;
		String onion;
		String mushroom;
		String toppings = "";
		Integer counter=0;
		
		System.out.printf("All pizzas come with cheese.%n" + 
				"Additional toppings are $1.25 each, choose from:%n" + 
				"Pepperoni, Sausage, Onion, Mushroom %n");
		
		// asking for pepperoni
		do {
			System.out.print("Do you want Pepperoni? (Y/N): ");
			pepperoni=in.next().toUpperCase();
			switch (pepperoni) {
				case "Y":
					toppings=toppings+"Pepperoni ";
					counter++;
					break;
				case "N":
					break;
				default:
					System.out.println("Invalid input.");
					pepperoni=null;
			}
		}
		while (pepperoni==null);
		
		// asking for sausage
		do {
			System.out.print("Do you want Sausage? (Y/N): ");
			sausage=in.next().toUpperCase();
			switch (sausage) {
				case "Y":
					toppings=toppings+"Sausage ";
					counter++;
					break;
				case "N":
					break;
				default:
					System.out.println("Invalid input.");
					sausage=null;
			}
		}
		while (sausage==null);
		
		// asking for onion
		do {
			System.out.print("Do you want Onion? (Y/N): ");
			onion=in.next().toUpperCase();
			switch (onion) {
				case "Y":
					toppings=toppings+"Onion ";
					counter++;
					break;
				case "N":
					break;
				default:
					System.out.println("Invalid input.");
					onion=null;
			}
		}
		while (onion==null);
		
		// asking for mushroom
		do {
			System.out.print("Do you want Mushroom? (Y/N): ");
			mushroom=in.next().toUpperCase();
			switch (mushroom) {
			case "Y":
				toppings=toppings+"Mushroom ";
				counter++;
				break;
			case "N":
				break;
			default:
				System.out.println("Invalid input.");
				mushroom=null;
			}
		}
		while (mushroom==null);
		
		// total cost;
		double cost=counter*1.25;
		// return result
		String[] resultArr = new String[3];
		resultArr[0]=toppings;
		resultArr[1]=Integer.toString(counter);
		resultArr[2]=Double.toString(cost);
		return resultArr;
	}
	
	static String curstFull(String name) {
		switch (name) {
			case "H":
				name="Hand-tossed";
				break;
			case "T":
				name="Thin-crust";
				break;
			case "D":
				name="Deep-dish";
				break;
			
		}
		return name;
		
	}
	

}
