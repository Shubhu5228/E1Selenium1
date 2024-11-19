package sample;

import org.testng.Assert;
import org.testng.annotations.Test;


public class HardAssertionPractice {
	@Test
	public void StrictComparisonHardAssert() {
		String expectedvalue="robin";
		String actualvalue="robin";
		Assert.assertEquals(actualvalue,expectedvalue);
		System.out.println("Assertion completed");
	}
	@Test
	public void containsComparisonHardAssert() {
		String expectedvalue="Don";
		String actualvalue="london";
		Assert.assertTrue(actualvalue.contains(expectedvalue));
		System.out.println("contains comparison completed");
	}

}
