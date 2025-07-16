package priorityAnnotations;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class annotationsDemo {

	@BeforeMethod
	void login() {
		System.out.println("Logging in Method Called......!!");
	}
	
	@AfterMethod
	void logout() {
		System.out.println("Logging out Method Called.....!!");
		System.out.println();
	}
	
	@Test
	void search() {
		System.out.println("Searching method is called.....!!");
	}
	
	@Test
	void advSearch() {
		System.out.println("Advance Searching method is called.....!!");
	}
}
