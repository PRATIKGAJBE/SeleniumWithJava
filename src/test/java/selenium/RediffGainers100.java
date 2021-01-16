package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RediffGainers100 extends BaseSelenium{

	public static void main(String[] args) {

		new BaseSelenium("firefox", "https://money.rediff.com/gainers");	
		int rows = driver.findElements(By.xpath("//table[@class='dataTable']//tr")).size();
		int counter = 0;
		for (WebElement e : driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"))) {
			counter++;
			if (e.getText().contains("Current Price")) {
				break;
			}
		}
		System.out.println("counter = " +counter);
		
		int serialno = 0;
		for(int currentrow=1;currentrow<rows;currentrow++) {
			WebElement currentpriceelement = driver.findElement(By.xpath("//table[@class='dataTable']//tr["+currentrow+"]/td["+counter+"]"));
			String currentpricestring = currentpriceelement.getText();
			String currentpricestringwithoutcomma = currentpricestring.replace(",", "");
			Double currentprice = Double.parseDouble(currentpricestringwithoutcomma);
			if(currentprice<100) {
				String companyname = driver.findElement(By.xpath("//table[@class='dataTable']//tr["+currentrow+"]/td[1]/a")).getText();
				System.out.println(++serialno + " : "+companyname + " : " + currentprice);
			}	
		}
	}
}
