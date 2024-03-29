package vehicle;

import ce.yildiz.oop.Subscription;

public class OfficialVehicle implements Vehicle {
	private final String plate;
	
	public OfficialVehicle(String plate) {
		this.plate = plate;
	}

	@Override
	public Subscription getSubscription() {
		return null;
	}
	
	@Override
	public String getPlate() {
		return plate;
	}
	
	@Override
	public boolean isOfficial() {
		return true;
	}
	
	@Override
	public String toString() {
		return plate + "-Official\n";
	}
}
