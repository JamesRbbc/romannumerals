package jamesr.bbc;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RomanNumeralGeneratorImplTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private RomanNumeralGenerator testSubject = new RomanNumeralGeneratorImpl();

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
		// When
		String romanNumeral = testSubject.generate(1);

		// Then
		assertEquals("I", romanNumeral);
	}
}
