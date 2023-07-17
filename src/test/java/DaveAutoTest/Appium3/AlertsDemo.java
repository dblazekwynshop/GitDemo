package DaveAutoTest.Appium3;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;



@Test
public class AlertsDemo extends BaseTest{

	public AlertsDemo  () throws MalformedURLException, InterruptedException
	{
		
		// dokumentace ke gestum https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
		// otevre obrazovku Views z hlavniho menu
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2ultra")).click();
		driver.findElement(By.id("android:id/button3")).click();
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		driver.findElement(By.xpath("//android.widget.ListView/android.widget.TextView[2]")).click();
		Thread.sleep(2000);

		

		
		
		
		
		
		
		
	}
	
	
	
	
}
