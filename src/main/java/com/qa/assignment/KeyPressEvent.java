//Non-Logged in Scenario

package com.qa.assignment;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
	import org.testng.annotations.Test;

	@Test
	public class KeyPressEvent {
		WebDriver driver;
		//Actions action= new Actions(driver);
		public void getAllCategories() throws Exception
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Softwares\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.amazon.in");
			// Thread.sleep(20000);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));  
			List<WebElement> li = dropdown.getOptions();
			int itemcount=li.size();
			for(int i = 0; i<=itemcount-1;i++)
			{
				System.out.println("" + li.get(i).getText());
				String AllLi = li.get(i).getText();
		  }
		}
		@Test(dependsOnMethods="getAllCategories")
			public void seleckBooks()
			{
				Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));  
				List<WebElement> li = dropdown.getOptions();
				int itemcount=li.size();
				for(int i = 0; i<=itemcount-1;i++)
				{
					WebElement text = li.get(i);
					System.out.println("" + li.get(i).getText());
					String AllLi = li.get(i).getText();
				if (AllLi.equals("Books"))
				{
					System.out.println(AllLi);
					text.click();
				}
			}

		}
		@Test(dependsOnMethods="seleckBooks")
			public void searchBook() throws Exception
			{
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("data");
				driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
				for (int j = 1; j <= 1; j++) {
				String firstpath = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div[" + j
							+ "]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span";
					driver.findElement(By.xpath(firstpath)).click();
					Thread.sleep(4000);
					ArrayList<String> arr = new ArrayList<String>(driver.getWindowHandles());
					System.out.println(arr.size());
					driver.switchTo().window(arr.get(1));
					System.out.println(driver.getTitle());
					Thread.sleep(4000);
					//To Handle WindowPopUP
					Robot rb = new Robot();
					rb.keyPress(KeyEvent.VK_ESCAPE);
					rb.keyRelease(KeyEvent.VK_ESCAPE);

				  }
			}
			
		@Test(dependsOnMethods="searchBook")
			public void addToCart() throws Exception
			{try {
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("window.scrollBy(0,1000)");
				driver.findElement(By.xpath("//input[@name='submit.add-to-cart' and @id='add-to-cart-button']")).isEnabled();
				driver.findElement(By.xpath("//input[@name='submit.add-to-cart' and @id='add-to-cart-button']")).isDisplayed();
				System.out.println("add to cart webelement is displaying");
				Thread.sleep(2000);
				//To Perform Add to Card
			WebElement add=driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']"));
			add.click();
			Thread.sleep(2000);
			System.out.println("Prodcut Added to Card");
			driver.navigate().refresh();
			//To Get the Add to Card Count 
			WebElement cartcountbdforeadded = driver.findElement(By.xpath("//a[@id='nav-cart']"));
			cartcountbdforeadded.getText();
			String initialcartcount=cartcountbdforeadded.getText();
			System.out.println("Cart count"+initialcartcount);
			}catch(ElementNotVisibleException e)
			{
				e.printStackTrace();
			}
			
			}
		@Test(dependsOnMethods="addToCart")
				public void proceedToPayment() throws Exception
				{
			WebElement proceed =driver.findElement(By.id("hlb-ptc-btn-native"));
			proceed.click();
			Thread.sleep(2000);
			System.out.println(" Payment Proceed :" + proceed);
		}
		
		@Test(dependsOnMethods="proceedToPayment")
		public void CreateAmazonAccount()
		{
			WebElement create = driver.findElement(By.id("createAccountSubmit"));
			create.click();
			System.out.println("User in Create Account Page :" + create);
			WebElement name =driver.findElement(By.id("ap_customer_name"));
			name.sendKeys("NarasimhaNaidu");
			WebElement number =driver.findElement(By.name("email"));
			number.sendKeys("7658995399");
			WebElement password =driver.findElement(By.xpath("//input[@class='a-input-text a-span12 auth-required-field auth-require-fields-match auth-require-password-validation']"));
			password.sendKeys("@Helpme123");
			WebElement submitt =driver.findElement(By.xpath("//input[@type='submit']"));
			submitt.click();
			System.out.println(" User Account Creating Completed:");
		}
		
		
}
