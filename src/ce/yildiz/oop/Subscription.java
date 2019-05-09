package ce.yildiz.oop;

public class Subscription {
	private Date begin;
	private Date end;
	private SubscribedVehicle vehicle;
	
	public Subscription(Date begin, Date end, String plate) {
		this.begin = begin;
		this.end = end;
		this.vehicle = new SubscribedVehicle(this, plate);
	}
	
	public Date getBegin() {
		return begin;
	}
	
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public SubscribedVehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(SubscribedVehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	//Write an Exception !!!
	public boolean isValid() {
		return ((Date.getToday().isAfterThan(begin) && 
				Date.getToday().isBeforeThan(end) ||
				Date.getToday().isEqualsWith(begin) || 
				Date.getToday().isEqualsWith(end) ));
	}
}
