package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSuite01 {

	@Test
	public void test1() {
		String path="C:\\Users\\varka\\eclipse-workspace\\Project_j-unit\\target\\Execution_Report.html";
		ExtentReports report = new ExtentReports(path);
		ExtentTest test = report.startTest("Flipcart Page");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser Launched");
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		test.log(LogStatus.INFO, "App Invoked");

		driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input"))
				.sendKeys("mobiles");
		test.log(LogStatus.INFO, "Selected Element");

		driver.findElement(By.cssSelector(
				"#container > div > div.q8WwEU > div > div > div > div > div:nth-child(1) > div > div.css-175oi2r.r-13awgt0.r-1iqfa7g.r-60vfwk > div > div._2nl6Ch > div._2NhoPJ > header > div._3ZqtNW > div._3NorZ0._3jeYYh > form > div > button > svg"))
				.click();
		test.log(LogStatus.INFO, "Clicked Element");
		String price = driver
				.findElement(By.xpath(
						"(//img[@class=\"DByuf4\"])[position()=1]/../../../../..//div[@class=\"Nx9bqj _4b5DiR\"]"))
				.getText();
		test.log(LogStatus.INFO, "Captured Text of an Element");
		System.out.println(price);
		test.log(LogStatus.INFO, "Printed Price of an Element");
		driver.quit();
		test.log(LogStatus.INFO, "Closed Browser");
		report.endTest(test);
		report.flush();
		report.close();
		

	}

}
