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
		throw new IllegalArgumentException(
				"Values greater than 3999 are not accepted");
	}

}
