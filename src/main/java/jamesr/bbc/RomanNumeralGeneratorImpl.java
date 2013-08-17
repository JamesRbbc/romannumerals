package jamesr.bbc;

/**
 * Implementation of {@link RomanNumeralGenerator}.
 * 
 * @author james
 * 
 */
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {

	@Override
	public String generate(int number) {
		if (number > 3999) {
			throw new IllegalArgumentException(
					"Values greater than 3999 are not accepted");
		}

		if (number <= 0) {
			throw new IllegalArgumentException("Values must be greater than 0");
		}

		//
		// This adds the parts that represent thousands + hundreds + tens +
		// single digits into a single number representation.
		//
		return RomanNumeralPart.THOUSANDS.format(number)
				+ RomanNumeralPart.HUNDREDS.format(number)
				+ RomanNumeralPart.TENS.format(number)
				+ RomanNumeralPart.SINGLE.format(number);
	}

}
