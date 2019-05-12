package ce.yildiz.oop;

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
}
