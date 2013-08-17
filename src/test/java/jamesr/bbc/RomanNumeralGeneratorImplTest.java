package jamesr.bbc;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RomanNumeralGeneratorImplTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private RomanNumeralGenerator testSubject = new RomanNumeralGeneratorImpl();

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
}
