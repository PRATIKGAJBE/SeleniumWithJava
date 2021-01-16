package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CSSSelectorsExample extends BaseSelenium {

	public static void main(String[] args) {
		new BaseSelenium();
		
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("selenium");
		
		WebDriverWait mywait = new WebDriverWait(driver, 5);
		mywait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));	
		
		driver.findElement(By.cssSelector("input[value^='Google']")).click();
		driver.findElement(By.cssSelector("a.q.qs")).click();
		//driver.findElement(By.cssSelector("input.RNmpXc")).click();
		
		
	}

}
