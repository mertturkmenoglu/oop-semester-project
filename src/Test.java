
public class Test {

	public static void main(String[] args) {
		Date date=new Date(12,05,1992);
		Date other=new Date(12,07,2019);
		Date today=Date.getToday();
		/*boolean test=date.isBeforeThan(today);
		System.out.println(today.getDay()+ " "+ today.getMonth() +" " +today.getYear());
		System.out.println(test);
		Subscription s=new Subscription(other,today,"ABC");
		Vehicle v=new SubscribedVehicle(s,"ABC");
		System.out.println(s.isValid());*/
		Time time=new Time(23,12);
		Time other1=new Time(15,17);
		System.out.println(time.getDifference(other1));
		
	}

}
