package testScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		// driver.get("https://www.google.co.in/");
		// WebElement searchBox=driver.findElement(By.name("q"));
		// searchBox.sendKeys("Java Tutorial");
		//// searchBox.sendKeys(Keys.ENTER);
		// searchBox.submit();

		// Navigation API
		driver.navigate().to("https://www.google.co.in/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java Tutorial");
//		Thread.sleep(2000);
		
		 searchBox.sendKeys(Keys.ENTER);
		// searchBox.submit();
		// System.out.println("Page title after search : "+driver.getTitle());
		// driver.navigate().back();
		// System.out.println("Page title of home page : "+driver.getTitle());
		// driver.navigate().forward();
		// System.out.println("Current URL : "+driver.getCurrentUrl());

		List<WebElement> eList = driver
				.findElements(By.xpath("//ul[@role='listbox']//li//descendant::div[@class='pcTkSc']//span"));
		for (WebElement we : eList) {
			System.out.println(we.getText());
			if (we.getText().equalsIgnoreCase("java tutorial pdf")) {
				we.click();
				break;
			}
		}
	}
}
