package selenium;

import java.util.Set;

import org.openqa.selenium.By;

public class FacebookWindows extends BaseSelenium {

	public static void main(String[] args) throws InterruptedException {
		BaseSelenium base = new BaseSelenium("firefox", "https://www.facebook.com");
		driver.manage().window().maximize();
		
		String mainwindowhandle = driver.getWindowHandle();
		System.out.println("Main Window Handle is: "+mainwindowhandle);
		
		driver.findElement(By.id("terms-link")).click();
		
		Thread.sleep(2000);
		
		Set<String> handles = driver.getWindowHandles();
		
		String windowhandle = null;
		
		System.out.println(handles.size());
		
		for (String handle : handles) {
			driver.switchTo().window(handle);
			if(driver.getTitle().contains("Terms")) {
				windowhandle = handle;
			}
		}
		
		System.out.println("Second Window Handle is: "+windowhandle);
		
		System.out.println(driver.findElement(By.tagName("h2")).getText());
		
		driver.close();
		
		driver.switchTo().window(mainwindowhandle);
		
		System.out.println(driver.getTitle());
		
		driver.close();
	
	}

}
