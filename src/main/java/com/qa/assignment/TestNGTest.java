package com.qa.assignment;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest {

	WebDriver driver = null;
	
	@BeforeClass
	
	public void launchbrower()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Launch browser");
		
	}
	
	@BeforeMethod
	public void AllCategories() throws Exception
	{
		System.out.println("Verify the Categories:");
		driver.get("https://www.amazon.in");
		Thread.sleep(20000);
		driver.manage().window().maximize();
		// driver.findElements(By.xpath('//option[text()='All Categories']');
		Thread.sleep(2000);
		List<WebElement> ele = driver.findElements(By.xpath("//select/option"));
		int sizeee = ele.size();
		for (int i = 0; i < sizeee; i++) {
			WebElement text = ele.get(i);
			String element = text.getText();
			System.out.println("All The Categories in List : " + element);
			if (element.equals("Books")) {
				System.out.println(element);
				text.click();
			}
		}	
	
	}

	@Test
	public void SelectBooks()
	{
		System.out.println("Select the books Categories:");
		List<WebElement> ele = driver.findElements(By.xpath("//select/option"));
		int sizeee = ele.size();
		for (int i = 0; i < sizeee; i++) {
			WebElement text = ele.get(i);
			String element = text.getText();
						if (element.equals("Books")) {
				System.out.println(element);
				text.click();
	}
	
		}
	}
	@Test(dependsOnMethods = {"SelectBooks"})
	
	public void clickFirstLink() throws Exception
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("data");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		for (int j = 1; j <= 1; j++) {

			String firstpath = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div[" + j
					+ "]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span";

			driver.findElement(By.xpath(firstpath)).click();
		}
		System.out.println(driver.getTitle());

		System.out.println();
	}
	
	// if SelectBooks failed  clickFirstLink will be skipped
	//if SelectBooks passed clickFirstLink will run
	
	@AfterMethod
	public void PrintAllDetails()
	{
		System.out.println();
	}
	
	@AfterClass
	public void quitBrowser()
	{
		System.out.println("Quit the browser:");
	}

}
