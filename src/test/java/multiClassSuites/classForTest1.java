package multiClassSuites;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class classForTest1 {
	
	@Test
	void testMethod1() {
		System.out.println("Method 1 from Test Class 1");
	}
	
	@Test
	void testMehod2() {
		System.out.println("Method 2 from Test Class 2");
	}
	
	@BeforeTest
	void beforeTestMethod() {
		System.out.println("Before Test Method");
	}

}
