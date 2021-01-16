package selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch extends BaseSelenium {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		new BaseSelenium();
		
		WebElement e;
		
		e = driver.findElement(By.name("q"));
		
		e.sendKeys("selenium");
		
		Thread.sleep(500);
		
		//e.submit();
		
		//e.sendKeys(Keys.ENTER);
		
		e = driver.findElement(By.className("gNO89b"));
		e.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e2) {
			System.out.println("Exception caught while waiting for page to load");
		}
		
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("selenium - Google Search")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		
		BaseSelenium.takeScreenShot("c:\\Temp\\GoogleSearch.jpg");
		
		driver.quit();
	}

}
