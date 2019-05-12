package ce.yildiz.oop;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateTest {	
	private static Date behindDate;
	private static Date behindDate2;
	private static Date behindDate3;
	private static Date behindDate4;
	private static Date behindDate5;
	
	private static Date thisDate;
	private static Date equalDate;
	
	private static Date aheadDate;
	private static Date aheadDate2;
	private static Date aheadDate3;
	private static Date aheadDate4;
	private static Date aheadDate5;

	@BeforeClass
	public static void setUpClass() {
		behindDate = new Date(1, 6, 2000);
		behindDate2 = new Date(30, 6, 2000);
		behindDate3 = new Date(15, 1, 2000);
		behindDate4 = new Date(15, 12, 2000);
		behindDate5 = new Date(15, 6, 2000);
		
		thisDate = new Date(15, 6, 2050);
		equalDate = new Date(15, 6, 2050);
		
		aheadDate = new Date(1, 6, 2100);
		aheadDate2 = new Date(30, 6, 2100);
		aheadDate3 = new Date(15, 1, 2100);
		aheadDate4 = new Date(15, 12, 2100);
		aheadDate5 = new Date(15, 6, 2100);
	}

	
	////---- isAfterThan tests starts ---- ////
	
	@Test
	public void testIsAfterThanBehindDateDayBehind() {
		boolean actual = thisDate.isAfterThan(behindDate);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsAfterThanBehindDateDayAhead() {
		boolean actual = thisDate.isAfterThan(behindDate2);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsAfterThanBehindDateMonthBehind() {
		boolean actual = thisDate.isAfterThan(behindDate3);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsAfterThanBehindDateMonthAhead() {
		boolean actual = thisDate.isAfterThan(behindDate4);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsAfterThanBehindDateYearBehind() {
		boolean actual = thisDate.isAfterThan(behindDate5);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsAfterThanDatesEqual() {
		boolean actual = thisDate.isAfterThan(equalDate);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsAfterThanAheadDateDayBehind() {
		boolean actual = thisDate.isAfterThan(aheadDate);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsAfterThanAheadDateDayAhead() {
		boolean actual = thisDate.isAfterThan(aheadDate2);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsAfterThanAheadDateMonthBehind() {
		boolean actual = thisDate.isAfterThan(aheadDate3);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsAfterThanAheadDateMonthAhead() {
		boolean actual = thisDate.isAfterThan(aheadDate4);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsAfterThanAheadDateYearAhead() {
		boolean actual = thisDate.isAfterThan(aheadDate5);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	
	//// ---- isAfterThan tests ends ---- ////
	
	//// ---- isBeforeThan tests starts ---- ////

	
	@Test
	public void testIsBeforeThanBehindDateDayBehind() {
		boolean actual = thisDate.isBeforeThan(behindDate);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsBeforeThanBehindDateDayAhead() {
		boolean actual = thisDate.isBeforeThan(behindDate2);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsBeforeThanBehindDateMonthBehind() {
		boolean actual = thisDate.isBeforeThan(behindDate3);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsBeforeThanBehindDateMonthAhead() {
		boolean actual = thisDate.isBeforeThan(behindDate4);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsBeforeThanBehindDateYearBehind() {
		boolean actual = thisDate.isBeforeThan(behindDate5);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsBeforeThanDatesEqual() {
		boolean actual = thisDate.isBeforeThan(equalDate);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsBeforeThanAheadDateDayBehind() {
		boolean actual = thisDate.isBeforeThan(aheadDate);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsBeforeThanAheadDateDayAhead() {
		boolean actual = thisDate.isBeforeThan(aheadDate2);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsBeforeThanAheadDateMonthBehind() {
		boolean actual = thisDate.isBeforeThan(aheadDate3);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsBeforeThanAheadDateMonthAhead() {
		boolean actual = thisDate.isBeforeThan(aheadDate4);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsBeforeThanAheadDateYearAhead() {
		boolean actual = thisDate.isBeforeThan(aheadDate5);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	
	//// ---- isBeforeThan tests ends ---- ////
	
	//// ---- isEqualsWith tests starts ---- ////
	
	
	@Test
	public void testIsEqualsWithBehindDate() {
		boolean actual = thisDate.isEqualsWith(behindDate);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsEqualsWithEqualDate() {
		boolean actual = thisDate.isEqualsWith(equalDate);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsEqualsWithAheadDate() {
		boolean actual = thisDate.isEqualsWith(aheadDate);
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	
	//// ---- isBeforeThan tests ends ---- ////
	
	
	@AfterClass
	public static void tearDownClass() {
		behindDate = null;
		behindDate2 = null;
		behindDate3 = null;
		behindDate4 = null;
		behindDate5 = null;
		
		thisDate = null;
		equalDate = null;
		
		aheadDate = null;
		aheadDate2 = null;
		aheadDate3 = null;
		aheadDate4 = null;
		aheadDate5 = null;
	}
}
