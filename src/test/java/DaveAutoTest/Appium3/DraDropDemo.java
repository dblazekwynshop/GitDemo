package DaveAutoTest.Appium3;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;



@Test
public class DraDropDemo extends BaseTest{

	public void DragDropTest  () throws MalformedURLException, InterruptedException
	{
		
		// dokumentace ke gestum https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
		// otevre obrazovku Views z hlavniho menu
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 650,
			    "endY", 580
			));
		
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
	
		
		
		Thread.sleep(3000);
		
		
		
		
		
		
		
	}
	
	
	
	
}
