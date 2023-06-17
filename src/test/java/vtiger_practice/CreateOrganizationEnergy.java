package vtiger_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationEnergy {

	public static void main(String[] args) throws Throwable {

		//Creating all the objects og utilities
		ExcelFileUtility eUtil=new ExcelFileUtility();
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();


		WebDriver driver=null;

		//Read all the required data 
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD= pUtil.readDataFromPropertyFile("password");
		String ORGNAME = eUtil.readDataFromExcelFile("Organization",6,2)+jUtil.getRandomNumber();
		String INDUSTRY=eUtil.readDataFromExcelFile("Organization",6,3);
		String TYPE=eUtil.readDataFromExcelFile("Organization", 6,4);

		//Launch the browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+"------->Launched   ");
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+"------->Launched   ");
		}
		else
			System.out.println("Invalid browser name");


		//Login to application with valid credentials
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login successful");

		//Click on Organizations link
		driver.findElement(By.linkText("Organizations")).click();

		//Click on Create Org Look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		//Create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		//Choose 'Energy' on Industry drop-down
		WebElement industrydropdown = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(industrydropdown,INDUSTRY);

		//Choose 'Customers' on Type drop-down
		WebElement typedropdown = driver.findElement(By.name("accounttype"));
		wUtil.handleDropDown(typedropdown,TYPE);

		// Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("Test Script Passed");
		}
		else
		{
			System.out.println("FAIL");
		}

		// Logout of App
		WebElement adImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseOverAction(driver, adImg);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout is scuccessful");

	}
}



