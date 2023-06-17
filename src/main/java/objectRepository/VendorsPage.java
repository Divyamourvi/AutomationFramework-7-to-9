package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {

	//Declaration
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createVendorLookUpImg;
	
	//Initialization
	
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	

	
	//Utilization

	public WebElement getCreateVendorLookUpImg() {
		return createVendorLookUpImg;
	}
	
	//Bussiness Logic
	public void clickonVendorLookUpImg() {
		createVendorLookUpImg.click();
	}

	
	
}
