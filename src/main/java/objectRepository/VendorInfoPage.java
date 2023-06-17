package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement vendorName;

	public WebElement getVendorName() {
		return vendorName;
	}
	
	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	
	public String getHeader() {
		return vendorName.getText();
		
	}
}
