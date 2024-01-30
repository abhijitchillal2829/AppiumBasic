package Mobile_Testing.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Api_Demos {

	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@Test
	public void Scroll() throws MalformedURLException, InterruptedException {

		caps.setCapability("deviceName", "100aa5bf");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.touchboarder.android.api.demos");
		caps.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");

		URL serverurl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(serverurl, caps);

		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"CONTINUE\")")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"API Demos\")")).click();

		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));

		driver.quit();
	}
}
