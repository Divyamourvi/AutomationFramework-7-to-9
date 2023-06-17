package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {

	@FindBy(name="vendorname")
	private WebElement vendorNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
		

	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}

	//Utilization
	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Bussiness Logic
	
	public void createNewVendorName(String VENDORNAME) {
		vendorNameEdt.sendKeys(VENDORNAME);
		SaveBtn.click();
	}
	
	
}
