package DaveAutoTest.Appium3;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


public class AppiumBasics extends BaseTest{

	@Test
	public void WifiSettingsName () throws MalformedURLException
	{
		
		// Xpath, id, accessibilityId, classname, androidUIAutomator
		//Xpath - tagName[@attribute='value'] -> tagName - stejne polozku vyhledava od leveho horniho rohu
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//vyjmuti textu z aplikace - porovnani jestli je text spravny
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		//zapsani do pole
		driver.findElement(By.id("android:id/edit")).sendKeys("Dave Wifi");
		//pro className pouzivat appiumBy. v novejsich verzich nebude By. fungovat
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		// nastaveni jmena Wifi 
		

		
		
		
		
		
		
	}
	
	
	
	
}
