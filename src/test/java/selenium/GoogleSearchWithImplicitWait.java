package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchWithImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().fullscreen();
		
		driver.get("https://www.google.com");
		
		WebElement e;
		
		e = driver.findElement(By.name("q"));
		
		e.sendKeys("selenium");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Thread.sleep(500);
		
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
		
		driver.quit();
	}

}
