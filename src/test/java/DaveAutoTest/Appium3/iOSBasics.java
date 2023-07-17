package DaveAutoTest.Appium3;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iOSBasics extends iOSBaseTest{
	
	
	@Test
	public void iOSBasicsTest()
	{
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
		//pouziti Xpath
	//	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\'Text Entry\']")).click();
		// iOS class chain
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello Dolly");
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		
		
		// iOS predicate string
	//	driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'"));
		// druha moznost zapisu - [c]- key sensytiv
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
			// vypise text do konzole
			String text = driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText();
			System.out.println(text);

		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
		
	//	driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'"));

		
		
		
		
	}

}
