package Mobile_Testing.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class Appium_Messages_Seprate_OTP {

	DesiredCapabilities caps = new DesiredCapabilities();
	protected AppiumDriver driver;
	
	@Test
	public void Messages() throws MalformedURLException, InterruptedException {

		PropertyConfigurator.configure("/home/apmosys/eclipse-workspace/Appium/src/test/java/log4j.properties");	caps.setCapability("deviceName", "Redmi Note 7S");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.android.mms");
		caps.setCapability("appActivity", "com.android.mms.ui.MmsTabActivity");

		URL serverurl = new URL("http://localhost:4723/wd/hub");
		driver = new AppiumDriver(serverurl, caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement close = driver.findElement(By.id("com.android.mms:id/search_guide_close"));
		close.click();
		WebElement Agree_Condition = driver.findElement(By.id("com.android.mms:id/recommend_ok"));
		Agree_Condition.click();
		WebElement search = driver.findElement(By.id("android:id/input"));
		search.click();
		Thread.sleep(2000);
		WebElement input = driver
				.findElement(By.xpath("//miuix.androidbasewidget.widget.ClearableEditText[@content-desc=\"Search\"]"));
		input.sendKeys("Phonepe");
		WebElement Message_click = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]"));
		Message_click.click();
		WebElement Message = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView"));
		String Message_Print = Message.getText();
		String OTP = Message_Print.replaceAll("[^2-7]", "");
		System.out.println("OTP is :" + OTP);

	}

}
