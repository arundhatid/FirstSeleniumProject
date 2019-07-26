package NewPackage;
import Utility.Constants;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

class FirstClass
{
	public static void main(String[] args)
	{
		
		FirstClass obj = new FirstClass();
		
		WebDriver objDriver = obj.launchWebsite();
		obj.verifyLogin(objDriver);
		
	}
			
	//testcase to launch website
	public WebDriver launchWebsite() 
	{
		//declare variables
		System.setProperty("webdriver.chrome.driver", Constants.sDriverLocation);
		WebDriver driver = new ChromeDriver();
		//WebDriverWait myWaitVar = new WebDriverWait(driver,10);
		
		String baseURL = Constants.URL;
		String actualTitle = "";
		String expectedTitle = Constants.sExpectedURLTitle;
		
		//launch website
		driver.get(baseURL);
		
		actualTitle = driver.getTitle();
				
		//verify title
		if( actualTitle.equals(expectedTitle))
		{
			System.out.println("Website Launched");
		}
		else
		{
			System.out.println("Launch Failed");
		}
		return driver;
	}
	
	//testcase to verify login
	public void verifyLogin(WebDriver objDriver)
	{
		String sActualLoginTitle = "";
		//Enter Login Details
		//assertTrue(objDriver.findElement((By.name("")))
		objDriver.findElement(By.name("uid")).sendKeys(Constants.sUserName);
		objDriver.findElement(By.name("password")).sendKeys(Constants.sPassword);
		objDriver.findElement(By.name("btnLogin")).click();
		sActualLoginTitle = objDriver.getTitle();
		//System.out.println(driver.getTitle());
		//if(sActualLoginTitle.contentEquals(Constants.sExpectedLoginTitle))
		//{
		//	System.out.println("Login Passed");		
		//}
		//else
		//{
		//	System.out.println("Login Failed");
		//}
		
		
		
	}
}