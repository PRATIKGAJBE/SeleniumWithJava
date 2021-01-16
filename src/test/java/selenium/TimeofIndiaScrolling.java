package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class TimeofIndiaScrolling extends BaseSelenium {

	public static void main(String[] args) {
		new BaseSelenium("firefox","https://timesofindia.indiatimes.com/");
		
		//driver.findElement(By.name("nlemail")).sendKeys("someemai@someemail.com");
		
		//driver.findElement(By.linkText("About us")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		System.out.println("Domain: " +js.executeScript("return document.domain;").toString());
		
	}

}
