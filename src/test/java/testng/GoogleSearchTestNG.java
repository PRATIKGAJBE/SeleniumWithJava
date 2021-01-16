package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTestNG {
	static WebDriver driver;
	
	@BeforeClass
	public void setUpClass() {
		System.setProperty("webdriver.gecko.driver", "C:\\Robot\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void setUp() {
		driver.navigate().to("https://www.google.com");
	}
	
	@Test
	public void testGoogleSearch() {
		
		String searchstring = "selenium";
		
		driver.findElement(By.name("q")).sendKeys(searchstring+Keys.ENTER);
		
		String expected = "selenium - Google Search";
		String actual = driver.getTitle();
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(dataProvider = "getData")
	public void testGoogleSearchResults(String searchstring) {	
		//String searchstring = "selenium";
		
		driver.findElement(By.name("q"));
		driver.findElement(By.name("q")).sendKeys(searchstring+Keys.ENTER);
		
		String expected = searchstring.toLowerCase();
		String actual = driver.findElement(By.className("LC20lb")).getText();
		System.out.println(actual);
		Assert.assertTrue(actual.toLowerCase().contains(expected));
	}
	
	@Test(dataProvider = "getDataWithExpected")
	public void testGoogleSearchResultsWithExpected(String searchstring, String expected) {	
		//String searchstring = "selenium";
		
		driver.findElement(By.name("q"));
		driver.findElement(By.name("q")).sendKeys(searchstring+Keys.ENTER);
		
		//String expected = searchstring.toLowerCase();
		String actual = driver.findElement(By.className("LC20lb")).getText();
		System.out.println(actual);
		Assert.assertTrue(actual.toLowerCase().contains(expected));
	}
	
	@DataProvider
	public Object[][] getData() {
		String[] a = new String[] {"One","Two","Three"};
		
		String[][] b = new String[][] {
			{"Selenium"},
			{"TestNG"},
			{"Maven"}
		};
		
		return b;
	}
	
	@DataProvider
	public Object[][] getDataWithExpected() {
		String[] a = new String[] {"One","Two","Three"};
		
		String[][] b = new String[][] {
			{"Selenium","selenium", ""},
			{"TestNG","testng",""},
			{"Maven","maven",""}
		};
		
		return b;
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() {
		String[][] b = getExcelData();
		return b;
	}
	
	private String[][] getExcelData() {
		
		return null;
	}

	@AfterClass
	public void tearDownClass() {
		driver.quit();
	}

}
