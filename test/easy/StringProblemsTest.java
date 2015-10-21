package easy;


import org.junit.Assert;
import org.junit.Test;

public class StringProblemsTest {

	@Test
	public void test() {
		String a = "是我";
		String b = "我是";
		StringProblems sp = new StringProblems();
		Assert.assertEquals(true, sp.isAnagram(a, b));
	}

}
