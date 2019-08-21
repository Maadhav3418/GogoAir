package com.amazon.qa.testcases;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.AmazonHomePage;
import com.amazon.qa.pages.BooksContentPage;

public class BooksContentPageTest extends TestBase {

	BooksContentPage booksContentPage;
	
	
	@Test
	public String allInfo()
	{
		String info = booksContentPage.BooksContentPages();
		System.out.println("The Basic Info of the book:" + info);
		return info;
	}

@Test
public void Title()
{
String tit = booksContentPage.Title();
System.out.println("The Title of the Page:" + tit);
}


}