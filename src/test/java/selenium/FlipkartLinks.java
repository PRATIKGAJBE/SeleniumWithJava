package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlipkartLinks {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.manage().window().setSize(new Dimension(1000,600));
		
		driver.get("https://www.flipkart.com");
		
		Thread.sleep(5000);
		
		driver.findElement(By.partialLinkText("Create an account")).sendKeys(Keys.ESCAPE);
		//driver.findElement(By.tagName("button")).click();
		
		WebElement ul = driver.findElement(By.className("_114Zhd"));
		
		WebElement firstlist = driver.findElement(By.tagName("li"));
		
		System.out.println(firstlist.getText());
		
		firstlist.click();
		
		ul = driver.findElement(By.className("_114Zhd"));
		
		WebElement electronicslist = driver.findElement(By.tagName("li"));
		
		List<WebElement> links = electronicslist.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
	}

}
