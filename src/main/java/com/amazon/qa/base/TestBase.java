package com.amazon.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.amazon.qa.utilities.TestUtilities;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	

public static void TestBase() throws IOException
{ 
	try {
		prop = new Properties();
FileInputStream ip = new FileInputStream("src/main/java/com/amazon/qa/configuration/configuration.properties");
	prop.load(ip);
	    } catch (FileNotFoundException e)
     {
	e.printStackTrace();	
     }

  }


//To read Browser and URL from properties file

public static void initialization(String browserName) throws InterruptedException, IOException
{

	if(browserName.equals(prop.getProperty("browser"))) {
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(2000);
	}
	else if (browserName.equals(prop.getProperty("browser")))
		{
			System.setProperty("webdriver.firefox.driver","D:\\Documents\\Softwares\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
			
	else {
		System.out.println("No Browser Value Specified");
	    }
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	}
	public void title() {
		String t=driver.getTitle();
		System.out.println(t);
		
	}
//quits browser
	public static void quit()
	{
		driver.quit();
	}

}