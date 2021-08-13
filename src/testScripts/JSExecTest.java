package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String jsTitle = js.executeScript("return document.title").toString();	//get the page title
		System.out.println("Page Title Using JSE : " + jsTitle);

//		driver.findElement(By.xpath("//*[@class='form-control input-lg']")).sendKeys("Phone");
		
		WebElement searchBox=(WebElement) js.executeScript("return document.getElementsByClassName('form-control input-lg')[0]");
		searchBox.sendKeys("phone");
		
		driver.findElement(By.xpath("//*[@class='fa fa-search']")).click();
		
//		js.executeScript("window.scrollBy(500,900)");	//page scroll
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); //page scroll to the height of the page
		js.executeScript("history.go(-1)");	//go backward
		js.executeScript("history.go(1)");	//navigate forward
		
driver.get("http://demo.automationtesting.in/Datepicker.html");
js.executeScript("document.querySelector('#datepicker1').value='30/07/2021'");
//datePicker.sendKeys("07/01/2021");


	}
}
