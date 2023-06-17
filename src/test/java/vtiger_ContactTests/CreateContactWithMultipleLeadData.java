package vtiger_ContactTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactWithMultipleLeadData extends BaseClass {

	
	
	@Test(dataProvider="getData")

	public void createContactWithLead(String LAST,String LEADSOURCE) throws Throwable {
		
		String LASTNAME=LAST+jUtil.getRandomNumber();
		wUtil.ImplicitWaiting(driver);
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		
		//Click on Contacts in homepage
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLink();
		
		//Click on contacts Lookupimg
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnContactsLookUpImg();
		
		//Enter lastname and lead
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createNewContactWithLead(LASTNAME,LEADSOURCE );
		
		WebElement leaddropdown = driver.findElement(By.name("leadsource"));
		wUtil.handleDropDown(leaddropdown,LEADSOURCE);
		
		//Validate
		ContactInfoPage cip=new ContactInfoPage(driver);
		
			String contHeader=cip.getHeader();
			Assert.assertTrue(contHeader.contains(LASTNAME));
			
		}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		return eUtil.readMultipleData("DataProviderContact");
	}
	
}
