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

		return formatNumberForBase(1000, number, 'M', '-', '-')
				+ formatNumberForBase(100, number, 'C', 'D', 'M')
				+ formatNumberForBase(10, number, 'X', 'L', 'C')
				+ formatNumberForBase(0, number, 'I', 'V', 'X');
	}

	/**
	 * Formats a string for a given base.
	 * 
	 * @param base
	 *            should be one of 0, 10, 100, 1000 and will handle results.
	 * @param number
	 *            the number to format
	 * @param singleDigit
	 *            the single digit representation
	 * @param fiveDigit
	 *            the five digits representation
	 * @param tenDigit
	 *            the ten digits representation
	 * @return a formatted string
	 */
	private String formatNumberForBase(int base, int number, char singleDigit,
			char fiveDigit, char tenDigit) {

		if (number >= base) {
			int root = number;

			if (base > 0) {
				root = number / base;
			}

			return formatTenNumber(root % 10, singleDigit, fiveDigit, tenDigit);
		}

		return "";
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
		case 0:
			return "";
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
