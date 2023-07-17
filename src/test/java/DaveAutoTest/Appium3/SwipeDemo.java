package DaveAutoTest.Appium3;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;



@Test
public class SwipeDemo extends BaseTest{

	public void SwipeDemoTest  () throws MalformedURLException, InterruptedException
	{
		
		// dokumentace ke gestum https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
		// otevre obrazovku Views z hlavniho menu
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
//		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();	
		WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		
		//kod pro zjisteni jestli je prvni obrazek focusable=true a po swipe se zmeni na false
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),"true");
		//Swipe - nepouzijeme souradnice bo zname elemen ID
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//				"elementId", ((RemoteWebElement)firstImage).getId(),
//			    "direction", "left",
//			    "percent", 0.75
//			));
		//swipe z BaseTest
		swipeAction(firstImage,"left");
		swipeAction(firstImage,"right");

		//overi ze se zmeni stav na false
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),"false");
		
		
		Thread.sleep(3000);
		
		
		
		
		
		
		
	}
	
	
	
	
}
