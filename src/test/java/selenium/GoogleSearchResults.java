package selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchResults extends BaseSelenium {

	public static void main(String[] args) throws IOException {
		new BaseSelenium();
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		WebDriverWait mywait = new WebDriverWait(driver, 5);
		mywait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		
		driver.findElement(By.name("btnK")).click();
		
		List<WebElement> results = driver.findElements(By.xpath("//span[@class='S3Uucc']"));
		
		int count = 0;
		for (WebElement result : results) {
			if(!result.getText().isEmpty()) {
				if(result.getText().toLowerCase().contains("selenium")) {
					System.out.println(++count+" : " +result.getText() + " : Passed");
				} else {
					System.out.println(++count+" : " +result.getText() + " : Failed");
				}
			}
		}
		System.out.println("Number of Results on first page = "+count);
		
		int nooflinks=0;
		driver.findElements(By.xpath("//span[@class='csb ch']/..")).size();
		try {
			while(driver.findElement(By.xpath("//span[text()='Next']")) != null) {
				driver.findElement(By.xpath("(//span[@class='csb ch'])[last()-1]")).click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Reached the end");
			System.out.println("No. of Pages = "+driver.findElement(By.xpath("//span[@class='csb']/..")).getText());
		}
		

		//((TakesScreenshot)driver).getScreenshotAs(target)
	}
}
