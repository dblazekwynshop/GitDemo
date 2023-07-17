package DaveAutoTest.Appium3;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumBy;



@Test
public class ScrollDemo extends BaseTest{

	public void ScrollDemoTest  () throws MalformedURLException, InterruptedException
	{
		
		// dokumentace ke gestum https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
		// otevre obrazovku Views z hlavniho menu
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//Postupne prohledava stranku az dojde k hledanemu textu WebView
		//Lepsi a presnejsi reseni
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"));"));
		
		//Skroluje dolu nebo nahoru podle souradnic - ne na urcity prvek
		//Skroluje jen o kousek
//		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 100, "top", 100, "width", 200, "height", 200,
//			    "direction", "down",
//			    "percent", 3.0
//			));
		
		//Skroluje do konce stranky
		
//		boolean canScrollMore;
//		do 
//		{
//		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 100, "top", 100, "width", 200, "height", 200,
//			    "direction", "down",
//			    "percent", 3.0
//			    // Muzou byt vlozeny podminky - pokud nalezne nejaky prvek muze na nej prejit
//			    
//			));
//		}while (canScrollMore);

		//skrolovani nakonec z BaseTest
//		scrollToEndAction();
		
		
		
		Thread.sleep(3000);
		
		
		
		
		
		
		
	}
	
	
	
	
}
