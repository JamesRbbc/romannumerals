package jamesr.bbc;

/**
 * Interface defining how to produce Roman numerals.
 * 
 * For example, see the following sample inputs and outputs:
 * 
 * <ul>
 * <li>1 = “I”
 * <li>5 = “V”
 * <li>10 = “X”
 * <li>20 = “XX”
 * <li>3999 = “MMMCMXCIX”
 * </ul>
 * 
 * Caveat: Only support numbers between 1 and 3999
 * 
 * For an in-depth description of Roman Numerals, see
 * 
 * http://en.wikipedia.org/wiki/Roman_numerals
 * 
 * @author james
 * 
 */
public interface RomanNumeralGenerator {
	/**
	 * Given an integer return a Roman numeral representation of that integer.
	 * 
	 * @param number
	 *            the integer to represent as a Roman numeral.
	 * @return the Roman numeral.
	 */
	public String generate(int number);
}
