package Mobile_Testing.Appium;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Client_Mobile {
	
	AndroidDriver drier;
	DesiredCapabilities caps;
	
	public void Amazon() {
		
		caps.setCapability("deviceName", "BE4H65M7CELR4LWW");
		caps.setCapability("udid", "BE4H65M7CELR4LWW");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPakage", "");
		caps.setCapability("appActivity", "");

}
}
