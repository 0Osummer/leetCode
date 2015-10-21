package easy;


import org.junit.Assert;
import org.junit.Test;

public class DigitTest {

	@Test
	public void hammingWeightTest() {
		long i = 2147483648L;
		Digit digit = new Digit();
		Assert.assertEquals(1, digit.hammingWeight((int) i));
	}
	
	@Test
	public void hammingWeightTest1() {
		long i =  4294967295L;
		Digit digit = new Digit();
		Assert.assertEquals(32, digit.hammingWeight((int) i));
	}

	@Test 
	public void titleToNumberTest(){
		String x = "AB";
		Digit digit = new Digit();
		Assert.assertEquals(28, digit.titleToNumber(x));

	}
	
	@Test
	public void majorityElementTest(){
		int[] a = {3,2,3};
		Digit digit = new Digit();
		Assert.assertEquals(3, digit.majorityElement(a));
	}
	
	@Test
	public void climbStairsTest(){
		Digit digit = new Digit();
		Assert.assertEquals(2, digit.climbStairs(2));
		Assert.assertEquals(3, digit.climbStairs(3));
	}
	
	@Test
	public void isHappyTest(){
		Digit digit = new Digit();
		Assert.assertEquals(false, digit.isHappy(2));
	}
}
