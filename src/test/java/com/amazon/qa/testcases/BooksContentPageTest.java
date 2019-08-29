package com.amazon.qa.testcases;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.AmazonHomePage;
import com.amazon.qa.pages.BooksContentPage;

import junit.framework.Assert;

public class BooksContentPageTest extends TestBase {

	public static BooksContentPage booksContentPage;
	public static AmazonHomePageTest apt;
	
	@Test
	public String allInfo() throws Exception
	{
		TestBase();
		initialization("chrome");
		
       apt=new AmazonHomePageTest();
		apt.AllOptions();
		apt.SelectBooks();
		apt.EnterData1();
		apt.getTitle();
		
	String info = booksContentPage.BooksContentPages();
		System.out.println("The Basic Info of the book:" + info);
		return info;
	}

@Test
public void getLink()
{
String tit = booksContentPage.getLink() ;
System.out.println("The Link of the Page:" + tit);
//Assert.assertEquals(tit, "");
}

@AfterClass(alwaysRun=true)
private void getrepotr()
{
	
	driver.quit();
}
}