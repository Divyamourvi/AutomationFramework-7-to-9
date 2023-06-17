package vtiger_Opportunities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateOpportunities  {
	public static void main(String[] args) throws Throwable {
	//Create all the object 
	ExcelFileUtility eUtil=new ExcelFileUtility();
	JavaUtility jUtil=new JavaUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();

	WebDriver driver=null;
	
	//Read all the required data
	String BROWSER=pUtil.readDataFromPropertyFile("browser");
	String URL=pUtil.readDataFromPropertyFile("url");
	String USERNAME=pUtil.readDataFromPropertyFile("username");
	String PASSWORD=pUtil.readDataFromPropertyFile("password");
	//Launch the browser
			if(BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println(BROWSER+"------->Launched   ");
			}
			else if(BROWSER.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println(BROWSER+"------->Launched   ");
			}
			else
				System.out.println("Invalid browser name");
			wUtil.maximizeWindow(driver);
			wUtil.waitForPageLoad(driver);

			driver.get(URL);

			//Login to the application
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME,PASSWORD);
			System.out.println("Login successfull");
			
			//Click on opportunities links in homepage
			HomePage hp=new HomePage(driver);
			hp.clickOnOpportunityLink();
			
			

	
	
}

}
