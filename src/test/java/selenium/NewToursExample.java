package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewToursExample {
	
	public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
			
			WebDriver driver = new FirefoxDriver();
			
			driver.manage().window().setSize(new Dimension(1000,600));
			
			driver.get("http://newtours.demoaut.com");
			
			driver.findElement(By.name("userName")).sendKeys("demo");
			driver.findElement(By.name("password")).sendKeys("demo");
			driver.findElement(By.name("login")).click();
			
			//click on radio button
			List<WebElement> radiobuttons = driver.findElements(By.name("tripType"));
			
			for (WebElement button : radiobuttons) {
				if(button.getAttribute("value").equals("oneway")) {
					button.click();
				}
			}
			
			//select arrival airport
			Select arrivingdropdown = new Select(driver.findElement(By.name("toPort")));
			arrivingdropdown.selectByVisibleText("Frankfurt");
			
		
			//select unified as preferred airline
			Select preferredairline = new Select(driver.findElement(By.name("airline")));
			preferredairline.selectByVisibleText("Unified Airlines");
			
			
			//continue
			driver.findElement(By.name("findFlights")).click();
	}

}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
