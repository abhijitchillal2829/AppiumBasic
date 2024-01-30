package Mobile_Testing.Appium;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Landscape_Appium {
	
	//command to get app pakage and app activity
	   //adb devices
	   //adb shell
	   //dumpsys window displays | grep -E 'mCurrentFocus'
	             //app pakage                         //app activity
	   //output:-com.touchboarder.android.api.demos/com.example.android.apis.preference.PreferenceDependencies

	// For landscape mode we use DeviceRotation Class and Rotate method
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@Test
	public void landscape_Appium() throws MalformedURLException, InterruptedException {

		caps.setCapability("deviceName", "Redmi Note7S");
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
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Preference\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"3. Preference dependencies\")"))
				.click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		driver.findElement(AppiumBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();
		boolean get_title = driver.findElement(AppiumBy.id("android:id/alertTitle")).isDisplayed();
		assertTrue(get_title);
		driver.setClipboardText("Abhijit wifi");
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		Thread.sleep(2000);
		driver.quit();

	}

}
