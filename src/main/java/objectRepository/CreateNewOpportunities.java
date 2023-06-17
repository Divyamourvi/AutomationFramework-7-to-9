package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOpportunities extends WebDriverUtility {

	@FindBy(name="potentialname")
	private WebElement oppNameEdt;
	
	@FindBy(id="related_to_type")
	private WebElement RelatedDropdwn;
	
	@FindBy(xpath="//img[@alt='Select'])[1]")
	private WebElement RelatedLookUpImg;
	
	@FindBy(id="search_txt")
	private WebElement RelatedSearchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	//Initialization
	public CreateNewOpportunities(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getOppNameEdt() {
		return oppNameEdt;
	}


	public WebElement getRelatedDropdwn() {
		return RelatedDropdwn;
	}


	public WebElement getRelatedLookUpImg() {
		return RelatedLookUpImg;
	}
	


	public WebElement getRelatedSearchEdt() {
		return RelatedSearchEdt;
	}
	
	public WebElement getsearchBtn() {
		return searchBtn;
	}
	
	//Bussiness Logic
	public void createNewOpportunities(String Oppname) {
		oppNameEdt.sendKeys(Oppname);
	}
	
	public void createNewOpportunities(WebDriver driver,String OPPNAME,String CONTACTNAME) {
		oppNameEdt.sendKeys(OPPNAME);
		handleDropDown("Contacts", RelatedDropdwn);
		RelatedLookUpImg.click();
		switchToWindow(driver,"Contacts");
		RelatedSearchEdt.sendKeys(CONTACTNAME);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+CONTACTNAME+"']")).click();
		switchToWindow(driver, "Opportunities");
		SaveBtn.click();
		
	}
		
		
	}
	

