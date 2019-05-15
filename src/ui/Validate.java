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
		if (fee.length() == 0 || value <= 0 ) {
			return false;
		}
		return true;
	}
	
	public static boolean capacity(String capacity) {
		int value;
		try {
			value = Integer.valueOf(capacity);
		} catch (NumberFormatException e){
			e.printStackTrace();
			return false;
		}
		if (capacity.length() == 0 || value <= 0 ) {
			return false;
		}
		return true;
	}
}
