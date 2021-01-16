package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class JSPromptExample extends BaseSelenium {

	public static void main(String[] args) throws InterruptedException {
		new BaseSelenium("firefox","https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
	
		//driver.switchTo().frame("iframeResult");
		driver.switchTo().frame(0);
		driver.findElement(By.tagName("button")).click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Ameya");
		
		alert.accept();
		
		System.out.println(driver.findElement(By.id("demo")).getText());
		
	}

}
