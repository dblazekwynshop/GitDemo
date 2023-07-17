package DaveAutoTest.Appium3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class MobileBrowserTest extends BrowserBaseTest{

	
	public void browserTest()
	{
		
		
//		driver.get("http://google.com");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		//blabla
		// blalba
		// blabla

		System.out.println("Blabla1");
		System.out.println("Blabla2");
		System.out.println("Blabla3");


		//skrolovani na strance
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		
		
		
		//vybrani tretiho produktu na strance Devops
		String text = driver.findElement(By.cssSelector("a[href*='/angularAppdemo/products/3']")).getText();
		Assert.assertEquals(text, "Devops");
		
	
		
		
		
		
	}
	
	
}
