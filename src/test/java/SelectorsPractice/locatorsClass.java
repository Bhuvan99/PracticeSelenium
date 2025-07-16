package SelectorsPractice;

import java.io.File;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class locatorsClass {
	
	public static void main(String args[]) throws MalformedURLException {
		
		WebDriver driver = new ChromeDriver();
		URL url = new URL("https://testautomationpractice.blogspot.com/");
		driver.navigate().to(url);
		driver.manage().window().maximize();
		WebDriverWait myDriverWait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("Clark Kent");
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("clarkkent");
		driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys("+01-5678876");
		driver.findElement(By.xpath("//textarea[@id=\"textarea\"]")).sendKeys("No.10-Manhantan street, New York");
		driver.findElement(By.xpath("//input[@id=\"male\" and @name=\"gender\"]")).click();
		List<WebElement> daysCheckBox = driver.findElements(By.xpath("//input[@class=\"form-check-input\" and @type=\"checkbox\"]"));
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		for(WebElement checkBoxes:daysCheckBox) {
			checkBoxes.click();
		}
		
//		Selecting from drop boxes
		Select mySelect = new Select(driver.findElement(By.xpath("//select[@id=\"country\"]")));
		mySelect.selectByValue("uk");
		
//		Mouse Actions
		Actions actions = new Actions(driver);
		
		WebElement yellowColor = driver.findElement(By.xpath("//option[@value=\"yellow\"]"));
		actions.moveToElement(yellowColor).click().perform();
		
		actions.moveToElement(driver.findElement(By.xpath("//option[@value=\"lion\"]"))).click().perform();
		
		/*
		 * WebElement drag = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		 * WebElement drop = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		 * actions.dragAndDrop(drag, drop).perform();
		 */
		actions.dragAndDrop(driver.findElement(By.xpath("//div[@id=\"draggable\"]")), driver.findElement(By.xpath("//div[@id=\"droppable\"]"))).perform();
		
//		Static Web Table
		int rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		int columns = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th")).size();
		
//		Reading data from the Static Date Table
		for(int r = 2;r<=rows;r++) {
			for(int c = 1; c<=columns;c++) {
				String tableValue = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(tableValue+" ");
			}
			System.out.println();
		}
		
//		Getting the name of the windows popup
		WebElement popUpWindow = driver.findElement(By.xpath("//button[@id=\"PopUp\"]"));
		actions.doubleClick(popUpWindow).click().perform();
		
		String mainWindow = driver.getWindowHandle();
		Set<String> popUpWindowsId = driver.getWindowHandles();
		List<String> popUpWindowsList = new ArrayList<String>(popUpWindowsId);
		
		for(String popWin:popUpWindowsList) {
			System.out.println(popWin);
			System.out.println(driver.switchTo().window(popWin).getTitle());
		}
		
		driver.switchTo().window(mainWindow);
		
//		Date pickers
//		Getting and formatting the dates
//		Target or Required Date as today
		String reqDate = "21-Jun-2025";
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate localDate = LocalDate.parse(reqDate,dateFormat);
		int targetDate = localDate.getDayOfMonth();
		int targetMonth = localDate.getMonthValue();
		int targetYear = localDate.getYear();
		
//		Clicking the Field of Calendars.
		
		driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();
		
		
//		Displaying the Date from Calendars
		
		while(true) {
			String displayedCalendar = driver.findElement(By.xpath("//div[@class=\"ui-datepicker-title\"]")).getText();
			DateTimeFormatter displayFormet = DateTimeFormatter.ofPattern("MM-yyyy");
			LocalDate displayDate = LocalDate.parse("01 "+displayedCalendar,DateTimeFormatter.ofPattern("dd MMMM yyyy"));
			
			int displayedMonth = displayDate.getMonthValue();
	        int displayedYear = displayDate.getYear();
	        
	        
	        if(displayedYear<targetYear || targetYear==displayedYear && displayedMonth<targetMonth) {
	        	driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();
	        }
	        else if(displayedYear > targetYear || targetYear == displayedYear && displayedMonth > targetMonth) {
	            driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click(); // Prev button
	        } else {
	            break;
	        }

		}
		
//		Comparing and validating the dates
		List<WebElement> dates = driver.findElements(By.xpath(" //td[@data-handler=\"selectDay\"]//a"));
		for(WebElement date:dates) {
			if(date.getText().equals(String.valueOf(targetDate))) {
				date.click();
				break;
			}
		}
		
//		Another date selection;
		driver.findElement(By.xpath("//input[@name=\"SelectedDate\"]")).click();
	
		Select dateSelect = new Select(driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]")));
		dateSelect.selectByValue("6");
		
		Select yearSelect = new Select(driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]")));
		yearSelect.selectByValue("2025");
		
		String targetDate1 = "21";
		List<WebElement> dates1 = driver.findElements(By.xpath("//td[@data-handler=\"selectDay\"]//a"));
		for(WebElement date1:dates1) {
			if(date1.getText().equals(String.valueOf(targetDate1))) {
				date1.click();
				break;
			}
		}
		
		
		List<WebElement> errorLinks = driver.findElements(By.xpath("//div[@id=\"broken-links\"]//a[@class=\"link\"]"));
//		List<WebElement> errorLinks = new ArrayList<WebElement>(errorLinksLocators);
		int brkLinks=0;
		for(WebElement errLinks:errorLinks) {
			String getErrorLinks = errLinks.getAttribute("href");
			try {
			HttpURLConnection linkUrl = (HttpURLConnection) new URL(getErrorLinks).openConnection();
			linkUrl.connect();
			if(linkUrl.getResponseCode()>=400) {
				System.out.println("Broken Link");
				brkLinks++;
			}
			else {
				System.out.println("No Broken Link");
			}
		
			
		}catch(Exception e)	{}
			
		}
		System.out.println("No. of Broken links provided: "+brkLinks);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+"\\ScreenShots\\fullPage.png");
		sourceFile.renameTo(targetFile);
		
		
		
		driver.quit();
	}
}