package com.amazon.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;
//import com.amazon.qa.testcases.BooksContent;

public class BooksContentPage extends TestBase {
	String arry;
	ArrayList<String> arr;
	@FindBy(xpath ="(//span[starts-with(@class,'a-size-medium a-color-base a-text-normal')])[1]")
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
