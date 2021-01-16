package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinksExample {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
			
		driver = new FirefoxDriver();
		
		driver.manage().window().setSize(new Dimension(600,600));
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.linkText("Advertising")).click();
		verifyTitle("Google Ads");
		//driver.navigate().back();
		
		driver.findElement(By.linkText("Business")).click();
		verifyTitle("Business Management Software");
		
		driver.findElement(By.linkText("About")).click();
		verifyTitle("About");
		
		driver.findElement(By.linkText("How Search works")).click();
		verifyTitle("Discover");
		//driver.navigate().back();
		
		driver.findElement(By.linkText("Privacy")).click();
		verifyTitle("Privacy");
		//driver.navigate().back();
		
		driver.findElement(By.linkText("Terms")).click();
		verifyTitle("Terms");
		//driver.navigate().back();
		
		driver.findElement(By.linkText("Settings")).click();
		
		WebElement e = driver.findElement(By.linkText("Search settings"));
		
		if(e.isDisplayed()) {
			System.out.println("Settings Test Passed");
		} else {
			System.out.println("Settings Test Failed");
		}
		
		//verifyTitle("Business Management Software");
		//driver.navigate().back();
		
		driver.quit();
	}

	private static void verifyTitle(String string) throws InterruptedException {
		Thread.sleep(2000);
		if(driver.getTitle().contains(string)) {
			System.out.println(string+ " Passed");
		}
		else {
			System.out.println(string+ " Failed");
		}
		driver.navigate().back();
		if(driver.getTitle().contains("Business")) {
			driver.navigate().back();
		}
//		if(!driver.getTitle().equals("Google")) {
//			Thread.sleep(5000);
//		}
		
	}




}
