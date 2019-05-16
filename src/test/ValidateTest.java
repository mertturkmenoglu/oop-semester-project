package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ui.Validate;

public class ValidateTest {

	@Test
	public void tesHourlyFeeEmptyString() {
		boolean actual = Validate.hourlyFee("");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourlyFeeNullValue() {
		boolean actual = Validate.hourlyFee(null);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourlyFeePunctuationValue() {
		boolean actual = Validate.hourlyFee("!!!!!!!!!!");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourlyFeeAlphabetChar() {
		boolean actual = Validate.hourlyFee("CHAR");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourlyFeeNegativeDoubleValue() {
		boolean actual = Validate.hourlyFee("-10.10");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourlyFeeZeroValue() {
		boolean actual = Validate.hourlyFee("0");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourlyFeeInvalidPositiveValueUnparselable() {
		boolean actual = Validate.hourlyFee("15.5STRING");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourlyFeeInValidInputWithWhitespace() {
		boolean actual = Validate.hourlyFee("   15.5   ");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourlyFeeValidInput() {
		boolean actual = Validate.hourlyFee("10.10");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	/////////////////////////////////////////////////////////////
	
	@Test
	public void tesCapacityEmptyString() {
		boolean actual = Validate.capacity("");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCapacityNullValue() {
		boolean actual = Validate.capacity(null);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCapacityPunctuationValue() {
		boolean actual = Validate.capacity("!!!!!!!!!!");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCapacityAlphabetChar() {
		boolean actual = Validate.capacity("CHAR");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCapacityNegativeIntegerValue() {
		boolean actual = Validate.capacity("-10");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCapacityZeroValue() {
		boolean actual = Validate.capacity("0");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCapacityInvalidPositiveValueDouble() {
		boolean actual = Validate.capacity("15.5");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCapacityInvalidPositiveValueUnparselable() {
		boolean actual = Validate.capacity("10STRING");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCapacityInvalidInputWithWhitespace() {
		boolean actual = Validate.capacity("   15   ");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCapacityValidInput() {
		boolean actual = Validate.capacity("10");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	/////////////////////////////////////////////////////////////
	
	@Test
	public void testPlateEmptyString() {
		boolean actual = Validate.plate("");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlateNullValue() {
		boolean actual = Validate.plate(null);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlatePunctuationValue() {
		boolean actual = Validate.plate("!!!!!!!!!!");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlateAlphabetChar() {
		boolean actual = Validate.plate("CHAR");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testPlateValidInputWithWhitespace() {
		boolean actual = Validate.plate("   15   ");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlateValidInput() {
		boolean actual = Validate.plate("34 AA 34");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	/////////////////////////////////////////////////////////////
		
	@Test
	public void testHourEmptyString() {
		boolean actual = Validate.hour("");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourNullValue() {
		boolean actual = Validate.hour(null);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourPunctuationValue() {
		boolean actual = Validate.hour("!!!!!!!!!!");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourAlphabetChar() {
		boolean actual = Validate.hour("CHAR");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourNegativeIntegerValue() {
		boolean actual = Validate.hour("-10");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourZeroValue() {
		boolean actual = Validate.hour("0");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourInvalidPositiveValueDouble() {
		boolean actual = Validate.hour("15.5");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourInvalidPositiveValueUnparselable() {
		boolean actual = Validate.hour("10STRING");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourInvalidInputWithWhitespace() {
		boolean actual = Validate.hour("   15   ");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourValidInput() {
		boolean actual = Validate.hour("10");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHourInvalidInputGreaterThanMax() {
		boolean actual = Validate.hour("48");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}

	/////////////////////////////////////////////////////////////

	@Test
	public void testMinuteEmptyString() {
		boolean actual = Validate.minute("");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinuteNullValue() {
		boolean actual = Validate.minute(null);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinutePunctuationValue() {
		boolean actual = Validate.minute("!!!!!!!!!!");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinuteAlphabetChar() {
		boolean actual = Validate.minute("CHAR");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinuteNegativeIntegerValue() {
		boolean actual = Validate.minute("-10");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinuteZeroValue() {
		boolean actual = Validate.minute("0");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinuteInvalidPositiveValueDouble() {
		boolean actual = Validate.minute("15.5");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinuteInvalidPositiveValueUnparselable() {
		boolean actual = Validate.minute("10STRING");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinuteInvalidInputWithWhitespace() {
		boolean actual = Validate.minute("   15   ");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinuteValidInput() {
		boolean actual = Validate.minute("10");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinuteInvalidInputGreaterThanMax() {
		boolean actual = Validate.minute("120");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	/////////////////////////////////////////////////////////////
	
	@Test
	public void testDateEmptyString() {
		boolean actual = Validate.date("");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateNullValue() {
		boolean actual = Validate.date(null);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDatePunctuationValue() {
		boolean actual = Validate.date("!!!!!!!!!!");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateAlphabetChar() {
		boolean actual = Validate.date("CHAR");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateNegativeIntegerValue() {
		boolean actual = Validate.date("-10");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateZeroValue() {
		boolean actual = Validate.date("0");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateInvalidPositiveValueUnparselable() {
		boolean actual = Validate.date("10STRING");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateValidInputWithWhitespace() {
		boolean actual = Validate.date("   12-4-2010   ");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateValidInput() {
		boolean actual = Validate.date("1-1-2019");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateInvalidInputDayField() {
		boolean actual = Validate.date("31-2-2019");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateInvalidInputMonthField() {
		boolean actual = Validate.date("15-13-2000");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateValidInputLeadingZero() {
		boolean actual = Validate.date("15-01-2000");
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDateInvalidFormatDateCorrectReturnsFalse() {
		boolean actual = Validate.date("15012000");
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
}
