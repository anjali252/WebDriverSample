package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().window().maximize();
		
		Select singleSel=new Select(driver.findElement(By.id("select-demo")));
		singleSel.selectByVisibleText("Monday");
//		singleSel.deselectByVisibleText("Monday");
		
		Select multiSel=new Select(driver.findElement(By.id("multi-select")));
		if(multiSel.isMultiple()) {
			multiSel.selectByIndex(1);
			multiSel.selectByValue("New York");
			multiSel.selectByVisibleText("Texas");
			System.out.println("No of selected options : "+multiSel.getAllSelectedOptions().size());
			
			
		}
	}
}
