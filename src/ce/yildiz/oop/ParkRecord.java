package ce.yildiz.oop;

public class ParkRecord {
	private Time enterTime;
	private Time exitTime;
	private Vehicle vehicle;
	
	public ParkRecord() {

	}
	
	public ParkRecord(Time enterTime, Time exitTime, Vehicle vehicle) {
		this.enterTime = enterTime;
		this.exitTime = exitTime;
		this.vehicle = vehicle;
	}
	public int getParkingDuration() {
		return exitTime.getDifference(enterTime);
	}
}
