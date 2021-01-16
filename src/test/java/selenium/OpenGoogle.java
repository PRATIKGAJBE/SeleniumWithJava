package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenGoogle {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SOFT DOWNLOAD\\Selenium Workshop\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "D:\\SOFT DOWNLOAD\\Selenium Workshop\\msedgedriver.exe");
		System.setProperty("webdriver.ie.driver", "D:\\SOFT DOWNLOAD\\Selenium Workshop\\IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
		
		
		WebDriver driver;
		//driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new InternetExplorerDriver();
		driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		TakesScreenshot scr = (TakesScreenshot)driver;
		File f = scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("c:\\Temp\\scr.jpg"));
		
		
//		if(driver.getTitle().equals("Google")) {
//			System.out.println("Test Passed");
//		} else {
//			System.out.println("Test Failed");
//		}
//		
//		if(driver.getCurrentUrl().contains("https")) {
//			System.out.println(driver.getCurrentUrl());
//			System.out.println("Security Test Passed");
//		} else {
//			System.out.println("Security Test Failed");
//		}
//		
//		System.out.println(driver.getPageSource());
		
	}
}
