package com.amazon.qa.testcases;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.AmazonHomePage;
import com.amazon.qa.pages.BooksContentPage;
import com.relevantcodes.extentreports.LogStatus;


public class AmazonHomePageTest extends TestBase {
	
	//ExtentReporterNG obj = new ExtentReporterNG();

	AmazonHomePage amazonHomePageTest;
	BooksContentPage booksContent;
	public static TestBase testbase;

	public AmazonHomePageTest() throws IOException {
		super();
		
	}
	

@BeforeClass(alwaysRun=true)
public void setUp() throws IOException, Exception
	{
	
	TestBase();
	initialization("chrome");
	amazonHomePageTest = new AmazonHomePage();
	
	}


/*@Test
public void validatePageTitle()
{
	
	
	String title = amazonHomePageTest.title();
	//assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	
}*/

@Test()
public void AllOptions()
{

	String Options = amazonHomePageTest.getAllOptions();
	System.out.println("All The Categories in List : " + Options);
	/*ExtentReportListener.LogStatus.info("All The Categories in List : " + Options);
	ExtentReportListener.LogStatus.pass("All Options Displayed");*/
}

@Test(dependsOnMethods="AllOptions")
public void SelectBooks()
{
	
	String books= amazonHomePageTest.SelectBooks();
	System.out.println("Books Catrgorie Selected");
	/*ExtentReportListener.LogStatus.pass("All Options Displayed");*/
}

@Test(dependsOnMethods="SelectBooks")
public void EnterData1() throws Exception
{
	
	String enter = amazonHomePageTest.EnterData();
	System.out.println("Data Entered");
/*	ExtentReportListener.LogStatus.info("Data Entered");
	ExtentReportListener.LogStatus.pass("All Options Displayed");*/
	allInfo();
	getTitle();
}

@Test(dependsOnMethods="EnterData1")
public String allInfo() throws IOException
{
	booksContent=new BooksContentPage();
	String info = booksContent.BooksContentPages();
	/*ExtentReportListener.LogStatus.info("The Basic Info of the book:" + info);*/
	return info;
}

@Test
public void getTitle()

{
ArrayList<String> list = booksContent.Windowhandles();
System.out.println("Switching to window" + list);

}

@AfterClass(alwaysRun=true)
public void getrepotr()
{
	/*ExtentReportListener.LogStatus.info("Execution Completed");*/
	driver.quit();
}
}


