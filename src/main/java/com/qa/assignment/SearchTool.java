package com.qa.assignment;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchTool {

	private static final Exception ElementNotVisibleException = null;
	private static final WebElement text = null;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		// Thread.sleep(20000);
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
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("data");
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			for (int j = 1; j <= 1; j++) {

				String firstpath = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div[" + j
						+ "]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span";

				driver.findElement(By.xpath(firstpath)).click();
			}
			System.out.println(driver.getTitle());

			ArrayList<String> arr = new ArrayList<String>(driver.getWindowHandles());
			System.out.println(arr.size());
			driver.switchTo().window(arr.get(1));
			System.out.println(driver.getTitle());
			Thread.sleep(4000);
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ESCAPE);
			rb.keyRelease(KeyEvent.VK_ESCAPE);

			List<WebElement> firstresult = driver.findElements(By.xpath("//div[@id='dp']"));

			Thread.sleep(5000);
			for (WebElement we : firstresult) {
				try
				{
				Thread.sleep(5000);
				String e = we.getText();
				ArrayList<String> arry = new ArrayList<String>();
				arry.add("The List Elements are :" + e);
				System.out.println(arry);
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

//driver.findElement(By.xpath("//span[contains(text(),'Data Structures and Algorithms Made Easy: Data Structures and Algorithmic Puzzles')]")).click();

		}

	}
