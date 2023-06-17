package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	//make it public bcz it can als be used in child class which inherits this base class
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	
	public WebDriver driver=null;
	
	public static WebDriver sDriver;

	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig() {
		System.out.println("------DB Connection Sucessfull----");
	}
	
	@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
	public void bcConfig() throws Throwable {
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+"------->Launched   ");
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+"------->Launched   ");
		}
		else
			System.out.println("Invalid browser name");
	
		sDriver=driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

	}
	
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws Throwable {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("-----Login Succesfull");
	}
	
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void amConfig() {
		HomePage hp=new HomePage(driver);
		hp.clickOnSignOut(driver);
		System.out.println("---Logout sucsessfull");
		
	}
	

	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void acConfig() {
		driver.quit();
		System.out.println("------Browser closed-------");
	
	}
	
		@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
		public void asConfig() {
			System.out.println("------DB Connection closed");
		}
		
		
	}

