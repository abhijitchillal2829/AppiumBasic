package Mobile_Testing.Appium;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class AppiumTest {
	
	public static Logger logger;
	
	 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    @Test
     public void Appium_Basic() throws MalformedURLException {
    	
    	logger = logger.getLogger("Mobile Testing");
		PropertyConfigurator.configure("/home/apmosys/eclipse-workspace/Appium/src/main/java/Mobile_Testing/Appium/log4j2.properties");
    
		// Set the desired capabilities
        desiredCapabilities.setCapability("PLATFORM_NAME", "Android");
        desiredCapabilities.setCapability("DEVICE_NAME", "100aa5bf");
             
        URL serverurl = new URL("http://localhost:4723/wd/hub");

        // Initialize the AppiumDriver
        AndroidDriver driver = new AndroidDriver(serverurl , desiredCapabilities);

        WebElement Click = driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Chrome\"])[1]"));
        Click.click();
        logger.info("click on ele");
        WebElement Send_Value = driver.findElement(By.id("com.android.chrome:id/search_box_text"));
        Send_Value.sendKeys("crickbuzz");
        logger.info("send value of crickbuzz in search box");

        // Quit the driver
        driver.quit();
    }
}
