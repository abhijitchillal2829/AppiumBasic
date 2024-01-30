package Mobile_Testing.Appium;

import java.net.MalformedURLException;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
import io.appium.java_client.touch.offset.PointOption;

public class Scroll_Appium {

	// syntax for scrolling---->>>
//		    driver.findElement(MobileBy.AndroidUIAutomator(
//		    		"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
//		    		+ "new UiSelector().text(\"Element text\"));"
//		    		));   

	DesiredCapabilities caps = new DesiredCapabilities();
	AppiumDriver driver;

	@Test
	public void Scroll_Action() throws MalformedURLException, InterruptedException {

		caps.setCapability("deviceName", "100aa5bf");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", "com.android.contacts.activities.NonPhoneActivity");

		URL serverurl = new URL("http://localhost:4723/wd/hub");

		driver = new AppiumDriver(serverurl, caps);
		WebElement settings = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]"));
		settings.click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().text(\"Services & feedback\"));"));
		
		Thread.sleep(2000);

		driver.quit();

	}
}
