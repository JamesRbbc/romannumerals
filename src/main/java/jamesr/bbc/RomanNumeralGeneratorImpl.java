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

		if (number <= 10) {
			return formatTenNumber(number, 'I', 'V', 'X');
		}

		return formatTenNumber(number / 10, 'X', 'L', 'C');
	}

	/**
	 * Deals with formating a set of numbers that are multiples of ten. For
	 * example formatTenNumber(number, "I", "V", "X"); where number goes from 1
	 * to 10 will return I, II, III, IV, V, VI, VII, VIII, IX, X.
	 * 
	 * @param number
	 *            a number between 1 and ten to format
	 * @param singleDigit
	 *            the
	 * @param fiveDigit
	 * @param tenDigit
	 * @return the formatted Roman number
	 */
	private String formatTenNumber(int number, char singleDigit,
			char fiveDigit, char tenDigit) {
		switch (number) {
		case 1:
			return asString(singleDigit);
		case 2:
			return asString(singleDigit, singleDigit);
		case 3:
			return asString(singleDigit, singleDigit, singleDigit);
		case 4:
			return asString(singleDigit, fiveDigit);
		case 5:
			return asString(fiveDigit);
		case 6:
			return asString(fiveDigit, singleDigit);
		case 7:
			return asString(fiveDigit, singleDigit, singleDigit);
		case 8:
			return asString(fiveDigit, singleDigit, singleDigit, singleDigit);
		case 9:
			return asString(singleDigit, tenDigit);
		case 10:
			return asString(tenDigit);
		default:
			throw new IllegalArgumentException(
					"Method only formats numbers between 1 and 10.");
		}
	}

	/**
	 * Returns a string built from the given chars.
	 * 
	 * @param chars
	 *            the chars to create a string from
	 * @return the required string
	 */
	private String asString(char... chars) {
		return new String(chars);
	}
}
