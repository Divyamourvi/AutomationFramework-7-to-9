package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	//declaration
		@FindBy(xpath="//img[@title='Create Product...']")
		private WebElement createProductLookUpImg;
		
		
		//initialization
		public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
			
		}

		public WebElement getCreateProductLookUpImg() {
			return createProductLookUpImg;
		}
		
		//Bussiness Logic
		public void clickOnCreateProductLookUp(){
			createProductLookUpImg.click();
		}
}
		
		
