
public class Time {
	private int hour,minute;
	//Write an Exception
	public int getDifference(Time other) {
		int temp=0;
		if(this.hour>other.hour)
		{
			temp+=60*(this.hour-other.hour);
		} 
			temp+=this.minute-other.minute;
		return temp;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public Time() {
		super();
	}

	public Time(int hour, int minute) {
		super();
		this.hour = hour;
		this.minute = minute;
	}
}
