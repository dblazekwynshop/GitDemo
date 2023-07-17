package DaveAutoTest.Appium3;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.Activity;




public class MiscellanousAppiumActions extends BaseTest{

	@Test
	public void Miscellanous () throws MalformedURLException
	{
		
		//spusteni app na jine nez home obrazovce
		//kazda stranka je jedna aktivita - otevreni na treti strance 
				
		//V terminalu zadat prikaz adb shell
		//dave-mac:~ davidblazek$ adb devices
		//List of devices attached
		//emulator-5554	device

		//dave-mac:~ davidblazek$ adb shell dumpsys window | grep -E 'mCurrentFocus'
		//  mCurrentFocus=Window{9194b56 u0 Application Error: io.appium.android.apis}
		//  mCurrentFocus=Window{2d138e0 u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
		//dave-mac:~ davidblazek$ 
		
		// pred lomitkem je Package name, za lomitkem je nazev Activity = obrazovka
		
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landScape = new DeviceRotation(0, 0, 90); 
		driver.rotate(landScape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//vyjmuti textu z aplikace - porovnani jestli je text spravny
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		//zapsani do pole
		//copy paste
		//ulozeni textu do schranky
		driver.setClipboardText("Dave Wifi");
//		driver.findElement(By.id("android:id/edit")).sendKeys("Dave Wifi");
		//vlozeni textu ze schranky
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		//pro className pouzivat appiumBy. v novejsich verzich nebude By. fungovat
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

		//stisknuti nativniho tlacitka Home
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		// nastaveni jmena Wifi
		

		
		
		
		
		
		
	}
	
	
	
	
}
