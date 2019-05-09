package ce.yildiz.oop;

public class SubscribedVehicle implements Vehicle {
	private Subscription subscription;
	private String plate;

	public SubscribedVehicle() {
		
	}

	public SubscribedVehicle(Subscription subscription, String plate) {
		this.subscription = subscription;
		this.plate = plate;
	}

	@Override
	public Subscription getSubscription() {
		return subscription;
	}
	
	public void setSubscription(Subscription subscription) {
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
