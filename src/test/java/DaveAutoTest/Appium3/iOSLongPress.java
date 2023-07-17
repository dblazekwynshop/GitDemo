package DaveAutoTest.Appium3;

import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iOSLongPress extends iOSBaseTest{
	
	
	@Test
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

}
