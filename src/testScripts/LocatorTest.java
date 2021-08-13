package testScripts;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatorTest {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait  wait=new WebDriverWait(driver,15);
		
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		
		driver.findElement(By.id("fname")).sendKeys(Keys.chord(Keys.SHIFT,"ab"));
		driver.findElement(By.id("fname")).sendKeys(Keys.PAGE_DOWN);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("idOfButton"))));
		
		boolean isButton=driver.findElement(By.id("idOfButton")).isDisplayed();
		System.out.println("Button enabled? : "+isButton);
		
//		driver.findElement(By.cssSelector("#fname")).sendKeys("TestUser");
		
		driver.findElement(By.xpath("//*[@id='idOfButton']")).click();
		driver.findElement(By.cssSelector("#female")).click();
		boolean isGenderSel=driver.findElement(By.cssSelector("#female")).isSelected();
		System.out.println("Is either of the geneder selected? : "+isGenderSel);
		
//		driver.findElement(By.xpath("//*[@class='Automation']")).click();
//		driver.findElement(By.cssSelector("#fname")).clear();
//		
//		List<WebElement> element=driver.findElements(By.tagName("input"));
//		for(WebElement we: element) {
//			System.out.println("Name attribute : "+we.getAttribute("name"));
//		}

//		List<WebElement> eList=driver.findElements(By.xpath("//input[@type='text']/following::button"));
//		for(WebElement we: eList) {
//			System.out.println(we.getText());
//		}
		
		List<WebElement> eList1=driver.findElements(By.xpath("//button[@id='idOfButton']//preceding::input"));
		for(WebElement we: eList1) {
			System.out.println(we.getAttribute("name"));
		}
		

	}

}
