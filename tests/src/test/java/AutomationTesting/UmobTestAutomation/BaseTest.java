package AutomationTesting.UmobTestAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseTest {

	// All our reusable utilities are added in this class
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException 
	{
		
		// Code to start the server
				service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\samee\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				
				// Adding the required UIAutomator capabilities
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("AnkitaEmulator"); 
				options.setApp("C://Users//samee//eclipse-workspace//UmobTestAutomation//src//test//java//resources//ApiDemos-debug.apk");
				
				// Creating Driver object
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
		service.stop();
	}
	
}
