package ParallelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class testMethods {

	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setUp(String br) {
		
		switch(br.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver();break;
		case "firefox": driver = new FirefoxDriver();break;
		default: System.out.println(); return;
		}
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	
	@Test
	void login() {
		boolean status = driver.findElement(By.xpath("//a[normalize-space()=\"Register\"]")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	@Test
	void execution() {
		
		boolean display = driver.findElement(By.xpath("//div[@id=\"headerPanel\"]")).isDisplayed();
		Assert.assertEquals(display, true);
	}
	
	
	@AfterClass
	void completeSetUp() {
		driver.close();
	}
}
