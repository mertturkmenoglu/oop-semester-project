package vehicle;

import ce.yildiz.oop.Subscription;

public class SubscribedVehicle implements Vehicle {
	private Subscription subscription;
	private final String plate;

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
		return plate + "-Subscribed\n";
	}
}
