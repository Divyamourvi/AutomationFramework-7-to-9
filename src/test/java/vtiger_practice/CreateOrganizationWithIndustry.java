package vtiger_practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;



public class CreateOrganizationWithIndustry {

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

		String ORGNAME = eUtil.readDataFromExcelFile("organization",5,2)+jUtil.getRandomNumber();
		String INDUSTRY=eUtil.readDataFromExcelFile("Organization",5,3);



		//Step 1: launch the browser   Run Time polymorphism
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

		//Step 2: Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login successful");

		//Step 3: Click on Organizations link
		driver.findElement(By.linkText("Organizations")).click();

		//Step 4: Click on Create Org Look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		//Step 5: Create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		//Step 6: Choose 'Chemicals' on Industry drop-down
		WebElement industrydropdown = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(industrydropdown,INDUSTRY);
		

		//Step 7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step 8: Validate
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

		//Step 9: Logout of App
		WebElement adImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseOverAction(driver, adImg);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout is scuccessful");


	}

}
