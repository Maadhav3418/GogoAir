package com.qa.assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonHomePageLinks {
	int num=0;
	 Actions action;
		WebDriver driver;
	@BeforeClass
    public void setup(){
       	System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		 driver.manage().window().maximize();
    }
	
	@Test
	public void links()
	{
		
		List<WebElement> li=driver.findElements(By.tagName("a"));
		System.out.println(li.size());
		
		for(WebElement ele:li)
		{
			//num=num++;
			System.out.println(" = "+ele.getText());
		}
	}
		@Test(dependsOnMethods="links")
		public void BrokenLinks() throws MalformedURLException, IOException
		{
			System.out.println("+++++++++++++++++++++++++++ Broken Links +++++++++++++++++ ");
			//1.get the list of all the links and images
			 List<WebElement> links = driver.findElements(By.tagName("a"));

			links.addAll(driver.findElements(By.tagName("img")));
			System.out.println("Size of the links and Images :" +links.size());
			List<WebElement> activeLinks = new ArrayList<WebElement>();
			//2.Iterate the links exclude all the links/images -doesnt have any href attribute
			for (int i=0;i<links.size();i++)
			{
				if (links.get(i).getAttribute("href")!=null &&(!links.get(i).getAttribute("href").contains("javascript"))&&(!links.get(i).getAttribute("href").contains("help.crmpro.com")))
				{
					activeLinks.add(links.get(i));
				}
			}

			System.out.println("Size of ActiveLinks and Images:"+activeLinks.size() );

			//3. check for the href URL
			for (int j=0;j<activeLinks.size();j++) {
				HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
				connection.connect();
				 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
				String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+ "---->"+ response);
				}
			
			}
		
		@Test()
		public void searchProduct()
		{
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smart tv");
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
			WebElement samsung = driver.findElement(By.xpath("//li[@id=\"p_89/Samsung\"]/span/a[1]/div[1]"));
			samsung.click();
			
			WebElement smarttv=driver.findElement(By.xpath("//li[@id=\"p_n_feature_five_browse-bin/6928153011\"]/span/a[1]/div[1]/label/input[1]"));
			smarttv.click();
			
			WebElement smarttvsize=driver.findElement(By.xpath("//li[@id=\"p_n_size_browse-bin/3578043011\"]/span/a[1]/div[1]/label/input[1]"));
			smarttv.click();
		}

}
	


	
	

