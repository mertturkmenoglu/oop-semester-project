package ui;

public class Validate {

	public static boolean hourlyFee(String fee) {
		double value;
		
		try {
			value = Double.valueOf(fee);
		} catch (NumberFormatException e){
			e.printStackTrace();
			return false;
		}
		
		return !(fee.length() == 0 || value <= 0);
	}
	
	public static boolean capacity(String capacity) {
		int value;
		
		try {
			value = Integer.valueOf(capacity);
		} catch (NumberFormatException e){
			e.printStackTrace();
			return false;
		}
		
		return !(capacity.length() == 0 || value <= 0 );
	}
	
	public static boolean plate(String plate) {
		return (plate.length() > 0);
	}
	
	public static boolean enterHour(String hour) {
		int value;
		
		try {
			value = Integer.valueOf(hour);
		} catch (NumberFormatException e){
			e.printStackTrace();
			return false;
		}
		
		return !(hour.length() == 0 || value < 0 || value >= 24);
	}
	
	public static boolean enterMinute(String minute) {
		int value;
		
		try {
			value = Integer.valueOf(minute);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		
		return !(minute.length() == 0 || value < 0 || value >= 60);
	}
}
