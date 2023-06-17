package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	//Declaration
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement OppLookUpImg;
	
	//Initialization
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//utilization

	public WebElement getOppLookUpImg() {
		return OppLookUpImg;
	}
	
	//Bussiness Logic
	public void clickOnOppLookUpImg() {
		OppLookUpImg.click();
	}
}