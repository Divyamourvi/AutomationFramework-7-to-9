package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	
	//Initialization
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
}



   public WebElement getContatHeaderText() {
		return ContactHeaderText;
	}



	//Bussiness Library
	/**
	 * This method will get the Contact header text
	 * @return
	 */
	public String getHeader() {
		return ContactHeaderText.getText();
		
	}
}
