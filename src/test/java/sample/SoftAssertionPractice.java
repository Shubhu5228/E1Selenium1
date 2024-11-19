package sample;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionPractice {
	@Test
	public void StrictComparisonSoftAssert() {
		String expectedvalue="rara";
		String actualvalue="Raja";
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualvalue,expectedvalue);
		System.out.println("Strict comparison soft Assertion completed");
		s.assertAll();
	}
	@Test
	public void containsComparisonSoftAssert() {
		String expectedvalue="corn";
		String actualvalue="babycorn";
		SoftAssert s=new SoftAssert();
		s.assertFalse(actualvalue.contains(expectedvalue));
		System.out.println("contains comparison Soft Assertion completed");
		s.assertAll();
	}

}
