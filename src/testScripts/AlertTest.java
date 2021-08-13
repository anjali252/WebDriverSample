package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println("Alert Message : "+alert.getText());
		alert.accept();
		
		driver.findElement(By.xpath("(//button[@class='btn btn-default btn-lg'])[1]")).click();
		Alert confirm=driver.switchTo().alert();
		System.out.println("Confirm message : "+confirm.getText());
		System.out.println("Upadated by Tester 2 : ");
		confirm.dismiss();
		
		driver.findElement(By.xpath("(//button[@class='btn btn-default btn-lg'])[2]")).click();
		Alert confirm1=driver.switchTo().alert();
		confirm1.sendKeys("Tteexxtt");
		Thread.sleep(2000);
		System.out.println("Confirm message : "+confirm1.getText());
		confirm1.accept();
		
	}

}
