package Mobile_Testing.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Class {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	AppiumDriver driver;
	
	@Test
	public void m1() throws MalformedURLException {
		
		caps.setCapability("deviceName", "100aa5bf");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", "com.android.contacts.activities.NonPhoneActivity");
		
		URL serverurl = new URL("http://localhost:4723/wd/hub");
		
		driver = new AndroidDriver(serverurl, caps);
		
		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Contacts\"]")).click();
		
		driver.findElement(AppiumBy.id("android:id/input\n")).sendKeys("rupaleen");

	}

}
