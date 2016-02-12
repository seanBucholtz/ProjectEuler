package eulerTest;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;
import euler.*;

public class LargestProductInASequenceTest {
	
	LargestProductInASequence LPS;
	String series;

	@Before
	public void setUp() throws Exception {
		this.series = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		this.LPS = new LargestProductInASequence();
	}

	@Test(expected=NumberFormatException.class)
	public void test_parseBigInt_Fail() throws Exception {
		LPS.parseBigInt('A');
	}
	
	@Test
	public void test_parseBigInt_Pass() throws Exception {
		BigInteger expected = new BigInteger("1");
		assertEquals(expected, LPS.parseBigInt('1'));
	}
	
	@Test(expected=NumberFormatException.class)
	public void test_getSubSeqProduct_Fail() {
		String subStr = "1A3";
		char[] subStrArr = subStr.toCharArray();
		LPS.getSubSeqProduct(subStrArr);
	}
	
	@Test
	public void test_getSubSeqProduct_Pass() throws Exception {
		String subStr = "123";
		char[] subStrArr = subStr.toCharArray();
		BigInteger expected = new BigInteger("6");
		assertEquals(expected, LPS.getSubSeqProduct(subStrArr));
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void test_getSubSeq_Fail() throws Exception {
		LPS.setSeq(this.series);
		LPS.getSubSeq(999, 13);
	}
	
	@Test
	public void test_getSubSeq_Pass() throws Exception {
		char[] expected = new char[] {'7','3','1','6'};
		LPS.setSeq(this.series);
		assertArrayEquals(expected, LPS.getSubSeq(0, 4));
	}
	
//	@Test(expected=NumberFormatException.class)
//	public void test_largestAdjacentProduct_Fail() throws Exception {
//		LPS.setSeq("731671A65313306249192251196744B657474235534919493496C83520312774506326");
//		LPS.largestAdjacentProduct(4);
//	}
	
	@Test
	public void test_largestAdjacentProduct_Pass() throws Exception {
		LPS.setSeq(this.series);
		int adjNumCount = 13;
		String expected = "23514624000";
		assertEquals(expected, LPS.largestAdjacentProduct(adjNumCount));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_setSeq_Fail_nonInt() throws Exception {
		LPS.setSeq("731671A65313306249192251196744B657474235534919493496C83520312774506326");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_setSeq_Fail_empty() throws Exception {
		LPS.setSeq("");
	}
	
	@Test
	public void test_setSeq_Pass() throws Exception {
		LPS.setSeq(this.series);
		assertNotNull(LPS.getSeq());
	}

}
