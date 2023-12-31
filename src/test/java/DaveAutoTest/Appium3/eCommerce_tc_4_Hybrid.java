package DaveAutoTest.Appium3;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends BaseTest{
	
	@Test
	public void FillForm() throws InterruptedException
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dave Test");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahamas\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bahamas']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		// dva zpusoby jak pridat produkty do kosiku podle id
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();	
		// pouzije se stejny index - text prvniho se ymeni na Added - tim je na strance jen jeden objekt Add to cart
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();	
		//driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();	
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(2000);
		// pocka na trance dokud nenalezne text "Cart"
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum = 0;
		for (int i = 0; i< count; i++)
		{
			String amountString = productPrices.get(i).getText();
			//odstraneni prvniho znaku v ziskanem textu
			//$160.07 - $ je index 0 - string zacne indexem 1
			//Double price = Double.parseDouble(amountString.substring(1));
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
		
		}
		
		
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormattedAmount(displaySum);
		AssertJUnit.assertEquals(totalSum, displayFormattedSum);
		
		
		// dlouhe stisknuti terms
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		// stisknuti tlacitka Close na terms
		driver.findElement(By.id("android:id/button1")).click();
		// zaskrtnuti pole
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(6000);
		
		//hybrid - webview v app
		Set<String> contexts = driver.getContextHandles();
		for(String contextName :contexts)
		{
			System.out.println(contextName);
			
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		//zobrazuje se potvrzeni podminek - to budu muset nejak obejit
		
		//scrollToEndAction();
		
		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//navrat do nativni app
		driver.context("NATIVE_APP");
		
		
		
		
		
		
		
		
	}

}
