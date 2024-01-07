package AutomationTesting.UmobTestAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest {

	@Test
	public void AppiumTest() throws MalformedURLException {
		
		// Actual Automation code
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.id("andriod:id/checkbox")).click();
		driver.findElement(By.xpath("(//andriod.widget.RelativeLayout)[2]")).click();
		
		String alertTitle = driver.findElement(By.id("andriod:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("andriod:id/edit")).sendKeys("Ankita Wifi");
		
		driver.findElements(AppiumBy.className("andriod.widget.Button")).get(1).click();
	}
	
}
