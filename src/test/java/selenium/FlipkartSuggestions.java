package selenium;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartSuggestions extends BaseSelenium {
	static int counter = 0;
	public static void main(String[] args) {
		
		final String inputstring = "samsung";

		new BaseSelenium("firefox", "https://www.flipkart.com");
		driver.findElement(By.partialLinkText("Create an account")).sendKeys(Keys.ESCAPE);
		
		driver.findElement(By.name("q")).sendKeys(inputstring);
		
		WebDriverWait mywait = new WebDriverWait(driver, 5);
		mywait.until(ExpectedConditions.attributeToBe(driver.findElement(By.name("q")), "value", inputstring));
		//mywait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//span[@class='_3Wn9Gb']/.."), 8));
		mywait.until(new Function<WebDriver, String>() {
			public String apply(WebDriver d) {
				System.out.println(++counter);
				//String text = d.findElement(By.xpath("//span[@class='_3Wn9Gb']/..")).getText();
				String text = d.findElement(By.name("q")).getAttribute("value");
				if(text.equals(inputstring)) {
					return inputstring;
				} else {
					return null;
				}
			}}
			);
		
		List<WebElement> suggestions = driver.findElements(By.xpath("//span[@class='_3Wn9Gb']/.."));
		System.out.println(suggestions.size());
		
		for (WebElement webElement : suggestions) {
			String expected = inputstring;
			String actual = webElement.getText().replace("\n", " ");
			System.out.print(actual);
			if(actual.contains(expected)) {
				System.out.println(" : Passed");
			} else {
				System.out.println(" : Failed");
			}
		}
	
	}

}
