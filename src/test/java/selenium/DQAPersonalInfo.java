package selenium;

import org.openqa.selenium.By;

public class DQAPersonalInfo extends BaseSelenium {

	public static void main(String[] args) {
		BaseSelenium base = new BaseSelenium("chrome", "http://www.destinationqa.com/aut-SamplePersonalInformationForm");
		
		driver.findElement(By.xpath("//input[@class='PItext fname']")).sendKeys("Ameya");
		driver.findElement(By.xpath("//input[@class='PItext' and @name='lastname']")).sendKeys("Naik");
		driver.findElement(By.xpath("//input[@name='address']")).clear();
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("My New Address");
		driver.findElement(By.xpath("(//input[@class='PItext' and @type='text'])[3]")).sendKeys("9987654328");
		driver.findElement(By.xpath("//div[@class='PIRadioButtons']/input[@value='male']")).click();
		if(!driver.findElement(By.xpath("//input[@name='vehicle' and @value='Bike']")).isSelected()) {
			driver.findElement(By.xpath("//input[@name='vehicle' and @value='Bike']")).click();
		}
		driver.findElement(By.xpath("//option[@value='B']")).click();
		driver.findElement(By.xpath("//input[@name='user']")).sendKeys("username");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("password");
		driver.findElement(By.xpath("//form")).submit();
		driver.quit();
		
		
	}

}
