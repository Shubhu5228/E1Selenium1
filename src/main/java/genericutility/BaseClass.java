package genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {
	
		
		public WebDriver driver;
		public static WebDriver sDriver;				 // only for listeners
		public SeleniumUtility sUtil = new SeleniumUtility();
		public PropertiesUtility pUtil = new PropertiesUtility();
		public ExcelUtility eUtil = new ExcelUtility();
		public JavaUtility jUtil = new JavaUtility();
		
		
		@BeforeSuite(alwaysRun = true)
		public void dbConnection()
		{
			System.out.println("DB Connection Created");
		}
		
		@Parameters("browser")
		@BeforeClass(alwaysRun = true)
		public void launchBrowser(@Optional("chrome") String BROWSER) throws Exception
		{
			if(BROWSER.equals("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equals("edge"))
			{
				driver = new EdgeDriver();
			}
			else if(BROWSER.equals("brave"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				driver = new ChromeDriver();
			}
			
			sDriver=driver;  //the sDriver is initialized which will be used in Listeners
			sUtil.implicitwait(driver, 15);
			sUtil.maximizeWindow(driver);
			String URL = pUtil.getDataFromPropertiesFile("url");
			sUtil.navigateToUrl(driver, URL);
			System.out.println("Browser launched successfully");
		}
		
		@BeforeMethod(alwaysRun = true)
		public void loginOperation() throws Exception 
		{
			String UN = pUtil.getDataFromPropertiesFile("username");
			String PWD = pUtil.getDataFromPropertiesFile("password");
			LoginPage lp = new LoginPage(driver);
			lp.loginToApplication(UN, PWD);
			System.out.println("Login done successfully");
		}
		
		@AfterMethod(alwaysRun = true)
		public void logoutOperation()
		{
			HomePage hp = new HomePage(driver);
			hp.signoutOperation(driver);
			System.out.println("SignOut done successfully");
		}
		
		@AfterClass(alwaysRun = true)
		public void closeBrowser()
		{
			driver.quit();
			System.out.println("Browser closed successfully");
		}
		
		@AfterSuite(alwaysRun = true)
		public void closeDBConnection()
		{
			System.out.println("DB connection closed");
		}
}
