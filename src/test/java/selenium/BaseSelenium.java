package selenium; 

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSelenium {
	public static WebDriver driver;
	
	public BaseSelenium() {
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		initialize();
	}

	public BaseSelenium(String browser) {
		
		switch (browser) {
		case "chrome": 
			System.setProperty("webdriver.chrome.driver", "D:\\SOFT DOWNLOAD\\Selenium Workshop\\chromedriver.exe");
			driver = new ChromeDriver();	
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		
		driver.get("https://www.google.com");
		initialize();
	}

	public BaseSelenium(String browser, String url) {
		
		switch (browser) {
		case "chrome": 
			System.setProperty("webdriver.chrome.driver", "D:\\SOFT DOWNLOAD\\Selenium Workshop\\chromedriver.exe");
			driver = new ChromeDriver();	
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		driver.get(url);
		initialize();
	}
	
	public static void initialize() {
		//driver.manage().window().setSize(new Dimension(900,600));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void takeScreenShot(String path) throws IOException {
		TakesScreenshot scr = (TakesScreenshot)driver;
		File f = scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(path));
		//driver.manage().window().setSize(new Dimension(900,600));
	}

}
