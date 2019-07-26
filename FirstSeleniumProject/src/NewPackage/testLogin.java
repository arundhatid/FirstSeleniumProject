package NewPackage;
import Utility.Constants;
//import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.Reporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver.*;
import org.openqa.selenium.support.ui.WebDriverWait;


public class testLogin {
  
	//declare variables
	
	String baseURL = Constants.URL;
	String actualTitle = "";
	String expectedTitle = Constants.sExpectedURLTitle;
	WebDriver driver;
	String sUserName = Constants.sUserName;
	String sPassWd = Constants.sPassword;
	String sActualLoginTitle = "";
	SoftAssert softAssertion = new SoftAssert();
	
	@Test
	public void launchDriver()
	{
		actualTitle = driver.getTitle();
		System.out.println("actualTitle is:" + actualTitle);
		Reporter.log("actualTitle is:" + actualTitle);
		
		
		//Assert.assertEquals(expectedTitle, actualTitle);
		softAssertion.assertEquals(expectedTitle, actualTitle);
		
		softAssertion.assertAll();	
		
		//return driver;
	} 
	
	@Test
	public void verifyLogin()
	{
		driver.findElement(By.name("uid")).sendKeys(sUserName);
		Reporter.log("Username is:" + sUserName);
		driver.findElement(By.name("password")).sendKeys(sPassWd);
		Reporter.log("Password is:" + sPassWd);
		driver.findElement(By.name("btnLogin")).click();
		Reporter.log("Login Button Click");
		try
		{
			sActualLoginTitle = driver.getTitle();
			softAssertion.assertEquals(Constants.sExpectedLoginTitle,sActualLoginTitle);
		}
		catch(Exception e)
		{
			//Reporter.("Unhandled Exception");
			Reporter.log("Unhandled window appeared");
			softAssertion.assertTrue(false);
			//softAssertion.fail("Unhandled Exception", e.getCause());
		}
		System.out.println("This is test");
		softAssertion.assertAll();
		
	}
	
	@BeforeClass
	public void beforeClass() 
	{		
		System.setProperty("webdriver.chrome.driver", Constants.sDriverLocation);
		driver = new ChromeDriver();
		WebDriverWait myWaitVar = new WebDriverWait(driver,10);		
		//launch website
		driver.get(baseURL);			
	}
	@BeforeMethod
	public void beforeMethod()
	{
		softAssertion.assertEquals(Constants.URL, driver.getCurrentUrl());
		softAssertion.assertAll();	
		System.out.println("Website is launched successfully");
	}
	@AfterClass
	public void afterClass() 
	{
		//verify title
		
		
		/*if( actualTitle.equals(expectedTitle))
		{
			System.out.println("Website Launched");
		}
		else
		{
			System.out.println("Launch Failed");
		}*/
		//close driver
		//driver.quit();
	}
	
}
		

