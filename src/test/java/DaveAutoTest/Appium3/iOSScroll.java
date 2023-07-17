package DaveAutoTest.Appium3;

import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iOSScroll extends iOSBaseTest{
	
	
	@Test
	public void iOSScrollTestDemo() throws InterruptedException
	{
		
		
		WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "down");
		params.put("element", ((RemoteWebElement)ele).getId());
		
		driver.executeScript("mobile:scroll", params);
		Thread.sleep(1000);
		
//		driver.findElement(AppiumBy.accessibilityId("Web View")).click();
//		Thread.sleep(2000);
//		
//		driver.findElement(AppiumBy.iOSNsPredicateString("label == \"UIKitCatalog\" AND name == \"UIKitCatalog\" AND type == \"XCUIElementTypeButton\"")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).sendKeys("105");
	String number = 	driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).getText();
		Assert.assertEquals(number, "105");
		System.out.println(number);
		Thread.sleep(2000);
		
		

		

		
	}

}
