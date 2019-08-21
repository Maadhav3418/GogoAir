package com.amazon.qa.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class AmazonHomePageTest extends TestBase {

	AmazonHomePage amazonHomePageTest;
	BooksContentPage booksContent;

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

@Test
public void validatePageTitle()
{
	//System.out.println("Title is : "+driver.getTitle());
	String title = amazonHomePageTest.validatePageTitle();
	//assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
}

@Test(dependsOnMethods="validatePageTitle")
public void AllOptions()
{
	String Options = amazonHomePageTest.getAllOptions();
	System.out.println("All The Categories in List : " + Options);
}

@Test(dependsOnMethods="AllOptions")
public void SelectBooks()
{
	String books= amazonHomePageTest.SelectBooks();
	System.out.println("Books Catrgorie Selected");
}

@Test(dependsOnMethods="SelectBooks")
public void EnterData1() throws Exception
{
	String enter = amazonHomePageTest.EnterData();
	System.out.println("Data Entered");
	
	allInfo();
	getTitle();
}


private String allInfo() throws IOException
{
	booksContent=new BooksContentPage();
	
	String info = booksContent.BooksContentPages();
	System.out.println("The Basic Info of the book:" + info);
	return info;
}


private void getTitle()
{
ArrayList<String> list = booksContent.Windowhandles();
System.out.println("Switching to window" + list);
String tit = booksContent.Title();
System.out.println("The Title of the Page:" + tit);

}
}
