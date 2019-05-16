package ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validate {
	
	private final static String DATE_FORMAT = "dd-MM-yyyy";

	public static boolean hourlyFee(String fee) {
		double value;
		
		if (fee == null) {
			return false;
		}
		
		try {
			value = Double.valueOf(fee);
		} catch (NumberFormatException e){
			return false;
		}
		
		return !(fee.length() == 0 || value <= 0);
	}
	
	public static boolean capacity(String capacity) {
		int value;
		
		try {
			value = Integer.valueOf(capacity);
		} catch (NumberFormatException e){
			return false;
		}
		
		return !(capacity.length() == 0 || value <= 0 );
	}
	
	public static boolean plate(String plate) {
		if (plate == null) {
			return false;
		} else {
			return (plate.length() > 0);
		}
	}
	
	public static boolean hour(String hour) {
		int value;
		
		if (hour == null) {
			return false;
		}
		
		try {
			value = Integer.valueOf(hour);
		} catch (NumberFormatException e){
			return false;
		}
		
		return !(hour.length() == 0 || value < 0 || value >= 24);
	}
	
	public static boolean minute(String minute) {
		int value;
		
		try {
			value = Integer.valueOf(minute);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return !(minute.length() == 0 || value < 0 || value >= 60);
	}
	
	public static boolean date(String date) {
		if (date == null) {
			return false;
		}
		
		try {
			DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
			dateFormat.setLenient(false);
			dateFormat.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
}
