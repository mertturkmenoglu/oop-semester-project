package ce.yildiz.oop;

public class ParkRecord {
	private Time enterTime,exitTime;
	private Vehicle vehicle;
	public int getParkingDuration() {
		return exitTime.getDifference(enterTime);
	}
}
