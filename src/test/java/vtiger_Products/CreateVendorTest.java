package vtiger_Products;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewProductPage;
import objectRepository.CreateNewVendorPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductInfoPage;
import objectRepository.ProductsPage;
import objectRepository.VendorInfoPage;
import objectRepository.VendorsPage;

public class CreateVendorTest extends BaseClass {

	@Test
public void createVendor() throws EncryptedDocumentException, IOException {				
				String VENDORNAME=eUtil.readDataFromExcelFile("Organization",8,5)+jUtil.getRandomNumber();
				String PRODUCTNAME=eUtil.readDataFromExcelFile("Organization", 8, 6)+jUtil.getRandomNumber();

				wUtil.ImplicitWaiting(driver);
				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);

				//Navigate to More
				HomePage hp=new HomePage(driver);
				WebElement more=driver.findElement(By.partialLinkText("More"));
				hp.mouseOveronMore(driver,more);
				
				//click on Vendor
				hp.clickOnVendorLink();
				
				//click on vendors Lookup img
				VendorsPage vp=new VendorsPage(driver);
				vp.clickonVendorLookUpImg();
				
				//Create New vendor
				CreateNewVendorPage cnv=new CreateNewVendorPage(driver);
				cnv.createNewVendorName(VENDORNAME);
				
				//Validate
				VendorInfoPage vip=new VendorInfoPage(driver);
				String vendorHeader=vip.getHeader();
				Assert.assertTrue(vendorHeader.contains(VENDORNAME));
				
				
				//Navigate to Products link in home page
				hp.clickOnProductLink();
				
				
	
				//Click on Product LookUpImg in Products Page
				ProductsPage p=new ProductsPage(driver);
				p.clickOnCreateProductLookUp();
				
				//Create New Product
				CreateNewProductPage cnp=new CreateNewProductPage(driver);
				cnp.createNewProductName(driver,PRODUCTNAME,VENDORNAME);
				
				
				//validate
				ProductInfoPage pinfo=new ProductInfoPage(driver);
				String productHeader=pinfo.getHeader();
				Assert.assertTrue(productHeader.contains(PRODUCTNAME));

				}
		

	}


	
