import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
	private int day,month,year;
	
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

	public boolean isAfterThan(Date other) {
		if(this.year>other.year)
		{
			return true;
		} else if(this.year==other.year) {
			if(this.month>other.month) 
			{
				return true;
			} else if(this.month==other.month) {
				if(this.day>=other.day) 
				{
					if(this.isEqualsWith(other))
						return false;
					return true;
				} else 
					return false;
			} else 
				return false;
		} else
			return false;
	}
	public boolean isBeforeThan(Date other) {
		if(this.year<other.year)
		{
			return true;
		} else if(this.year==other.year) {
			if(this.month<other.month) 
			{
				return true;
			} else if(this.month==other.month) {
				if(this.day<=other.day) 
				{
					if(this.isEqualsWith(other))
						return false;
					return true;
				} else 
					return false;
			} else 
				return false;
		} else
			return false;
	}
	
	public boolean isEqualsWith (Date other) {
		if((this.day==other.day) && (this.month==other.month) && (this.year==other.year)) {
			return true;
		}
		return false;
	}
	
	public static Date getToday() {
		Calendar cal = new GregorianCalendar();
		Date temp=new Date();
		temp.day=cal.get(Calendar.DAY_OF_MONTH);
		temp.month=cal.get(Calendar.MONTH)+1;
		temp.year=cal.get(Calendar.YEAR);
		return temp;
	}
}
