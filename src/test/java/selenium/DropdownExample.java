package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().setSize(new Dimension(600,600));
		
		driver.get("http://book.theautomatedtester.co.uk/");
		
		driver.findElement(By.linkText("Chapter1")).click();
		
		WebElement radiobutton = driver.findElement(By.id("radiobutton"));

		System.out.println(radiobutton.isSelected());
		if(!radiobutton.isSelected()) {
			radiobutton.click();
		}
		
		Select dropdown = new Select(driver.findElement(By.id("selecttype")));
		
		List<WebElement> selectedoptions = dropdown.getAllSelectedOptions();
		for (WebElement webElement : selectedoptions) {
			System.out.println(webElement.getText());
		}
		
		dropdown.selectByVisibleText("Selenium RC");
		
		dropdown.selectByIndex(3);
		
		if(!driver.findElement(By.name("selected(1234)")).isSelected()) {
			driver.findElement(By.name("selected(1234)")).click();
		}
		
	}

}
