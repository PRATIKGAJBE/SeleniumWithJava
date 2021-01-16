package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class JavaScriptAlertExample extends BaseSelenium {

	public static void main(String[] args) throws InterruptedException {

		new BaseSelenium("firefox", "https://mail.rediff.com/cgi-bin/login.cgi");
		
		
		  driver.findElement(By.tagName("form")).submit();
		  
		  Alert javascriptalert = driver.switchTo().alert();
		  
		  System.out.println(javascriptalert.getText());
		  
		  javascriptalert.accept();
		  
		  driver.findElement(By.id("login1")).sendKeys("user");
		  
		  driver.findElement(By.tagName("form")).submit();
		  
		  javascriptalert = driver.switchTo().alert();
		  
		  System.out.println(javascriptalert.getText());
		  
		  javascriptalert.accept();
		  //javascriptalert.
		  
		 // Thread.sleep(2000);
		 
		
		//driver.findElement(By.id("login1")).sendKeys("user");
		driver.findElement(By.name("passwd")).sendKeys("pass");
		
		driver.findElement(By.tagName("form")).submit();
		
		String invalidtext = driver.findElement(By.xpath("//div[contains(text(),'Wrong')]")).getText();
		
		System.out.println(invalidtext);
	}

}
