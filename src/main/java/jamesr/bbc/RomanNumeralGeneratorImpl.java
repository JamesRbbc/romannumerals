package jamesr.bbc;

/**
 * Implementation of {@link RomanNumeralGenerator}.
 * 
 * @author james
 * 
 */
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {

	private enum RomanNumeralPart {
		SINGLE(0, 'I', 'V', 'X'), TENS(10, 'X', 'L', 'C'), HUNDREDS(100, 'C',
				'D', 'M'), THOUSANDS(1000, 'M', '-', '-');

		private final int base;
		private final char singleDigit;
		private final char fiveDigit;
		private final char tenDigit;

		private RomanNumeralPart(int base, char single, char five, char ten) {
			this.base = base;
			this.singleDigit = single;
			this.fiveDigit = five;
			this.tenDigit = ten;
		}

		/**
		 * Formats a string for a given base.
		 * 
		 * @param partToFormat
		 *            The part of the Roman numeral to be formatted
		 * @param number
		 *            the number to format
		 * @return a formatted string
		 */
		String format(int number) {

			if (number >= base) {
				int root = number;

				if (base > 0) {
					root = number / base;
				}

				return doFormat(root % 10);
			}

			return "";
		}

		/**
		 * Deals with formating a set of numbers that are multiples of ten. For
		 * example formatTenNumber(number, "I", "V", "X"); where number goes
		 * from 1 to 10 will return I, II, III, IV, V, VI, VII, VIII, IX, X.
		 * 
		 * @param number
		 *            a number between 1 and ten to format
		 * @param singleDigit
		 *            the
		 * @param fiveDigit
		 * @param tenDigit
		 * @return the formatted Roman number
		 */
		private String doFormat(int number) {
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
				return asString(fiveDigit, singleDigit, singleDigit,
						singleDigit);
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

	@Override
	public String generate(int number) {
		if (number > 3999) {
			throw new IllegalArgumentException(
					"Values greater than 3999 are not accepted");
		}

		if (number <= 0) {
			throw new IllegalArgumentException("Values must be greater than 0");
		}

		return RomanNumeralPart.THOUSANDS.format(number)
				+ RomanNumeralPart.HUNDREDS.format(number)
				+ RomanNumeralPart.TENS.format(number)
				+ RomanNumeralPart.SINGLE.format(number);
	}

}
