package BrowserApp_Appium;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Automating_WebBrowser {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@Test
	public void browser_app() throws MalformedURLException {
		
		caps.setCapability("deviceName", "Redmi Note7S");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.play.core.common.PlayCoreDialogWrapperActivity");

		URL serverurl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(serverurl, caps);
		driver.get("https://www.example.com"); 
}
}