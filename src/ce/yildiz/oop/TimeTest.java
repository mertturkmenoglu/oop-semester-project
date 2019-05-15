package ce.yildiz.oop;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TimeTest {
	private static Time thisTime;
	private static Time behindTime;
	private static Time behindTime2;
	private static Time equalTime;
	private static Time aheadTime;
	private static Time aheadTime2;

	@BeforeClass
	public static void setUpClass() {
		thisTime = new Time(42, 42);
		behindTime = new Time(10, 10);
		behindTime2 = new Time(10, 59);
		equalTime = new Time(42, 42);
		aheadTime = new Time(100, 0);
		aheadTime2 = new Time(100, 59);
	}

	@Test
	public void testGetDifferenceBehindTimeMinuteBehind() {
		int actual = thisTime.getDifference(behindTime);
		int expected = 32 * 60 + 32;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetDifferenceBehindTimeMinuteAhead() {
		int actual = thisTime.getDifference(behindTime2);
		int expected = 32 * 60 + (42-59);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetDifferenceEqualTimes() {
		int actual = thisTime.getDifference(equalTime);
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDifferenceAheadTimeMinuteBehind() {
		int actual = thisTime.getDifference(aheadTime);
		int expected = -1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetDifferenceAheadTimeMinuteAhead() {
		int actual = thisTime.getDifference(aheadTime2);
		int expected = -1;
		assertEquals(expected, actual);
	}

	@AfterClass
	public static void tearDownClass() {
		behindTime = null;
		behindTime2 = null;
		thisTime = null;
		equalTime = null;
		aheadTime = null;
		aheadTime2 = null;
	}
}
