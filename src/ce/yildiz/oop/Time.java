package ce.yildiz.oop;

public class Time {
	private int hour;
	private int minute;
	
	public Time() {

	}

	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
	//Write an Exception
	public int getDifference(Time other) {
		int diff = 0;
		if (this.hour > other.hour) {
			diff += 60 * (this.hour - other.hour);
			diff += this.minute - other.minute;
		} else {
			diff += 60 * (other.hour - this.hour);
			diff += other.minute - this.minute;
		}

		return diff;
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
}
