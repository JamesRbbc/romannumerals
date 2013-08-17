package jamesr.bbc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RomanNumeralGeneratorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void shouldNotAllowNumbersAbove3999() {
		// Expect
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Values greater than 3999 are not accepted");

		// Given
		RomanNumeralGenerator testSubject = new RomanNumeralGeneratorImpl();

		// When
		testSubject.generate(4000);
	}
}
