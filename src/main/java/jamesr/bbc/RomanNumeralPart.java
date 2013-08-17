package jamesr.bbc;

/**
 * Enum representing the parts that make up a full Roman Numeral.
 * 
 * @author james
 * 
 */
public enum RomanNumeralPart {
	// @formatter:off
	/**
	 * Single digits from 1 to 10
	 */
	SINGLE(0, 'I', 'V', 'X'),
	/**
	 * The tens digit from 10 to 100.
	 */
	TENS(10, 'X', 'L', 'C'),
	/**
	 * The hundreds digit from 100 to 1000.
	 */
	HUNDREDS(100, 'C', 'D', 'M'),
	/**
	 * The tens digit from 1000 to 10000.
	 */
	THOUSANDS(1000, 'M', '-', '-');
	// @formatter:on

	private final int base;
	private final char singleDigit;
	private final char fiveDigit;
	private final char tenDigit;

	/**
	 * Create the enum value.
	 * 
	 * @param base
	 *            the base this part represents (e.g. 0s, 10s, 100s etc)
	 * @param single
	 *            the character that represents a single part (e.g. a 1 or a 10
	 *            or a 100)
	 * @param five
	 *            the character that represents a five parts (e.g. a 5 or a 50
	 *            or a 500)
	 * @param ten
	 *            the character that represents a ten parts (e.g. a 10 or a 100
	 *            or a 1000)
	 */
	private RomanNumeralPart(int base, char single, char five, char ten) {
		this.base = base;
		this.singleDigit = single;
		this.fiveDigit = five;
		this.tenDigit = ten;
	}

	/**
	 * Formats a number for this part of the Roman numeral.
	 * 
	 * @param number
	 *            the number to format
	 * @return a formatted string
	 */
	String format(int number) {

		if (number >= base) {
			return doFormat(toRoot(number));
		}

		return "";
	}

	/**
	 * Converts the number X into "(x / base) % 10" for working out the (Y *
	 * 10)th digit.
	 * 
	 * The root can then be used to find the correct set of digits to represent
	 * this number.
	 * 
	 * e.g. <code>
	 * SINGLE.toRoot(12345) => 5
	 * TENS.toRoot(12345) => 4
	 * HUNDREDS.toRoot(12345) => 3
	 * THOUSANDS.toRoot(12345) => 2
	 * </code>
	 * 
	 * @param number
	 *            the number whose root is required
	 * @return the root
	 */
	private int toRoot(int number) {
		int root = number;

		if (base > 0) {
			root = number / base;
		}

		return root % 10;
	}

	/**
	 * Deals with formating a set of numbers that are multiples of ten. For
	 * example SINGLE.formatTenNumber(number); where number goes from 1 to 10
	 * will return I, II, III, IV, V, VI, VII, VIII, IX, X.
	 * 
	 * @param number
	 *            a number between 0 and ten to format
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
