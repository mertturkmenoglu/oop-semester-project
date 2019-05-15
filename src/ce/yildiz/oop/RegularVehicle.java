package ce.yildiz.oop;

public class RegularVehicle implements Vehicle{
	private final String plate;
	
	public RegularVehicle(String plate) {
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
		return false;
	}
	
	@Override
	public String toString() {
		return plate + "-Regular\n";
	}
}
