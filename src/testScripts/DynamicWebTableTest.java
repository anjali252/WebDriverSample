package testScripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableTest {

	static WebDriver driver;

	public static void main(String[] args) throws IOException{
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Libs_Workshop/b.html");
		driver.manage().window().maximize();
//		we are accessing the html table and try to access all the elements in a single row12:15
//		like check the check box and get the price of an item12:16
//		with preceding-sibling and following-sibling1
		
		driver.findElement(By.xpath("//td[contains(text(),'Keyboard')]//preceding-sibling::td//input")).click();
		
		TakesScreenshot screen=(TakesScreenshot)driver;
		File srcFile=screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File ("E:\\Libs_Workshop\\Screenshot\\Screenshot1.png"));
	}

}
