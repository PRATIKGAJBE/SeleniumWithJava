package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClassNameLocatorExample {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().setSize(new Dimension(600,600));
		
		driver.get("https://www.google.com");
		
		WebElement e;
		
		e = driver.findElement(By.className("gLFyf gsfi"));
		
		e.sendKeys("selenium");
		
		driver.quit();
	}

}
