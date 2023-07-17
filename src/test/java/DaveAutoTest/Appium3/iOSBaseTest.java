package DaveAutoTest.Appium3;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.ios.IOSDriver;


public class iOSBaseTest {
	
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		// code to start server	- me to nefunguje a neumi to vyresit
		// service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				// .withIPAddress("127.0.0.1").usingPort(4723).build();
				//service.start();
		
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName ("iPhone 12 Pro");
		options.setApp("/Users/davidblazek/Library/Developer/Xcode/DerivedData/UIKitCatalog-gnvfowfhttcjdxccfthfesyyxpgp/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
//		options.setApp("//Users//davidblazek//eclipse-workspace2//Appium3//src//test//java//Resources//TestApp 3.app");
		options.setPlatformVersion("14.3");
		//Webdriveragen - prodle spusteni
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//pro spusteni na realnem iOS zariyeni
//		d.setCapability("xcodeOrgId","xxxxxxxx");//TeamID - ziskam od vyvojare - nebo v informaci o app - https://developer.apple.com/account
//		d.setCapability("xcodeSigningId","iPhone Developer");//defaultni hodnota - stejna pro vsechny
//		d.setCapability("udid","xxxxxxxx");//finder po pripojeni
//		d.setCapability("updateWDABundleId","io.appiumDBV1.WebDriverAgentRunner");//Appstore connect 

		
		
		
	}
	
	
	
	public void iOSLongPressTest()
	{
		
		
		driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
			WebElement ele= driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
			Map <String, Object>params = new HashMap<>();
			params.put("element", ((RemoteWebElement)ele).getId());
			params.put("duration", 5);
			
			
			driver.executeScript("mobile:touchAndHold", params);
			
			WebElement ele2= driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Decrement'`][3]"));
			Map <String, Object>params2 = new HashMap<>();
			params2.put("element", ((RemoteWebElement)ele2).getId());
			params2.put("duration", 5);
			
			
			driver.executeScript("mobile:touchAndHold", params2);
		
	}


	@AfterClass
	public void tearDown()
	{
		// zavreni app ihned po skonceni testu
		driver.quit();
		
		//stop server	
		//service.stop();
	}
}
