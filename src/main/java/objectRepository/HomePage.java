package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{//Rule 1:Create class
	
	//Rule 2:Identify the element using annotations
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orgLink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contLink;
	
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement oppLink;

	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement logOutBtn;

	
	@FindBy(partialLinkText ="More")
	private WebElement MoreMouseOver;
	
	@FindBy(partialLinkText = "Vendors")
	private WebElement vendorLink;
	
	@FindBy(partialLinkText = "Products")
	private WebElement ProductsLink;

	
	

	//utilization
	public WebElement getMore() {
		return MoreMouseOver;
	}

	public WebElement getVendorLink() {
		return vendorLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContLink() {
		return contLink;
	}

	public WebElement getAdminImg() {
		return AdminImg;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	
	public WebElement getOppLink() {
		return oppLink;
	}
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Business library
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganizationLink() {
		orgLink.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactLink() {
		contLink.click();
	}
	
	public void clickOnOpportunityLink() {
		oppLink.click();
	}
	

	/**
	 * This method will click on signout
	 * 
	 */
	public void clickOnSignOut(WebDriver driver) {
		mouseOverAction(driver, AdminImg);
		logOutBtn.click();
	}
	
	/**
	 * This method will mouseOver to more option
	 * @param driver
	 * @param moreMouseOver
	 */
	
	public void mouseOveronMore(WebDriver driver,WebElement moreMouseOver) {
		mouseOverAction(driver,moreMouseOver);
	}
	
	/**
	 * This method will click on vendorLink
	 */
	
	public void clickOnVendorLink() {
		vendorLink.click();
	}
	
	public void clickOnProductLink() {
		ProductsLink.click();
	}
	
}
