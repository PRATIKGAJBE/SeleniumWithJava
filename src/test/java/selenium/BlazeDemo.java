package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().setSize(new Dimension(900,600));
		
		driver.get("http://blazedemo.com");
		
		Select departurecity = new Select(driver.findElement(By.name("fromPort")));
		System.out.println("Default departure: "+departurecity.getFirstSelectedOption().getText());
		
		Select destinationcity = new Select(driver.findElement(By.name("toPort")));
		System.out.println("Default destination: "+destinationcity.getFirstSelectedOption().getText());
		
		departurecity.selectByVisibleText("Boston");
		destinationcity.selectByVisibleText("London");
		
		//Click the Find Flights Button
//		WebElement container = driver.findElement(By.className("container"));
//		WebElement findflightsbutton = container.findElement(By.tagName("input"));
//		findflightsbutton.click();	
		driver.findElement(By.tagName("form")).submit();
		
		//Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		String flightnumberforlowestpricedflight = "default";
		String priceinstring = "default";
		double lowestprice = 0.0;
		
		WebElement table = driver.findElement(By.className("table"));
		
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		rows.remove(0);	
		System.out.println(rows.size());
		int rowcount = 0;
		
		for (WebElement row : rows) {
			System.out.println(++rowcount + ": " + row.getText());
			List<WebElement> columns = row.findElements(By.tagName("td"));
			priceinstring = columns.get(5).getText();
			System.out.print(priceinstring + "\n");
			priceinstring = priceinstring.substring(1);
			double price = Double.parseDouble(priceinstring);
			if(rowcount == 1) {
				lowestprice = price; 
				flightnumberforlowestpricedflight = columns.get(1).getText();
			}
			else if (price < lowestprice) {
				lowestprice = price;
				flightnumberforlowestpricedflight = columns.get(1).getText();
			}
		}
		
		System.out.println("Lowest Price is: "+lowestprice+" and Flight number is "+flightnumberforlowestpricedflight);
		driver.quit();
	}

}
