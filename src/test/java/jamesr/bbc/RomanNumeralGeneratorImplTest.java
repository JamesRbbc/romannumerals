package jamesr.bbc;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit tests for {@link RomanNumeralGeneratorImpl}.
 * 
 * @author james
 * 
 */
public class RomanNumeralGeneratorImplTest {

	/**
	 * Normally shouldn't throw an exception.
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * The instance being tested.
	 */
	private RomanNumeralGenerator testSubject = new RomanNumeralGeneratorImpl();

	/**
	 * Used to verify the output of the test subject.
	 * 
	 * @param numberIn
	 *            the integer to be generated into a Roman numeral.
	 * @param expectedNumberOut
	 *            the expected Roman numeral.
	 */
	private void verifyOutput(int numberIn, String expectedNumberOut) {
		// When
		String romanNumeral = testSubject.generate(numberIn);

		// Then
		assertEquals(expectedNumberOut, romanNumeral);
	}

	@Test
	public void shouldNotAllowNumbersAbove3999() {
		// Expect
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Values greater than 3999 are not accepted");

		// When
		testSubject.generate(4000);
	}

	@Test
	public void shouldNotAllowNumbersZeroOrBelow() {
		// Expect
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Values must be greater than 0");

		// When
		testSubject.generate(0);
	}

	@Test
	public void shouldHandleFirstTenNumbers() {
		verifyOutput(1, "I");
		verifyOutput(2, "II");
		verifyOutput(3, "III");
		verifyOutput(4, "IV");
		verifyOutput(5, "V");
		verifyOutput(6, "VI");
		verifyOutput(7, "VII");
		verifyOutput(8, "VIII");
		verifyOutput(9, "IX");
		verifyOutput(10, "X");
	}

	@Test
	public void shouldHandleMultiplesOfTen() {
		verifyOutput(10, "X");
		verifyOutput(20, "XX");
		verifyOutput(30, "XXX");
		verifyOutput(40, "XL");
		verifyOutput(50, "L");
		verifyOutput(60, "LX");
		verifyOutput(70, "LXX");
		verifyOutput(80, "LXXX");
		verifyOutput(90, "XC");
		verifyOutput(100, "C");
	}

	@Test
	public void shouldHandleMultiplesOfHundred() {
		verifyOutput(100, "C");
		verifyOutput(200, "CC");
		verifyOutput(300, "CCC");
		verifyOutput(400, "CD");
		verifyOutput(500, "D");
		verifyOutput(600, "DC");
		verifyOutput(700, "DCC");
		verifyOutput(800, "DCCC");
		verifyOutput(900, "CM");
		verifyOutput(1000, "M");
	}

	@Test
	public void shouldHandleMultiplesOfThousand() {
		verifyOutput(1000, "M");
		verifyOutput(2000, "MM");
		verifyOutput(3000, "MMM");
	}

	@Test
	public void shouldCombineNumbersNotMultpleOf10() {
		// from wikipedia
		verifyOutput(1954, "MCMLIV");
		verifyOutput(1990, "MCMXC");
		verifyOutput(2008, "MMVIII");
		verifyOutput(47, "XLVII");

		// from exercise
		verifyOutput(3999, "MMMCMXCIX");
	}
}
