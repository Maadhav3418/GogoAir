package com.amazon.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;
//import com.amazon.qa.testcases.BooksContent;

public class BooksContentPage extends TestBase {
	String arry;
	ArrayList<String> arr;
	//public static WebDriver driver;
	public static BooksContentPage page;
	
	//PageFactory or Object Repository 
	
	@FindBy(css ="#search > div.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.s-right-column.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(4) > div.s-result-list.s-search-results.sg-row > div:nth-child(1) > div > div > div > div:nth-child(2) > div.sg-col-4-of-12.sg-col-8-of-16.sg-col-16-of-24.sg-col-12-of-20.sg-col-24-of-32.sg-col.sg-col-28-of-36.sg-col-20-of-28 > div > div:nth-child(1) > div > div > div:nth-child(1) > h2 > a")
	WebElement   FistBook;
		
	
	// To initialize the all the current page factory objects
	
	public BooksContentPage() throws IOException {
		PageFactory.initElements(driver,this); 
	}

	
	//Actions
	
	public String BooksContentPages()
		{
		try
		{
		Thread.sleep(5000);
	     arry = FistBook.getText();
		System.out.println("The List Elements are :" + arry);
		System.out.println(arry);
		
		FistBook.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arry;
	
		}
	
	
	
		
	
	public String Title()
	{
		
		return driver.getTitle();
	}
	
	public String getLink()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean VerifyText()
	{
		return driver.getPageSource().contains("Data Structures and Algorithms Made Easy: Data Structures and Algorithmic Puzzles");
	
	}
	
	public ArrayList<String> Windowhandles()
	{
		 arr = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(arr.size());
		driver.switchTo().window(arr.get(1));
		return arr;
	}
	
	
	
	
}
