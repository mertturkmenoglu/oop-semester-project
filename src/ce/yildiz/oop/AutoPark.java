package ce.yildiz.oop;

import java.util.Arrays;

@SuppressWarnings("unused")
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
			int i = getFirstEmptyIndex(subscribedVehicles);
			
			if (i == -1) {
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
		// Vehicle has already parked
		if (searchVehicle(plate) != null) {
			return false;
		}
		
		// Subscribed car or not
		boolean result = searchOnSubscriptions(plate);
		
		if (result) {
			int index = getVehicleIndexOnSubscribedVehicles(plate);
			parkRecords[getFirstEmptyIndex(parkRecords)] = new ParkRecord(enter, null, 
					subscribedVehicles[index]);
			return true;
		} else {
			// Official vehicle
			if (isOfficial) {
				parkRecords[getFirstEmptyIndex(parkRecords)] = 
						new ParkRecord(enter, null, new OfficialVehicle(plate));
				return true;
			}
			
			parkRecords[getFirstEmptyIndex(parkRecords)] = new ParkRecord(enter, null, 
					new RegularVehicle(plate));
			return true;
		}
	}
	
	public boolean vehicleExits(String plate, Time exit) throws Exception {
		Vehicle v = searchVehicle(plate);

		// Vehicle does not exist
		if (v == null) {
			return false;
		}
		
		// Official vehicle has permanently valid subscription
		if (v instanceof OfficialVehicle) {
			// Get vehicle index and set exit time
			int index = getVehicleIndexOnParkRecords(v);
			parkRecords[index].setExitTime(exit);
			// Vehicle is gone now. Set to null.
			parkRecords[index] = null;
			return true;
		}
		
		// Vehicle is subscribed
		if (v instanceof SubscribedVehicle) {
			if (!v.getSubscription().isValid()) {
				// Subscription is not valid. Must pay fee.
				throw new Exception();
			}
		}
		
		// Vehicle is regular
		// Get vehicle index and set exit time
		int index = getVehicleIndexOnParkRecords(v);
		parkRecords[index].setExitTime(exit);
		
		if(v.getSubscription() == null) {
			// Vehicle is not subscribed. Must pay fee.
			incomeDaily += calculateFee(index);
			
			// Vehicle is gone now. Set to null.
			parkRecords[index] = null;
			return true;
		}

		return false;
	}
	
	private boolean searchOnSubscriptions(String plate) {
		for(SubscribedVehicle v : subscribedVehicles) {
			if (v.getPlate().equals(plate)) {
				return true;
			}
		}
		return false;
	}
	
	private int getVehicleIndexOnParkRecords(Vehicle v) {
		for(int i = 0; i < capacity; i++) {
			if (parkRecords[i].getVehicle() == v) {
				return i;
			}
		}
		return -1;
	}
	
	private int getVehicleIndexOnParkRecords(String plate) {
		for(int i = 0; i < capacity; i++) {
			if (parkRecords[i].getVehicle().getPlate().equals(plate)) {
				return i;
			}
		}
		return -1;
	}
	
	private int getVehicleIndexOnSubscribedVehicles(Vehicle v) {
		for(int i = 0; i < capacity; i++) {
			if (subscribedVehicles[i] == v) {
				return i;
			}
		}
		return -1;
	}
	
	private int getVehicleIndexOnSubscribedVehicles(String plate) {
		for(int i = 0; i < capacity; i++) {
			if (subscribedVehicles[i].getPlate().equals(plate)) {
				return i;
			}
		}
		return -1;
	}
	
	private double calculateFee(int vehicleIndex) {
		// Get hour data
		int duration = parkRecords[vehicleIndex].getParkingDuration();
		duration /= 60;
					
		// Calculate fee
		return  duration * hourlyFee;
	}
	
	private int getFirstEmptyIndex(Object[] array) {
		int i = 0;
		while(i < capacity && array[i] != null) {
			i++;
		}
		return (array[i] == null) ? i : -1;
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