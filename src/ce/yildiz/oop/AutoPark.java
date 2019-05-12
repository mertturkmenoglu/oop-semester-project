package ce.yildiz.oop;

import java.util.Arrays;

public class AutoPark {
	private SubscribedVehicle[] subscribedVehicles;
	private ParkRecord[] parkRecords;
	private double hourlyFee;
	private double incomeDaily;
	private int capacity;
	
	public AutoPark(double hourlyFee, int capacity) {
		this.hourlyFee = hourlyFee;
		this.capacity = capacity;
		subscribedVehicles = new SubscribedVehicle[capacity];
		parkRecords = new ParkRecord[capacity];
	}
	
	public SubscribedVehicle searchVehicle(String plate) {
		for(SubscribedVehicle v : subscribedVehicles) {
			if (v.getPlate().equals(plate)) {
				return v;
			}
		}
		return null;
	}
	
	public boolean isParked(String plate) {
		for(int i = 0; i < capacity; i++) {
			if (parkRecords[i].getVehicle().getPlate().equals(plate)) {
				return true;
			}
		}
		return false;
	}
	
	public void enlargeVehicleArray() {
		SubscribedVehicle[] tmp = new SubscribedVehicle[capacity];
		for(int i = 0; i < capacity; i++) {
			tmp[i] = subscribedVehicles[i];
		}
		
		capacity *= 2;
		
		subscribedVehicles = new SubscribedVehicle[capacity];
		
		int i = 0;
		for(SubscribedVehicle v : tmp) {
			subscribedVehicles[i] = v;
			i++;
		}
	}
	
	public boolean addVehicle(SubscribedVehicle v) {
		if (searchVehicle(v.getPlate()) == null) {
			int i = 0;
			while(i < capacity && subscribedVehicles[i] != null) {
				i++;
			}
			
			if (i >= capacity) {
				return false;
			} else {
				subscribedVehicles[i] = v;
				return true;
			}
		} else {
			return false;
		}
	}
	
	public boolean vehicleEnters(String plate, Time enter, boolean isOfficial) {
		// TODO: Implement method
		return false;
	}
	
	public boolean vehicleExits(String plate, Time exit) {
		// TODO: Implement method
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Subscribed Vehicles: ");
		strBuilder.append(Arrays.toString(subscribedVehicles));
		strBuilder.append("\nPark Records: ");
		strBuilder.append(Arrays.toString(parkRecords));
		strBuilder.append("\nHourly fee: ");
		strBuilder.append(new Double(hourlyFee).toString());
		strBuilder.append("\nIncome Daily: ");
		strBuilder.append(new Double(incomeDaily).toString());
		strBuilder.append("\nCapacity: ");
		strBuilder.append(new Integer(capacity).toString());
		return strBuilder.toString();
	}
}