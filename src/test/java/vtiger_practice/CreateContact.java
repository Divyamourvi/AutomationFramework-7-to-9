package vtiger_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws Throwable {

		//create all the objects of all utilities
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();


		WebDriver driver=null;

		//Read all the required data
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME=eUtil.readDataFromExcelFile("Contact", 1, 2)+jUtil.getRandomNumber();

		//Step 1: launch the browser   Run Time polymorphism
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

		//Step 2:Login to the application with valid credentials
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login successful");

		//Step 3:Navigate to Contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		//Step 4:Click on create contact lookup image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		//Step 5:Create Contact with mandatory fields
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		//Step 6: Save
		driver.findElement(By.name("button")).click();


		//Step 7:Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(LASTNAME)) {
			System.out.println(contactHeader);
			System.out.println("Test Script Passed");
		}
		else
			System.out.println("FAIL");

		//Step 8:Logout of application
		WebElement adImg = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wUtil.mouseOverAction(driver, adImg);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("Logout successfull");
		driver.close();
	}
}