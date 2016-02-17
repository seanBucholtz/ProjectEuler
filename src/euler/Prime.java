/**
 * 
 */
package euler;

import java.lang.Integer;
import java.lang.NumberFormatException;;

/**
 * @author seanbucholtz
 *
 */

public class Prime {
	
	/**
	 * Method returns an integer array of all the
	 * prime numbers up to and included a defined ceiling.
	 * @param ceiling the max prime value in the array
	 * @return an integer array filled with prime numbers
	 */
	public static int[] getPrimeNumbers(int ceiling) {
		String primes = "";
		for(int i = 1; (2*i-1) <= ceiling; i++) {
			int num;
			if(i > 1) {
				num = (2*i)-1;
			} 
			else {
				num = 2;
			}
			
			if(isPrime(num)) {
				if(primes.length() > 0) {
					primes += (","+num);
				}
				else {
					primes += String.valueOf(num);
				}
			}
		}
		
		int[] primesArr = toIntArray(primes);
		return primesArr;
	}
	
	/**
	 * Verifies the primality of the given integer value.
	 * @param num the integer value to be verified
	 * @return true if integer is prime, and false otherwise
	 */
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns an integer array of the prime factors of a given 
	 * composite integer.
	 * @param num the composite integer
	 * @return the integer array of prime factors
	 */
	public static int[] getPrimeFactors(int num) {
		int[] primes = getPrimeNumbers(num);
		return primeFactor(num, primes, 0, "");
	}
	
	/**
	 * Recursive helper method for deducing the prime factors of an 
	 * composite integer.
	 * @param composite the composite number
	 * @param factorArr the array of prime numbers less than the composite
	 * @param index the index of the prime number
	 * @param factors the string list of factors found
	 * @return an integer array of the prime factors 
	 */
	private static int[] primeFactor(int composite, int[] factorArr, int index, String factors) {
		if(composite == 1 || index == factorArr.length) {
			return toIntArray(factors);
		}
		else {
			int primeNum = factorArr[index];
			int num = composite;
			while(num % primeNum == 0) {
				num /= primeNum;
				factors += String.valueOf(primeNum)+",";
			}
			return primeFactor(num, factorArr, index+1, factors);
		}
	}
	
	/**
	 * Converts a string array of integer values into an integer array.
	 * @param ints the string of ints
	 * @return the array of ints
	 * @throws NumberFormatException if character in array is not an integer
	 */
	private static int[] toIntArray(String ints) throws NumberFormatException{
		String[] intsStrArr = ints.split(",");
		int[] intsArr = new int[intsStrArr.length];
		for(int i = 0; i < intsStrArr.length; i++) {
			String intsStr = intsStrArr[i];
			int prime = Integer.parseInt(intsStr);
			intsArr[i] = prime;
		}
		return intsArr;
	}
	
	/**
	 * Prints the list of prime numbers to the console.
	 * @param primes the integer list of primes to be displayed
	 * @throws NumberFormatException if character in array is not an integer
	 */
	public static void printPrimes(int[] primes) throws NumberFormatException{
		System.out.print("[");
		for(int i = 0; i < primes.length; i++) {
			String prime = String.valueOf(primes[i]);
			if(i < primes.length-1) {
				System.out.print(prime+", ");
			}
			else {
				System.out.print(prime+"]\n");
			}
		}
	}
	
}
