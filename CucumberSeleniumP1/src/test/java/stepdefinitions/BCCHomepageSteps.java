package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.*;
public class BCCHomepageSteps{
	
	public static WebDriver driver;
	
	
	//hooks
	@Before	
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(Scenario scenario) throws Exception
	{
		if(scenario.isFailed())
		{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfile, new File("C:\\Selenium WebDriver\\Screenshots\\screenshot.png"));
		}
		driver.quit();
	}
	
	
	//BCCHompepage Login page
	@Given("I navigate to the BCC website")
	public void i_navigate_to_the_bcc_website() {
		driver.get("https://www.bbc.com/");
		System.out.print(driver.getTitle());
		
	}


	@When("I see homepage is displayed correctly")
	public void i_see_homepage_is_displayed_correctly() throws Exception {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//*[@icon='list-view-text']")).isDisplayed())
		{
			System.out.println("user is on Home page");
		}
		
		else if(driver.findElement(By.xpath("//iframe[@id='sp_message_iframe_1091681']")).isDisplayed())
		{
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//*[text()='I agree']")).click();
			System.out.println("frame is handled");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//*[@icon='list-view-text']")).isDisplayed();
		}
	}

	
	
	@Then("I verify top navigation links are displayed")
	public void i_verify_top_navigation_links_are_displayed() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[@data-testid='internal-link']//*[text()='News']")).click();	  
	  String newsUrl =  driver.getCurrentUrl();
	  String actualurl = "https://www.bbc.com/news";
	  Assert.assertEquals(actualurl,newsUrl);
	    driver.navigate().back();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//li[@data-testid='mainNavigationItemStyled']//*[text()='Sport']")).click();
	    String sportURL = driver.getCurrentUrl();
	    String actualSportUrl = "https://www.bbc.com/sport";
	    Assert.assertEquals(actualSportUrl,sportURL);
	    driver.navigate().back();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//li[@data-testid='mainNavigationItemStyled']//*[text()='Business']")).click();
	    String businessUrl = driver.getCurrentUrl();
	    String actualBusinessurl = "https://www.bbc.com/business";
	    Assert.assertEquals(actualBusinessurl, businessUrl);
	    
	}
	
	
	
	@When("I click on News section")
	public void i_click_on_news_section() {
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='sp_message_iframe_1091681']")));
		driver.findElement(By.xpath("//button[@title='I agree']")).click();
		driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//li[@data-testid='mainNavigationItemStyled']//a[@href='/news']")).click();
	}
	
	@Then("I verify the url")
	public void i_verify_the_url()
	{
	   String url = driver.getTitle();
	   System.out.println("news url is"+url);
	}
	

	@When("I click on search button")
	public void i_click_on_search_button() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='sp_message_iframe_1091681']")));
		//Thread.sleep(20);
		driver.findElement(By.xpath("//button[@aria-label='I agree']")).click();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//button[@class='sc-75742244-3 sc-75742244-4 eupXpe hKHSDc']")).click();
		
	WebElement str = driver.findElement((By.xpath("//input[@class='sc-e1a87ea7-1 iARAvt']")));
	str.sendKeys("Houghton Mifflin Harcourt");
				
	
	}

	@Then("I verify the search results for {string}")
	public void i_verify_the_search_results_for(String string) 
	{
		if(driver.getPageSource().contains(("Houghton Mifflin Harcourt)")))
		{
			System.out.println("entered text is present");
		}
		else
		{
			System.out.println("entered text is not visible");
		}
   
	}
	
	
}
