package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupWindowTest {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.stqatools.com/demo/Windows.php");
		driver.manage().window().maximize();
		String parentWin=driver.getWindowHandle();
		System.out.println("Parent Window : "+parentWin);
		driver.findElement(By.xpath("//button[contains(text(),'Tab')]")).click();
		Set<String> tabs=driver.getWindowHandles();
		System.out.println("Number of tabs : "+tabs.size());
		for(String i:tabs) {
			System.out.println(i);
			if(!i.equalsIgnoreCase(parentWin)) {
				driver.switchTo().window(i);
				driver.findElement(By.xpath("(//span[@class='menu-text'])[1]")).click();
			}
			
		}
		driver.close();
		driver.switchTo().window(parentWin);
		driver.findElement(By.xpath("//button[contains(text(),'new Window')]")).click();
		tabs=driver.getWindowHandles();
		for(String i:tabs) {
			System.out.println(i);
			if(!i.equalsIgnoreCase(parentWin)) {
				driver.switchTo().window(i);
				driver.findElement(By.xpath("(//button[@class='btn btn-info'])[3]")).click();
			}			
		}
		driver.close();
		driver.quit();
	}
}
