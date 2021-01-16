package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlipkartLaptopsSearch extends BaseSelenium {

	public static void main(String[] args) {
		new BaseSelenium("firefox","https://www.flipkart.com");
		
		driver.findElement(By.cssSelector("._2AkmmA._29YdH8")).click();
		
		driver.findElement(By.name("q")).sendKeys("laptop");
		
		driver.findElement(By.cssSelector(".vh79eN")).click();
		
		List<WebElement> listoflaptops = driver.findElements(By.cssSelector("a._31qSD5"));
		System.out.println(listoflaptops.size());
		int count = 0;
		
		for (WebElement laptop : listoflaptops) {
			//String ram = laptop.findElement(By.cssSelector("a._31qSD5 li.tVe95H:nth-of-type(2)")).getText();
			//String ram = laptop.findElement(By.cssSelector("li.tVe95H:nth-of-type(2)")).getText();
			String ram = laptop.findElement(By.xpath(".//*[@class='tVe95H'][contains(text(),'RAM')]")).getText();
			if(ram.contains("4 GB")) 
				System.out.println(++count+" : "
						  +laptop.findElement(By.className("_3wU53n")).getText().substring(0, 25) + " : "
						  +laptop.findElement(By.cssSelector("div._1vC4OE._2rQ-NK")).getText().substring(1));
			}
		
			//System.out.println(ram);
		}
		
		/*
		 * for (WebElement laptop : listoflaptops) { List<WebElement> list =
		 * laptop.findElements(By.className("tVe95H")); for (WebElement l : list) {
		 * if(l.getText().contains("4 GB")) { System.out.println(++count+" : "
		 * +laptop.findElement(By.className("_3wU53n")).getText() + " : "
		 * +laptop.findElement(By.cssSelector("div._1vC4OE._2rQ-NK")).getText()); } } }
		 */
	}

