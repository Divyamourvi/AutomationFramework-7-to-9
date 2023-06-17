package vtiger_OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrgnizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformPage;
import objectRepository.OrganizationPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateOrgWithIndustryTest extends BaseClass {
	
	@Test(groups="SmokeSuite")
	public void createOrgWithIndustry() throws EncryptedDocumentException, IOException {

		String ORGNAME = eUtil.readDataFromExcelFile("organization",5,2)+jUtil.getRandomNumber();
		String INDUSTRY=eUtil.readDataFromExcelFile("Organization",5,3);
		
		wUtil.ImplicitWaiting(driver);
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);

		// Click on Organizations link
		HomePage hp=new HomePage(driver);
				hp.clickOnOrganizationLink();
				Reporter.log("Click on organization link",true);

		// Click on Create Org Look Up Image
		OrganizationPage op=new OrganizationPage(driver);
				op.clickOnCreateOrgLookUpImg();
				Reporter.log("Click on create org lookup img ",true);

		// Create Organization with mandatory fields
		CreateNewOrgnizationPage np=new CreateNewOrgnizationPage(driver);
		np.createNewOrganization(ORGNAME, INDUSTRY);
		Reporter.log("Organization created with industry",true);

		// Choose 'Chemicals' on Industry drop-down
		WebElement industrydropdown = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(industrydropdown,INDUSTRY);
		

		// Validate
		OrganizationInformPage info=new OrganizationInformPage(driver);
		String orgHeader= info.getHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));

	}

}

