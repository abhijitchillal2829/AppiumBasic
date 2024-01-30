package Mobile_Testing.Appium;

import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;



public class Dailer_Contact {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	AppiumDriver driver;
	@Test
	public void Dailer() throws MalformedURLException {
		
		caps.setCapability("deviceName", "100aa5bf");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", "com.android.contacts.activities.NonPhoneActivity");
		
		
		URL serverurl = new URL("http://localhost:4723/wd/hub");
		
		driver = new AppiumDriver(serverurl , caps);
		WebElement contacts = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Contacts\"]"));
		contacts.click();
		WebElement contact = driver.findElement(AppiumBy.id("android:id/input"));
		contact.click();
		contact.sendKeys("");
		WebElement Call = driver.findElement(AppiumBy.id("com.android.contacts:id/name"));
		Call.click();
		WebElement dail = driver.findElement(AppiumBy.id("com.android.contacts:id/first_action_button"));
		dail.click();
		
		
	}
	
	

}
