package ce.yildiz.oop;

import java.util.Scanner;

import ui.Validate;
import vehicle.SubscribedVehicle;

/**
 * 
 * !!! IMPORTANT !!!
 * !!! IMPORTANT !!!
 * !!! IMPORTANT !!!
 * 
 * THIS PROGRAM HAS USER INTERFACE. 
 * PLEASE GO TO UI PACKAGE AND RUN MAINACTIVITY
 * 
 * THIS MAIN METHOD IS FOR CONSOLE APPLICATIONS
 * AND TEST.
 * 
 * GO TO UI --> MAINACTIVITY
 * 
 * !!! IMPORTANT !!!
 * !!! IMPORTANT !!!
 * !!! IMPORTANT !!!
 */
public class Main {
	
	private static Scanner keyboard = new Scanner(System.in);
	
	// Please go to ui package and run MainActivity.java file
	// This method is just for console applications
	// And written for just to be sure that we cover everything.
	public static void main(String[] args) {
		char c;
		
		System.out.println("Hourly fee: ");
		double hourlyFee = keyboard.nextDouble();
		
		System.out.println("Capacity: ");
		int capacity = keyboard.nextInt();
		
		keyboard.nextLine();
		
		AutoPark autoPark = new AutoPark(hourlyFee, capacity);
		boolean flag = true;
		
		do {
			menu();
			c = keyboard.nextLine().charAt(0);
			
			switch (c) {
				case '1':
					vehicleEnters(autoPark);
					break;
				case '2':
					vehicleExits(autoPark);
					break;
				case '3':
					addVehicle(autoPark);
					break;
				case '4':
					System.out.println(autoPark.toString());
					break;
				case '0':
					flag = false;
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
		} while (flag);
		
		autoPark = null;
		keyboard.close();
	}
	
	private static void menu() {
		System.out.println("1- Vehicle enters");
		System.out.println("2- Vehicle exits");
		System.out.println("3- Add vehicle to subscribed vehicles");
		System.out.println("4- See AutoPark");
		System.out.println("0- Exit Program");
	}
	
	private static void vehicleEnters(AutoPark autoPark) {
		String plate;
		String enterHour;
		String enterMinute;
		
		/*
		 * Take vehicle plate
		 */
		System.out.println("Plate: ");
		plate = keyboard.nextLine();


		System.out.println("Is official?: (true)(false)");
		boolean isOfficial = keyboard.nextBoolean();
		
		keyboard.nextLine();
		
		/*
		 * Take time information. First take hour data then minute data.
		 */
		do {
			System.out.println("Enter hour(Only hour data): ");
			enterHour = keyboard.nextLine();
		} while (!Validate.hour(enterHour));
		
		do {
			System.out.println("Enter minute(Only minute data): ");
			enterMinute = keyboard.nextLine();
		} while (!Validate.minute(enterMinute));
		
		/*
		 * Try to add it to autopark
		 */
		boolean added = autoPark.vehicleEnters(plate, 
			new Time(Integer.valueOf(enterHour), Integer.valueOf(enterMinute)), 
			isOfficial);
		
		/*
		 * According to boolean value, print information to screen.
		 */
		String message = added ? "Vehicle added" : "Couldnot added";
		System.out.println(message);	
	}
	
	private static void vehicleExits(AutoPark autoPark) {
		String plate;
		String exitHour;
		String exitMinute;
		
		/*
		 * Take vehicle plate
		 */
		do {
			System.out.println("Vehicle plate: ");
			plate = keyboard.nextLine();
		} while (!Validate.plate(plate));
		
		/*
		 * Take time information. First take hour data then minute data.
		 */
		do {
			System.out.println("Exit hour(Only hour data): ");
			exitHour = keyboard.nextLine();
		} while (!Validate.hour(exitHour));
		
		do {
			System.out.println("Exit minute(Only minute data): ");
			exitMinute = keyboard.nextLine();
		} while (!Validate.minute(exitMinute));
		
		/*
		 * Try to remove it from autopark
		 */
		boolean checkOut = autoPark.vehicleExits(plate,
				new Time(Integer.valueOf(exitHour), Integer.valueOf(exitMinute)));
		
		/*
		 * According to boolean value, print information to screen.
		 */
		String message = checkOut ? "Exit success" : "Unsuccessful";
		System.out.println(message);
	}
	
	private static void addVehicle(AutoPark autoPark) {
		String plate;
		Date[] dates;
		Subscription subscription;
		SubscribedVehicle vehicle;
		
		/*
		 * Take vehicle plate
		 */
		do {
			System.out.println("Vehicle plate: ");
			plate = keyboard.nextLine();
		} while (!Validate.plate(plate));
		
		/*
		 * Get subscription's begin and end dates.
		 * Then create an appropriate subscription with dates and plate.
		 * Then it will create a vehicle with subscription and plate.
		 * Then it will try to add it to autopark's subscriptedVehicles array.
		 */
		dates = getDate();
		subscription = new Subscription(dates[0], dates[1], plate);
		vehicle = new SubscribedVehicle(subscription, plate);
		
		boolean added = autoPark.addVehicle(vehicle);
		
		/*
		 * According to boolean value, print information to screen.
		 */
		String message = added ? "Vehicle added" : "Unsuccessful";
		System.out.println(message);
	}
	
	private static Date[] getDate() {
		Date[] dates = new Date[2];
		
		String beginDay;
		String beginMonth;
		String beginYear;
		String endDay;
		String endMonth;
		String endYear;
		String beginDate;
		String endDate;
		
		/*
		 * Take begin and end date informations field by field.
		 */
		do {
			System.out.println("Beginning day: ");
			beginDay = keyboard.nextLine();
			
			System.out.println("Beggining month: ");
			beginMonth = keyboard.nextLine();
			
			System.out.println("Beggining year: ");
			beginYear = keyboard.nextLine();
			
			System.out.println("End day: ");
			endDay = keyboard.nextLine();
			
			System.out.println("End month: ");
			endMonth = keyboard.nextLine();
			
			System.out.println("End year: ");
			endYear = keyboard.nextLine();
			
			beginDate = beginDay +"-" + beginMonth + "-" + beginYear;
			endDate = endDay + "-" + endMonth + "-" + endYear;
		} while (!Validate.date(beginDate) || !Validate.date(endDate));
		
		/*
		 * After validating input, create date objects
		 * and return them in an array.
		 */
		dates[0] = new Date(Integer.valueOf(beginDay), 
							Integer.valueOf(beginMonth),
							Integer.valueOf(beginYear));
		dates[1] = new Date(Integer.valueOf(endDay),
							Integer.valueOf(endMonth),
							Integer.valueOf(endYear));
		
		return dates;
	}
}
