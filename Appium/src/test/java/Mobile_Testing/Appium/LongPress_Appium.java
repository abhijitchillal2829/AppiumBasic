package Mobile_Testing.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Maps;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LongPress_Appium {

	// Locators---->>>
	// Xpath , id , accessibilityId , classname , androidUIAutomator

	DesiredCapabilities caps = new DesiredCapabilities();
	AppiumDriver driver;

	@Test
	public void Long_Press() throws MalformedURLException {

		caps.setCapability("deviceName", "Redmi Note 7S");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPakage", "in.amazon.mShop.android.shopping");
		caps.setCapability("appActivity", "com.amazon.mShop.navigation.MainActivity");

		URL serverurl = new URL("http://localhost:4723/wd/hub");

		driver = new AppiumDriver(serverurl, caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Amazon\"]"));
		
		AndroidTouchAction touch = new AndroidTouchAction((PerformsTouchActions) driver);
		touch.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(ele))).perform();
		
		
		// Syntax of xpath---
		// tagName[@attribute='value']

	}

}
