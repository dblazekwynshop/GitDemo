package DaveAutoTest.Appium3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest{
	
	@Test
	public void FillForm() throws InterruptedException
	{
		
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dave Test");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahamas\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bahamas']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//stisknuti tlacitka bez zadani jmena = zobrazi se toust message
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		
		
		Thread.sleep(3000);
		


		
	}

}
