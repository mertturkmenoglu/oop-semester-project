package ce.yildiz.oop;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {

	}
	
	public Date(int day, int month, int year) {
		this.day = day;	
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Check two date object and compare dates.
	 * If this date is after than other date then return true else false
	 * @param other is the other date object to compare
	 * @return date object comparison result
	 */
	public boolean isAfterThan(Date other) {
		// Case 1: This date's year is ahead
		if (this.year > other.year) {
			return true;
		} 
		
		// Case 2: Other date's year is ahead
		if (this.year < other.year) {
			return false;
		}
		
		// Years are equal. Check for month and day fields.
		// Case 3: This date's month is ahead
		if (this.month > other.month) {
			return true;
		} 
		
		// Case 4: Other date's month is ahead
		if (this.month < other.month) {
			return false;
		}
		
		// Year and month fields are equal. Check for day field
		// Case 5: Day fields
		if (this.day >= other.day) {
			return !(isEqualsWith(other));
		} else  {
			return false;
		}
	}
	
	/**
	 * Check two date object and compare dates.
	 * If this date is before than other date then return true else false
	 * @param other is the other date object to compare
	 * @return date object comparison result
	 */
	public boolean isBeforeThan(Date other) {
		// Case 1: This date's year is behind
		if (this.year < other.year) {
			return true;
		} 
		
		// Case 2: Other date's year is behind
		if (this.year > other.year) {
			return false;
		}
		
		// Year fields are equal. Check for month and day fields.
		// Case 3: This date's month is behind
		if (this.month < other.month) {
			return true;
		}
		
		// Case 4: Other date's month is behind
		if (this.month > other.month) {
			return false;
		}
		
		// Year and month fields are equal. Check for day field.
		// Case 5: Day fields
		if (this.day <= other.day) {
			return !(isEqualsWith(other));
		} else 
			return false;
	}
	
	/**
	 * Compare two date objects and return a boolean 
	 * @param other is the other date object to compare
	 * @return equivalence value
	 */
	public boolean isEqualsWith(Date other) {
		return ((this.day == other.day) && 
				(this.month == other.month) && 
				(this.year == other.year));
	}
	
	/**
	 * Static function to get today's date as date object
	 * @return a date object holds today's date values
	 */
	public static Date getToday() {
		Calendar cal = new GregorianCalendar();
		Date temp = new Date();
		
		temp.day = cal.get(Calendar.DAY_OF_MONTH);
		temp.month = cal.get(Calendar.MONTH) + 1;
		temp.year = cal.get(Calendar.YEAR);
		
		return temp;
	}
}
