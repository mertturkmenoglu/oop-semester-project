package ce.yildiz.oop;

public class OfficialVehicle implements Vehicle {
	private String plate;

	public OfficialVehicle(String plate) {
		super();
		this.plate = plate;
	}

	public OfficialVehicle() {
		// TODO Auto-generated constructor stub
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
		this.plate=plate;
	}

}
