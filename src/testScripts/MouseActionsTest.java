package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsTest {
	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.get("https://stqatools.com/demo/DoubleClick.php");
		driver.manage().window().maximize();
		
		Actions actions=new Actions(driver);
//		WebElement btn=driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
//		actions.doubleClick(btn).perform();
//		actions.doubleClick(btn).doubleClick(btn).build().perform();
//		actions.contextClick(btn).perform();
		
		driver.get("https://demo.opencart.com/");
		WebElement menu=driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[4]"));
		actions.moveToElement(menu).perform();
		WebElement monitor=driver.findElement(By.xpath("//a[contains(text(),'Monitors')]"));
		actions.moveToElement(monitor).click().build().perform();
	}
}
