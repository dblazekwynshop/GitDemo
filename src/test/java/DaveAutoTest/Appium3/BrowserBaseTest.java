package DaveAutoTest.Appium3;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BrowserBaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		// code to start server	- me to nefunguje a neumi to vyresit
		// service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				// .withIPAddress("127.0.0.1").usingPort(4723).build();
				//service.start();
		
				
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("DaveEmulator");
		options.setChromedriverExecutable("/Users/davidblazek/chromedriver");
		// otevreni prohliyece
		options.setCapability("browserName", "Chrome");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
	}
	
	
	
	

//	@AfterClass
//	public void tearDown()
//	{
		// zavreni app ihned po skonceni testu
//		driver.quit();
		
		//stop server	
		//service.stop();
//	}
}
