package Listeners;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class testMethods {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"url"})
	void login(String testUrl){
		driver=new ChromeDriver();
		driver.get(testUrl);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	void test() {
		boolean elementStatus = driver.findElement(By.xpath("//div[@id=\"headerPanel\"]")).isDisplayed();
		Assert.assertEquals(elementStatus,true);
	}
	
	@Test(dependsOnMethods= {"test"})
	void test2() {
		boolean elementStatus2 = driver.findElement(By.xpath("//a[normalize-space()=\"Register\"]")).isDisplayed();
		Assert.assertEquals(elementStatus2, true);
	}
	
	
	@AfterClass
	void driverClose() {
		driver.quit();
	}
}
