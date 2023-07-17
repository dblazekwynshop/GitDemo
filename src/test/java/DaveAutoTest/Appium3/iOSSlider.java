package DaveAutoTest.Appium3;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

@Test
public class iOSSlider extends iOSBaseTest{
	
	
	public void iOSSliderTest() throws InterruptedException
	{
		
		WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == 'AppElem'`]"));
		slider.sendKeys("0%");
		System.out.println(slider.getAttribute("value"));
		Assert.assertEquals("0%", slider.getAttribute("value"));
		Thread.sleep(2000);
		
		slider.sendKeys("1%");
		System.out.println(slider.getAttribute("value"));
		Assert.assertEquals("100%", slider.getAttribute("value"));
		Thread.sleep(2000);
		
		

		
	}

}
