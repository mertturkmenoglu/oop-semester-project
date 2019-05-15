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
	
	public Time getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(Time enterTime) {
		this.enterTime = enterTime;
	}

	public Time getExitTime() {
		return exitTime;
	}

	public void setExitTime(Time exitTime) {
		this.exitTime = exitTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getParkingDuration() {
		return exitTime.getDifference(enterTime);
	}
	
	@Override
	public String toString() {
		String s = "\n" + vehicle.toString();
		s += "Enter Time: ";
		if (enterTime != null) {
			s += "\t" + enterTime.toString() + "\n";
		} else {
			s += "\tnull" + "\n";
		}
		
		s += "Exit time: ";
		if(exitTime != null) {
			s += "\t" + exitTime.toString() + "\n";
		} else {
			s += "\tnull" + "\n";
		}
		
		return s;
	}
}
