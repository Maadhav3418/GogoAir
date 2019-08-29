package com.amazon.qa.pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class AmazonHomePage extends TestBase {
public static TestBase base;
	String element;
	BooksContentPage booksContentPage;
	
	//PageFactory or Object Repository in AmazonHomepage 

	@FindBy(xpath ="//select/option")
	//WebElement   AllOptions;
	List<WebElement>   AllOptions;
	@FindBy(id ="twotabsearchtextbox")
	WebElement searchText;
	
	@FindBy(xpath ="//input[@id='twotabsearchtextbox']")
	WebElement textBox;
	
	// To initialize the all the current page factory objects
	
	public AmazonHomePage() throws IOException {

		PageFactory.initElements(driver,this); 
		
	}
	
	//Actions
	public void validatePageTitle()
	{
		base=new TestBase();
		base.title();
	
	}
	
	public String getAllOptions()	{
	
		int sizeee = AllOptions.size();
		for (int i = 0; i < sizeee; i++)
			{
				WebElement text = AllOptions.get(i);
			    element = text.getText();
				System.out.println("All The Categories in List : " + element);
		      }
		
		return element;
 }
	public String SelectBooks()
	{
		int sizeee = AllOptions.size();
		for (int i = 0; i < sizeee; i++)
			{
				WebElement text = AllOptions.get(i);
			    element = text.getText();
			    if (element.equals("Books")) {
					System.out.println(element);
					text.click();
		      }
			}
		return element;
	}
	public String EnterData() throws Exception
	{
		textBox.sendKeys("data");
		textBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return null ;

	}
	
	
	
}
