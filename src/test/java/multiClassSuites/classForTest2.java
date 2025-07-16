package multiClassSuites;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class classForTest2 {
	
	@Test
	void testMethod1() {
		System.out.println("Method 1 from Test Class 2");
	}
	
	@Test
	void testMethod2() {
		System.out.println("Method 2 from Test Class 2");
	}
	
	@AfterTest
	void afterTestMethod() {
		System.out.println("After Test Method");
	}
	
}
