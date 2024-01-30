package Mobile_Testing.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class Drag_Drop_Appium {

	static Logger logger = Logger.getLogger("Drag_Drop_Appium");

	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@Test
	public void Drag_Drop() throws MalformedURLException, InterruptedException {

		PropertyConfigurator.configure("/home/apmosys/eclipse-workspace/Appium/src/test/java/log4j.properties");

		caps.setCapability("deviceName", "100aa5bf");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.touchboarder.android.api.demos");
		caps.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");

		URL serverurl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(serverurl, caps);
		logger.info("Api-Demos application is opened");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"CONTINUE\")")).click();
		logger.info("Click on contiune");
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		logger.info("Click on next");
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
		logger.info("Click on next");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"API Demos\")")).click();
		logger.info("Click on API Demos");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
		logger.info("Click on views");
		driver.findElement(AppiumBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[8]"))
				.click();
		logger.info("Click on next");
		WebElement Source = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/drag_dot_1"));
		WebElement Dest = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/drag_dot_2"));
		AndroidTouchAction touch = new AndroidTouchAction((PerformsTouchActions) driver);
		touch.longPress(ElementOption.element(Source)).moveTo(ElementOption.element(Dest)).release().perform();
		logger.info("Drag & Drop activity is completed");
		driver.quit();
		logger.info("Close Application");
	}
}
