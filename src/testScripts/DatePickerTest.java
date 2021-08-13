package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerTest {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("datepicker")).click();
		selectDate("2022", "February", "25");
	}

	public static String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
	}

	public static void selectDate(String expYear, String expMonth, String expDate) {
		String monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println("MOnth Year Value: " + monthYearVal);
		if (expMonth.equalsIgnoreCase("february") && Integer.parseInt(expDate) > 29) {
			System.out.println("Trying to select wrong date: " + expMonth + " " + expDate);
		}
		String[] monthYear = monthYearVal.split(" ");
		while (!(monthYear[0].equals(expMonth) && monthYear[1].equals(expYear))) {
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
			monthYear = monthYearVal.split(" ");
		}
		//		String date = "//a[text()='"+expDate+"']";
		try {
			driver.findElement(By.xpath("//a[text()='\"+expDate+\"']")).click();
		} catch (Exception e) {
			System.out.println("TRying to select wrong date " + expDate);
		}
	}
}