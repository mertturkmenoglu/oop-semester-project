package ce.yildiz.oop;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("unused")
public class AutoParkTest {
	private static AutoPark autoPark;
	private static Date date;
	private static Date behindDate;
	private static Date epochDate;
	private static Date aheadDate;
	private static String[] plates;
	
	@BeforeClass
	public static void setUpClass() {
		autoPark = new AutoPark(2, 20);
		
		date = Date.getToday();
		behindDate = new Date(1, 1, 1000);
		epochDate = new Date(1, 1, 1970);
		aheadDate = new Date(1, 1, 2100);
		
		plates = new String[] {
				"34 AS 34",
				"33 LA 33",
				"28 GR 28",
				"01 AA 01",
				"06 AA 06"
		};
	}
	
	@Before
	public void clearArrays() {
		autoPark.setParkRecords(new ParkRecord[autoPark.getCapacity()]);
		autoPark.setSubscribedVehicles(new SubscribedVehicle[autoPark.getCapacity()]);
		for(String s : plates) {
			autoPark.addVehicle(new SubscribedVehicle(new Subscription(
							behindDate, aheadDate, s), s));
		}
	}
	
	@Test
	public void testSearchVehicle1() {
		SubscribedVehicle actual = autoPark.searchVehicle("34 AS 34");
		SubscribedVehicle expected = autoPark.getSubscribedVehicles()[0];
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSearchVehicle2() {
		SubscribedVehicle actual = autoPark.searchVehicle("INVALID PLATE");
		assertNull(actual);
	}
	
	@Test
	public void testIsParkedReturnsTrue() {
		autoPark.vehicleEnters(plates[0], new Time(1, 20), false);
		boolean actual = autoPark.isParked(plates[0]);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsParkedReturnsFalse() {
		boolean actual = autoPark.isParked("INVALID PLATE");
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVehicleEntersReturnsTrue() {
		boolean actual = autoPark.vehicleEnters(plates[1], new Time(1, 20), false);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVehicleEntersReturnsFalse() {
		autoPark.vehicleEnters(plates[2], new Time(1, 20), false);
		boolean actual = autoPark.vehicleEnters(plates[2], new Time(1, 20), false);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVehicleExitsReturnsTrueVehicleDoesNotExists() {
		try {
			boolean actual = autoPark.vehicleExits(null, null);
			boolean expected = false;
			assertEquals(expected, actual);
		} catch (Exception e) {
			assertEquals("EXCEPTION", 0, 1);
		}
	}
	
	@Test
	public void testVehicleExitsReturnsTrueVehicleExists() {
		autoPark.vehicleEnters(plates[0], new Time(1, 20), false);
		try {
			boolean actual = autoPark.vehicleExits(plates[0], new Time(2, 20));
			boolean expected = true;
			assertEquals(expected, actual);
		} catch (Exception e) {
			assertEquals("EXCEPTION", 0, 1);
		}
	}
	
	@Test
	public void testIncome() {
		double first = autoPark.getIncomeDaily();
		autoPark.vehicleEnters("Regular Plate", new Time(1, 0), false);
		try {
			autoPark.vehicleExits("Regular Plate", new Time(2, 0));
		} catch (Exception e) {
			assertEquals("EXCEPTION", 0, 1);
		}
		double end = autoPark.getIncomeDaily();
		double actual = end - first;
		double expected = autoPark.getHourlyFee();
		assertEquals(end, first, 0);
	}

	@AfterClass
	public static void tearDownClass() {
		autoPark = null;
		date = null;
		behindDate = null;
		epochDate = null;
		aheadDate = null;
	}
}