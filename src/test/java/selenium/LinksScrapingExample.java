package selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinksScrapingExample {

	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.manage().window().setSize(new Dimension(1000,600));
		
		driver.get("https://www.google.com");
		
		WebElement objectcontainingalllinks = driver.findElement(By.id("fbar"));
		
		List<WebElement> allelements = objectcontainingalllinks.findElements(By.tagName("a"));
		
		System.out.println(allelements.size());
		
		List<String> linkstoclick = new ArrayList<String>();
		
		for (WebElement webElement : allelements) {
			String linktext = webElement.getText();
			System.out.println(linktext);
			if(linktext.length()>0) {
				linkstoclick.add(linktext);
			}
		}
		
		System.out.println(linkstoclick.size());
		
		for (String string : linkstoclick) {
			driver.findElement(By.linkText(string)).click();
			String title = driver.getTitle();
			System.out.println(title);	
			driver.navigate().back();
			if(title.contains("Business")) {
				driver.navigate().back();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println(driver.findElement(By.id("fbar")).findElements(By.tagName("a")).size());
//		
//		List<WebElement> linkelements = driver.findElement(By.id("fbar")).findElements(By.tagName("a"));
//		
//		List<String> linkstoclick = new ArrayList<String>();
//		
//		for (WebElement webElement : linkelements) {
//			System.out.println(webElement.getText()+": length: "+webElement.getText().length());
//			if(webElement.getText().length()>0) linkstoclick.add(webElement.getText());
//		}
//		System.out.println("No. of links to click: "+linkstoclick.size());
//		for (String link : linkstoclick) {	
//				driver.findElement(By.linkText(link)).click();
//				String title = driver.getTitle();
//				System.out.println(title + " Passed");
//				driver.navigate().back();
//				if(title.contains("Business")) {
//					driver.navigate().back();
//				}	
//		}
	}

}
