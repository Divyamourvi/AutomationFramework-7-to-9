package vtiger_ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrgnizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformPage;
import objectRepository.OrganizationPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups="SmokeSuite")
	public  void createContactWithOrg() throws EncryptedDocumentException, IOException {


		String LASTNAME=eUtil.readDataFromExcelFile("Contact", 1, 2)+jUtil.getRandomNumber();
		String ORGNAME = eUtil.readDataFromExcelFile("Organization",5,2)+jUtil.getRandomNumber();
		wUtil.ImplicitWaiting(driver);
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
	
		//Click on  organization link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Click on OrganizationLookup img
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();

		//Create new Organization
		CreateNewOrgnizationPage cno=new CreateNewOrgnizationPage(driver);
		cno.createNewOrganization(ORGNAME);
		
		
		//Validate for Organization
		OrganizationInformPage oin=new OrganizationInformPage(driver);
		String orgHeader=oin.getHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		
		//Navigate to contacts link

		hp.clickOnContactLink();

		//Click on create contact lookup image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnContactsLookUpImg();

		//Create Contact with mandatory fields
		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		cnc.createNewContact(driver, LASTNAME, ORGNAME);
		
		
		//Validate of organization
		ContactInfoPage cin=new ContactInfoPage(driver);
		String contactHeader=cin.getHeader();
		Assert.assertTrue(contactHeader.contains(LASTNAME));

	}
}

