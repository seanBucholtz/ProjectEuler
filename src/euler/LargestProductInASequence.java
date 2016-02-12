package euler;
/**
 * 
 */

/**
 * @author Sean Bucholtz
 *
 */

import java.math.BigInteger;
import java.lang.NumberFormatException;
import java.lang.String;

public class LargestProductInASequence {
	
	private String seq;
	
	/**
	 * Initializes a newly created LargestProductInASeries object.
	 */
	public LargestProductInASequence() {
		this.seq = null;
	}
	
	/**
	 * Initializes a sequence with a newly created LargestProductInASeries object.
	 * @param seq the string numeric sequence to be investigated
	 */
	public LargestProductInASequence(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Finds the largest product of adjacent digits in a sequence of numbers.
	 * @param numAdj the number of adjacent digits
	 * @return the largest product of adjacent digits
	 * @throws NumberFormatException if the instance member {@code seq} contains
	 * non-integer values
	 */
	public String largestAdjacentProduct(int numAdj) throws NumberFormatException{
		BigInteger product = new BigInteger("0");
		for(int i = 0; i < seq.length(); i++) {
			try {
				char[] subSeqArr = getSubSeq(i, numAdj);
				BigInteger nextProduct = getSubSeqProduct(subSeqArr);
				if(nextProduct.compareTo(product) > 0) {
					product = nextProduct;
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
			catch(NumberFormatException e) {
				throw new NumberFormatException("Error: Sequence string contains non-integer characters");
			}
		}
		return product.toString();
	}
	
	/**
	 * Returns a new sequence that is a sub-sequence of the instance member {@code seq}.
	 * The sub-sequence begins as the specified {@code startIndex} and extends to the 
	 * character at index {@code startIndex + numAdj - 1}. 
	 * @param startIndex the starting index of the sub-sequence
	 * @param numAdj the number of adjacent digits
	 * @return a new sub-sequence
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public char[] getSubSeq(int startIndex, int numAdj) throws ArrayIndexOutOfBoundsException {
		int endIndex = startIndex+numAdj;
		char[] subSeq = new char[0];
		if(endIndex > this.seq.length()-1) {
			throw new ArrayIndexOutOfBoundsException(endIndex);
		}
		else {
			String subString = this.seq.substring(startIndex, startIndex+numAdj);
			subSeq = subString.toCharArray();
			return subSeq;
		}
	}
	
	/**
	 * Returns the product of a numerical sub-sequence array.
	 * @param subSeq the sub-sequence to be operated upon
	 * @return the product of the sub-sequence array
	 * @throws NumberFormatException if the instance member {@code seq} contains
	 * non-integer values
	 */
	public BigInteger getSubSeqProduct(char[] subSeq) throws NumberFormatException {
		BigInteger product = new BigInteger("1");
		for(int i = 0; i < subSeq.length; i++) {
			char val = subSeq[i];
			BigInteger num = parseBigInt(val);
			product = product.multiply(num); 
		}
		return product;
	}
	
	/**
	 * Parses and returns an integer character as a {@code BigInteger} object.
	 * @param val the integer character to be parsed
	 * @return the integer character as a {@code BigInteger} object
	 * @throws NumberFormatException if the instance member {@code seq} contains
	 * non-integer values
	 */
	public BigInteger parseBigInt(char val) throws NumberFormatException {
		String strVal = String.valueOf(val);
		return new BigInteger(strVal);
	}
	
	/**
	 * Sets the sequence instance member {@code seq}.
	 * @param seq the sequence to be set
	 * @throws IllegalArgumentException if {@code seq}  contains non-integer characters 
	 */
	public void setSeq(String seq) throws IllegalArgumentException{
		if(isValidIntSeq(seq)) {
			this.seq = seq;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * the instance member {@code seq}.
	 * @return the value of the sequence 
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 *  Iterates over the sequence to determine if it contains non-integer characters.
	 * @param seq the sequence the be verified 
	 * @return {@code true} if there are no non-integer values, otherwise {@code false}
	 */
	public boolean isValidIntSeq(String seq) {
		if(seq.length() > 0) {
			for(int i = 0; i < seq.length(); i++) {
				char element = seq.charAt(i);
				try {
					Integer.parseInt(String.valueOf(element));
				}
				catch (NumberFormatException e){
					return false;
				}
			}
		}
		else {
			return false;
		}
		return true;
	}
	
}
