package ce.yildiz.oop;

import vehicle.Vehicle;

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

	public boolean setExitTime(Time exitTime) {
		if (exitTime.getDifference(enterTime) == -1) {
			return false;
		} else {
			this.exitTime = exitTime;
			return true;
		}
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
