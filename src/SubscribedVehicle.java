
public class SubscribedVehicle implements Vehicle {
	private Subscription subscription;
	private String plate;

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public SubscribedVehicle() {
		// TODO Auto-generated constructor stub
	}

	public SubscribedVehicle(Subscription subscription, String plate) {
		super();
		this.subscription = subscription;
		this.plate = plate;
	}

	public String getPlate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Subscription getSubscription() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSpecial() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPlate(String plate) {
		// TODO Auto-generated method stub
		
	}

}
