package vehicle;

import ce.yildiz.oop.Subscription;

public interface Vehicle {
	public String getPlate();
	public Subscription getSubscription();
	public boolean isOfficial();
}