package DaveAutoTest.Appium3;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iOSSwipeTest extends iOSBaseTest{
	
	
	@Test
	public void iOSSwipeTestDemo() throws InterruptedException
	{
		// sposteni aplikace instalovne v zariyeni/simulatoru podle Bundle ID - nativni Apple app - ask Google
		Map <String, String> params = new HashMap<String, String>();
		params.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile:launchApp", params);
//		Thread.sleep(3000);
		//otevreni all photos
		driver.findElement(AppiumBy.accessibilityId("All Photos")).click();
//		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
//		Thread.sleep(3000);

		
		// ziskani poctu fotek na obrazovce
		List <WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
		System.out.println(allPhotos.size());
		
		//swipe jednou
//		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell[`label == 'Photo, October 09, 2009, 11:09 PM'`]")).click();
//		Map<String, Object> params1 = new HashMap<String, Object> ();
//		params1.put("direction", "left");
//		
//		driver.executeScript("mobile:swipe", params1);
		
		
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell[`label == 'Photo, October 09, 2009, 11:09 PM'`]")).click();
		
		//swipe pro vsech 6 obrayku
		for (int i =0; i<allPhotos.size(); i++)
		{
			System.out.println(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeNavigationBar")).getAttribute("name"));
			Map<String, Object> params1 = new HashMap<String, Object> ();
			params1.put("direction", "left");
			
			driver.executeScript("mobile:swipe", params1);		
			

		}
//		//kliknuti na sipku zpet
		driver.navigate().back();
//		//vraceni do vychoziho stavu app - debilni postup
		
		driver.findElement(AppiumBy.accessibilityId("Albums")).click();
		
		
		
	}

}
