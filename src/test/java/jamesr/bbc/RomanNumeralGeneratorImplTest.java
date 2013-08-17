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
	public void shouldReturnRomanOne() {
		verifyOutput(1, "I");
	}

	@Test
	public void shouldReturnRomanTwo() {
		verifyOutput(2, "II");
	}

	@Test
	public void shouldReturnRomanThree() {
		verifyOutput(3, "III");
	}

	@Test
	public void shouldReturnRomanFour() {
		verifyOutput(4, "IV");
	}

	@Test
	public void shouldReturnRomanFive() {
		verifyOutput(5, "V");
	}
}
