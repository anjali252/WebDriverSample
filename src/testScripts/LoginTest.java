package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Libs_Workshop/Demo%20Login%20Page.html");
		
		driver.findElement(By.xpath("//input[@type='text' and @class='inputtext']")).sendKeys("HelloUser");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("welcome123");
		driver.findElement(By.xpath("//input[@type='submit' and @name='continue']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Redirect')]")).click();
		
		driver.findElement(By.xpath("//*[starts-with(@name,'Google')]")).click();
	}

}
