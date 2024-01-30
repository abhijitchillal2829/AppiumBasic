package Mobile_Testing.Appium;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;


public class Amaz_AddToCart {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	AppiumDriver driver;
	
	@Test
	public void Amz() throws MalformedURLException {
		
		caps.setCapability("deviceName", "Redmi Note 7S");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPakage", "in.amazon.mShop.android.shopping");
		caps.setCapability("appActivity", "com.amazon.mShop.navigation.MainActivity");
		
		URL serverurl = new URL("http://localhost:4723/wd/hub");
		driver = new AppiumDriver(serverurl , caps);
		
		WebElement Click = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Amazon\"]"));
		Click.click();
		WebElement search_product = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Select English\"]"));
		search_product.click();
		WebElement book = driver.findElement(By.id("in.amazon.mShop.android.shopping:id/continue_button"));
		book.click();
		WebElement Add_to_cart = driver.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button"));
		Add_to_cart.click();	
	}

}
