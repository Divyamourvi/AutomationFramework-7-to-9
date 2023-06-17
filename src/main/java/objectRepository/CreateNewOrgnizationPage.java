package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrgnizationPage extends WebDriverUtility {

	//Declaration
	@FindBy(name="accountname")
	private WebElement orgName;

	@FindBy(name="industry")
	private WebElement industryDropDown;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	//Initialization
	public CreateNewOrgnizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}


	//Bussiness Logic
	/**
	 * This method will create new organization
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME) {
		orgName.sendKeys(ORGNAME);
		saveBtn.click();
	}
	/**
	 * This method will create new organization with industry
	 * @param ORGNAME
	 * @param Industry
	 */

	public void createNewOrganization(String ORGNAME,String Industry) {
		orgName.sendKeys(ORGNAME);
		handleDropDown(industryDropDown, Industry);
		saveBtn.click();

	}

}
