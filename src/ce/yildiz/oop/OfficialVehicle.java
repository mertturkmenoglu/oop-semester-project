package ce.yildiz.oop;

public class OfficialVehicle implements Vehicle {
	private Subscription subscription;
	private String plate;

	public OfficialVehicle() {
		
	}
	
	public OfficialVehicle(Subscription subscription, String plate) {
		this.subscription = subscription;
		this.plate = plate;
	}

	@Override
	public Subscription getSubscription() {
		return subscription;
	}
	
	public void setSubcription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	public String getPlate() {
		return plate;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public boolean isSpecial() {
		// TODO Auto-generated method stub
		return false;
	}
}
