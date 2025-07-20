package Listeners;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener{
		
	 public void onTestStart(ITestResult result) {
		 System.out.println("Test Started....!!");
	 }
	 
	 public void onTestSuccess(ITestResult result) {
		 System.out.println("Test Success....!!");
		
	 }
	 
	 public void onTestFailure(ITestResult result) {
		 System.out.println("Test Failed....!!");
	 }
	 
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("Test Skipped....!!");
	 }

}