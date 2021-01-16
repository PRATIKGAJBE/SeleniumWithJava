package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSuggestions extends BaseSelenium {

	public static void main(String[] args) throws InterruptedException {
		new BaseSelenium();
		
		driver.findElement(By.name("q")).sendKeys("testng");
		//Thread.sleep(200);
		
		System.out.println(driver.findElements(By.xpath("//div[@class='sbl1' or @class='sbl1 sbl1p']/span")).size());
//		WebDriverWait mywait = new WebDriverWait(driver, 5);
//		mywait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='sbl1' or @class='sbl1 sbl1p']/span"), "testng"));
		
		WebDriverWait mywait = new WebDriverWait(driver, 20);
		mywait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='sbl1' or @class='sbl1 sbl1p']/span"), 10));
		System.out.println(driver.findElements(By.xpath("//div[@class='sbl1' or @class='sbl1 sbl1p']/span")).size());
		
		
		//List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='sbl1' or @class='sbl1 sbl1p']/span"));
		List<WebElement> suggestions = driver.findElements(By.className("sbl1"));
		
		
		System.out.println("Size of suggestions is: "+suggestions.size());
		for (WebElement suggestion : suggestions) {
			System.out.println(suggestion.getText());
		}
	
		System.out.println("Script Finished");
		
		driver.quit();
	}

}
