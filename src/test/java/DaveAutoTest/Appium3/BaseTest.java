package DaveAutoTest.Appium3;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		// code to start server	- me to nefunguje a neumi to vyresit
//		 service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//				 .withIPAddress("127.0.0.1").usingPort(4723).build();
//				service.start();
		
				
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("DaveEmulator");
//		options.setDeviceName("Android Device"); //realne zarizeni
		options.setChromedriverExecutable("/Users/davidblazek/chromedriver");
		options.setApp("//Users//davidblazek//eclipse-workspace//Appium3//src//test//java//Resources//ApiDemos-debug.apk");
//		options.setApp("//Users//davidblazek//eclipse-workspace//Appium3//src//test//java//Resources//General-Store.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do 
		{
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			    // Muzou byt vlozeny podminky - pokud nalezne nejaky prvek muze na nej prejit
			    
			));
		}while (canScrollMore);
	}
	
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
		
		
	}
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
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
