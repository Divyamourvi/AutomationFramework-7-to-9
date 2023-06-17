package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	//Declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgLookUp;
	
	
	//Initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getCreateOrgLookUp() {
		return createOrgLookUp;
	}
	
	//Bussiness Library
	/**
	 * This method will click on create organization look up img
	 */
	public void clickOnCreateOrgLookUpImg() {
		createOrgLookUp.click();
	}
}
