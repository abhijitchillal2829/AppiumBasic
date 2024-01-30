package Tests;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {
	
	

	DesiredCapabilities caps = new DesiredCapabilities();
	protected AppiumDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException {

		caps.setCapability("deviceName", "Redmi Note 7S");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.android.mms");
		caps.setCapability("appActivity", "com.android.mms.ui.MmsTabActivity");

		URL serverurl = new URL("http://localhost:4723/wd/hub");

		
		driver = new AppiumDriver(serverurl, caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	
	public void longpressAction(WebElement ele) {
		
		AndroidTouchAction touch = new AndroidTouchAction((PerformsTouchActions) driver);
		touch.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(ele))).perform();
	}
	
	public void scrollAction() {
		
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().text(\"Services & feedback\"));"));
	}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();

	}

}
