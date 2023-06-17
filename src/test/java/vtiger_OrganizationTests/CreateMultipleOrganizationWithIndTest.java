package vtiger_OrganizationTests;

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
import objectRepository.CreateNewOrgnizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformPage;
import objectRepository.OrganizationPage;

public class CreateMultipleOrganizationWithIndTest extends BaseClass {

	
	
	@Test(dataProvider="getData")
	public void createOrgTest(String ORG,String INDUSTRY) throws Throwable {
		
				String ORGNAME=ORG+jUtil.getRandomNumber(); //bcz we need different organization name
				WebDriver driver=null;
				wUtil.ImplicitWaiting(driver);
				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				
				
				// Click on Organizations link
				HomePage hp=new HomePage(driver);
						hp.clickOnOrganizationLink();

				// Click on Create Org Look Up Image
				OrganizationPage op=new OrganizationPage(driver);
						op.clickOnCreateOrgLookUpImg();

				// Create Organization with mandatory fields
				CreateNewOrgnizationPage np=new CreateNewOrgnizationPage(driver);
				np.createNewOrganization(ORGNAME, INDUSTRY);

				// Choose 'Chemicals' on Industry drop-down
				WebElement industrydropdown = driver.findElement(By.name("industry"));
				wUtil.handleDropDown(industrydropdown,INDUSTRY);
				

				// Validate
				OrganizationInformPage info=new OrganizationInformPage(driver);
				String orgHeader= info.getHeader();
				Assert.assertTrue(orgHeader.contains(ORGNAME));

	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		return eUtil.readMultipleData("DataProviderOrg");
	}
}
