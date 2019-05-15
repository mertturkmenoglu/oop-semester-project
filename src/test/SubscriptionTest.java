package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ce.yildiz.oop.Date;
import ce.yildiz.oop.Subscription;

public class SubscriptionTest {
	private Subscription subscription;
	private static Date date;
	private static Date behindDate;
	private static Date epochDate;
	private static Date aheadDate;
	
	@BeforeClass
	public static void setUpClass() {
		date = Date.getToday();
		behindDate = new Date(1, 1, 1000);
		epochDate = new Date(1, 1, 1970);
		aheadDate = new Date(1, 1, 2100);
	}

	@Test
	public void testIsValidReturnsTrue() {
		subscription = new Subscription(epochDate, aheadDate, "34 CE 1000");
		boolean actual = subscription.isValid();
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsValidReturnsFalse() {
		subscription = new Subscription(behindDate, epochDate, "34 CE 1000");
		boolean actual = subscription.isValid();
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsValidTodayDateIsBeginDateReturnsTrue() {
		subscription = new Subscription(date, aheadDate, "34 CE 1000");
		boolean actual = subscription.isValid();
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsValidTodayDateIsEndDateReturnsTrue() {
		subscription = new Subscription(epochDate, date, "34 CE 1000");
		boolean actual = subscription.isValid();
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@AfterClass
	public static void tearDownClass() {
		date = null;
		epochDate = null;
		aheadDate = null;
	}
}
