package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testMethods2 {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"url"})
	void login(String testUrl){
		driver=new ChromeDriver();
		driver.get(testUrl);
		driver.manage().window().maximize();
	}
	
	@Test
	void anotherTest() {
		boolean elementStatusOne = driver.findElement(By.xpath("//a[normalize-space()='home']")).isDisplayed();
		Assert.assertEquals(elementStatusOne, true);
	}
	@Test(dependsOnMethods= {"anotherTest"})
	void anotherTest2() {
		boolean elementStatusTwo = driver.findElement(By.xpath("//a[normalize-space()='about']")).isDisplayed();
		Assert.assertEquals(elementStatusTwo, true);
	}
	
	@AfterClass	
	void driverClose() {
		driver.quit();
	}
	
}
