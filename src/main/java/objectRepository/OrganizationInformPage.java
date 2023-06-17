package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class OrganizationInformPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	
	//Initialization
	public OrganizationInformPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
}

	//Utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}


   //Bussiness Library
	/**
	 * This method will get the organization header text
	 * @return
	 */
	public String getHeader() {
		return OrgHeaderText.getText();
		
	}
}