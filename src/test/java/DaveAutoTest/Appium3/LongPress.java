package DaveAutoTest.Appium3;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;



@Test
public class LongPress extends BaseTest{

	public void LongPressGesture  () throws MalformedURLException, InterruptedException
	{
		
		// dokumentace ke gestum https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//Xpath - tagName[@attribute='value'] -> tagName - stejne polozku vyhledava od leveho horniho rohu
		// Odkazuje na Java script v BaseTest - WebElement
	WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(ele);
		
		
		
		// musi se vlozit Java script  
		// dokumentace ke gestum - https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
//				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
//						"duration",2000));
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText, "Sample menu");
		
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		
		// doba po kterou zustane app jeste spustena po dokonceni long press
		//Thread.sleep(2000);
		
		
		
		
		
		
		
	}
	
	
	
	
}
