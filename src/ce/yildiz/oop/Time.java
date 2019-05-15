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
	
	/**
	 * Gets difference between this time and other.
	 * If other time is ahead of this time, returns -1
	 * else returns difference in minutes
	 * @param other is other time object
	 * @return time difference
	 */
	public int getDifference(Time other){
		int diff = 0;
		if (this.hour >= other.hour) {
			diff += 60 * (this.hour - other.hour);
			diff += this.minute - other.minute;
		} else {
			diff = -1;
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
	
	@Override
	public String toString() {
		return String.valueOf(hour) + ":" + String.valueOf(minute);
	}
}
