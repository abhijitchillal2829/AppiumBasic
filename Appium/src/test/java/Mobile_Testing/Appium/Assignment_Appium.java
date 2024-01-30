package Mobile_Testing.Appium;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Assignment_Appium {

	static Logger logger = Logger.getLogger("Assignment_Appium");

	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@Test
	public void Assignment_App() throws MalformedURLException, InterruptedException {

		PropertyConfigurator.configure("/home/apmosys/eclipse-workspace/Appium/src/test/java/log4j.properties");

		caps.setCapability("deviceName", "Redmi Note 7s");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.touchboarder.android.api.demos");
		caps.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");

		URL serverurl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(serverurl, caps);
		
		logger.info("Application open");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"CONTINUE\")")).click();
		logger.info("Click on continue");
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		logger.info("Click on next");
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
		logger.info("Click on next");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"API Demos\")")).click();
		logger.info("Click on Api-Demos");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")")).click();
		logger.info("Click on App");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Alert Dialogs\")")).click();
		logger.info("Verify alert dialogs");
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/two_buttons")).click();
		logger.info("Click on next");
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		logger.info("Click on next");
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/two_buttons2")).click();
		logger.info("Click on next");
		String Title = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(Title, "Header title");
		logger.info("Verify title");
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		logger.info("Click on next");
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/two_buttons2ultra")).click();
		logger.info("Click on next");
		boolean Text = driver.findElement(AppiumBy.id("android:id/message")).isDisplayed();
		assertTrue(Text);
		logger.info("Verify text");
		driver.findElement(AppiumBy.id("android:id/button3")).click();
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/select_button")).click();
		boolean command_line = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Command one\")"))
				.isDisplayed();
		assertTrue(command_line);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Command one\")")).click();
		boolean command_text = driver.findElement(AppiumBy.id("android:id/message")).isDisplayed();
		assertTrue(command_text);
		driver.navigate().back();
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/progress_button")).click();
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/progress_spinner_button")).click();
		boolean buffer = driver.findElement(AppiumBy.id("android:id/alertTitle")).isDisplayed();
		assertTrue(buffer);
		driver.navigate().back();
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/radio_button")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Satellite\")")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/checkbox_button")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Monday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Wednesday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Friday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Saturday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Sunday\")")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/checkbox_button2")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().text(\"Vaibhav Kalshetti\"));"));

		driver.navigate().back();
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/text_entry_button")).click();
		boolean Text_Entry = driver.findElement(AppiumBy.id("android:id/alertTitle")).isDisplayed();
		assertTrue(Text_Entry);
		assertTrue(
				driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/username_view")).isDisplayed());
		assertTrue(
				driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/password_view")).isDisplayed());
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/username_edit"))
				.sendKeys("Abhijit Chillal");
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/password_edit")).sendKeys("Abhijit1998");
		driver.findElement(AppiumBy.id("android:id/button1")).click();
//		driver.findElement(AppiumBy.id("android:id/autofill_save_no")).click();
		driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/two_buttons_old_school")).click();
		assertTrue(driver.findElement(AppiumBy.id("android:id/alertTitle")).isDisplayed());
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

}
