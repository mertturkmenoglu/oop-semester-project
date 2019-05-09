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
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	public String getPlate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPlate(String plate) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isSpecial() {
		// TODO Auto-generated method stub
		return false;
	}
}
