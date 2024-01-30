package GenralStore_Ecommerce;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TC_FillingFormDetails {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	AppiumDriver driver;

	@Test
	public void base_Class() throws MalformedURLException {
		
		caps.setCapability("deviceName", "Redmi Note7S");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		caps.setCapability("appActivity", "com.amazon.mShop.navigation.MainActivity");
		

		URL serverurl = new URL("http://localhost:4723/wd/hub");

		driver = new AppiumDriver(serverurl, caps);
		driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Amazon\"])[2]")).click();

		

}
}
