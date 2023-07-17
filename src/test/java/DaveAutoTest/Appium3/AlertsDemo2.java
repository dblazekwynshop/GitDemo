package DaveAutoTest.Appium3;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;



@Test
public class AlertsDemo2 extends BaseTest{

	public AlertsDemo2  () throws MalformedURLException, InterruptedException
	{
		
		// dokumentace ke gestum https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
		// otevre obrazovku Views z hlavniho menu
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Progress dialog")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Text Entry dialog\"]")).click();
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Dave");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Test1234");
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElements(AppiumBy.className("android.widget.CheckedTextView")).get(2).click();
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		driver.findElements(AppiumBy.className("android.widget.CheckedTextView")).get(0).click();
		driver.findElements(AppiumBy.className("android.widget.CheckedTextView")).get(1).click();
		driver.findElements(AppiumBy.className("android.widget.CheckedTextView")).get(4).click();
		driver.findElements(AppiumBy.className("android.widget.CheckedTextView")).get(6).click();
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		driver.findElements(AppiumBy.className("android.widget.CheckedTextView")).get(1).click();
		driver.findElements(AppiumBy.className("android.widget.CheckedTextView")).get(2).click();
		driver.findElements(AppiumBy.className("android.widget.CheckedTextView")).get(4).click();
		driver.findElements(AppiumBy.className("android.widget.CheckedTextView")).get(6).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
//		driver.findElement(AppiumBy.accessibilityId("Send Call to VoiceMail")).click();
//		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Text Entry dialog\"]")).click();		
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Dave");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Test1234");
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with traditional theme")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "Lorem ipsum dolor sit aie consectetur adipiscing\n"
				+ "Plloaso mako nuto siwuf cakso dodtos anr koop.");
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with traditional theme")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with Holo Light theme")).click();
		String alertTitle2 = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle2, "Lorem ipsum dolor sit aie consectetur adipiscing\n"
				+ "Plloaso mako nuto siwuf cakso dodtos anr koop.");
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with Holo Light theme")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
		Thread.sleep(2000);

		System.out.println("Blabla1");
		System.out.println("Blabla2");
		System.out.println("Blabla3");
		
		
	}
	
	
	
	
}
