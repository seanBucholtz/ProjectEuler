/**
 * 
 */
package eulerTest;

import static org.junit.Assert.*;
import euler.Prime;
import org.junit.Before;
import org.junit.Test;

/**
 * @author seanbucholtz
 *
 */
public class PrimeTest {
	
	private int[] primesUnderThousand;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.primesUnderThousand = new int[] 
				{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 
				41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 
				89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 
				139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 
				193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 
				251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 
				311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 
				373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 
				433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 
				491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 
				569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 
				619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 
				683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 
				757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 
				827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 
				887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 
				971, 977, 983, 991, 997};
	}

	@Test
	public void test_isPrime_Fail() throws Exception {
		int num = 25;
		assertFalse(Prime.isPrime(num));
	}
	
	@Test
	public void test_isPrime_Pass() throws Exception {
		int num = 29;
		assertTrue(Prime.isPrime(num));
	}
	
	@Test
	public void test_getPrimeNumbers_Pass_Under20() throws Exception {
		int[] primes = new int[] {2,3,5,7,11,13,17,19};
		int ceiling = 20;
		assertArrayEquals(primes, Prime.getPrimeNumbers(ceiling));
	}
	
	@Test
	public void test_getPrimeNumbers_Pass_Under1000() throws Exception {
		int ceiling = 1000;
		assertArrayEquals(this.primesUnderThousand, Prime.getPrimeNumbers(ceiling));
	}
	
//	@Test
//	public void test_primeFactor_Pass() throws Exception {
//		int composite = 90;
//		int[] primeFactors = new int[]{2,3,5,7,11,13,17,19};
//		int[] expectedPrimeFactors = new int[] {2,3,3,5};
//		assertArrayEquals(expectedPrimeFactors, Prime.primeFactor(composite,primeFactors, 0, ""));
//	}
	
	@Test
	public void test_getPrimeFactors_Pass() throws Exception {
		int composite = 6;
		int[] expectedPrimeFactors = new int[] {2,3};
		assertArrayEquals(expectedPrimeFactors, Prime.getPrimeFactors(composite));
	}
	
//	@Test(expected=NumberFormatException.class)
//	public void test_toIntArray_Fail_AlphaElem() throws Exception {
//		String strArr = "1,2,3,A,4";
//		Prime.toIntArray(strArr);
//	}
//	
//	@Test(expected=NumberFormatException.class)
//	public void test_toIntArray_Fail_AlphaNum() throws Exception {
//		String strArr = "1,2,3,A4,5";
//		Prime.toIntArray(strArr);
//	}
	
//	public void test_toIntArray_Pass() throws Exception {
//		String strArr = "1,2,3,4,5";
//		int[] expected = new int[]{1,2,3,4,5};
//		assertArrayEquals(expected, Prime.toIntArray(strArr));
//	}


}
