package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	//Declaration
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrgSearchBtn;
	
	@FindBy(name="leadsource")
	private WebElement LeadSourceDropdwn;
	
	//initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	

	public WebElement getLastName() {
		return lastName;
	}



	public WebElement getSaveBtn() {
		return SaveBtn;
	}



	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}



	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}



	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}

	


	public WebElement getLeadSourceDropdwn() {
		return LeadSourceDropdwn;
	}



	//Business library
	/**
	 * This method will create a new contact
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		lastName.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME) {
		lastName.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		getOrgSearchBtn().click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "contacts");
		SaveBtn.click();
		
	}
	
	/**
	 * This method will create contact with leadsource 
	 * @param driver
	 * @param LASTNAME
	 * @param LEADSOURCE
	 */
	public void createNewContactWithLead(String LASTNAME,String LEADSOURCE) {
		lastName.sendKeys(LASTNAME);
		handleDropDown(LeadSourceDropdwn,LEADSOURCE);
		SaveBtn.click();
	}
	
	
	
	
}
