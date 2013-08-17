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

		switch (number) {
		case 1:
			return "I";
		case 2:
			return "II";
		default:
			return null;
		}
	}
}
