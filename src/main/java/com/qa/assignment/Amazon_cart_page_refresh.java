package com.qa.assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Amazon_cart_page_refresh {
    Actions action;
	WebDriver driver;
    
	@BeforeClass
    public void setup(){
       
    	System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		 driver.manage().window().maximize();
    }
    
    @Test(priority = 0)
    public void Amazon_login(){
    	      
        WebElement ele = driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]"));
        //mouse_rover(ele);
        //driver.findElement(By.xpath("(//span[@class='nav-action-inner'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("karthiece35@gmail.com");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("karthi123");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
   @Test(dependsOnMethods = {"Amazon_login"})
    public void switch_windows(){
        String parentwindow = driver.getWindowHandle();
        System.out.println(parentwindow);
        System.out.println(driver.getTitle());
        action=new Actions(driver);
        action.keyDown(Keys.CONTROL).build().perform();
        driver.findElement(By.xpath("//a[text()='Amazon Pay']")).click();
        driver.findElement(By.linkText("Orders")).click();
        action.keyUp(Keys.CONTROL).build().perform();
    }
     @Test(dependsOnMethods ={"switch_windows"})
    public void add_to_cart(){
         System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("Max Men's Slim Casual Shirt", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal']/span)[2]")).click();
        // driver.findElement(By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div[5]/div/div/div/div[2]/div[3]/div/div[1]/div[2]/div/a/span[1]/span[2]/span[2]")).click();
/*        List<WebElement> searchlist = driver.findElements(By.xpath("//div/div/ul/li/span/div/a/div[@class='a-section octopus-pc-item-image-section octopus-pc-item-image-section-v3']"));
        for(int i=0;i<searchlist.size();i++){
           String Text = searchlist.get(i).getText();
           System.out.println(Text);
        }
         searchlist.get(0).click();*/
         System.out.println(driver.getTitle());
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         List<String> winds = new ArrayList<String>(driver.getWindowHandles());
         driver.switchTo().window(winds.get(1));
         System.out.println(driver.getTitle());
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // WebElement s = driver.findElement(By.xpath("(//select)[3]/option"));
         WebElement s = driver.findElement(By.name("dropdown_selected_size_name"));
         Select se = new Select(s);
        // List<WebElement> op = se.getOptions();
         se.selectByVisibleText("42");
         driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test(dependsOnMethods = {"add_to_cart"})
    public void switch_to_window(){
        Set<String> windows =driver.getWindowHandles();
        for (String win:windows){
            driver.switchTo().window(win);
            driver.navigate().refresh();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            System.out.println(driver.getTitle());
        }
    }
   @AfterClass
    public void logout(){
        //WebElement elem = driver.findElement(By.xpath("//span[text()='Hi karthikaiselvan']"));
       WebElement elem = driver.findElement(By.id("nav-link-accountList"));
        //mouse_move(elem);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
        driver.close();
        driver.quit();
    }
   public void mouse_rover_click(WebElement main,WebElement subMenu)
   {
	    Actions ac = new Actions(driver);
	    ac.moveToElement(main).build().perform();
	    ac.moveToElement(subMenu);
	    ac.click().build().perform();

}
}
