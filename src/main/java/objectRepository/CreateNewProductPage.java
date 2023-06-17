package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewProductPage  extends WebDriverUtility{

	@FindBy(name="productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//input[@name='vendor_name']/following-sibling::img[@alt='Select']")
	private WebElement selectVendorLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchVendorName;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	//Initializaton
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	
	
	//Utilization
	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSearchVendorName() {
		return searchVendorName;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getSelectVendorLookUpImg() {
		return selectVendorLookUpImg;
	}

	//Bussiness Logic

	public void createNewProductName(WebDriver driver,String PRODUCTNAME,String VENDORNAME) {
		productNameEdt.sendKeys(PRODUCTNAME);
		selectVendorLookUpImg.click();
		switchToWindow(driver,"Vendors");
		searchVendorName.sendKeys(VENDORNAME);
		searchbtn.click();
		driver.findElement(By.xpath("//a[.='"+VENDORNAME+"']")).click();
		switchToWindow(driver,"Products");
		SaveBtn.click();
	}
	
	
}

