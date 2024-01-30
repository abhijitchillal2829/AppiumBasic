package Tests;

import org.testng.annotations.Test;



import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TestCases extends BaseClass{
	
	@Test
	public void test() throws MalformedURLException {
		
//		setup();
		driver.get("http://google.com");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Automation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		teardown();
	}

}
