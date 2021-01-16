package selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartMenuMouseHover extends BaseSelenium {

	public static void main(String[] args) throws IOException, InterruptedException {
		BaseSelenium base = new BaseSelenium("firefox","https://www.flipkart.com");
		driver.manage().window().fullscreen();
		
		driver.findElement(By.cssSelector("._2AkmmA._29YdH8")).click();
		
		Actions builder = new Actions(driver);
		//only 1 action
		builder.moveToElement(driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8'][text()='Electronics']")));
		builder.contextClick();
		Action build = builder.build();
		build.perform();
		
		WebDriverWait mywait = new WebDriverWait(driver, 5);
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[title='Mobiles']"))));
		
		base.takeScreenShot("c:\\Temp\\Electronics.jpg");
		
		builder.moveToElement(driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8'][text()='TVs & Appliances']")));
		builder.contextClick();
		builder.click();
		build = builder.build();
		build.perform();
		
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[title='Television']"))));
		base.takeScreenShot("c:\\Temp\\TVs & Appliances.jpg");
		
		
		builder.moveToElement(driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8'][text()='Men']")));
		builder.contextClick();
		build = builder.build();
		build.perform();
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[title='Footwear']"))));
		base.takeScreenShot("c:\\Temp\\Men.jpg");
		
		
		
	}

}
