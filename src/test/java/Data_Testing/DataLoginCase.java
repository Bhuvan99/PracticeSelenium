package Data_Testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataLoginCase {

	public static void main(String[] args) throws IOException {		
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\SeleniumData.xlsx");
		
		
		XSSFWorkbook workBook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet1 = workBook.getSheet("Sheet1");
		
		int totalRows = sheet1.getLastRowNum();
		int totalCols = sheet1.getRow(1).getLastCellNum();
		
		for(int r=1; r <= sheet1.getLastRowNum(); r++) {
			Row row = sheet1.getRow(r);
			driver.findElement(By.xpath("//a[normalize-space()=\"Register\"]")).click();
			
			String firstName = row.getCell(0).getStringCellValue();
			String lastName = row.getCell(1).getStringCellValue();
			String address = row.getCell(2).getStringCellValue();
			String city = row.getCell(3).getStringCellValue();
			String state = row.getCell(4).getStringCellValue();
			String zipCode = row.getCell(5).getStringCellValue();
			String phoneNumber = row.getCell(6).getStringCellValue();
			String ssn = row.getCell(7).getStringCellValue();
			String userName = row.getCell(8).getStringCellValue();
			String password = row.getCell(9).getStringCellValue();
			
			
			driver.findElement(By.xpath("//input[@id=\"customer.firstName\"]")).sendKeys(firstName);
			driver.findElement(By.xpath("//input[@id=\"customer.lastName\"]")).sendKeys(lastName);
			driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(address);
			driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(city);
			driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(state);
			driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(zipCode);
			driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys(phoneNumber);
			driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys(ssn);
			driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys(userName);
			driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys(password);

			driver.findElement(By.xpath("//input[@value='Register']")).click();
			
			String output = driver.findElement(By.xpath("//p[normalize-space()=\"Your account was created successfully. You are now logged in.\"]")).getText();
			if(output.equalsIgnoreCase("Your account was created successfully. You are now logged in.")) {
				System.out.println("Account Registered");
			}
			
			driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
		}
		
		driver.quit();
		workBook.close();
		fileInput.close();
		
	}

}
