package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.chercher.tech/practice/frames");
		driver.manage().window().maximize();
		
		WebElement label=driver.findElement(By.xpath("//label/span"));
		System.out.println("Label text : "+label.getText());
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Topic");
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("New Topic");
		
		driver.switchTo().defaultContent();
		System.out.println("Again get label : "+driver.findElement(By.xpath("//label/span")).getText());
	}
}
