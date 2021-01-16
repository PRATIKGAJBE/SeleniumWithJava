package selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserNavigation {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\SOFT DOWNLOAD\\Selenium Workshop\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().setSize(new Dimension(600,600));
		
		driver.get("https://www.flipkart.com");
			
	    System.out.println(driver.getTitle());
	  
	    driver.navigate().to("https://www.bbc.com");
	  
	    System.out.println(driver.getTitle());
	  
	    driver.navigate().back();
	  
	    System.out.println(driver.getTitle());
	  
	    driver.navigate().forward();
	  
	    System.out.println(driver.getTitle());
	  
	    driver.navigate().refresh();
	 		
	    System.out.println(driver.getTitle());
		
		Dimension d = driver.manage().window().getSize();
		
		System.out.println("Width: "+d.getWidth()+" and Height: "+d.getHeight());
		
		Point p = driver.manage().window().getPosition();
		
		System.out.println("x: "+p.getX()+" & y: "+p.getY());
		
		driver.manage().window().setPosition(new Point(400,10));
		
		p = driver.manage().window().getPosition();
		
		System.out.println("x: "+p.getX()+" & y: "+p.getY());
		
		//driver.manage().window().maximize();
		
		d = driver.manage().window().getSize();
		
		System.out.println("Width: "+d.getWidth()+" and Height: "+d.getHeight());
		
		driver.manage().window().setSize(new Dimension(600,600));
		
		d = driver.manage().window().getSize();
		
		System.out.println("Width: "+d.getWidth()+" and Height: "+d.getHeight());
		
		driver.manage().window().fullscreen();
		
	}

}
