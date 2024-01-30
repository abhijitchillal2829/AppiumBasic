package Mobile_Testing.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.appium.java_client.AppiumDriver;

public class Calculator_Test {
	
	static Logger logger = Logger.getLogger("Calculator_Test");
	
	DesiredCapabilities caps = new DesiredCapabilities();
	AppiumDriver driver;
	
	@Test
	public void Open_Calculator() throws MalformedURLException, InterruptedException {
		
		PropertyConfigurator.configure("/home/abhijit.chillal@apmosys.mahape/eclipse-workspace/Appium/src/test/java/log4j.properties");

		
		caps.setCapability("deviceName", "100aa5bf");
		caps.setCapability("udid", "100aa5bf");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.miui.calculator");
		caps.setCapability("appActivity", "com.miui.calculator.cal.CalculatorTabActivity");
		
		URL serverurl = new URL("http://localhost:4723/wd/hub");
		
		driver = new AppiumDriver(serverurl, caps);
		logger.info("Calculator app is open");
		WebElement privacy = driver.findElement(By.id("android:id/button1"));
		privacy.click();  //Agree
		logger.info("Click on privacy");		
		Thread.sleep(3000);
		WebElement one = driver.findElement(By.id("com.miui.calculator:id/btn_3_s"));
		one.click();
		logger.info("Click on one number");
		WebElement plus = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
		plus.click();
		logger.info("Click on plus");
		WebElement six = driver.findElement(By.id("com.miui.calculator:id/btn_6_s"));
		six.click();
		logger.info("Click on six number");
		WebElement equals = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
		equals.click();
		logger.info("Click on equals");
		String Text = driver.findElement(By.id("com.miui.calculator:id/result")).getText();
		System.out.println("Validate Result "+Text);
		logger.info("Result is displayed on screen");
		Thread.sleep(3000);
		WebElement clear_cal = driver.findElement(By.id("com.miui.calculator:id/btn_c_s"));
		clear_cal.click();
		logger.info("Click on clear");
		String Text_AfterClear = driver.findElement(By.xpath("//android.view.View[@content-desc=\"0\"]")).getText();
		System.out.println("Validate Result After Clear "+Text_AfterClear);
		logger.info("zero is displayed on screen");
		driver.quit();
		logger.info("Application is closed");
		
		
	}

}
